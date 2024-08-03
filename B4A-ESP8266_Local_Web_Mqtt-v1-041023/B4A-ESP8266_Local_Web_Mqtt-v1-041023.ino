/*
- adafruit te alşıyor - b4a da çalışıyor  
- web de çalışyor - local ağda çalışıyor
*/

#include "config.h"

#include <ESP8266WebServer.h>
#include <ESP8266WiFi.h>
#include <PubSubClient.h>
#include <WiFiUdp.h>
#include <time.h>

int count = 0;
// holds the boolean (true/false) state of the light
bool is_on = false;
bool durum = false;

#define LED1 0
#define LED2 2

ESP8266WebServer server(80);

int timezone = 3 * 3600;  // GMT+03:00 turkiye
int dst = 0;

int statusLED1 = LOW;  // variable for LED1 status
int statusLED2 = LOW;  // variable for LED2 status

// Set your Static IP address
IPAddress local_IP(192, 168, 1, 204);  // 201:turuncu -- 202:masa -- 203:lambader -- 204:vitrin -- 205:
// Set your Gateway IP address
IPAddress gateway(192, 168, 1, 1);

IPAddress subnet(255, 255, 255, 0);
//IPAddress primaryDNS(8, 8, 8, 8);   //optional
//IPAddress secondaryDNS(8, 8, 4, 4); //optional

WiFiUDP udp;
const char *ntpServer = "pool.ntp.org";
const int timeZone = 3;  // Türkiye için UTC+3

const int NTP_PACKET_SIZE = 48;
byte packetBuffer[NTP_PACKET_SIZE];

// -----------------------------------------------------------------------------------------------------------------Declare constants to make the page to be visited.
const String HtmlHtml = "<html><head>"
                        "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\" /></head>";
const String HtmlNewLine = "<br></br>\n";
const String HtmlTitle = "<h1>Control LED Using NodeMCU WiFi Access Point</h1><br/>\n";
const String HtmlLed1StateLow = "<big>LED1 is now <b>ON</b></big>\n";
const String HtmlLed1StateHigh = "<big>LED1 is now <b>OFF</b></big>\n";
const String HtmlLed2StateLow = "<big>LED2 is now <b>ON</b></big>\n";
const String HtmlLed2StateHigh = "<big>LED2 is now <b>OFF</b></big>\n";
const String HtmlButtonsLED1 =
  "<a href=\"Relay01=1\"><button style=\"background-color:green;color:white;width:10%;height:5%;\">ON </button></a>\n"
  "<a href=\"Relay01=0\"><button style=\"background-color:red;color:white;width:10%;height:5%;\">OFF </button></a><br/>";
const String HtmlButtonsLED2 =
  "<a href=\"Relay02=1\"><button style=\"background-color:green;color:white;width:10%;height:5%;\">ON </button></a>\n"
  "<a href=\"Relay02=0\"><button style=\"background-color:red;color:white;width:10%;height:5%;\">OFF </button></a><br/>";
const String HtmlHtmlClose = "</html>";
// -----------------------------------------------------------------------------------------------------------------


// track time of last published messages and limit feed->save events to once
// every IO_LOOP_DELAY milliseconds
#define IO_LOOP_DELAY 10000
unsigned long lastUpdate;

// set up the 'counter' feed
AdafruitIO_Feed *counter = io.feed("counter");

// set up the 'light' feed
AdafruitIO_Feed *light = io.feed("light");


void setup() {

  // start the serial connection
  Serial.begin(115200);
  delay(10);



  pinMode(0, OUTPUT);
  //digitalWrite(LED1, statusLED1);
  pinMode(2, OUTPUT);
  //digitalWrite(LED2, statusLED2);

  // wait for serial monitor to open
  while (!Serial)
    ;

  Serial.print("Connecting to Adafruit IO");

  // connect to io.adafruit.com
  io.connect();

  // attach message handler for the counter feed.
  counter->onMessage(handleCount);

  // attach a new message handler for the light feed.
  light->onMessage(handleLight);

  // wait for a connection
  while (io.status() < AIO_CONNECTED) {
    Serial.print(".");
    delay(500);
  }

  // we are connected
  Serial.println();
  Serial.println(io.statusText());

  // make sure all feeds get their current values right away
  counter->get();
  light->get();

  // İnternet saatini senkronize edin
  configTime(timezone, dst, "pool.ntp.org", "time.nist.gov");
  Serial.println("\nWaiting for Internet time");

  while (!time(nullptr)) {
    Serial.print("*");
    delay(1000);
  }
  Serial.println("\nTime response....OK");

  if (!WiFi.config(local_IP, gateway, subnet)) {
    Serial.println("STA Failed to configure");
  }


  // Start the server
  server.begin();
  Serial.println("Web server On");

  // Print the IP address
  Serial.println(WiFi.localIP());

  server.on("/", response);

  server.on("/Relay02=1", handleLed2On);
  server.on("/Relay02=0", handleLed2Off);
}

void loop() {

  server.handleClient();

  // process messages and keep connection alive
  io.run();

  // Zaman bilgisini al
  time_t now = time(nullptr);
  struct tm *p_tm = localtime(&now);
  Serial.print(p_tm->tm_mday);
  Serial.print("/");
  Serial.print(p_tm->tm_mon + 1);
  Serial.print("/");
  Serial.print(p_tm->tm_year + 1900);

  Serial.print(" ");

  Serial.print(p_tm->tm_hour);
  Serial.print(":");
  Serial.print(p_tm->tm_min);
  Serial.print(":");
  Serial.println(p_tm->tm_sec);

  delay(1000);

  // TURN LED ON

  if (p_tm->tm_sec == 10) {
    digitalWrite(2, statusLED2);
  }
  // TURN LED OFF

  if (p_tm->tm_sec == 13) {
    digitalWrite(2, statusLED2);
  }


  if (millis() > (lastUpdate + IO_LOOP_DELAY)) {
    Serial.println();

    // save current count to 'counter'
    Serial.print("sending -> counter ");
    Serial.println(count);
    counter->save(count);
    // increment count value
    count++;

    // print out the light value we are sending to Adafruit IO
    Serial.print("sending -> light ");
    if (is_on)
      Serial.println("is on.\n");
    else
      Serial.println("is off.\n");
    // save state of light to 'light' feed
    light->save(is_on);  // broker a geri dönş


    // for the purpose of this demo, toggle the
    // light state based on the count value
    //if((count % 2) == 0)
    // if(is_on != durum)
    //  is_on = durum;
    // else
    // is_on = durum;
    //durum = is_on;
    //update timer
    lastUpdate = millis();
  }
}


// you can set a separate message handler for a single feed,
// as we do in this example for the light feed
void handleLight(AdafruitIO_Data *data) {            //mqtt den gelen veri ile led2 yak

  // print out the received light value
  Serial.print("received <- light ");

  // use the isTrue helper to get the
  // boolean state of the light
  if (data->isTrue()) {
    handleLed2On();
    Serial.println("is on.");
  } else {
    handleLed2Off();
    Serial.println("is off.");
  }
}



// aynı beslemeye birden fazla besleme de ekleyebilirsiniz
// mesaj işleyici işlevi. hem sayaç hem de karşı iki
// bu geri çağırma fonksiyonuna eklenir ve mesajlar
// her ikisi için de bu fonksiyon tarafından alınacaktır.
void handleCount(AdafruitIO_Data *data) {

  Serial.print("received <- ");

  // işlemek için aynı işlevi kullandığımızdan
  // iki feed için mesajlar, feedName() işlevini kullanabiliriz
  // mesajın hangi feed'den geldiğini bulma sırası.
  Serial.print(data->feedName());
  Serial.print(" ");

  // alınan sayı değerini yazdırın
  Serial.println(data->value());
}

// -----------------------------------------------------LED2
// Function / procedure for turning on the LED2
void handleLed2On() {
  is_on = 1;
  statusLED2 = LOW;  // conditions to make the LED turn on
  digitalWrite(LED2, statusLED2);
  Serial.println("LED2 is ON");
  response();
}

// Function / procedure for turning off the LED2
void handleLed2Off() {
  is_on = 0;
  statusLED2 = HIGH;  // conditions to make the LED turn off
  digitalWrite(LED2, statusLED2);
  Serial.println("LED2 is OFF");
  response();
}
// -----------------------------------------------------

// Function / procedure to handle each client making a request
void response() {
  String htmlRes = HtmlHtml + HtmlTitle;
  if (statusLED1 == LOW) {
    htmlRes += HtmlLed1StateLow;
  } else {
    htmlRes += HtmlLed1StateHigh;

  }

  htmlRes += HtmlNewLine;
  htmlRes += HtmlButtonsLED1;
  htmlRes += HtmlNewLine;

  if (statusLED2 == LOW) {
    htmlRes += HtmlLed2StateLow;
  } else {
    htmlRes += HtmlLed2StateHigh;
  }

  htmlRes += HtmlNewLine;
  htmlRes += HtmlButtonsLED2;

  htmlRes += HtmlHtmlClose;

  server.send(200, "text/html", htmlRes);
}



void sendNTPpacket(IPAddress &address) {
  memset(packetBuffer, 0, 48);
  packetBuffer[0] = 0b11100011;
  packetBuffer[1] = 0;
  packetBuffer[2] = 6;
  packetBuffer[3] = 0xEC;
  packetBuffer[12] = 49;
  packetBuffer[13] = 0x4E;
  packetBuffer[14] = 49;
  packetBuffer[15] = 0x4D;
  udp.beginPacket(address, 123);
  udp.write(packetBuffer, 48);
  udp.endPacket();
}

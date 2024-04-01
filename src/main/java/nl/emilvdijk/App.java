package nl.emilvdijk;

import java.io.IOException;
import java.util.Scanner;


/**
 *
 */
public class App {

  public static void main(String[] args) throws IOException {
    Scanner myScanner = new Scanner(System.in);
    double timeBetweenTAndL;
    double distanceFromBolt;
    double timeBetweenMeasurements;
    double distanceBetweenMeasurements;
    double cloudSpeed;
    double eTA;
    double previousDistance;
    double unitModifier;
    String unitText;
    int count = 1;
    char units;

    do {
      System.out.println(
          "\nWould you like to measure in Feet or Meters?\nF for feet\nM for meters");
      units = (char) System.in.read();
      char ignore;
      do {
        ignore = (char) System.in.read();
      } while (ignore != '\n');
    } while (!(units == 'F' | units == 'M'));

    if (units == 'M') {
      unitModifier = 1;
      unitText = " meters";
    } else {
      unitModifier = 3.2808399;
      unitText = " feet";
    }

    //get time between lightning and thunder and calculate distance
    System.out.println(
        "\nPlease enter the time between the lightning and the thunder in seconds:\n");
    timeBetweenTAndL = myScanner.nextDouble();
    distanceFromBolt = timeBetweenTAndL * 343;
    previousDistance = distanceFromBolt;

    //output the measurement in the appropriate units

    System.out.println(
        "The distance between you and the lightning is:"
            + distanceFromBolt * unitModifier
            + unitText);

    do {

      //get another measurement and a time between measurements
      System.out.println(
          "Please make another measurement between the lightning and the thunder so we can calculate its speed:\n");
      timeBetweenTAndL = myScanner.nextDouble();
      System.out.println(
          "\nPlease enter the time between this measurement and the previous measurement in seconds:\n");
      timeBetweenMeasurements = myScanner.nextDouble();

      //calculate the distance and the speed of the cloud and the time it will take for the cloud to arrive
      distanceFromBolt = timeBetweenTAndL * 343;
      distanceBetweenMeasurements = previousDistance - distanceFromBolt;
      previousDistance = distanceFromBolt;
      cloudSpeed = distanceBetweenMeasurements / timeBetweenMeasurements;
      eTA = distanceFromBolt / cloudSpeed;

      //output the measurement plus the speed of the cloud and lastly the time it will take the cloud to reach you

      System.out.println(
          "\nThe distance between you and the lightning is: "
              + distanceFromBolt * unitModifier
              + unitText);
      System.out.println(
          "The thundercloud is moving at a speed of " + cloudSpeed * unitModifier
              + unitText + " per second");

      System.out.println(
          "If the thundercloud continues at this speed it will reach you in " + eTA
              + " seconds.");
      System.out.println("measurement amount:" + ++count);


    } while (true);

//Gebaseerd op Try This 2-1 bladzijde 40.
//Geluid verplaatst zich met ongeveer 343 meter per seconden.
//Wanneer je een flits ziet en telt tot de donder, dan weet je de afstand tot de bliksem afstand in meters = tijd in seconden X 343 meter
//We kunnen berekenen hoe snel de bliksem zich verplaatsts door een aantal meet momenten te nemen en de afstand te berekenen tussen de donder en de vorige donder en de tijd die daar tussen lag.
//Op deze manier kunnen we berekenen hoe lang het duurt dat de bliksem bij ons is.
//Opdracht:
//
//Je mag input uitlezen zoals in hoofdstuk 3 wordt aangegeven, maar je mag ook de scanner class gebruiken: https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
//Geef de gebruiker de optie om aan te geven of de afstand in "feet" of "km" moet worden aangegeven
//Vraag met een loop steeds om input van de seconden tussen de bliksem en de donder
//Geef na elke input de afstand tot de bliksem weer, hoe snel het zich verplaatst en hoe lang het duurt tot het bij ons is
  }
}

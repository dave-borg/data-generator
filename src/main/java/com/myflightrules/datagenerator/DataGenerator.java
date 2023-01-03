package com.myflightrules.datagenerator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class DataGenerator {

    Random random = new Random();

    protected String randomPhoneticCharacter(int numberOfCharacters) {
        String rValue = "";

        ArrayList<String> callsign = new ArrayList<>();
        callsign.add("Alpha");
        callsign.add("Bravo");
        callsign.add("Charlie");
        callsign.add("Delta");
        callsign.add("Echo");
        callsign.add("Foxtrot");
        callsign.add("Golf");
        callsign.add("Hotel");
        callsign.add("India");
        callsign.add("Juliet");
        callsign.add("Kilo");
        callsign.add("Lima");
        callsign.add("Mike");
        callsign.add("November");
        callsign.add("Oscar");
        callsign.add("Papa");
        callsign.add("Quebec");
        callsign.add("Romeo");
        callsign.add("Sierra");
        callsign.add("Tango");
        callsign.add("Uniform");
        callsign.add("Victor");
        callsign.add("Whiskey");
        callsign.add("X-ray");
        callsign.add("Yankee");
        callsign.add("Zulu");

        for (int i = 0; i < numberOfCharacters; i++) {
            rValue = rValue.concat(randomListItem(callsign));
            if (i < numberOfCharacters - 1)
                rValue = rValue.concat(" ");
        }

        return rValue;
    }

    protected String randomListItem(ArrayList<String> listToRandomise) {
        return listToRandomise.get(random.nextInt(listToRandomise.size()));
    }

    protected String randomCallsign() {
        String rValue = "";

        // three random characters for the callsign
        rValue = rValue.concat(randomPhoneticCharacter(3));

        return rValue;
    }

    protected String randomAircraftType() {
        String rValue = "";
        ArrayList<String> aircraftType = new ArrayList<>();
        if (random.nextInt(4 - 1) + 4 == 4) {
            aircraftType.add("Archer");
            aircraftType.add("Cherokee");
            aircraftType.add("Arrow");
            aircraftType.add("Cessna");
            aircraftType.add("Cirrus");
            aircraftType.add("Diamond");
            aircraftType.add("Foxbat");

            rValue = rValue.concat(randomListItem(aircraftType));
        }
        return rValue;
    }

    protected String randomGreeting(String controllerBeingAddressed) {
        ArrayList<String> greetings = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            greetings.add(String.format("%s,", controllerBeingAddressed));
        greetings.add(String.format("Hello %s,", controllerBeingAddressed));
        greetings.add(String.format("Good morning %s,", controllerBeingAddressed));
        greetings.add(String.format("Good afternoon %s,", controllerBeingAddressed));
        greetings.add(String.format("Good evening %s,", controllerBeingAddressed));
        greetings.add(String.format("%s good morning,", controllerBeingAddressed));
        greetings.add(String.format("%s good afternoon,", controllerBeingAddressed));
        greetings.add(String.format("%s good evening,", controllerBeingAddressed));

        return randomListItem(greetings);
    }

    protected String formatForCsv(ArrayList<String> rValueBits, String callType) {
        String rValue = "";
        Iterator it = rValueBits.iterator();

        while (it.hasNext()) {
            rValue = rValue.concat(it.next() + " ");
        }

        return "\"" + rValue.trim() + "\", " + callType;
    }
}

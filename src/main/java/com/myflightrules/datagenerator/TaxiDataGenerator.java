package com.myflightrules.datagenerator;

import java.util.ArrayList;

public class TaxiDataGenerator extends DataGenerator {

    public ArrayList<String> generate(int cycles, String type) {
        ArrayList<String> rValue = new ArrayList<String>();

        for (int i = 0; i < cycles; i++)
            rValue.add(generateCall(type));

        return rValue;
    }

    private String generateCall(String type) {
        ArrayList<String> rValueBits = new ArrayList<>();
        String rValue = "";

        int randomStructure = random.nextInt(5);
        String randomAircraftType;

        switch (randomStructure) {
            case 0:
                rValueBits.add(randomGreeting("Ground"));
                randomAircraftType = randomAircraftType();
                if (randomAircraftType.length() > 0)
                    rValueBits.add(randomAircraftType);
                rValueBits.add(randomCallsign());
                rValueBits.add(randomLocation());
                rValueBits.add(randomRequest());

                break;

            case 1:
                rValueBits.add(randomGreeting("Ground"));
                rValueBits.add(randomCallsign());
                rValueBits.add(randomLocation());
                rValueBits.add(randomRequest());

                break;

            case 2:
                rValueBits.add(randomGreeting("Ground"));
                rValueBits.add(randomCallsign());
                rValueBits.add(randomRequest());

                break;

            case 3:
                randomAircraftType = randomAircraftType();
                if (randomAircraftType.length() > 0)
                    rValueBits.add(randomAircraftType);
                rValueBits.add(randomCallsign());
                rValueBits.add(randomLocation());
                rValueBits.add(randomRequest());

                break;

            case 4:
                rValueBits.add(randomCallsign());
                rValueBits.add(randomLocation());
                rValueBits.add(randomRequest());

                break;

            default:
                System.out.println("Error: randomStructure is not a valid value");
                break;
        }

        return formatForCsv(rValueBits, "REQUEST_TAXI", LabelConstants.REQUEST_TAXI, type);
    }

    private String randomLocation() {
        ArrayList<String> location = new ArrayList<>();

        for (int i = 1; i < 18; i++)
            location.add("at GA parking");

        for (int i = 1; i < 18; i++)
            location.add("at gate " + i);

        for (int i = 1; i < 12; i++)
            location.add("gate " + i);

        for (int i = 1; i < 8; i++)
            location.add("stand " + i);

        return randomListItem(location);
    }

    private String randomRequest() {
        ArrayList<String> request = new ArrayList<>();

        request.add("Ready for taxi");
        request.add("For taxi");
        request.add("Request taxi");
        request.add("Taxi for the active");
        request.add("Taxi to the active");
        request.add("Taxi to the runway");
        request.add("Taxi to the runway for takeoff");
        request.add("Request taxi for the active");
        request.add("Request taxi to the active");
        request.add("Request taxi for " + randomRunway());
        request.add("Request taxi to " + randomRunway());
        request.add("Ready for taxi to " + randomRunway());
        request.add("Ready for taxi for " + randomRunway());

        return randomListItem(request);
    }

}

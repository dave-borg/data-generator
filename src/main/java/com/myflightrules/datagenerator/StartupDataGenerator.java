package com.myflightrules.datagenerator;

import java.util.ArrayList;

public class StartupDataGenerator extends DataGenerator {

    public ArrayList<String> generate(int cycles, String type) {
        ArrayList<String> rValue = new ArrayList<String>();

        for (int i = 0; i < cycles; i++)
            rValue.add(generateCall(type));

        return rValue;
    }

    private String generateCall(String type) {
        ArrayList<String> rValueBits = new ArrayList<>();
        String rValue = "";

        int randomStructure = random.nextInt(6);
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
                randomAircraftType = randomAircraftType();
                if (randomAircraftType.length() > 0)
                    rValueBits.add(randomAircraftType);
                rValueBits.add(randomCallsign());
                rValueBits.add(randomLocation());
                rValueBits.add(randomRequest());

                break;

            case 2:
                rValueBits.add(randomGreeting("Ground"));
                rValueBits.add(randomCallsign());
                rValueBits.add(randomLocation());
                rValueBits.add(randomRequest());

                break;

            case 3:
                rValueBits.add(randomGreeting("Ground"));
                randomAircraftType = randomAircraftType();
                if (randomAircraftType.length() > 0)
                    rValueBits.add(randomAircraftType);
                rValueBits.add(randomCallsign());
                rValueBits.add(randomRequest());

                break;

            case 4:
                rValueBits.add(randomCallsign());
                rValueBits.add(randomRequest());

                break;

            case 5:
                rValueBits.add(randomGreeting("Ground"));
                rValueBits.add(randomCallsign());
                rValueBits.add(randomRequest());

                break;

            default:
                System.out.println("Error: randomStructure is not a valid value");
                break;
        }

        return formatForCsv(rValueBits, "REQUEST_STARTUP", LabelConstants.REQUEST_STARTUP, type);
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

        request.add("Ready to start");
        request.add("Ready for start");
        request.add("Request start");
        request.add("Request startup");
        request.add("Request engine start");
        request.add("Request engine startup");
        request.add("Request engine start up");
        request.add("Request engine startup");
        request.add("Ready for engine start");
        request.add("Ready for engine startup");
        request.add("engine start up");
        request.add("engine startup");
        request.add("engine start");
        request.add("start up");
        request.add("Request start up clearance");
        request.add("Request startup clearance");
        request.add("Request engine start up clearance");
        request.add("Request engine startup clearance");
        request.add("Request engine start clearance");

        return randomListItem(request);
    }

}

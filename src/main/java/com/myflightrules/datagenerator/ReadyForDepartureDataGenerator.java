package com.myflightrules.datagenerator;

import java.util.ArrayList;

public class ReadyForDepartureDataGenerator extends DataGenerator {

    public ArrayList<String> generate(int cycles) {
        ArrayList<String> rValue = new ArrayList<>();

        for (int i = 0; i < cycles; i++) {
            rValue.add(generateCall().trim());
        }

        return rValue;
    }

    private String generateCall() {
        ArrayList<String> rValueBits = new ArrayList<>();
        String rValue = "";

        int randomStructure = random.nextInt(6);
        String randomAircraftType;

        switch (randomStructure) {
            case 0:
                rValueBits.add(randomGreeting("Tower"));
                randomAircraftType = randomAircraftType();
                if (randomAircraftType.length() > 0)
                    rValueBits.add(randomAircraftType);
                rValueBits.add(randomCallsign());
                rValueBits.add(randomLocation());
                rValueBits.add(randomReady());
                rValueBits.add(randomIntention());

                break;

            case 1:
                randomAircraftType = randomAircraftType();
                if (randomAircraftType.length() > 0)
                    rValueBits.add(randomAircraftType);
                rValueBits.add(randomCallsign());
                rValueBits.add(randomLocation());
                rValueBits.add(randomReady());
                rValueBits.add(randomIntention());

                break;

            case 2:
                rValueBits.add(randomGreeting("Tower"));
                randomAircraftType = randomAircraftType();
                if (randomAircraftType.length() > 0)
                    rValueBits.add(randomAircraftType);
                rValueBits.add(randomCallsign());
                rValueBits.add(randomLocation());
                rValueBits.add(randomReady());

                break;

            case 3:
                rValueBits.add(randomGreeting("Tower"));
                rValueBits.add(randomCallsign());
                rValueBits.add(randomLocation());
                rValueBits.add(randomReady());
                rValueBits.add(randomIntention());

                break;

                case 4:
                rValueBits.add(randomGreeting("Tower"));
                rValueBits.add(randomCallsign());
                rValueBits.add(randomReady());

                break;

                case 5:
                rValueBits.add(randomCallsign());
                rValueBits.add(randomReady());

                break;

        }

        return formatForCsv(rValueBits, "READY_FOR_DEPARTURE", LabelConstants.READY_FOR_DEPARTURE);
    }

    

    private String randomIntention() {
        ArrayList<String> intention = new ArrayList<>();

        intention.add("for circuits");
        intention.add("departure to the south");
        intention.add("departure to the north");
        intention.add("departure to the east");
        intention.add("departure to the west");
        intention.add("for an upwind departure");
        intention.add("for a downwind departure");
        intention.add("for the training area");

        return randomListItem(intention);
    }

    private String randomReady() {
        ArrayList<String> ready = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            ready.add("is ready");
            ready.add("ready");
            ready.add("ready for departure");
        }

        ready.add("ready to go");
        ready.add("ready for takeoff");
        ready.add("ready to takeoff");

        return randomListItem(ready);
    }

    private String randomLocation() {

        ArrayList<String> runwayDescriptor = new ArrayList<>();
        String rValue = "";

        ArrayList<String> holdingDescriptor = new ArrayList<>();
        if (random.nextInt(2 - 1) + 2 == 2) {

            holdingDescriptor.add("at holding point");
            holdingDescriptor.add("at");
            holdingDescriptor.add("holding point");
            holdingDescriptor.add("holding");
            holdingDescriptor.add("holding at");
            holdingDescriptor.add("holding short of");
            holdingDescriptor.add("holding short at");
            holdingDescriptor.add("holding short");

            rValue = rValue.concat(randomListItem(holdingDescriptor));

            // Include the holding point name? 25% chance
            if (random.nextInt(4 - 1) + 4 == 4)
                rValue = rValue.concat(" " + randomPhoneticCharacter(1));

            if (random.nextInt(4 - 1) + 4 == 4)
                rValue = rValue.concat(" runway");

            runwayDescriptor.add("zero one");
            runwayDescriptor.add("zero two");
            runwayDescriptor.add("zero three");
            runwayDescriptor.add("zero four");
            runwayDescriptor.add("zero five");
            runwayDescriptor.add("zero six");
            runwayDescriptor.add("zero seven");
            runwayDescriptor.add("zero eight");
            runwayDescriptor.add("zero nine");
            runwayDescriptor.add("zero one");
            runwayDescriptor.add("zero two");
            runwayDescriptor.add("zero three");
            runwayDescriptor.add("zero four");
            runwayDescriptor.add("zero five");
            runwayDescriptor.add("zero six");
            runwayDescriptor.add("zero seven");
            runwayDescriptor.add("zero eight");
            runwayDescriptor.add("zero nine");
            runwayDescriptor.add("one");
            runwayDescriptor.add("two");
            runwayDescriptor.add("three");
            runwayDescriptor.add("four");
            runwayDescriptor.add("five");
            runwayDescriptor.add("six");
            runwayDescriptor.add("seven");
            runwayDescriptor.add("eight");
            runwayDescriptor.add("nine");
            runwayDescriptor.add("one zero");
            runwayDescriptor.add("one one");
            runwayDescriptor.add("one two");
            runwayDescriptor.add("one three");
            runwayDescriptor.add("one four");
            runwayDescriptor.add("one five");
            runwayDescriptor.add("one six");
            runwayDescriptor.add("one seven");
            runwayDescriptor.add("one eight");
            runwayDescriptor.add("one nine");
            runwayDescriptor.add("two zero");
            runwayDescriptor.add("two one");
            runwayDescriptor.add("two two");
            runwayDescriptor.add("two three");
            runwayDescriptor.add("two four");
            runwayDescriptor.add("two five");
            runwayDescriptor.add("two six");
            runwayDescriptor.add("two seven");
            runwayDescriptor.add("two eight");
            runwayDescriptor.add("two nine");
            runwayDescriptor.add("three zero");
            runwayDescriptor.add("three one");
            runwayDescriptor.add("three two");
            runwayDescriptor.add("three three");
            runwayDescriptor.add("three four");
            runwayDescriptor.add("three five");
            runwayDescriptor.add("three six");

            rValue = rValue.concat(" " + randomListItem(runwayDescriptor));
        }

        return rValue;
    }

    

}
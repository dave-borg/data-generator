package com.myflightrules.datagenerator;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataGeneratorRunner {
    public static void main(String[] args) throws IOException {

        //==============================================================================================================
        //==============================================================================================================
        //GROUND
        FileWriter groundTrainingWriter = new FileWriter("generated-data/ground-training.csv");
        FileWriter groundTestingWriter = new FileWriter("generated-data/ground-testing.csv");

        // // Generate departure training calls
        ArrayList<String> departureTrainingCalls = (new ReadyForDepartureDataGenerator()).generate(100000);

        for (String departureCall : departureTrainingCalls) {
            groundTrainingWriter.append(departureCall).append("\n");
        }

        System.out.println("Generated " + departureTrainingCalls.size() + " training departure calls");


        // Generate departure testing calls
        ArrayList<String> departureTestingCalls = (new ReadyForDepartureDataGenerator()).generate(30000);

        for (String departureTestingCall : departureTestingCalls) {
            groundTestingWriter.append(departureTestingCall).append("\n");
        }

        System.out.println("Generated " + departureTestingCalls.size() + " testing departure calls");

        // Generate taxi calls

        // Generate startup/pushback calls

        ArrayList<String> startupTrainingCalls = (new StartupDataGenerator()).generate(100000);

        for (String startupTrainingCall : startupTrainingCalls) {
            groundTrainingWriter.append(startupTrainingCall).append("\n");
        }

        System.out.println("Generated " + startupTrainingCalls.size() + " training startup calls");

        ArrayList<String> startupTestingCalls = (new StartupDataGenerator()).generate(30000);

        for (String startupTestingCall : startupTestingCalls) {
            groundTestingWriter.append(startupTestingCall).append("\n");
        }

        System.out.println("Generated " + startupTestingCalls.size() + " testing startup calls");

        groundTrainingWriter.close();
        groundTestingWriter.close();

        //==============================================================================================================
        //==============================================================================================================
        //DEPARTURE



        //==============================================================================================================
        //==============================================================================================================
        //CRUISE



        //==============================================================================================================
        //==============================================================================================================
        //ARRIVAL



        //==============================================================================================================
        //==============================================================================================================
        //APPROACH

    }

}

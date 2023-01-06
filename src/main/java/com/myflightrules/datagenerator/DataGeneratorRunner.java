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

        //write column headers to both files
        groundTrainingWriter.append("call,label,labelId,type\n");
        groundTestingWriter.append("call,label,labelId,type\n");

        // Generate departure training calls
        ArrayList<String> departureTrainingCalls = (new ReadyForDepartureDataGenerator()).generate(100000, "train");

        for (String departureCall : departureTrainingCalls) {
            groundTrainingWriter.append(departureCall).append("\n");
        }

        System.out.println("Generated " + departureTrainingCalls.size() + " training departure calls");


        // Generate departure testing calls
        ArrayList<String> departureTestingCalls = (new ReadyForDepartureDataGenerator()).generate(30000, "test");

        for (String departureTestingCall : departureTestingCalls) {
            groundTestingWriter.append(departureTestingCall).append("\n");
        }

        System.out.println("Generated " + departureTestingCalls.size() + " testing departure calls");

        // Generate taxi calls
        ArrayList<String> taxiTrainingCalls = (new TaxiDataGenerator()).generate(100000, "train");

        for (String taxiCall : taxiTrainingCalls) {
            groundTrainingWriter.append(taxiCall).append("\n");
        }

        System.out.println("Generated " + taxiTrainingCalls.size() + " training taxi calls");


        // Generate departure testing calls
        ArrayList<String> taxiTestingCalls = (new TaxiDataGenerator()).generate(30000, "test");

        for (String taxiTestingCall : taxiTestingCalls) {
            groundTestingWriter.append(taxiTestingCall).append("\n");
        }

        System.out.println("Generated " + taxiTestingCalls.size() + " testing taxi calls");

        // Generate startup/pushback calls

        ArrayList<String> startupTrainingCalls = (new StartupDataGenerator()).generate(100000, "train");

        for (String startupTrainingCall : startupTrainingCalls) {
            groundTrainingWriter.append(startupTrainingCall).append("\n");
        }

        System.out.println("Generated " + startupTrainingCalls.size() + " training startup calls");

        ArrayList<String> startupTestingCalls = (new StartupDataGenerator()).generate(30000, "test");

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

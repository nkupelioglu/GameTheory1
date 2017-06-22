package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        test_usr[] testUsers = new test_usr[1000];
        boolean[] isPaired = new boolean[1000];
        Random r = new Random();
        for (int i = 0; i < 1000; i++) {
            testUsers[i] = new test_usr();
            testUsers[i].random_cutoff_generate();
        }
        for(int i = 0; i < 1000; i++){
            initialize_isPaired(isPaired);
            for(int j = 0; j < 100; j++){
                int pairIndex = r.nextInt(1000);
                if(pairIndex == i){
                    break;
                }
                if(isPaired[pairIndex] == true){
                    break;
                }
                if(testUsers[i].offer < testUsers[pairIndex].cutoff){
                    testUsers[i].add_to_total(100 - testUsers[i].offer);
                    testUsers[pairIndex].add_to_total(testUsers[i].offer);
                    isPaired[pairIndex] = true;
                }
            }
        }
        sort(testUsers);
        for(int i = 0; i < 10; i++){
            System.out.println("Total Gains = " + testUsers[i].total_gains + " , Cutoff = " + testUsers[i].cutoff
                    + ", Offer = " + testUsers[i].offer);
        }
    }
    public static void initialize_isPaired(boolean[] isPaired) {
        for (int i = 0; i < 1000; i++) {
            isPaired[i] = false;
        }
    }
    public static void sort(test_usr[] testUsers){
        int currentMax = 0;
        int currentMaxId = 0;
        for(int j = 0; j < testUsers.length; j++) {
            currentMax = 0;
            currentMaxId = 0;
            for (int i = j; i < testUsers.length; i++) {
                if (currentMax < testUsers[i].total_gains) {
                    currentMax = testUsers[i].total_gains;
                    currentMaxId = i;
                }
            }
            test_usr temp = testUsers[j];
            testUsers[j] = testUsers[currentMaxId];
            testUsers[currentMaxId] = temp;
        }
    }
}


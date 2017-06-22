package com.company;

import java.util.Random;

public class test_usr {
    int cutoff = 0;
    int total_gains = 0;
    int offer = 0;

    void random_cutoff_generate(){
        Random rand = new Random();
        cutoff = rand.nextInt(99) + 1;
        offer = rand.nextInt(99) + 1;
    }
    void add_to_total(int added_value){
        total_gains = total_gains + added_value;
    }

}

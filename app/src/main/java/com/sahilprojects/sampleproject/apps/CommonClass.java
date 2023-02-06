package com.sahilprojects.sampleproject.apps;

import java.util.ArrayList;

public class CommonClass {


    public ArrayList<String> getHeadName()
    {
        ArrayList<String> headName = new ArrayList<>();
        headName.add("Family");
        headName.add("EMI");
        headName.add("Education");
        headName.add("Health");
        headName.add("Enjoyment");
        headName.add("Insurance");
        headName.add("Savings");
        headName.add("Donation");
        headName.add("Hotel");
        headName.add("Travelling");
        headName.add("Emergency Fund");
        headName.add("Other");
        return headName;
    }

    public ArrayList<Integer> getHeadPercentage()
    {
        ArrayList<Integer> headPercentage = new ArrayList<>();
        headPercentage.add(30);
        headPercentage.add(30);
        headPercentage.add(5);
        headPercentage.add(5);
        headPercentage.add(5);
        headPercentage.add(2);
        headPercentage.add(7);
        headPercentage.add(1);
        headPercentage.add(3);
        headPercentage.add(5);
        headPercentage.add(5);
        headPercentage.add(2);
        return headPercentage;
    }

}

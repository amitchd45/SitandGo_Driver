package com.omninos.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ExpandableListDataPump {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> step_one = new ArrayList<String>();
        step_one.add("1. Please upload your Driving license.");
        step_one.add("2. Please upload your vehicle documents.");

        List<String> step_two = new ArrayList<String>();
        step_two.add("1. Please upload your vehicle insurance.");
        step_two.add("2. Please upload your vehicle documents.");

        List<String> step_three = new ArrayList<String>();
        step_three.add("1. Please upload your vehicle permit.");
        step_three.add("2. Please upload your vehicle documents.");

        List<String> step_four = new ArrayList<String>();
        step_four.add("1. Please upload your vehicle registration.");
        step_four.add("2. Please upload your vehicle documents.");

        expandableListDetail.put("Step 1:Driver License", step_one);
        expandableListDetail.put("Step 2:Vehicle Insurance", step_two);
        expandableListDetail.put("Step 3:Vehicle Permit", step_three);
        expandableListDetail.put("Step 4:Vehicle Registration", step_four);
        return expandableListDetail;
    }
}


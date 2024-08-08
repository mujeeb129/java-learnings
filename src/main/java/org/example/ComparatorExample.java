package org.example;

import java.util.*;

public class ComparatorExample {
    public static void main(String[] args) {
        Comparator<String> com = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        };
        HashMap<String, Integer> hm = new HashMap<>();
        ArrayList<String> stringArray = new ArrayList<>();
        stringArray.add("dafaffad");
        stringArray.add("adf");
        stringArray.add("wfewf");
        Collections.sort(stringArray, com);
        hm.put("Mujeeb", 23);
        System.out.println(stringArray);
        System.out.println(hm.get("Mujeeb"));
        System.out.println(hm.get("Mujeeb"));

    }
}

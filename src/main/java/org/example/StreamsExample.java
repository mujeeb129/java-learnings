package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StreamsExample {
    public static void main(String[] args) {
        int size = 10_000;
        Random ran = new Random();

        List<Integer> nums = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            nums.add(ran.nextInt(100));
        }

        long startSeq = System.currentTimeMillis();
        int sum1 = nums.stream()
                .map(i -> {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                    return i * 2;
                })
                .mapToInt(i -> i)
                .sum();
        long endSeq = System.currentTimeMillis();
        long startPara = System.currentTimeMillis();
        int sum2 = nums.parallelStream()
                .map(i -> {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                    return i * 2;
                })
                .mapToInt(i -> i)
                .sum();
        long endPara = System.currentTimeMillis();
        System.out.println(sum1 + " " + sum2);
        System.out.println("Seq: " + (endSeq - startSeq));
        System.out.println("Para: " + (endPara - startPara));

    }
}

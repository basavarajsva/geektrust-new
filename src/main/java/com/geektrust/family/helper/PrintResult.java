package com.geektrust.family.helper;

import java.util.List;

import static com.geektrust.family.constant.Constant.NONE;

public class PrintResult {

    private PrintResult() {
    }

    public static void printResult(List<String> nodes) {
        if (nodes.isEmpty()) {
            System.out.println(NONE);
        } else {
            for (String node : nodes) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}

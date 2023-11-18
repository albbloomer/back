package com.example.back.cote;

public class CotePlayground1 {

    public static Integer problem_1_result() {
        int leftNumber = 1;
        int rightNumber = 2;

        return leftNumber + rightNumber;
    }

    public static String stringBuilderPrac() {
        StringBuilder sb = new StringBuilder();
        int[] indexList = {1, 3};
        String myString = "myString";
        for (int idx : indexList) {
            sb.append(myString.charAt(idx));
        }

        return sb.toString();
    }
}

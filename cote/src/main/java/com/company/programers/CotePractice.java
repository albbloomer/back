package com.company.programers;

public class CotePractice {

    // 배열 + 이중 String
    public static void main(String[] args) {

        String[] array = {"111100000", "111100000", "111100000"};
        int n = array.length;      // 행의 수
        int m = array[0].length(); // 열의 수

        int[][] maps = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maps[i][j] = array[i].charAt(j) - '0';
            }
        }

        for (int index = 0 ; index < n ; ++index) {
            System.out.println();
            for (int inIndex = 0 ; inIndex < m ; ++inIndex) {
                System.out.print(maps[index][inIndex]);
            }
        }
    }
}
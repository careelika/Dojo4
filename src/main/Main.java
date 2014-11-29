package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by Careelika on 29/11/2014.
 */

public class Main {

    public static String fileName = "births.dat";
    public static java.io.File file;

    public static void main(String[] args) throws FileNotFoundException {

        int[][] data = readData(fileName);
        int year = findBiggestBoysPercentageYear(data);

        System.out.println(year);
    }

    public static int findBiggestBoysPercentageYear(int[][] data) {
        int bestYear = 0;
        double bestPercentage = 0;

        for (int i = 0; i < data.length; i++) {
            int year = data[i][0];
            int boys = data[i][1];
            int girls = data[i][2];

            double percentage = computePercentage(boys, girls);

            if (percentage > bestPercentage) {
                bestPercentage = percentage;
                bestYear = year;
            }
        }

        return bestYear;
    }

    public static int[][] readData(String fileName) throws FileNotFoundException {
        file = new File(fileName);
        int[][] data = new int[69][3];
        Scanner sc = new Scanner(file);

        sc.nextLine(); // removes unnecessary first line

        for (int j =0; j<69; j++){
            String line = sc.nextLine();
            String[] parts =line.trim().split(";");

            for (int i = 0; i < parts.length; i++) {
                data[j][i] = Integer.parseInt(parts[i]);
            }
        }
        return data;
    }

    public static double computePercentage(int boys, int girls) {
        double p = boys*100/(boys+girls);
        return  p;
    }

}

package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Careelika on 29/11/2014.
 */
public class Kata2 {

    public static String fileName = "soccer.dat";
    public static java.io.File file;
    public static HashMap<String,Integer> data;

    public static void main(String[] args) throws FileNotFoundException {

        data = readData(fileName);
        String best = findBestTeam(data);
        System.out.println(best);
    }

    public static String findBestTeam(HashMap<String, Integer> data) {

        Map.Entry<String, Integer>  minEntry = null;

        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            if (minEntry == null || entry.getValue() < minEntry.getValue()) {
                minEntry = entry;
            }
        }
        return minEntry.getKey();
    }

    public static HashMap<String,Integer> readData(String fileName) throws FileNotFoundException {
        file = new File(fileName);
        HashMap<String,Integer> data = new HashMap<String, Integer>();
        Scanner sc = new Scanner(file);
        sc.nextLine(); // removes unnecessary first line

        for (int j = 0; j < 20; j++){
            String line = sc.nextLine();
            String[] parts = getParts(line);

            int goalDiff = Integer.parseInt(parts[1]) - Integer.parseInt(parts[2]);
            data.put(parts[0], goalDiff);
        }
        return data;
    }

    public static String[] getParts(String line) {

        String[] parts =line.trim().split("\\t");
        String[] newParts = new String[3];
        newParts[0] = parts[1];
        newParts[1] = parts[6];
        newParts[2] = parts[7];

        return newParts;
    }

}


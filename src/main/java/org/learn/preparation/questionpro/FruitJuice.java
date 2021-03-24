package org.learn.preparation.questionpro;

import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FruitJuice {

    public static void main(String[] args) throws Exception {

        /* Use below method if you want to read the inputs from a file */
        // provide complete absolute file path here
        readInputsFromFileAndPrepareFruitJuice("C:\\Users\\sgajbhar\\Downloads\\QPCodingTest\\QPCodingTest\\sampleinput.txt");

        /* Use below method if you want to read the inputs from console */
        //readInputsFromConsoleAndPrepareFruitJuice();
    }

    public static void readInputsFromFileAndPrepareFruitJuice(String fileName) throws Exception {

        Scanner fileScanner = new Scanner(new FileReader(new File(fileName)));
        // total number of friends coming to the party
        int numberOfFriends = fileScanner.nextInt();
        // for each friend
        while (numberOfFriends > 0) {
            // number of fruits on the cupboard
            int numberOfFruits = fileScanner.nextInt();
            int[] caloriesOfEachFruit = new int[numberOfFruits];

            // calories for each fruit
            for (int i = 0; i < numberOfFruits; i++) {
                caloriesOfEachFruit[i] = fileScanner.nextInt();
            }

            // list of fruits available
            String availableFruits = fileScanner.next();
            // maximum calories of the current friend
            int exactCaloriesIntakeOfFriend = fileScanner.nextInt();

            // prepare the Juice :)
            prepareMixFruitJuice(caloriesOfEachFruit, availableFruits, exactCaloriesIntakeOfFriend);
            numberOfFriends--;
        }
        fileScanner.close();
    }

    private static void prepareMixFruitJuice(int[] caloriesOfEachFruit, String availableFruits, int exactCaloriesIntakeOfFriend) {

        // step 1: Build a mapping of each fruit and its calories
        Map<Character, Integer> fruitCalorieMapping = new HashMap<>();
        for (int i = 0; i < caloriesOfEachFruit.length; i++) {
            int curr = i + 'a';
            fruitCalorieMapping.put(new Character((char) curr), caloriesOfEachFruit[i]);
        }

        // Step 2: We need to choose fruits in alphabetical order. Hence sorting these fruits
        char[] fruits = availableFruits.toCharArray();
        Arrays.sort(fruits);   // This operation takes N(log(N)) time to sort the fruits

        // step 3:
        int j = 0;
        int i = 0;
        int totalCalories = 0;
        boolean doable = false;

        while (j < fruits.length) {
            // 3.1: Choosing each fruit in order & adding its calories to CurrentCal
            totalCalories += fruitCalorieMapping.get(fruits[j]);

            // 3.2: If totalCalories goes beyond the exactCaloriesIntakeOfFriend, then removing the first fruit's calories
            if (totalCalories > exactCaloriesIntakeOfFriend) {
                totalCalories = totalCalories - fruitCalorieMapping.get(fruits[i]);
                i++;
            }
            j++;

            // 3.3: If totalCalories are equal to the exactCaloriesIntakeOfFriend, then break the loop
            if (totalCalories == exactCaloriesIntakeOfFriend) {
                doable = true;
                break;
            }
        }

        // Step 4: print the juice name
        if (doable) {
            while (i < j) {
                System.out.print(fruits[i]);
                i++;
            }
            System.out.println();
        } else {
            System.out.println("SORRY, YOU JUST HAVE WATER");
        }
    }

    public static void readInputsFromConsoleAndPrepareFruitJuice() {

        Scanner sc = new Scanner(System.in);
        // total number of friends coming to the party
        int numberOfFriends = sc.nextInt();

        // for each friend
        while (numberOfFriends > 0) {
            // number of fruits on the cupboard
            int numberOfFruits = sc.nextInt();
            int[] caloriesOfEachFruit = new int[numberOfFruits];

            // calories for each fruit
            for (int i = 0; i < numberOfFruits; i++) {
                caloriesOfEachFruit[i] = sc.nextInt();
            }

            // list of fruits available
            String availableFruits = sc.next();
            // maximum calories of the current friend
            int exactCaloriesIntakeOfFriend = sc.nextInt();

            // prepare the Juice :)
            prepareMixFruitJuice(caloriesOfEachFruit, availableFruits, exactCaloriesIntakeOfFriend);
            numberOfFriends--;
        }
        sc.close();
    }
}

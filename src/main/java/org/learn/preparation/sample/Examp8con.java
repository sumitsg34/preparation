package org.learn.preparation.sample;

import java.util.Scanner;

public class Examp8con {

    public static void main(String args[]) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

*/
        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        // Write your code here
        int length = name.length();

        String left = name.substring(name.length() / 2);
        String right = name.substring(0, name.length() / 2);

        //System.out.println("first:" + first +" sec:"+second);
        int ptr1 = 0;
        int ptr2 = right.length() - 1;

        while (true) {
            // if match 1 == 2
            if (right.charAt(ptr2) == left.charAt(ptr1)) {
                //go right
                while(right.charAt(ptr2) == left.charAt(ptr1)){
                    ptr1++;
                }

            }
        }
    }
}

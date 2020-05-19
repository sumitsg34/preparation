package org.learn.preparation.greeks;

/**
 * https://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
 */
public class SubArraySum {
    //1 2 3 7 5
    public static void findSubarraySum(int[] nums, int target) {

        int sum = 0;
        int start = 0;
        boolean found = false;

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int temp = sum + curr;
            if (temp > target) {
                // remove the subtract the first num, move start pointer and check sum equals target
                while (temp > target) {
                    temp = temp - nums[start];
                    start++;
                }

            }
            if (temp == target) {
                found = true;
                System.out.println((start + 1) + " " + (i + 1));
                break;
            }
            sum = temp;
        }
        if (!found)
            System.out.println(-1);
    }

    public static void main(String[] args) {
        //int[] nums = {135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 172, 139, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134};
        //int[] nums = {1,2,3,7,5};
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        findSubarraySum(nums, 15);

//        Scanner sc = new Scanner(System.in);
//        int test = sc.nextInt();
//        while (test > 0) {
//            int n = sc.nextInt();
//            int target = sc.nextInt();
//            int[] nums = new int[n];
//            for (int i = 0; i < n; i++) {
//                nums[i] = sc.nextInt();
//            }
//            findSubarraySum(nums, target);
//            test--;
//        }
//        sc.close();
    }
}

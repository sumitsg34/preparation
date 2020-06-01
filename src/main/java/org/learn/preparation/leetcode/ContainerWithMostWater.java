package org.learn.preparation.leetcode;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {

        int maxArea = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int width = j - i;
            int currHeight = Math.min(height[i], height[j]);
            if (maxArea < (width * currHeight)) {
                maxArea = width * currHeight;
            }
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }

        }
        return maxArea;
    }

    public static void main(String[] args) {
        /**
         *
         *   !
         *   !
         *   !      !
         *   !  !  !  !
         *   -----------------------
         *
         *
         * **/


        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println("area: " + containerWithMostWater.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println("area: " + containerWithMostWater.maxArea(new int[]{1, 2, 3, 1}));

    }


}

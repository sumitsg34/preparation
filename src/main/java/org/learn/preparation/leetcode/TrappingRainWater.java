package org.learn.preparation.leetcode;

public class TrappingRainWater {

    private int maxLeft(int[] height, int curr) {
        int max = 0;
        curr--;
        while (curr >= 0) {
            if (height[curr] > max) {
                max = height[curr];
            }
            curr--;
        }
        return max;
    }

    private int maxRight(int[] height, int curr) {
        int max = 0;
        curr++;
        while (curr < height.length) {
            if (height[curr] > max) {
                max = height[curr];
            }
            curr++;
        }
        return max;
    }

    public int trap(int[] height) {
        int volume = 0;
        for (int i = 0; i < height.length; i++) {
            int currVolume = (Math.min(maxRight(height, i), maxLeft(height, i)) - height[i]);
            if (currVolume > 0) {
                volume += currVolume;
            }
        }
        return volume;
    }

    public int trap2(int[] height) {
        int length = height.length;
        if (height == null || length == 0) {
            return 0;
        }
        int[] leftMax = new int[length];
        int[] rightMax = new int[length];

        leftMax[0] = 0;
        for (int i = 1; i < length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        int vol = 0;
        for (int i = 1; i < length - 1; i++) {
            vol += (Math.min(leftMax[i], rightMax[i]) - height[i]);
        }
        return vol;
    }

    public static void main(String[] args) {
        TrappingRainWater trappingRainWater = new TrappingRainWater();
        System.out.println("out:" + trappingRainWater.trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println("out:" + trappingRainWater.trap2(new int[]{2, 0, 2}));
    }

}

class Solution {
    
       public int[] intersect(int[] nums1, int[] nums2) {
           
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int i = 0; i < nums1.length; i++) {
            numbers.put(nums1[i], numbers.getOrDefault(nums1[i], 0) + 1);
        }

        List<Integer> out = new ArrayList<>();

        for (int i = 0; i < nums2.length; i++) {
            Integer num = numbers.get(nums2[i]);
            if (num != null && num > 0) {
                out.add(nums2[i]);
                numbers.put(nums2[i], numbers.get(nums2[i]) - 1);
            }
        }
        
        int output[] = new int[out.size()];
        for (int i = 0; i < output.length; i++) {
            output[i] = out.get(i);
        }
        return output;
    }


    
}
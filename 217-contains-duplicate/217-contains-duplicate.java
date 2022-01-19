class Solution {
    
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> counts = new HashSet<>();
        
        for(Integer num : nums) {
            if(counts.contains(num))
                return true;
            counts.add(num);
        }
        return false;
        
    }
}
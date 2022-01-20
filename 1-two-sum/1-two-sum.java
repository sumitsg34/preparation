class Solution {
    
    
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer,Integer> visited = new HashMap<>();
        
        for(int i=0; i<nums.length ; i++) {
            int temp = target - nums[i];
            
            if(visited.containsKey(temp)){
                return new int[] { visited.get(temp), i };
            }else{
                visited.put(nums[i], i);
            }
        }
        
        return new int[2];
        
        
    }
}
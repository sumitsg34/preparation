class Solution {
    public int firstUniqChar(String s) {
        
        Map<Character, Integer> visited = new LinkedHashMap<>();
        
        for(int i=0; i < s.length() ; i++) {
            visited.put(s.charAt(i), visited.getOrDefault(s.charAt(i), 0) +1);
        }
        
        for(int i=0; i < s.length() ; i++) {
        
            if(visited.get(s.charAt(i)) == 1)
                return i;
        }
        
        return -1;
        
    }
    
}
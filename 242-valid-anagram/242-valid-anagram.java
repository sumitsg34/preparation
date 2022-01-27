class Solution {
    
    
    
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())
            return false;
        
        int[] visited = new int[26];
        
        for(char c : s.toCharArray()) {
            int character = c - 'a';
            visited[character] = visited[character] + 1;
        }
        
        
         for(char c : t.toCharArray()) {
            int character = c - 'a' ;
            
            if(visited[character] == 0)
                return false;
            
            visited[character] = visited[character] - 1;
        }
        
        return true;            
    }
}
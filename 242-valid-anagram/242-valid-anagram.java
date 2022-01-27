class Solution {
    
    
    
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length())
            return false;
        
        int[] visited = new int[26];
        
        for(int i=0; i< s.length(); i++) {
            int character = s.charAt(i) - 'a';
            visited[character] = visited[character] + 1;
        }
        
        
        for(int i=0; i<t.length(); i++) {
            int character = t.charAt(i) - 'a' ;
            
            if(visited[character] == 0)
                return false;
            
            visited[character] = visited[character] - 1;
        }
        
        return true;            
    }
}
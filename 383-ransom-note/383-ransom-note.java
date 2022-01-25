class Solution {
    
    public boolean canConstruct(String ransomNote, String magazine) {
        
        Map<Character, Integer> note = new HashMap<>();
        
        for(char c : magazine.toCharArray()) {
            note.put(c,note.getOrDefault(c,0)+1);
        }
        
        for(char c : ransomNote.toCharArray()) {
            
            Integer count = note.get(c);
            
            if(count == null || count == 0)
                return false;
            
            note.put(c, note.get(c)-1);
            
        }
       
        return true;
    }
    
}
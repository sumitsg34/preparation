class Solution {
    public List<List<Integer>> generate(int numRows) {
        
        int row = 0;
        List<List<Integer>> output = new ArrayList<>();
        
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        
        output.add(firstRow);
        
        for(;row < numRows-1; row++) {
            
            List<Integer> nextRow = new ArrayList<>();
            nextRow.add(1);
            
            List<Integer> lastRow = output.get(row);
            
            int i=0;
            
            while( i+1 < lastRow.size() ) {
                nextRow.add( lastRow.get(i) + lastRow.get(i+1));
                i++;
            }
            
        
            nextRow.add(1);
            output.add(nextRow);
            
        }
        
        return output;
         
    }
}
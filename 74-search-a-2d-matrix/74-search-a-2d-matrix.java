class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int lastIndex = matrix[0].length-1;
        
        for ( int i=0; i < matrix.length; i++) {
            
            if(target == matrix[i][lastIndex])
                return true;
            
            if(target < matrix[i][lastIndex])
                return binarySearch(matrix[i], target);
            
        }
        
        return false;
    }
    
    
    private boolean binarySearch(int[] matrix, int target) {
        
        int i = 0;
        int j = matrix.length-1;
        
        while( i <= j ) {
            
            int temp = (i+j)/2;
            
            if(target == matrix[temp]) 
                return true;
            
            if(target < matrix[temp]) {
                j = temp - 1;
            } else {
                i = temp + 1;
            }
            
        } 
        
        return false;
        
    }
}
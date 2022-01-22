class Solution {
    
    public int[][] matrixReshape(int[][] mat, int r, int c) {
               
        if(mat[0].length * mat.length != r * c )
            return mat; 
        
        int[][] out = new int[r][c];
        int p = 0; // rows
        int q = 0; // columns
        for(int i=0; i<mat.length; i++) {
            
            for( int j=0; j < mat[0].length ; j++ ) {
        
                out[p][q] = mat[i][j];
                q++;
                if(q == c) {
                    p++; q=0;
                }             
                
            }
            
        }
        return out;

    }
}
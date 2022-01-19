class Solution {
    
    public boolean isValidSudoku(char[][] board) {

        int[][] numbers = new int[9][9];
        int[][] numbers2 = new int[9][9];


        int[][][] subBoxes = new int[3][3][9];

        for(int i=0; i<9; i++) {

            for(int j=0; j<9; j++) {

                if(board[i][j] == '.')
                    continue;

                int temp = board[i][j] - '0' - 1;

                if(numbers[i][temp] == 1){
                   // System.out.println(Arrays.deepToString(numbers));
                    return false;
                }

                if(numbers2[temp][j] == 1){
                //    System.out.println(Arrays.deepToString(numbers));
                    return false;
                }

                if(subBoxes[i/3][j/3][temp] == 1) {
                //    System.out.println(Arrays.deepToString(numbers));
                    return false;
                }

                numbers[i][temp] = 1;
                numbers2[temp][j] = 1;
                subBoxes[i/3][j/3][temp] = 1;
                // System.out.println("************ " + (temp+1));
                // for(int p=0; p<9; p++)
                //    System.out.println((p+1) + " " + Arrays.toString(numbers[p]));
                // System.out.println("-------------------------------------------");

            }

        }
        return true;
    }
}
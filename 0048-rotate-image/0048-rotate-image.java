class Solution {
    public void rotate(int[][] matrix) {
        
        transpose(matrix);
        
        for(int i = 0; i < matrix.length; i++){
            int lo = 0;
            int hi = matrix[i].length - 1;
            
            while(lo < hi){
                int temp = matrix[i][lo];
                matrix[i][lo] = matrix[i][hi];
                matrix[i][hi] = temp;
                lo++;
                hi--;
            }
        }
    }
    
    void transpose(int [][] matrix){
        for(int i = 0; i < matrix.length;i++){
            for(int j = i + 1; j < matrix[0].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int l=0;
        int h=rows-1;
        while(l<=h){
            int m = (l+h)/2;
            if(target<matrix[m][0]){
                h = m-1;
            }else if(target>matrix[m][cols-1]){
                l = m+1;
            }else{
                break;
            }
        }
        if (!(l<=h))return false;

        int row = (l+h)/2;

        int left = 0;
        int right = cols-1;
        while(left<=right){
            int m = (left+right)/2;
            if(target==matrix[row][m])return true;
            if(target<matrix[row][m]) right = m-1;
            else{
                left = m+1;
            }
        }
        return false;
    }

}

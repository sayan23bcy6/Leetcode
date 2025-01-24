class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int start1=0,start2=0;
        int end1=matrix.length,end2=matrix[0].length;
        ArrayList<Integer> arr=new ArrayList<>();
        while(start1<=end1 && start2<=end2)
        {
            for(int j=start2;j<end2;j++)
            {
                arr.add(matrix[start1][j]);
            }
            start1++;
            if(start1>=end1)
            break;
            for(int i=start1;i<end1;i++)
            {
                arr.add(matrix[i][end2-1]);
            }end2--;
             if(start2>=end2)
            break;
            for(int j=end2-1;j>=start2;j--)
            {
                arr.add(matrix[end1-1][j]);
            }
            end1--;
             if(start1>=end1)
            break;
            for(int i=end1-1;i>=start1;i--)
            {
                arr.add(matrix[i][start2]);
            }
            start2++;
             if(start2>=end2)
            break;
        }
        return arr;
    }
}
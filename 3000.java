class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        double maxd=0;
        int maxA=0;
        for(int i=0;i<dimensions.length;i++)
        {int m=dimensions[i][0];
        int n=dimensions[i][1];
        double d=Math.sqrt(m*m+n*n);
        int area=m*n;
        if(d>maxd)
        {maxd=d;
        maxA=area;}
        else if(d==maxd)
        {
            if(area>maxA)
            {
                maxA=area;
            }
        }
        }
        return maxA;   
    }
}
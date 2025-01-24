class Solution {
    public int candy(int[] ratings) 
    {int arr[]=new int[ratings.length];
    int ar[]=new int[ratings.length];
       Arrays.fill(arr,1);
       Arrays.fill(ar,1);
        for(int i=1;i<ratings.length;i++)
        {
            
            
                if(ratings[i]>ratings[i-1])
                {
                    arr[i]=1+arr[i-1];
                }
            
            
           
        }
        for(int i=ratings.length-2;i>=0;i--)
        {
           
            
                if(ratings[i]>ratings[i+1])
                {
                    ar[i]=1+ar[i+1];
                }
             
           }int s=0;
        for(int i=0;i<arr.length;i++)
        {
           s+=Math.max(arr[i],ar[i]);

        }
        return s;
    }
}
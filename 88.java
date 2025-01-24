class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       int i=0,j=0,a=0;
        for(i=m;i<(m+n);i++)
        { 
          nums1[i]=nums2[j];j++;}
          for(i=0;i<(m+n);i++)
          {
            for(j=0;j<(m+n-i-1);j++)
            {
              if(nums1[j]>nums1[j+1])
{a=nums1[j];
nums1[j]=nums1[j+1];
nums1[j+1]=a;}
            }
          }
}}
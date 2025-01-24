int minSubArrayLen(int target, int* nums, int numsSize) {
    int start=-1;
    int sum=0;
    int min=numsSize+1;
    for(int i=0;i<numsSize;i++)
    {
        sum+=nums[i];
        while(sum>=target)
        {min=min<(i-start)?min:(i-start);
            sum-=nums[++start];
        }
    }
    if(min==numsSize+1)
    return 0;
    else
    return min;
    
}
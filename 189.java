void rotate(int* nums, int numsSize, int k) {
    k=k%numsSize;
    int arr[numsSize];
    int j=0;
    for(int i=numsSize-k;i<numsSize;i++)
    {
        arr[j]=nums[i];
        j++;
    }
    for(int i=0;i<numsSize-k;i++)
    {
        arr[j]=nums[i];
        j++;
    }
    for(int i=0;i<numsSize;i++)
    {
        nums[i]=arr[i];
    }
}
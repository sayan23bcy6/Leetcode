class Solution {
    public int maxProfit(int[] prices) {
        int start=0;
        int max=0;
        for(int i=0;i<prices.length;i++)
        {
           int profit=prices[i]-prices[start];
            while(profit<0 && start<=i)
            {
                start++;
                profit=prices[i]-prices[start];
            }
            max=Math.max(max,profit);
        }
        return max;
    }
}
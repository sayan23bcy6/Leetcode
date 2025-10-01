class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum=0;
        int rem=0;
        while(numBottles!=0)
        {   
            sum+=numBottles;
            numBottles+=rem;
            rem=numBottles%numExchange;
            numBottles/=numExchange;
        }
        return sum;
    }
}
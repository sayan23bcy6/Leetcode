class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int sum=0;
        while(numBottles>=numExchange)
        {
            sum+=numExchange;
            numBottles+=1-numExchange;
            numExchange++;
        }
        sum+=numBottles;
        return sum;
    }
}
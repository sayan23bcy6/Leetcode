class Solution {
    public int findClosest(int x, int y, int z) {
        int dist_x=Math.abs(z-x);
        int dist_y=Math.abs(z-y);
        if(dist_x>dist_y)
        return 2;
        else if(dist_y>dist_x)
        return 1;
        else
        return 0;
    }
}
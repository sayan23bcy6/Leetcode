/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        if(n==1)
        return 1;
        int start=1;
        int end=n;
        int mid=0;
        while(start<=end)
        {
            mid=start+(end-start)/2;
            int g=guess(mid);
            if(g==-1)
            end=mid-1;
            else if(g==1)
            start=mid+1;
            else if(g==0)
            break;
        }
        return mid;
    }
}
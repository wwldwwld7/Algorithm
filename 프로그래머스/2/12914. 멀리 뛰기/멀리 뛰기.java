import java.util.*;
class Solution {
    public long solution(int n) {
        int[] dp = new int[2001];
        dp[0] = 1;
        dp[1] = 1;
        if(n>1){
            for(int i=2 ; i<=n ; i++){
                dp[i] =(dp[i-2] + dp[i-1])%1234567;
                // if(i%2!=0) dp[i]++;
                
            }
        }
        return dp[n];
    }
}
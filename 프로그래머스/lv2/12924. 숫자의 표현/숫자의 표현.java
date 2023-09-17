import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = 1;
        while(num <= n){
            int sum = 0;
            int val = num;
            while(true){
                sum += val;
                if(sum >= n){
                    if(sum == n) answer++;
                    break;
                } 
                val++;
                
            }
            num++;
        }
        return answer;
    }
}
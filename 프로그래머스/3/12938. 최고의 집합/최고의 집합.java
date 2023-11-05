import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {-1};
        if(n > s) return answer;
        else{
            answer = new int[n];
            int num = n;
            for(int i=0 ; i<n ; i++){
                answer[i] = s/num;
                s -= answer[i];
                num--;
            }
            Arrays.sort(answer);
            return answer;
        }       
    }
}
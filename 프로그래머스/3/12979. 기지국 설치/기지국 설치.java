import java.util.*;
class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        Arrays.sort(stations);
        
        int idx = 0;
        int i = 1;
        
        while(i<=n){
            if(idx<stations.length && stations[idx]-w<=i) {
                i = stations[idx]+w+1;
                idx++;
            }
            else{
                i = i+2*w+1;
                answer++;
            }
        }
        
        return answer;
    }
}
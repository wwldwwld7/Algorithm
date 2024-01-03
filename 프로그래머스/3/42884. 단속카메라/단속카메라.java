import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (o1, o2)->(o1[1]-o2[1]));
        
        int size = routes.length;
        boolean[] check = new boolean[size];
        for(int i=0 ; i<size ; i++){
            if(check[i]) continue;
            check[i] = true;
            for(int j=i ; j<size-1 ; j++){
                if(routes[i][1]>=routes[j+1][0]) check[j+1] = true;
            }
            answer++;  
        }
        return answer;
    }
}
import java.util.*;

class Solution {
    static int[] p;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        p = new int[n];
        for(int i=0 ; i<n ; i++){
            p[i] = i;
        }

        for(int i=0 ; i<n ; i++){
            for(int j=0 ; j<n ; j++){
                if(i!=j && computers[i][j] == 1)
                    union(i, j);
            }
        }

        for(int i=0 ; i<n ; i++){
            if(p[i] == i){
                answer++;
            }
        }

        return answer;
    }
    
    static int find(int x){
        if(x == p[x]) return x;
        return find(p[x]);
    }
    
    static void union(int x, int y){
        x = find(x);
        y = find(y);
        if(x<=y) p[y] = x;
        else p[x] = y;
    }
}
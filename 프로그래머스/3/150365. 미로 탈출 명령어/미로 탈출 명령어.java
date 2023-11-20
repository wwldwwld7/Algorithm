import java.util.*;

class Solution {
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};
    static String[] dir = {"d", "l", "r", "u"};
    static int N,M,R,C;
    static StringBuilder Ans;
    static String answer;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {    
        N = n;
        M = m;
        R = r-1;
        C = c-1;      
        
        Ans = new StringBuilder();
        int distance = Math.abs(x-r)+Math.abs(y-c);
        if(distance > k || (k-distance)%2==1) return "impossible";
        dfs(0, x-1, y-1, k);       
        return answer == null ? "impossible" : answer;
    }
    
    static void dfs(int cnt, int nr, int nc, int k){
        if(answer != null) return;
        if(nr<0 || nr>=N || nc<0 || nc>=M) return;
        int distance = Math.abs(nr-R)+Math.abs(nc-C);
        if(cnt+distance > k) return;
        if(cnt == k && nr==R && nc==C) {        
            answer = Ans.toString();
            return; 
        }
        else if(cnt >= k) return;
        for(int d=0 ; d<4 ; d++){
            Ans.append(dir[d]);
            dfs(cnt+1, nr+dr[d], nc+dc[d], k);
            Ans.delete(cnt, cnt+1);
        }
    }
}
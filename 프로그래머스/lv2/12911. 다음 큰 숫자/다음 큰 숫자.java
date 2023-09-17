import java.io.*;
class Solution {
    public int solution(int n) {
        String str = Integer.toBinaryString(n);
        int one = 0;
        for(int i=0 ; i<str.length() ; i++){
            if(str.charAt(i) == '1') one++;
        }
        // System.out.println(str);
        while(true){
            n++;
            int cnt = 0;
            str = Integer.toBinaryString(n);
            for(int i=0 ; i<str.length() ; i++){
                if(str.charAt(i) == '1') cnt++;
            }
            if(one == cnt) break;
        }
        return n;
    }
}
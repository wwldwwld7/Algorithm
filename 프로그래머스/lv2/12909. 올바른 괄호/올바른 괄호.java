import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int idx=0;
        Stack<Character> st = new Stack<>();
        while(true){
            if(idx==s.length()) break;   
            if(s.charAt(idx)=='('){
                st.push(s.charAt(idx));
            }
            else{
                if(idx==0){
                    answer = false;
                    break;
                }
                else if(st.size()==0){
                    answer = false;
                    break;
                }
                else{
                    st.pop();
                }
            }
            idx++;
        }
        if(st.size()>0) answer = false;

        

        return answer;
    }
}
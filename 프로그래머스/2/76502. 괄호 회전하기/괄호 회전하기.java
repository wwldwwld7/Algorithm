import java.util.*;
class Solution {
    public int solution(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        int answer = 0;
        outer: for(int a=0 ; a<n-1 ; a++){
            st.clear();
            if(a != 0){
                char ch = s.charAt(0);
                s = s.substring(1) + ch;                
            }
            for(int i=0 ; i<n ; i++){
                if(s.charAt(i)=='(' || s.charAt(i)=='{' || s.charAt(i)=='['){
                    st.add(s.charAt(i));
                }
                else if(st.empty()){
                    continue outer;
                }
                else if(s.charAt(i)==')' && st.peek()=='('){
                    st.pop();
                }
                else if(s.charAt(i)=='}' && st.peek()=='{'){
                    st.pop();
                }
                else if(s.charAt(i)==']' && st.peek()=='['){
                    st.pop();
                }
                else {
                    continue outer;
                }
            }
            if(!st.empty()){
                continue;
            }
            answer++;
        }
        return answer;
    }
}
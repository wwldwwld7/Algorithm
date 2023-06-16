class Solution {
    public String solution(String s) {
        String[] str = s.toLowerCase().split(" ");
        String answer = "";
        for(int i=0 ; i<str.length ; i++){           
            if(str[i].length()==0) answer += " ";
            else{
                if(i==str.length-1)
                    answer += str[i].substring(0,1).toUpperCase()+str[i].substring(1);
                else 
                    answer += str[i].substring(0,1).toUpperCase()+str[i].substring(1) + " ";
            }
        }
        if(s.substring(s.length()-1, s.length()).equals(" "))
            answer += " ";
        return answer;
    }
}
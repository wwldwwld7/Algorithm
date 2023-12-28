class Solution {
    public String solution(String[] seoul) {
        int n = -1;
        int size = seoul.length;
        for(int i=0 ; i<size ; i++){
            if(seoul[i].equals("Kim")) n = i;
        }
        String answer = "김서방은 "+n+"에 있다";
        return answer;
    }
}
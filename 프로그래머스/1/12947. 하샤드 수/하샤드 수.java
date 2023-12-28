class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int n = 0;
        int num = x;
        while(num != 0){
            n += num%10;
            num /= 10;
        }
        if(x%n == 0) answer = true;
        else answer = false;
        return answer;
    }
}
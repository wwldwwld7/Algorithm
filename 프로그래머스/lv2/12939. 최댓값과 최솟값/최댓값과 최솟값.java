class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0 ; i<str.length ; i++){
            if(max < Integer.parseInt(str[i]))
                max = Integer.parseInt(str[i]);
            if(min > Integer.parseInt(str[i]))
                min = Integer.parseInt(str[i]);
        }
        String ans = min+" "+max;
        return ans;
    }
}
import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {        
        int n = people.length;
        Arrays.sort(people);
        int big = n-1;
        int small = 0;
        // System.out.println(people[0]);
        int answer = 0;
        while(true){
            if(big <= small){
                if(big == small) answer++;
                break;
            }
            if((people[big] + people[small]) <= limit){
                big--;
                small++;
            }
            else big--;
            answer++;
        }
        
        return answer;
    }
}
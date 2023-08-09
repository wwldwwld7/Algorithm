import java.io.*;
import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        int len = A.length;
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i=0 ; i<len ; i++){
            answer += A[i]*B[len-i-1];
        }

        return answer;
    }
}
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1 ; tc<=T ; tc++){
            int N = sc.nextInt();
            int add=1;
            int[] numCheck = new int[10];
            while(true){
                int temp = N*add;
                while(true){
//                    System.out.println(temp);
                    if(temp<10){
                        numCheck[temp]++;
                        break;
                    }
                    numCheck[temp%10]++;
                    temp /= 10;
                }

                boolean flag = true;
                for(int n=0 ; n<10 ; n++){
                    if(numCheck[n] == 0) {
                        flag = false;
                    }
                }
                if(flag) break;

                add++;
            }

            System.out.println("#"+tc+" "+(N*add));
        }

    }
}
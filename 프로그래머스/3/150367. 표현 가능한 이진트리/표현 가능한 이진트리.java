import java.util.*;
class Solution {
    static Boolean check = true;
    public int[] solution(long[] numbers) {       
        int N = numbers.length;
        int[] answer = new int[N];
        for(int tc=0 ; tc<N ; tc++){
            check = true;
            String binary = Long.toBinaryString(numbers[tc]);
            // System.out.println(binary);
            int n = nodeCnt(binary.length());
            String tree = binary;

            //포화이진트리 만들기
            int size = binary.length();
            for(int i=0 ; i<n-size ; i++){
                tree = "0"+tree;
                
                // if(idx < 0) tree[i] = '0';
                // else tree[i] = binary.charAt(idx);
            }
            //잘만들었는지 출력
            // System.out.println(tree);

            //이진트리로 표현 가능한지 확인하는 함수
            confirm(tree);
            
            if(!check) answer[tc] = 0;
            else answer[tc] = 1;
        }     
        return answer;
    }
    
    static int nodeCnt(int len){
        //트리 노드의 최소 개수
        int node = 1;
        while(node < len){
            node = node*2+1;
        }
        return node;
    }
    
    static void confirm(String tree){
        int n = tree.length();
        int root = tree.charAt(n/2)-'0';

        if(!check) return;
        if(n==1){
            check = true;
            return;
        }
        if(root==0 && tree.contains("1")){
            check = false;
            return;
        }
        if(root==0 && !tree.contains("1")){
            check = true;
            return;
        }
        
        //left
        confirm(tree.substring(0,n/2));
        //right
        confirm(tree.substring(n/2+1));
    }
}
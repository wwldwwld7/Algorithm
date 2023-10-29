import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2)->{
            return o2-o1;
        });
        
        int l = works.length;
        for(int i=0 ; i<l ; i++){
            pq.add(works[i]);
        }
        
        for(int i=0 ; i<n ; i++){
            int num = pq.poll();
            if(num<=0) {
                pq.add(num);
                break;
            }
            num--;
            pq.add(num);
        }
        
        long answer = 0;
        for(int i=0 ; i<l ; i++){
            int num = pq.poll();
            answer += num * num;
        }
        return answer;
    }
}
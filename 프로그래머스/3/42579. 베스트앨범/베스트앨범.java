import java.util.*;
class ms{
    int total;
    int pl;
    int idx;
    public ms(int total, int pl, int idx){
        this.total = total;
        this.pl = pl;
        this.idx = idx;
    }
}
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        //장르별 최대 두개
        //재생 수 가장 많은 장르부터
        //같은 장르에서 더 많이 재생된 곡부터
        int n = genres.length;
        Map<String, Integer> music = new HashMap<>();
        //장르별 총 재생횟수 구한다.
        for(int i=0 ; i<n ; i++){
            if(!music.containsKey(genres[i])){
                music.put(genres[i], plays[i]);
            }
            else{
                int a = music.get(genres[i]);
                music.replace(genres[i], plays[i]+a);
            }
        }
        //총재생횟수와 내 재생횟수로 정렬
        PriorityQueue<ms> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.total != o2.total) return o2.total - o1.total;
            else{
                if(o1.pl != o2.pl) return o2.pl - o1.pl;
                else return o1.idx - o2.idx;
            }
        });
        ms nnew = new ms(music.get(genres[0]), plays[0], 0);
        for(int i=0 ; i<n ; i++){
            pq.add(new ms(music.get(genres[i]), plays[i], i));
        }
        int aIndex = 0;
        int name = -1;
        int num = 0;
        List<Integer> list = new ArrayList<>();
        int m = pq.size();
        // System.out.println(pq.size());
        for(int i=0 ; i<m ; i++){
            ms msc = pq.poll();
            // System.out.println("i : "+i);
            if(i==0) name = msc.total;
            int nowName = msc.total;
            if(name != nowName){
                num=0;
            }
            // System.out.println(num);
            if(num>=2) {
                // pq.poll();
                continue;
            }

            list.add(msc.idx);
            name = nowName;
            num++;
        }
        int[] answer = new int[list.size()];
        for(int i=0 ; i<list.size() ; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
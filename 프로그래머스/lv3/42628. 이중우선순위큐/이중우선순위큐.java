import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2]; // [최댓값, 최소값]

        List<Integer> list = new ArrayList<>();
        
        for(int i=0 ; i<operations.length ; i++){
            String[] str = operations[i].split(" ");
            if(str[0].equals("I")){
                int num = Integer.parseInt(str[1]);
                list.add(num);
            }
            else{
                if(list.size() > 0){
                    if(str[1].equals("1")){
                        list.remove(list.size()-1);
                    }else{
                        list.remove(0);
                    }
                }
            }
            Collections.sort(list);
            // System.out.println(list.toString());
        }
        if(list.size() > 0){
            answer[0] = list.get(list.size()-1);
            answer[1] = list.get(0);
        }
        
        return answer;
    }
}
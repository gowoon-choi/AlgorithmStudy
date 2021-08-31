import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.substring(2, s.length()-2);
        String[] split = s.split("[}]*[,][{]*");
        Map<Integer, Integer> count = new HashMap<>();
        int current, value;
        for(String str : split){
            current = Integer.parseInt(str);
            value = 1;
            if(count.containsKey(current)) value += count.get(current);
            count.put(current, value);
        }
        List<Map.Entry<Integer, Integer>> entry = new LinkedList<>(count.entrySet());
        entry.sort(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });
        int[] answer = new int[entry.size()];
        for(int i=0; i<entry.size(); i++) answer[i] = entry.get(i).getKey();
        return answer;
    }
}

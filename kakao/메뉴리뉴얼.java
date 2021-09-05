import java.util.*;

class Solution {
    static Map<String, Integer> menu;

    public static void put(String key){
        int value = 1;
        if(menu.containsKey(key)) value += menu.get(key);
        menu.put(key, value);
    }

    public static String sortString(String str){
        char[] temp = str.toCharArray();
        Arrays.sort(temp);
        return new String(temp);
    }

    public static String makeString(String str, boolean[] visited){
        String result = "";
        for(int i=0; i<str.length(); i++){
            if(visited[i]) result+=str.charAt(i);
        }
        result = sortString(result);
        return result;
    }

    public static void combination(String input, int n, boolean[] visited, int cur){
        if(n == 0){
            put(makeString(input, visited));
            return;
        }
        for(int i=cur; i<input.length(); i++){
            visited[i] = true;
            combination(input, n-1, visited, i+1);
            visited[i] = false;
        }
    }
    
    public String[] solution(String[] orders, int[] course) {
        String[] answer;
        List<Map.Entry<String, Integer>> entryList;
        ArrayList<String> result = new ArrayList<>();
        for(int n : course){
            menu = new HashMap<>();
            for(String order : orders){
                order = sortString(order);
                if(order.length() < n) continue;
                else if(order.length() == n) put(order);
                else combination(order, n, new boolean[order.length()], 0);
            }
            entryList = new LinkedList<>(menu.entrySet());
            entryList.sort(new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return o2.getValue()-o1.getValue();
                }
            });
            for(int i=0; i<entryList.size(); i++){
                if(entryList.get(i).getValue() <= 1) break;
                result.add(entryList.get(i).getKey());
                if(i == entryList.size()-1 || !entryList.get(i).getValue().equals(entryList.get(i + 1).getValue())) break;
            }
        }
        result.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        answer = new String[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}

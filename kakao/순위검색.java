import java.util.*;

class Solution {
    public static Map<String, String> languageMapper = new HashMap<>(){{
        put("cpp", "1");
        put("java", "2");
        put("python", "3");
    }};
    public static Map<String, String> jobMapper = new HashMap<>(){{
        put("backend", "1");
        put("frontend", "2");
    }};
    public static Map<String, String> careerMapper = new HashMap<>(){{
        put("junior", "1");
        put("senior", "2");
    }};
    public static Map<String, String> foodMapper = new HashMap<>(){{
        put("chicken", "1");
        put("pizza", "2");
    }};

    public static ArrayList<Map<String, Integer>> maps = new ArrayList(Arrays.asList(languageMapper, jobMapper, careerMapper, foodMapper));

    public static Map<String, ArrayList<Integer>> infoSet;
    public static boolean[] visited;

    public static String convert(String[] info){
        String result = "";
        for(int i=0; i<4; i++){
            if(!maps.get(i).containsKey(info[i])) result += "-";
            else result += maps.get(i).get(info[i]);
        }
        return result;
    }

    public static void combination(String info, char[] result, boolean[] visited, int r, int cur, int score){
        if(r == 0){
            String temp = new String(result);
            if(!infoSet.containsKey(temp)) infoSet.put(temp, new ArrayList<>());
            infoSet.get(temp).add(score);
            return;
        }
        for(int i=cur; i<info.length(); i++){
            if(!visited[i]){
                visited[i] = true;
                result[i] = info.charAt(i);
                combination(info, result, visited, r-1, i+1, score);
                result[i] = '-';
                visited[i] = false;
            }
        }
    }

    public static void addCased(String info, int score){
        for(int i=0; i<=4; i++){
            visited = new boolean[info.length()];
            combination(info, "----".toCharArray(), visited, i, 0, score);
        }
    }
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        infoSet = new HashMap<>();
        String[] eachInfo;
        for(String str : info){
            eachInfo = str.split(" ");
            addCased(convert(eachInfo), Integer.parseInt(eachInfo[4]));
        }
        Set<String> keys = infoSet.keySet();
        for(String key : keys){
            infoSet.get(key).sort(Comparator.naturalOrder());
        }
        int left, right, mid, score;
        ArrayList<Integer> target;
        String key, str;
        for(int i=0; i<query.length; i++){
            str = query[i];
            str = str.replace("and ", "");
            eachInfo = str.split(" ");
            key = convert(eachInfo);
            score = Integer.parseInt(eachInfo[4]);
            if(!infoSet.containsKey(key)) continue;
            target = infoSet.get(key);
            left = 0;
            right = target.size()-1;
            while(left < right){
                mid = (left + right) / 2;
                if(target.get(mid) < score) left = mid+1;
                else right = mid;
            }
            answer[i] = target.size() - left;
        }
        return answer;
    }
}

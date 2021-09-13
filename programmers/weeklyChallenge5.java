import java.util.*;

class Solution {
    public static char[] alpha = {'A', 'E', 'I', 'O', 'U'};
    public static ArrayList<String> dic = new ArrayList<>();
    
    public static void combination(char[] out, int depth, int r){
        if(depth == r){
            dic.add(new String(out));
            return;
        }
        for(int i=0; i<alpha.length; i++){
            out[depth] = alpha[i];
            combination(out, depth+1, r);
        }
    }
    
    public int solution(String word) {
        for(int i=1; i<=alpha.length; i++){
            combination(new char[i], 0, i);
        }
        Collections.sort(dic);
        return dic.indexOf(word)+1;
    }
}

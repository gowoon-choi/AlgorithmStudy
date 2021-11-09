import java.util.*;

class Solution {
    public static char[] mems;
    public static ArrayList<Map<Character, Integer>> target;

    public static void permutation(boolean[] visited, char[] output, int size, int depth){
        if(depth == size){
            Map<Character, Integer> temp = new HashMap<>();
            for(int i=0; i<depth; i++){
                temp.put(output[i], i);
            }
            target.add(temp);
            return;
        }
        for(int i=0; i<mems.length; i++){
            if(!visited[i]){
                output[depth] = mems[i];
                visited[i] = true;
                permutation(visited, output, size, depth+1);
                visited[i] = false;
            }
        }
    }

    public static boolean isPossible(char op, int gap, int num){
        if(op == '=') return gap == num;
        else if(op == '<') return gap < num;
        else return gap > num;
    }

    public int solution(int n, String[] data) {
        int answer = 0;

        target = new ArrayList<>();
        mems = new char[]{'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
        int size = mems.length;
        permutation(new boolean[size], new char[size], size, 0);

        char mem1, mem2, operand;
        int gap, num;
        boolean flag;
        for(Map<Character, Integer> elem : target){
            flag = true;
            for(String info : data){
                mem1 = info.charAt(0);
                mem2 = info.charAt(2);
                operand = info.charAt(3);
                num = info.charAt(4)-'0';
                gap = Math.abs(elem.get(mem1)-elem.get(mem2))-1;
                if(!isPossible(operand, gap, num)){
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }

        return answer;
    }
}

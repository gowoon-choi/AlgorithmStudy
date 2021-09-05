import java.util.*;
import java.util.stream.Collectors;

class Solution {
    private static char[] operators = {'+', '-', '*'};
    private static ArrayList<String> combinations = new ArrayList<>();

    public static void combination(int depth, char[] output, boolean[] visited){
        if(depth == operators.length){
            combinations.add(new String(output));
            return;
        }
        for(int i=0; i< operators.length; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = operators[i];
                combination(depth+1, output, visited);
                visited[i] = false;
            }
        }
    }

    public static long calc(Long num1, Long num2, String op){
        Long result = 0L;
        switch (op){
            case "+":
                result = num1+num2;
                break;
            case "-":
                result = num1-num2;
                break;
            case "*":
                result = num1*num2;
                break;
        }
        return result;
    }
    
    public long solution(String expression) {
        combination(0, new char[operators.length], new boolean[operators.length]);
        String[] opsArr = expression.split("[0-9]+");
        String[] numsArr = expression.split("[*+-]");
        ArrayList<String> ops = new ArrayList<>(Arrays.asList(opsArr)); ops.remove(0);
        ArrayList<Long> nums = (ArrayList<Long>) Arrays.stream(numsArr).map(Long::valueOf).collect(Collectors.toList());

        ArrayList<String> opList;
        ArrayList<Long> numList;
        String operator;
        ArrayList<Long> result = new ArrayList<>();
        for(String combination : combinations){
            opList = (ArrayList<String>) ops.clone();
            numList = (ArrayList<Long>) nums.clone();
            for(int i=0; i<combination.length(); i++){
                operator = String.valueOf(combination.charAt(i));
                for(int j=0; j<opList.size(); j++){
                    if(opList.get(j).equals(operator)){
                        numList.set(j, calc(numList.get(j), numList.get(j+1), operator));
                        numList.remove(j+1);
                        opList.remove(j--);
                    }
                }
            }
            result.add(Math.abs(numList.get(0)));
        }
        result.sort(Comparator.reverseOrder());
        return result.get(0);
    }
}

/*
 * 2021.01.14
 * gowoon-choi/github.com
 * programmers 소수 찾기
 */

package com.gowoon;

import java.util.*;

public class Solution {
    public static ArrayList<Integer> allNumbers = new ArrayList<>();

    public static boolean isPrime(Integer num){
        if(num <= 1) return false;
        for(int i=2; i<=Math.sqrt(num); i++){ if(num%i == 0) return false; }
        return true;
    }

    public static void permutaion(int n, ArrayList<Integer> number, boolean[] visited, String value){
        if(value.length() == n){
            if(!allNumbers.contains(Integer.parseInt(value))){
                allNumbers.add(Integer.parseInt(value));
            }
            return;
        }
        for(int i=0; i<number.size(); i++){
            if(visited[i]) continue;
            value += number.get(i);
            visited[i] = true;
            permutaion(n, number, visited, value);
            value = value.substring(0, value.length()-1);
            visited[i] = false;
        }
    }

    public static int solution(String numbers) {
        ArrayList<Integer> number = new ArrayList<>();
        boolean[] visited = new boolean[numbers.length()];
        for(int i=0; i<numbers.length(); i++){
            number.add(Integer.parseInt(String.valueOf(numbers.charAt(i))));
            visited[i] = false;
        }
        for(int i=0; i< number.size(); i++){ permutaion(i+1, number, visited, ""); }
        int count = 0;
        for (Integer allNumber : allNumbers) { if (isPrime(allNumber)) count++; }
        return count;
    }
}

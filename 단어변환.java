/*
 * 2021.04.25
 * gowoon-choi/github.com
 * programmers 단어 변환
 */

package com.gowoon;

import java.util.*;

public class Solution {

    public static boolean isNear(String str1, String str2){
        boolean diff = false;
        for (int i=0; i<str1.length(); i++){
            if (str1.charAt(i) != str2.charAt(i)){
                if(diff) return false;
                else diff = true;
            }
        }
        return diff;
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean isContain = false;
        for (String word : words) {
            if (word.equals(target)) {
                isContain = true;
                break;
            }
        }
        if(!isContain) return 0;
        boolean[] visited = new boolean[words.length];
        Arrays.fill(visited, false);
        Queue<String> currentQueue = new LinkedList<>();
        Queue<String> nextQueue = new LinkedList<>();
        nextQueue.add(begin);
        String current;
        while(!nextQueue.isEmpty()){
            currentQueue.addAll(nextQueue);
            nextQueue.clear();
            answer++;
            while(!currentQueue.isEmpty()){
                current = currentQueue.poll();
                if(current.equals(target)) return answer-1;
                for(int i=0; i<words.length; i++){
                    if(isNear(current, words[i]) && !visited[i]){
                        nextQueue.add(words[i]);
                        visited[i] = true;
                    }
                }
            }
        }
        return 0;
    }
}

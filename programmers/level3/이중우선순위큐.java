/*
 * 2021.05.05
 * gowoon-choi/github.com
 * programmers 이중우선순위큐
 */

package com.gowoon;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public static int[] solution(String[] operations) {
        int[] answer = {0, 0};
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        String[] splited;
        int count = 0;
        for(String operation : operations){
            splited = operation.split(" ");
            switch (splited[0]){
                case "I" : {
                    max.add(Integer.valueOf(splited[1]));
                    min.add(Integer.valueOf(splited[1]));
                    count ++;
                    break;
                }
                case "D" : {
                    if(count == 0) continue;
                    if(splited[1].charAt(0) == '-') min.poll();
                    else max.poll();
                    count--;
                    break;
                }
            }
        }
        if(count != 0){
            answer[0] = max.poll();
            answer[1] = min.poll();
        }
        return answer;
    }
}

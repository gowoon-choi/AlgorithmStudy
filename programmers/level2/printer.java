/*
 * 2021.05.04
 * gowoon-choi/github.com
 * programmers 프린터
 */

package com.gowoon;

import java.util.*;

public class Solution {

    public static class Job{
        private int priority;
        private int location;
        Job(int priority, int location){
            this.priority = priority;
            this.location = location;
        }
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Job> printerQueue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++) printerQueue.add(new Job(priorities[i], i));
        Arrays.sort(priorities);
        int printed = 1;
        while(!printerQueue.isEmpty()){
            if(printerQueue.peek().priority == priorities[priorities.length-printed]){
                if(printerQueue.peek().location == location) return printed;
                printerQueue.poll();
                printed++;
            }
            else{
                Job job = printerQueue.poll();
                printerQueue.add(job);
            }
        }
        return answer;
    }
}

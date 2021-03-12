/*
 * 2021.03.12
 * gowoon-choi/github.com
 * programmers 디스크 컨트롤러
 */

package com.gowoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static class Task implements Comparable<Task>{
        private int requested;
        private int required;

        Task(int requested, int required){
            this.requested = requested;
            this.required = required;
        }

        @Override
        public int compareTo(Task task) {
            return this.required - task.required;
        }
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        int currentTime = 0;
        int index = 1;
        int i;
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        PriorityQueue<Task> pq = new PriorityQueue<>();
        pq.add(new Task(jobs[0][0], jobs[0][1]));
        while (!pq.isEmpty()){
            if(currentTime < pq.peek().requested) currentTime = pq.peek().requested;
            currentTime += pq.peek().required;
            answer += currentTime - pq.poll().requested;
            for(i=index; i<jobs.length; i++){
                if(jobs[i][0] <= currentTime){
                    pq.add(new Task(jobs[i][0], jobs[i][1]));
                }
                else {
                    if(pq.isEmpty()){
                        pq.add(new Task(jobs[i][0], jobs[i][1]));
                        i++;
                    }
                    break;
                }
            }
            index = i;
        }
        return answer/ jobs.length;
    }
}

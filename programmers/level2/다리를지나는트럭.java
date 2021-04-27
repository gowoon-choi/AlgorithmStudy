/*
 * 2021.04.27
 * gowoon-choi/github.com
 * programmers 다리를 지나는 트럭
 */

package com.gowoon;

import java.util.Vector;

public class Solution {
    public static class Truck{
        int weight;
        int time;
        Truck(int weight){
            this.weight = weight;
            this.time = 0;
        }
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int current = 0;
        int move;
        Vector<Truck> onBridge = new Vector<>();
        for (int i=0; i<truck_weights.length; i++) {
            if (onBridge.isEmpty() || current + truck_weights[i] <= weight){
                onBridge.add(new Truck(truck_weights[i]));
                current += truck_weights[i];
                move = 1;
            }
            else {
                i--;
                move = bridge_length - onBridge.get(0).time;
            }
            for (int j = 0; j < onBridge.size() ; j++) {
                onBridge.get(j).time+=move;
                if (onBridge.get(j).time == bridge_length){
                    current -= onBridge.get(j).weight;
                    onBridge.remove(j);
                    j--;
                }
            }
            answer+=move;
        }
        return answer+(bridge_length - onBridge.get(onBridge.size()-1).time);
    }
}

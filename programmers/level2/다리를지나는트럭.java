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

    public static boolean isPossible(int weight, Vector<Truck> onBridge, int next_weight){
        int total = 0;
        for(Truck truck : onBridge){
            total += truck.weight;
        }
        return (total + next_weight) <= weight;
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        Vector<Truck> onBridge = new Vector<>();
        for (int i=0; i<truck_weights.length; i++) {
            if (onBridge.isEmpty() || isPossible(weight, onBridge, truck_weights[i])) onBridge.add(new Truck(truck_weights[i]));
            else i--;
            for (int j = 0; j < onBridge.size() ; j++) {
                if (onBridge.get(j).time + 1 == bridge_length){
                    onBridge.remove(j);
                    j--;
                }
                else onBridge.get(j).time++;
            }
            answer++;
        }
        return answer+(bridge_length - onBridge.get(onBridge.size()-1).time);
    }
}

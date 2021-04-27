import java.util.Vector;

class Solution {
    public static class Truck{
        int weight;
        int time;
        Truck(int weight){
            this.weight = weight;
            this.time = 0;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int current = 0;
        Vector<Truck> onBridge = new Vector<>();
        for (int i=0; i<truck_weights.length; i++) {
            if (onBridge.isEmpty() || current + truck_weights[i] <= weight){
                onBridge.add(new Truck(truck_weights[i]));
                current += truck_weights[i];
            } 
            else i--;
            for (int j = 0; j < onBridge.size() ; j++) {
                if (onBridge.get(j).time + 1 == bridge_length){
                    current -= onBridge.get(j).weight;
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

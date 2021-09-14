import java.util.*;

class Solution {
    public static class Data{
        private int index;
        private double winRate;
        private int winOverWeight;
        private int myWeight;
        Data(int index, int myWeight){
            this.index = index;
            winRate = 0.0;
            winOverWeight = 0;
            this.myWeight = myWeight;
        }
    }

    public int[] solution(int[] weights, String[] head2head) {
        int[] answer = new int[weights.length];
        
        ArrayList<Data> boxers = new ArrayList<>();
        double count, win;
        for(int i=0; i<head2head.length; i++){
            boxers.add(new Data(i+1, weights[i]));
            count = 0;
            win = 0;
            for(int j=0; j<head2head[i].length(); j++){
                if(head2head[i].charAt(j) == 'W'){
                    count++;
                    win++;
                    if(weights[j] > weights[i]) boxers.get(i).winOverWeight++;
                }
                else if(head2head[i].charAt(j) == 'L') count++;
            }
            if(count!=0) boxers.get(i).winRate = win/count;
        }
        
        Collections.sort(boxers, new Comparator<>(){
            @Override
            public int compare(Data o1, Data o2){
                if(o1.winRate == o2.winRate){
                    if(o1.winOverWeight == o2.winOverWeight){
                        return o2.myWeight-o1.myWeight;
                    }
                    else return o2.winOverWeight-o1.winOverWeight;
                }
                else{
                    if(o2.winRate > o1.winRate) return 1;
                    else return -1;
                }
            }
        });
        
        for(int i=0; i<boxers.size(); i++){
            answer[i] = boxers.get(i).index;
        }
        
        return answer;
    }
}

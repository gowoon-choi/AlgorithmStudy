/*
 * 2021.01.15
 * gowoon-choi/github.com
 * programmers 조이스틱
 */

public class Solution {
    public static int solution(String name) {
        int alphaChanged = 0;
        int maxA = 0;
        int countA = 0;
        int maxIndex = -1;
        for(int i=0; i<name.length(); i++){
            if((int)name.charAt(i)-65 < 13){ alphaChanged += (name.charAt(i)-65); }
            else{ alphaChanged += (91-name.charAt(i)); }
            if(name.charAt(i) == 'A'){
                if(i != 0) countA++;
                if(i == name.length()-1){
                    if(countA > maxA){
                        maxA = countA;
                        maxIndex = i-1;
                    }
                }
            }
            else{
                if(countA > maxA){
                    maxA = countA;
                    maxIndex = i-1;
                    countA = 0;
                }
            }
        }
        if(maxA == name.length()-1) return 0;
        if(maxA == 0){ return alphaChanged+name.length()-1; }
        int distance = maxIndex - maxA;
        if((name.length()-maxIndex-1) < distance) distance = name.length()-maxIndex-1;
        int leftA = 0;
        int rightA = 0;
        for(int i=1; i<name.length(); i++){
            if(name.charAt(i) == 'A') leftA++;
            else break;
        }
        for(int i=1; i<=name.length(); i++){
            if(name.charAt(name.length()-i) == 'A') rightA++;
            else break;
        }
        if(maxA <= distance){
            if(leftA > rightA){ return name.length()-leftA-1; }
            else{ return name.length()-rightA-1+alphaChanged; }
        }
        else{
            int bigger = rightA;
            if(leftA > rightA) bigger = leftA;
            if(maxA-distance < bigger) return name.length()-bigger-1+alphaChanged;
            return (distance*2)+((name.length()-1)-(distance+maxA))+alphaChanged;
        }
    }
}

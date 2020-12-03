package com.gowoon;

public class Solution {
    public String covertToBinary(int N){
        String result = "";
        int num = N;
        while(num > 1){
            result = num%2 + result;
            num = num/2;
        }
        return "1"+result;
    }

    public int calcGap(String binary){
        int result = 0;
        int count = 0;;
        for(int i=0; i<binary.length(); i++){
            if(binary.charAt(i) == '0') count ++;
            else if(binary.charAt(i) == '1'){
                if(result < count) result = count;
                count = 0;
            }
        }
        return result;
    }

    public int solution(int N) {
        String binary = covertToBinary(N);
        return calcGap(binary);
    }
}

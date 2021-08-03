class Solution {
    public long sumTo(int num){
        return num*(num+1)/2;
    }
    
    public long solution(int price, int money, int count) {
        long result = (sumTo(count)*price) - money;
        if(result < 0) return 0;
        else return result;
    }
}

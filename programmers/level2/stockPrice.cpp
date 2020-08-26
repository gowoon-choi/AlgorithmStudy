/*
 * Programmers 주식 가격
 * stockPrice.cpp
 * 2020.08.27
 * github.com/gowoon-choi
 */

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

vector<int> solution(vector<int> prices) {
    vector<int> answer(prices.size());
    stack<pair<int,int>> stack;
    stack.push(make_pair(prices[0],0));
    int count;
    for(int i=1; i<prices.size(); i++){
        count = 0;
        while (1){
            if(stack.empty() || prices[i]>=stack.top().first){
                stack.push(make_pair(prices[i], i));
                break;
            }
            else{
                answer[stack.top().second] = i-stack.top().second;
                stack.pop();
                count++;
            }
        }
    }
    while (!stack.empty()){
        answer[stack.top().second] = prices.size() - stack.top().second - 1;
        stack.pop();
    }
    return answer;
}

int main(){
    int size;
    cin >> size;
    vector<int> prices(size);
    for(int i=0; i<prices.size(); i++){
        cin >> prices[i];
    }
    vector<int> result = solution(prices);
    for(int i=0; i<result.size(); i++){
        cout << result[i] << " ";
    }
}

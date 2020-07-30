/*
 * Programmers 예산
 * budget.cpp
 * 2020.07.31
 * github.com/gowoon-choi
 */

#include <iostream>
#include <vector>

using namespace std;

int solution(vector<int> budgets, int M) {
    int answer = *max_element(budgets.begin(),budgets.end());
    int min = 1;
    int max = answer;
    long sum = 0;

    for(int i=0; i<budgets.size(); i++) sum+=budgets[i];
    if(sum != M){
        while(max-min>1){
            if((M-sum) > 0) min = answer;
            else max = answer;
            answer = (min+max)/2;
            sum = 0;
            for(int i=0; i<budgets.size(); i++){
                if(budgets[i] > answer) sum += answer;
                else sum += budgets[i];
            }
        }
    }
    return answer;
}

int main(){
    int size, totalBudget;
    cin >> size;
    vector<int> budgets(size);
    for(int i=0; i<size; i++){
        cin >> budgets[i];
    }
    cin >> totalBudget;
    cout << solution(budgets, totalBudget);
    return 0;
}

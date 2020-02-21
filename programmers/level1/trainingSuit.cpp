/*
 * Programmers 체육복
 * trainingSuit.cpp
 * 2020.02.21
 * github.com/choigone
 */

#include <iostream>
#include <vector>
#include <string>

using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    vector<int> student(n+1,1);
    student[0] = -1;
    for(int i=0; i<lost.size(); i++) student[lost[i]]--;
    for(int i=0; i<reserve.size(); i++) student[reserve[i]]++;

    for(int i=1; i<=n; i++){
        if(student[i] == 0){
            if(student[i-1] == 2){
                student[i]++;
                student[i-1]--;
            }
            else if(student[i+1] == 2){
                student[i]++;
                student[i+1]--;
            }
            else answer++;
        }
    }
    return n-answer;
}

int main(){
    int n, lostn, reserven;
    cin >> n >> lostn >> reserven;
    vector<int> lost;
    vector<int> reserve;
    int temp;
    for(int i=0; i<lostn; i++){
        cin >> temp;
        lost.push_back(temp);
    }
    for(int i=0; i<reserven; i++){
        cin >> temp;
        reserve.push_back(temp);
    }
    cout << solution(n, lost, reserve);

    return 0;
}

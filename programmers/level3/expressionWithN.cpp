/*
 * Programmers N으로 표현
 * expressionWithN.cpp
 * 2020.05.21
 * github.com/choigone
 */

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>

using namespace std;

#define MAX 8

int solution(int N, int number) {
    int answer = -1;
    if(N == number){
        return 1;
    }
    else{
        string temp="";
        vector<vector<int>> DP(MAX+1);
        DP[1].push_back(N);
        for(int i=2; i<=MAX; i++){
            for(int j=1; j<=i/2; j++){
                for(int k=0; k<DP[j].size(); k++){
                    for(int l=0; l<DP[i-j].size(); l++){
                        if(DP[j][k] + DP[i-j][l] == number) return i;
                        else DP[i].push_back(DP[j][k] + DP[i-j][l]);
                        if(DP[j][k] - DP[i-j][l] == number) return i;
                        else DP[i].push_back(DP[j][k] - DP[i-j][l]);
                        if(DP[i-j][l] - DP[j][k] == number) return i;
                        else DP[i].push_back(DP[i-j][l] - DP[j][k]);
                        if(DP[j][k] * DP[i-j][l] == number) return i;
                        else DP[i].push_back(DP[j][k] * DP[i-j][l]);
                        if(DP[i-j][l] != 0){
                            if(DP[j][k] / DP[i-j][l] == number) return i;
                            else DP[i].push_back(DP[j][k] / DP[i-j][l]);
                        }
                        if(DP[j][k] != 0){
                            if(DP[i-j][l] / DP[j][k] == number) return i;
                            else DP[i].push_back(DP[i-j][l] / DP[j][k]);
                        }
                    }
                }
            }
            sort(DP[i].begin(), DP[i].end());
            DP[i].erase(unique(DP[i].begin(), DP[i].end()), DP[i].end());
            for(int j=0; j<i; j++) temp+=to_string(N);
            if(stoi(temp) == number) return i;
            DP[i].push_back(stoi(temp));
            temp="";
        }
    }
    return answer;
}

int main(){
    int N, number;
    cin >> N >> number;
    cout << solution(N, number);
    return 0;
}

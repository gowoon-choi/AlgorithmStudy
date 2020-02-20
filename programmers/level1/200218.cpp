/*
 * Programmers level1 바이러스
 * 200218-lv1.cpp
 * 2020.02.18
 * github.com/choigone
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> array, vector<vector<int>> commands){
    vector<int> answer;
    vector<int> test;
    for(int i=0; i<commands.size(); i++){
        test = array;
        sort(test.begin()+(commands[i][0]-1),test.begin()+commands[i][1]);
        answer.push_back(test[(commands[i][0] - 1) + (commands[i][2] - 1)]);
    }
    return answer;
}

int main(){
    int num, testcase;
    cin >> num;
    vector<int> array(num);
    for(int i=0; i<num; i++){
        cin >> array[i];
    }
    cin >> testcase;
    vector<vector<int>> commands(testcase);
    vector<int> temp(3);
    for(int i=0; i<testcase; i++){
        cin >> temp[0] >> temp[1] >> temp[2];
        commands[i] = temp;
    }
    vector<int> result = solution(array, commands);
    for(int i=0; i<testcase; i++){
        cout << result[i] << " ";
    }
    return 0;
}

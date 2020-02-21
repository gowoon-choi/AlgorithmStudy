/*
 * programmers 완주하지 못 한 선수
 * failedPlayer.cpp
 * 2020.02.07
 * github.com/choigone
 */

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

// sort and compare ( idea by hash )
string solution(vector<string> participant, vector<string> completion){
    sort(participant.begin(), participant.end());
    sort(completion.begin(), completion.end());
    for(int i=0;i<completion.size();i++)
    {
        if(participant[i] != completion[i])
            return participant[i];
    }
    return participant[participant.size() - 1];
}

// using set_differece
string solution2(vector<string> participant, vector<string> completion){
    sort(participant.begin(),participant.end());
    sort(completion.begin(),completion.end());
    vector<string> result;
    result.resize(participant.size()+completion.size());
    auto iter = set_difference(participant.begin(),participant.end(),completion.begin(), completion.end(),result.begin());
    result.erase(iter,result.end());
    string answer = result[0];
    return answer;
}

int main(){
    int n;
    cin >> n;
    vector<string> p(n);
    for(int i=0; i<n; i++){
        cin >> p[i];
    }
    vector<string> c(n-1);
    for(int i=0; i<n-1; i++){
        cin >> c[i];
    }
    cout<< solution(p,c);
}

/*
 * swExpert #3752
 * testScore.cpp
 * 2019.08.05
 * 최고운 github.com/choigone
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int possibleScore(vector<int> score){
    int temp;
    vector<int> scores;
    scores.push_back(0);
    for(int i=0;i<score.size();i++){
        temp = scores.size();
        scores.push_back(score[i]);
        for(int j=0;j<temp;j++){
            scores.push_back(scores[j]+score[i]);
        }
    }
    sort(scores.begin(),scores.end());
    scores.erase(unique(scores.begin(),scores.end()),scores.end());
    return scores.size();
}

int main(){
    int testCase;
    int count;
    int temp;
    vector<int> score;
    vector<int> result;
    cin >> testCase;
    for(int i=0;i<testCase;i++){
        cin >> count;
        for(int j = 0; j<count;j++){
            cin >> temp;
            score.push_back(temp);
        }
        result.push_back(possibleScore(score));
        score.clear();
    }
    for(int i=0;i<result.size();i++) cout << "#" << i+1 << " " << result[i] << endl;
    
    return 0;
}


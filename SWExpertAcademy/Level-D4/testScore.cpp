/*
 * swExpert #3752
 * testScore.cpp
 * 2019.08.05
 * 최고운 github.com/choigone
 */

#include <iostream>
#include <vector>
#include <set>
#include <algorithm>

using namespace std;

//TODO DP로 풀어보자
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
    int temp,temp2;

    vector<int> score;
    score.push_back(0);
    cin >> testCase;
    for(int i=0;i<testCase;i++){
        cin >> count;
        for(int j = 0; j<count;j++){
            cin >> temp;
            temp2 = score.size();
            score.push_back(temp);
            for(int j=0;j<temp2;j++){
                score.push_back(score[j]+temp);
            }
        }
        cout << "#" << i+1 << " " << possibleScore(score) << endl;
        score.clear();
    }

    return 0;
}

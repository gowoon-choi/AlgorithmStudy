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

int func(vector<int> a, vector<int> result, int size, int depth){
    int dep = depth;
    int temp;
    if(dep == size){
        sort(result.begin(),result.end());
        result.erase(unique(result.begin(),result.end()),result.end());
        return result.size();
    }
    else{
        if(result.size() != 1){
            temp = result.size()-1;
            for(int i=0;i<temp;i++){
                result.push_back(result[i+1]+a[dep]);
            }
        }
        result.push_back(a[dep]);
        temp = func(a,result,size,dep+1);
    }
    return temp;
}

int main(){
    int testCase;
    int count;
    int temp;
    vector<int> score;
    vector<int> result;
    vector<int> answer;
    cin >> testCase;
    for(int i=0;i<testCase;i++){
        cin >> count;
        for(int j = 0; j<count;j++){
            cin >> temp;
            score.push_back(temp);
        }
        result.push_back(0);
        answer.push_back(func(score,result,count,0));
        score.clear();
        result.clear();
    }
    for(int i=0;i<answer.size();i++) cout << "#" << i+1 << " " << answer[i] << endl;

    return 0;
}


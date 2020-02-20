/*
 * programmers 모의고사
 * 200212-lv1.cpp
 * 2020.02.12
 * github.com/choigone
 */

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> pattern1{ 1, 2, 3, 4, 5 };
vector<int> pattern2{ 2, 1, 2, 3, 2, 4, 2, 5 };
vector<int> pattern3{ 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

bool compare(pair<int,int> a, pair<int,int> b){
    return a.second > b.second;
}
// param answers : answer of problems
// return answer : persons got best score
vector<int> solution(vector<int> answers){
    vector<pair<int,int>> persons{make_pair(1,0), make_pair(2,0), make_pair(3,0)};

    for(int i=0; i<answers.size(); i++){
        //pattern1
        if(answers[i] == pattern1[i%5]){
            persons[0].second++;
        }
        //pattern2
        if(answers[i] == pattern2[i%8]){
            persons[1].second++;
        }
        //pattern3
        if(answers[i] == pattern3[i%10]){
            persons[2].second++;
        }
    }
    sort(persons.begin(), persons.end(), compare);
    vector<int> answer;
    answer.push_back(persons[0].first);
    for(int i=1; i<3; i++){
        if(persons[0].second == persons[i].second){
            answer.push_back(persons[i].first);
        }
        else{
            break;
        }
    }

    return answer;
}

int main(){
    int size;
    cin >> size;

    vector<int> problems(size);
    for(int i=0; i<size; i++){
        cin >> problems[i];
    }

    vector<int> result = solution(problems);
    for(int i=0; i<result.size(); i++){
        cout << result[i];
    }

    return 0;
}

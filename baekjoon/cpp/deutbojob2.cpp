/*
 * baekjoon #1764
 * deutbojob.cpp
 * 2019.09.18
 * 최고운 github.com/choigone
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;


int main(){
    int n,m;
    cin >> n >> m;

    vector<string> group1;
    vector<string> group2;
    vector<string> result;

    string temp;

    for(int i=0;i<n;i++){
        cin >> temp;
        group1.push_back(temp);
    }

    for(int i=0;i<m;i++){
        cin >> temp;
        group2.push_back(temp);
    }

    sort(group1.begin(),group1.end());
    sort(group2.begin(),group2.end());

    set_intersection(group1.begin(),group1.end(),group2.begin(),group2.end(),back_inserter(result));
    sort(result.begin(), result.end());

    cout << result.size() << endl;
    for(int i=0;i<result.size();i++){
        cout << result[i] << endl;
    }

    return 0;
}
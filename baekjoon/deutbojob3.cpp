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

    vector<string> group;
    vector<string> result;

    string temp;

    for(int i=0;i<n+m;i++){
        cin >> temp;
        group.push_back(temp);
    }

    sort(group.begin(), group.end());

    for(int i=0;i<n+m;i++){
        if(group[i] == group[i+1]) result.push_back(group[i++]);
    }

    sort(result.begin(),result.end());
    cout << result.size() << endl;
    for(int i=0;i<result.size();i++){
        cout << result[i] << endl;
    }

    return 0;
}
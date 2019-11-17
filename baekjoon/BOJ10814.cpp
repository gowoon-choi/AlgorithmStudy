/*
 * baekjoon #10814 
 * BOJ1260.cpp
 * 2019.10.28
 * 최고운 github.com/choigone
 */

#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

bool compare(pair<int,string> a, pair<int,string> b){
    return a.first < b.first;
}

int main(){
    int n;
    scanf("%d",&n);

    vector<pair<int,string>> p;

    int age;
    string name;
    for(int i=0; i<n; i++){
        scanf("%d",&age);
        cin >> name;
        p.push_back(make_pair(age,name));
    }
    stable_sort(p.begin(),p.end(),compare);

    for(int i=0; i<p.size(); i++){
        printf("%d ",p[i].first);
        cout << p[i].second << "\n";
    }

    return 0;
}
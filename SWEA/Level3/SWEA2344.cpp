/*
 * SWEA #1244 최대상금
 * SWEA2344.cpp
 * 2020.04.24
 * github.com/choigone
 */

#include <iostream>
#include <queue>
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

string swap(string s, int a, int b){
    char temp = s[a];
    s[a] = s[b];
    s[b] = temp;
    return s;
}

bool cmp(int a, int b){
    return a > b;
}

pair<string,int> max(string s){
    vector<int> v,e;
    for(int i=0; i<s.length(); i++){
        v.push_back(s[i]-'0');
    }
    sort(v.begin(),v.end(),cmp);
    e = v;
    e.erase(unique(e.begin(),e.end()),e.end());
    int index;
    if(e.size() == v.size()) index = 0;
    else index = 1;
    string result = "";
    for(int i=0; i<v.size(); i++){
        result += to_string(v[i]);
    }
    return make_pair(result,index);
}

int bfs(string num, int count){
    int size = num.length();
    int visited = 0;
    queue<string> cur, next;
    vector<int> result;
    next.push(num);
    string temp, current;
    pair<string,int> a;
    while(count){
        cur = next;
        next = {};
        while(!cur.empty()){
            current = cur.front();
            cur.pop();
            a = max(num);
            if(current == a.first){
                if(count%2 == 0 || a.second){
                    return stoi(current);
                }
                else{
                    return stoi(swap(current,size-1, size-2));
                }
            }
            for(int i=0; i<size-1; i++){
                for(int j=i+1; j<size; j++){
                    if(current[i]-'0' == current[j]-'0'){
                        if(visited == 0){
                            visited = 1;
                            temp = current;
                            if(count == 1) result.push_back(stoi(temp));
                            else next.push(temp);
                        }
                        else continue;
                    }
                    else {
                        temp = swap(current,i,j);
                        if(count == 1) result.push_back(stoi(temp));
                        else next.push(temp);
                    }
                }
            }
        }
        count--;
        visited = 0;
    }
    return *max_element(result.begin(),result.end());
}

int main() {
    int n, count;
    string num;
    cin >> n;
    for(int t=0; t<n; t++){
        cin >> num >> count;
        cout << "#" << t+1 << " " << bfs(num, count) << "\n";
    }
    return 0;
}

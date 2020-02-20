/*
 * programmers 문자열 압축
 * 200116-lv1.cpp
 * 2020.01.16
 * 최고운 github.com/choigone
 */

#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string s){
    vector<int> list;
    for(int i=1; i<=s.length()/2; i++){
        int count = 1;
        string result = "";
        int j;
        for(j=0; j<=s.length()-i; j+=i){
            if(s.substr(j,i) == s.substr(j+i,i)) count++;
            else{
                if(count == 1) result+=s.substr(j,i);
                else result+=(to_string(count)+s.substr(j,i));
                count = 1;
            }
        }
        result+=s.substr(j,s.length()-j);
        list.push_back(result.length());
    }
    list.push_back(s.length());
    sort(list.begin(),list.end());
    int answer = list[0];
    return answer;
}

int main(){
    string str;
    cin >> str;
    cout << solution(str);
}

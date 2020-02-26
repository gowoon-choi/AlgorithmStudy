/*
 * Programmers 가운데 글자 가져오기
 * getCenterOfString.cpp
 * 2020.02.26
 * github.com/choigone
 */

#include <iostream>
#include <string>

using namespace std;

string solution(string s){
    int n = s.length();
    if(n%2 == 0){
        return s.substr(n/2-1,2);
    }
    else{
        return s.substr(n/2,1);
    }
}

int main(){
    string s;
    cin >> s;
    cout << solution(s);
    return 0;
}

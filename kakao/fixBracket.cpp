/*
 * kakao 2020 blind 괄호변환
 * fixBracket.cpp
 * 2020.09.09
 * github.com/gowoon-choi
 */

#include <iostream>
#include <string>
#include <vector>
#include <stack>

using namespace std;

bool isRight(string p){
    stack<char> braket;
    for(int i=0; i<p.size(); i++){
        if(p[i] == '(') braket.push(p[i]);
        else{
            if(braket.empty()) return false;
            else braket.pop();
        }
    }
    return true;
}

bool isBalanced(string p){
    int left = 0;
    int right = 0;
    for(int i=0; i<p.size(); i++){
        if(p[i] == '(') left++;
        else right++;
    }
    if(left == right) return true;
    else return false;
}

string reverse(string p){
    string result="";
    for(int i=0; i<p.size(); i++){
        if(p[i] == ')') result += "(";
        else result += ")";
    }
    return result;
}

string func(string p){
    string result = "";
    string empty;
    string left, right;
    if(p == "") return "";
    else if(isRight(p)) return p;
    else{
        for(int i=0; i<p.size(); i++){
            left = p.substr(0, i+1);
            if(isBalanced(left)){
                right = p.substr(i+1, right.size()-left.size());
                if(isRight(left)){
                    result += left;
                    result += func(right);
                    return result;
                }
                else{
                    empty = "(";
                    empty += func(right);
                    empty += ")";
                    result += empty;
                    result += reverse(left.substr(1, left.size()-2));
                    return result;
                }
            }
        }
    }
    return result;
}

string solution(string p) {
    return func(p);
}

int main(){
    string input;
    cin >> input;
    cout << solution(input);
    return 0;
}

/*
 * baekjoon #1541
 * BOJ1541.cpp
 * 2019.09.23
 * 최고운 github.com/choigone
 */

#include <iostream>
#include <string>

using namespace std;

int main(){
    string input;
    cin >> input;

    string temp;
    int index = 0;
    int result = 0;
    for(int i=0;i<input.length();i++){
        if(input[i] == '+' || input[i] == '-'){
            if(index == 0){
                result += stoi(temp);
            }
            else{
                result -= stoi(temp);
            }
            temp = "";
        }
        else{
            temp += input[i];
        }

        if(input[i] == '-') index = 1;
    }
    if(index == 0){
        result += stoi(temp);
    }
    else{
        result -= stoi(temp);
    }

    cout << result;

    return 0;
}

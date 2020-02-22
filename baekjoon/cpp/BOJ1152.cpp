/*
 * BOJ #1152 단어의 개수
 * BOJ1152.cpp
 * 2020.02.22
 * github.com/choigone
 */

#include <iostream>

#define MAX 1000000

using namespace std;

int main(){
    char str[MAX];
    cin.getline(str,MAX,'\n');
    int index = 0;
    int count = 0;
    for(int i=0; str[i]!='\0'; i++){
        if(str[i] != ' ' && index == 0){
            count ++ ;
            index = 1;
        }
        if(str[i] == ' ') index = 0;
    }
    cout << count;
    return 0;
}

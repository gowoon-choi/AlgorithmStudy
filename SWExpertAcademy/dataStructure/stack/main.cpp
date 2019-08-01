/*
 * stack 구현해서 사용
 */

#include <iostream>
using namespace std;

#define MAX 100

int top;
int stack[MAX];

void init(){
    top = 0;
}

int isEmpty(){
    if(top == 0) return 1;
    else return 0;
}

int isFull(){
    if(top == MAX) return 1;
    else return 0;
}

int push(int value){
    if(isFull()){
        cout << "stack is full";
        return -1;
    }
    else{
        stack[top++] = value;
        return 0;
    }
}

int pop(){
    if(isEmpty()){
        cout << "stack is empty";
        return -1;
    }
    else return stack[--top];
}

int main() {
    int testCase, size, value;
    cin >> testCase;
    for(int i=0;i<testCase;i++){
        cin >> size;
        init();
        for(int j=0;j<size;j++){
            cin >> value;
            push(value);
        }
        for(int j=0;j<size;j++){
            cout << pop() << " ";
        }
        cout << endl;
    }
    return 0;
}
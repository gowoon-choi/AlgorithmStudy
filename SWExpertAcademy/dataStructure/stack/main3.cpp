/*
 * stack class 구현해서 사용
 */

#include <iostream>

using namespace std;

class Stack{
    int index;
    int size;
    int *stack;
public:
    Stack(int size) {
        this->size = size;
        this->index = -1;
        stack = new int[size];
    }
    bool isEmpty(){
        if(index == -1) return true;
        else return false;
    }
    bool isFull(){
        if(index == size-1) return true;
        else return false;
    }
    bool push(int value){
        if(isFull()){
            cout << "stack is full";
            return false;
        }
        else{
            stack[++index] = value;
        }
    }
    bool pop(){
        if(isEmpty()){
            cout << "stack is empty";
            return false;
        }
        else{
            stack[index] = NULL;
            index--;
        }
    }
    int top(){
        if(isEmpty()){
            cout << "stack is empty";
            return -1;
        }
        else return stack[index];
    }
};

int main(){
    int testCase, size, value;
    cin >> testCase;
    for(int i=0;i<testCase;i++){
        cin >> size;
        Stack a(size);
        for(int j=0;j<size;j++){
            cin >> value;
            a.push(value);
        }
        for(int j=0;j<size;j++){
            cout << a.top() << " ";
            a.pop();
        }
        cout << endl;
    }
    return 0;
}
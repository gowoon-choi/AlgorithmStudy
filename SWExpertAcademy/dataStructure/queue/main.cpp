/*
 * queue 구현 by C
 */

#include <stdio.h>

#define MAX 100

int front;
int rear;
int queue[MAX];

int isEmpty(){

}

int isFull(){

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
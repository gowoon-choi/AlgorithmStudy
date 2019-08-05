/*
 * queue 구현 by C
 */

#include <iostream>
using namespace std;

#define MAX 100

int front; // dequeue index
int rear; // enqueue index
int queue[MAX];

void init(){
    front = 0;
    rear = 0;
}

int isEmpty(){
    return (front == rear);
}

int isFull(){
    return ((rear+1)%MAX == front);
}

int enqueue(int value){
    if(isFull()){
        cout << "queue is full";
        return -1;
    }
    else{
        queue[rear] = value;
        rear = (rear+1)%MAX;
        return 0;
    }
}

int dequeue(){
    if(isEmpty()){
        cout << "queue is empty";
        return -1;
    }
    else{
        int result = queue[front];
        front = (front+1)%MAX;
        return result;
    }
}



int main() {
    int testCase, size, value;
    cin >> testCase;
    for(int i=0;i<testCase;i++){
        cin >> size;
        init();
        for(int j=0;j<size;j++){
            cin >> value;
            enqueue(value);
        }
        for(int j=0;j<size;j++){
            cout << dequeue() << " ";
        }
        cout << endl;
    }
    return 0;
}
/*
 * queue 구현 by C++ using class
 */

#include <iostream>
using namespace std;

class Queue{
    int front;
    int rear;
    int size;
    int *queue;
public:
    Queue(int size){
        this->front = 0;
        this->rear = 0;
        this->size = size;
        this->queue = new int[size];
    }
    bool isEmpty(){
        return (front == rear);
    }
    bool isFull(){
        return ((rear+1)%size == front);
    }
    bool enqueue(int value){
        if(isFull()){
            cout << "queue is full";
            return false;
        }
        else{
            queue[rear] = value;
            rear = (rear+1)%size;
            return true;
        }
    }
    bool dequeue(){
        if(isEmpty()){
            cout << "queue is empty";
            return false;
        }
        else{
            front = (front+1)%size;
            return true;
        }
    }
    int q_front(){
        if(isEmpty()){
            cout << "queue is empty";
            return false;
        }
        else{
            return queue[front];
        }
    }
};

int main(){
    Queue a(10);
    int testCase, size, value;
    cin >> testCase;
    for(int i=0;i<testCase;i++){
        cin >> size;
        for(int j=0;j<size;j++){
            cin >> value;
            a.enqueue(value);
        }
        for(int j=0;j<size;j++){
            cout << a.q_front() << " ";
            a.dequeue();
        }
        cout << endl;
    }

    return 0;
}

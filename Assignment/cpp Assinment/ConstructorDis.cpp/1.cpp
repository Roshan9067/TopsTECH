/*
1. Write a program to find the multiplication values and the cubic values using 
inline function 
*/
#include <iostream>
using namespace std;

inline int square(int num){return num*num;}
inline int cube(int num){return num*num*num;}

int main(){
    int num;
    cout<<"Enter Any number for find square and cube of the number: ";
    cin>>num;
    cout<<"The square and cube of given number is: "<<square(num)<<endl<<cube(num)<<endl;
}



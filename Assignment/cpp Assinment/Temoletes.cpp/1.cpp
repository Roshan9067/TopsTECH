// 1. Write a program of to swap the two values using template.

#include <iostream>
using namespace std;
template <class t>
class Swap{
   public:  
     t a, b;
    Swap(){
        cout<<"Enter Value Of a and b: ";
        cin>>a>>b;
        cout<<"Before Swap:"<<endl;
        cout<<"a = "<<a<<"\tb = "<<b<<endl;
        cout<<"After Swap :"<<endl;
        a = a + b;
        b = a - b;
        a = a - b;
        cout<<"a = "<<a<<"\tb = "<<b<<endl;
    }
};
int main(){
    Swap <int> i;
    Swap <double> jk;
}
/*
12. Write a program to swap the two numbers using friend function 
without using third variable 
*/

#include <iostream>
using namespace std;
class Numbers{
    private:
        int a , b;
    
    friend int Num(Numbers);
    public:
    Numbers(){
        cout<<"Enter Value Of a :";
        cin>>a;
        cout<<"Enter Value Of b :";
        cin>>b;
        cout<<"Befor Swap :"<<endl;
        cout<<"a = "<<a<<"\tb = "<<b<<endl;

    }
};
int Num(Numbers n){
        n.a = n.a + n.b;
        n.b = n.a - n.b;
        n.a = n.a - n.b;
        cout<<"After Swap:"<<endl;
        cout<<"a = "<<n.a<<"\tb = "<<n.b<<endl;
}

int main(){
    Numbers ns;
    Num(ns);
}
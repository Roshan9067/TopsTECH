/* 13. Write a program to find the max number from given two numbers 
using friend function 
*/

#include <iostream>
using namespace std;
class Numbers{
    private:
    int num1,num2;
    friend int Max(Numbers);
    public:
    Numbers(){
        cout<<"Enter Number 1:";
        cin>>num1;
        cout<<"Enter Number 2:";
        cin>>num2;
    }
   
};
int Max(Numbers n1){
    if(n1.num1>n1.num2){
        cout<<"Max = "<<n1.num1<<endl;
    }
    else{
        cout<<"Max = "<<n1.num2<<endl;
    }
}
int main(){
    Numbers n;
    Max(n);
}
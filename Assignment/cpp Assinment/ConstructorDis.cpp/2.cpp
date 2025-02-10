/*
2. Write a program of Addition, Subtraction, Division, Multiplication using 
constructor. 
*/

#include <iostream>
using namespace std;

class calculator{
    public:
    float num1,num2, sum, sub, multi, div;

    calculator(float n1,float n2){
        num1 = n1;
        num2 = n2;
        sum = num1 + num2;
        sub = num1 - num2;
        multi = num1 * num2;

        if(num2 != 0){
        div = num1 / num2;
        }else{
            div = 0;
        }
    }
    void display(){
        cout<<"Addition= "<<sum<<endl;
        cout<<"Substraction= "<<sub<<endl;
        cout<<"Multiplicatgion= "<<multi<<endl;
        if(num2 != 0){
            cout<<"Division = "<<div<<endl;
        }else{
            cout<<"Not divisible by :0";
        }
    }
};

int main(){
    float n1, n2;

    cout<<"Enter Two numbers: ";
    cin>>n1;
    cin>>n2;
    calculator calc(n1,n2);

    calc.display();
}
// 1. WAP to create simple calculator using class .

#include <iostream>
using namespace std;

class calculator{
    public:

    double add(double a, double b){
        return a + b;
    }
    double sub(double a, double b){
        return a- b;
    }
    double multi(double a, double b){
        return a * b;
    }
    double div(double a, double b){
        if(b != 0)
        return a / b;
        else{
            cout<<"Error not divisible By Zero."<<endl;
            return 0;
        }
    }
};
int main() {
    calculator calc;
    double num1, num2;
    char oprator;

    cout<<"Enter first number: ";
    cin>>num1;

    cout<<"Enter an oprator(+, -, *, /): ";
    cin>>oprator;

    cout<<"Enter second Number: ";
    cin>>num2;

    switch(oprator){
        case '+':
        cout<<"Result: "<<calc.add(num1, num2)<<endl;
        break;

        case '-':
        cout<<"Result: "<<calc.sub(num1, num2)<<endl;
        break;

        case '*':
        cout<<"Result: "<<calc.multi(num1, num2)<<endl;
        break;

        case '/':
        cout<<"Result: "<<calc.div(num1, num2)<<endl;
        break;

    }
}
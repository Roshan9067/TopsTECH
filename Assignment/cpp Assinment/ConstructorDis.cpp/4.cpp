/*
4. Write a C++ program to implement a class called Bank Account that has 
private member variables for account number and balance. Include 
member functions to deposit and withdraw money from the account. 
*/

#include <iostream>
using namespace std;

class BankAccount{
    private:
    int account_number;
    double balance,amount;

    public:
    void setdata(int Ac_num, double bal){
        account_number = Ac_num;
        balance = bal;
    }

    void deposit(){
        cout<<"Enter amout to Deposite: ";
        cin>>amount;
        if(amount > 0){
            balance += amount;
            cout<<"Money deposited successfull: "<<amount<<endl;
        }else{
            cout<<"invalid amount!"<<endl;
        }
        cout<<"updated balance: "<<balance<<endl;

    }

    void withdraw(){
        cout<<"Enter amount to withdraw: ";
        cin>>amount;
        if(amount > 0 &&amount <= balance){
            balance -= amount;
            cout<<"Withdraw successfull: "<<amount<<endl;
        }else if(amount > balance){
            cout<<"Insufficient balance!"<<endl;
        }else{
            cout<<"Invalid amount!"<<endl;
        }
        cout<<"updated Balance is: "<<balance<<endl;

    }

    void get_data(){
        cout<<"Enter Your Account number: ";
        cin>>account_number;
        cout<<"Enter intial Balance: ";
        cin>>balance;
    }

    void display(){
        cout<<"Account number: "<<account_number<<endl;
        cout<<"Balance: "<<balance<<endl;
    }

};

int main(){
    BankAccount ac;

    ac.get_data();
    ac.deposit();
    ac.withdraw();
    ac.display();
}
  
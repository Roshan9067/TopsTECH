// 2. Define a class to represent a bank account. Include the following members: 
/*
 Data Member: 
-Name of the depositor
 -Account Number -
 Type of Account -
 Balance amount in the account 
 
Member Functions 
 -To assign values 
 -To deposited an amount 
 -To withdraw an amount after checking balance 
 -To display name and balance 
 */

#include <iostream>
#include <string>
using namespace std;

class BankAc{
    private:
    string depositorName;
    int accountNumber;
    string accountType;
    double balance;

    public:
    void details(string name, int accnum, string acctype, double initialbal){
        depositorName = name;
        accountNumber = accnum;
        accountType = acctype;
        balance = initialbal;
        cout<<"Account opened successfully!"<<endl;
    }

    void deposit(double amount){
        if(amount > 0){
        balance += amount;
        cout <<"Money deposited successfully. Updated Balance is: "<< amount << endl; 
        }else{
        cout<<"Invalid Amount!"<<endl;
        }
    }

    void withdrawal(double amount){
        if (amount > balance){
            cout<<"Insufficient balance! Current Balance is: "<<balance <<endl;
        }else{
            balance -= amount;
            cout<<"Money withdrawn successfully: "<<amount <<endl;
        }
    }

    void display(){
        cout<<"Account Holder: "<<depositorName <<endl;
        cout<<"Account Number: "<< accountNumber<< endl;
        cout<<"Account Type: "<<accountType<<endl;
        cout<<"Balance: "<<balance<<endl;

    }
};

int main(){
    BankAc account;
    string name;
    int accNumber;
    string accType;
    double initialBalance, depositAmount, withdrawAmount;

    cout << "Enter account holder's name: ";
    getline(cin, name);

    cout << "Enter account number: ";
    cin >> accNumber;

    cout << "Enter account type (Savings/Current): ";
    cin >> accType;
    
    cout << "Enter initial balance: ";
    cin >> initialBalance;

    account.details(name, accNumber, accType, initialBalance);

    cout << "\nEnter amount to deposit: ";
    cin >> depositAmount;
    account.deposit(depositAmount);

    cout << "\nEnter amount to withdraw: ";
    cin >> withdrawAmount;
    account.withdrawal(withdrawAmount);

    cout << "\nAccount Details:\n";
    account.display();

}
#include<iostream>
#include<ctime>
using namespace std;
class Atm{
   private:
    string Name;
    int accountno;
    string Address;
    string branchlocation;
    int balance;
    public:
    int atmpin;
    public:
    Atm(): atmpin(12345){}
    Atm(string n,string add,string bl,int accno,int bal){
        Name=n;
        Address=add;
        branchlocation=bl;
        accountno=accno;
        balance=bal;
    }
    void Display(){
        cout<<"Account Holder Name:"<<Name<<endl<<"Account Holder Address:"<<Address<<endl;
        cout<<"Branch Loction :"<<branchlocation<<endl<<"Account Number:"<<accountno<<endl;
        cout<<"Account New Balance:"<<balance<<endl;
    }
    void displayDateTime() {
        time_t now = time(0);
        tm* localTime = localtime(&now);
        cout << "Current Date and Time: " << asctime(localTime);
    }
    int Deposit(int amount){
        balance+=amount;

    }
    int Withdraw(int amount){
        balance-=amount;
    }
};
int main(){
    Atm at("Roshan Gupta","Valsad ","Dungri",123456,50000);
    cout<<"***************Welcome Atm ******************"<<endl;
     at.displayDateTime();
     int Enteredpin;
     cout<<"Enter ATM Pin:";
     cin>>Enteredpin;
     if(Enteredpin=at.atmpin){
        int choice;

    do{
        cout<<"*********Menu***********"<<endl;
    cout<<"1.Deposit Amount"<<endl;
     cout<<"2.WithDrawal Amount"<<endl;
      cout<<"3.Account Balance "<<endl;
       cout<<"0.exit"<<endl;
       cout<<"Select choice:";
       cin>>choice;
     switch(choice){
        case 1:
                int amo;
            cout<<"**********Deposit Amount**********"<<endl;
                cout<<"Enter Deposit Amount:"<<endl;
                cin>>amo;
                cout<<"Deposit Balance:"<<amo<<endl;
                at.Deposit(amo);

                break;

     case 2:
            int with;
            cout<<"**********Withdrwal Amount**********"<<endl;
            cout<<"Enter Withdraw Amount:"<<endl;
            cin>>with;
            at.Withdraw(with);
            break;
    case 3:
    cout<<"***************Account Holder Info ******************"<<endl;
    at.Display();
    break;

    case 0:
        cout<<"Thank For Using Atm";
        break;
    default:
        cout<<"invalid choice"<<endl;
        break;
        }
    }while(choice!=0);
}
else{
    cout<<"Incorrect Pin Access Denied."<<endl;
}
}



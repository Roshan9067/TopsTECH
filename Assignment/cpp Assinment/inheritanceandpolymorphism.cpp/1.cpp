/*
1. Assume a class cricketer is declared. Declare a derived class batsman from 
cricketer. Data member of batsman. Total runs, Average runs and best 
performance. Member functions input data, calculate average runs, Display 
data. (Single Inheritance)
*/

#include <iostream>
using namespace std;

class cricketer{
    protected:
    string name;
    int age;
    int matches;

    public:

    void getdata(){
        cout<<"Enter Cricketer name: ";
        cin>>name;
        cout<<"Enter Cricketer age: ";
        cin>>age;
        cout<<"Enter number of matches played: ";
        cin>>matches;
    }
};

class batsman: public cricketer{
    private:
    int totalruns;
    float averageruns;
    int best;

    public:
    void getbatsmendata(){
        cout<<"Enter total Runs: ";
        cin>>totalruns;
        cout<<"Enter Best perfomance: ";
        cin>>best;
    }

    void average(){
        if(matches > 0){
            averageruns = totalruns / matches;
        }else{
            averageruns = 0;
        }
    }

    void display(){
        cout<<endl<<endl<<endl;
        cout<<"Name: "<<name<<endl;
        cout<<"Age: "<<age<<endl;
        cout<<"Best Score: "<<best<<endl;
        cout<<"Total Runs: "<<totalruns<<endl;
        cout<<"Average runs: "<<averageruns<<endl;

    }
};

int main(){
    batsman b;
    b.getdata();
    b.getbatsmendata();
    b.average();
    b.display();
}
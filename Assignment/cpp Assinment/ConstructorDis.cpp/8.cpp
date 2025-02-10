/*
8. Write a C++ program to implement a class called Student that has private 
member variables for name, class, roll number, and marks. Include 
member functions to calculate the grade based on the marks and display 
the student's information. Accept address from each student implement 
using of aggregation.
*/

#include <iostream>
using namespace std;
class Address{
    public:
    string City;
    string State;
    Address(string ct,string st){
        this->City = ct;
        this->State = st;
    }
};
class Student{
    private:
    Address *add;
        string name;
        string s_class;
        int roll_no;
        int marks;
        char grade;

     public:
        void calculate_grade(int marks){
            if(marks >=80 && marks<=100){
                grade = 'A';
            }
            else if(marks >=60 && marks<80){
                grade = 'B';
            }
            else if(marks >=45 && marks<60){
                grade = 'C';
            }
            else if(marks >=35 && marks<45){
                grade = 'D';
            }
            else{
                grade = 'F';
            }
        }
    void stud_info(){
        cout<<"Enter Your Name: ";
        cin>>name;
        cout<<"Enter Your Class : ";
        cin.ignore();
        getline(cin,s_class);
        cout<<"Enter Your Roll Number : ";
        cin>>roll_no;
        cout<<"Enter Your Marks : ";
        cin>>marks;
        
    }
    void show_info(Address *adr){
        calculate_grade(marks);
        add = adr;
        cout<<"\n-- student Marks Sheet --"<<endl;
        cout<<"Student Name: "<<name<<endl;
        cout<<"Student Class : "<<s_class<<endl;
        cout<<"Roll Number: "<<roll_no<<endl;
        cout<<"Student Address \nCity: "<<add->City<<endl;
        cout<<"State :"<<add->State<<endl;
        cout<<"Marks: "<<marks<<endl;
        cout<<"Grade :"<<grade<<endl;
        if(grade == 'F'){
            cout<<"Sorry!..You Are Failed!."<<endl;
        }
        else{
            cout<<"Congratulations!..You Passed With "<<grade<<" Grade."<<endl;
        }
    }
};
int main(){ 
    Student st;
    st.stud_info();
    string cty,stat;
    cout<<"Enter City:";
    cin>>cty;
    cout<<"Enter State:";
    cin>>stat;
    Address ad(cty,stat);
    st.show_info(&ad);
}
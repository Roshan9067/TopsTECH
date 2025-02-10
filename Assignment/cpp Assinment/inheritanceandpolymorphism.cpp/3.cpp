/*
3. Create a class person having members name and age. Derive a class student 
having member percentage. Derive another class teacher having member 
salary. Write necessary member function to initialize, read and write data. 
Write also Main function (Multiple Inheritance) 
*/

#include <iostream>
using namespace std;

class person{
    protected:
    string name;
    int age;

    public:
    void getpersondata(){
        cout<<"Enter name: ";
        cin>>name;
        cout<<"Enter age: ";
        cin>>age;
    }
    void displaypersondata(){
        cout<<"Name: "<<name<<endl;
        cout<<"Age: "<<age<<endl;
    }
};

class student{
    protected:
    float percrntage;

    public:
    void getstudentdata(){
        cout<<"Enter percentage: ";
        cin>>percrntage;
    }

    void displaystudentdata(){
        cout<<"Percentage: "<<percrntage<<"%"<<endl;
    }
};

class teacher: public person, student{
    protected:
    double salary;

    public:
    void getteacherdata(){
    person :: getpersondata();
    student :: getstudentdata();
    cout<<"Enter the salary: ";
    cin>>salary;
    }

    void displayteacherdata(){
    person :: displaypersondata();
    student :: displaystudentdata(); 
        cout<<"salary: "<<salary<<endl;
    }

};

int main(){
    teacher t;

    t.getteacherdata();
    t.displayteacherdata();
   

}
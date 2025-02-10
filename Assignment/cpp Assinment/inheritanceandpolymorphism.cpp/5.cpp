/*
5. Assume that the test results of a batch of students are stored in three different 
classes. Class Students are storing the roll number. Class Test stores the 
marks obtained in two subjects and class result contains the total marks 
obtained in the test. The class result can inherit the details of the marks 
obtained in the test and roll number of students. (Multilevel Inheritance) 
*/

#include <iostream>
using namespace std;

class student{
    protected:
    int rollnum;
    
    public:
    void data(){
        cout<<"Enter roll number: ";
        cin>>rollnum;
    }
    void showdata(){
        cout<<"Roll number: "<<rollnum<<endl;
    }
};

class Test:public student{
    protected:
    int maths,science;

    public:
    void gettest(){
        data();
        cout<<"Enter marks obtain in maths: ";
        cin>>maths;
        cout<<"Enter Marks obtain in science: ";
        cin>>science;
    }
    void display(){
        showdata();
        cout<<"Maths: "<<maths<<endl;
        cout<<"Science: "<<science<<endl;
    }
};

class result:public Test{
    public:
    int Total;


    public:
    void getresult(){
    gettest();
    Total = maths + science;

    
    }
    void showresult(){
        display();
        cout<<"Totalmarks: "<<Total<<endl;
       
    }
};

int main(){
    result r;

    r.getresult();
    r.showresult();
}
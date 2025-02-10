/*
3. Write a C++ program to create a class called Car that has private 
member variables for company, model, and year. Implement member 
functions to get and set these variables. 
*/

#include <iostream>
using namespace std;

class car{
    private:
    string company;
    string model;
    int year;

    public:
    void get_data(){
        cout<<"Enter the car company name: ";
        cin>>company;
        cout<<"Enter the car model: ";
        cin>>model;
        cout<<"The the manufacturing year: ";
        cin>>year;
    }
    void display(){
        cout<<"compamny: "<<company<<endl<<"model: "<<model<<endl<<"year: "<<year<<endl;
    }

};
 int main(){
    car c;
    c.get_data();
    c.display();
 }
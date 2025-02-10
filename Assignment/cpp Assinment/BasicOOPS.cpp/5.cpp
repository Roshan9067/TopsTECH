/*
6. Write a C++ program to create a class called Person that has private 
member variables for name, age and country. Implement member 
functions to set and get the values of these variables.
*/

#include <iostream>
#include <string>
using namespace std;

class person{
    private:
    string name;
    int age;
    string country;

    public:
    void setdata(string n, int a, string c){
        name = n;
        age = a;
        country = c;
    }
      void display() {
            cout<<"Name: "<<name<<endl;
            cout<<"Age: "<<age<<endl;
            cout<<"Country: "<<country<<endl;
        }
};

int main(){
    person per;
    string name, country;
    int age;

    cout<<"Enter the Person name: ";
    getline(cin, name);

    cout<<"Enter person age: ";
    cin>> age;
    cin.ignore();

    cout<<"Enter the person country: ";
    getline(cin, country);

    per.setdata(name, age, country);
    cout<<"Person information:"<<endl;
    per.display();


}

//2. Write a C++ Program to find Area of Rectangle using inheritance.

#include <iostream>
using namespace std;

class Rectangle{
    protected:
    float length;
    float width;
    float area;

    public:
    void getdata(){
        cout<<"Enter The Length: ";
        cin>>length;
        cout<<"Enter The Width: ";
        cin>>width;
    }
};

class rect: public Rectangle{
    public:
    
    float rectarea(){
        area = length * width;
    }
    void display(){
        cout<<"The area of rectangle is= "<<area<<endl;
    }
};

int main(){
    rect r;
    r.getdata();
    r.rectarea();
    r.display();
}
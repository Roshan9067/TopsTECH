/*
4. Write a C++ program to create a class called Rectangle that has private 
member variables for length and width. Implement member functions to 
calculate the rectangle's area and perimeter. 
*/

#include <iostream>
using namespace std;

class Rectangle{
    private:
    float length;
    float width;

    public:
    void data(float l, float w){
        length = l;
        width = w;
    }

    float area(){
        return length * width;
    }
    float perimeter(){
        return 2 * (length + width);
    }
};

int main(){
    Rectangle rect;
    float length, width;

    cout<<"Enter the length of the rectangle: ";
    cin>>length;

    cout<<"Enter the width of the rectangle: ";
    cin>>width;

    rect.data(length, width);
    cout<<"Area of rectangle: "<<rect.area()<<endl;
    cout<<"perimeter of the rectangle: "<<rect.perimeter()<<endl;
}
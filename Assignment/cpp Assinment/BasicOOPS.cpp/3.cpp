/*
4. Write a C++ program to implement a class called Circle that has private 
member variables for radius. Include member functions to calculate the 
circle's area and circumference. 
*/

#include <iostream>
using namespace std;


class Circle{
    private:
    float radius;

    public:
    void getradius(float r){
        radius = r;
    }

    float area(){
        return 3.14 * radius * radius;
    }

    float circumference(){
        return 2 * 3.14 * radius;
    }

};

int main(){
    Circle circle;
    float radius;

    cout<<"Enter the Radius of the circle: ";
    cin>>radius;

    circle.getradius(radius);
    cout<<"Area of the circle: "<<circle.area()<<endl;

    cout<<"Circumference of the circle: "<<circle.circumference()<<endl;

}
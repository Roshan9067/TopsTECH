/*
5. Write a C++ program to create a class called Triangle that has private 
member variables for the lengths of its three sides. Implement member 
functions to determine if the triangle is equilateral, isosceles, or scalene.
*/

#include <iostream>
using namespace std;

class Triangle{
    private:
    int side1, side2, side3;
    
    public:

    void setsides(int s1, int s2, int s3){
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }
    void getsides(){
        cout<<"The sides of the triangle: "<<side1<<", "<<side2<<", "<<side3<<endl;
    }

    void getTriangle(){
        if(side1 == side2 && side2 == side3){
            cout<<"This Triangle id equilatrol Triangle.";
        }else if(side1 == side2 || side2 == side3 || side1 == side3){
            cout<<"This Triangle is isosceles Triangle.";
        }else{
            cout<<"This Triangle is scalene Triangle.";
        }

    }
};


    int main(){
        Triangle t;
        int s1, s2, s3;

        cout<<"Enter sides of Triangle: ";
        cin >> s1 >> s2 >> s3;  
        t.setsides(s1,s2,s3);
        t.getsides();
        t.getTriangle();
    }


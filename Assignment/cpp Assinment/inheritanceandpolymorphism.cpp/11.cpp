/*
11. Write a program to calculate the area of circle, rectangle and triangle 
using Function Overloading 
Rectangle: Area * breadth 
Triangle: ½ *Area* breadth 
Circle: Pi * Area *Area
*/

#include <iostream>
#define Pi 3.14
using namespace std;
class Area{
    public:
        int length,width,redius,base,side;
        float area;
        
    void get_lw(){
        cout<<"Enter Length And Width Of Rectangle:";
        cin>>length>>width;
    }
    void get_r(){
        cout<<"Enter Radius Of Circle:";
        cin>>redius;
    }
    void get_bs(){
        cout<<"Enter Base and Side Length Of Triangle:";
        cin>>base>>side;
    }
    int get_area(int l,int w){
        area = l*w;
        cout<<"Area Of Rectangle :"<<area<<endl;
        return area;
    }
    void get_area(float half,int b,int s){
        area = half*b*s;
        cout<<"Area Of Triangle :"<<area<<endl;
    }
    void get_area(int r){
        area = (float)Pi * r * r;
        cout<<"Area Of Circle :"<<area<<endl;
    }
};
int main(){
    float half = 0.5;
     Area area;
     area.get_r();
     area.get_area(area.redius);
     area.get_lw();
     area.get_area(area.length,area.width);
     area.get_bs();
     area.get_area(half,area.base,area.side);
}
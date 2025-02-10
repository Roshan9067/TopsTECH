/*
7. Write a C++ program to implement a class called Date that has private 
member variables for day, month, and year. Include member functions to 
set and get these variables, as well as to validate if the date is valid. 
*/

#include <iostream>
using namespace std;
class date{
    private:
    int day,month,year;
    public:
    void setdate(){
        cout<<"enter a day : ";
        cin>>day;
        cout<<"enter the month : ";
        cin>>month;
        cout<<"enter the year : ";
        cin>>year;
        cout<<"date : "<<day<<"/"<<month<<"/"<<year<<endl;
    }
    bool valid(){
        if(year>0 && (month>0 && month<=12)&&(day>0 && day<=31)) {
            return true;
        }
        return false;

    }
    void display(){
        if(valid()){
            cout<<"Valid Date";
        }else{
            cout<<"invalid date ";
        }

    }
};
int main(){
    date d;
    d.setdate();
    d.display();
}


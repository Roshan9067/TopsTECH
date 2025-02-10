/*
6. Write a C++ program to implement a class called Employee that has 
private member variables for name, employee ID, and salary. Include 
member functions to calculate and set salary based on employee 
performance. Using of constructor 
*/

#include <iostream>
using namespace std;

class Employee{
    private:
    string name;
    string id;
    double salary;
    float performance;

    public:
    Employee(string n, string i, double sal, float per){
          name =n;
          id =i;
          salary=sal;
          performance=per;

    }
    string setName(string n){
        name =n;
    }
    string getName(){
        return name;
    }
   string setId(string i){
        id = i;
    }
    string getId(){
        return id;
    }
    double setSal(double sal ){
        salary =sal;
    }
    double getSal(){
        return salary;
    }
    float setper(float per){
        performance = per;
    }
    float getper(){
        return performance;
    }

 
    void getsalary(){
        if(performance >= 4.5){
            salary += salary * 0.2;
        }else if(performance >= 3.5){
            salary += salary * 0.10;
        }else if (performance >= 2.5){
            salary += salary * 0.05;
        }else{
            cout<<"NO increment Due to poor Performance!";
        }
    }

    void display(){
        cout<<"employee name: "<<name<<endl;
        cout<<"employee ID: "<<id<<endl;
        cout<<"Updated Salary on Employee performance: "<<salary<<endl;
    }
};

int main(){
    string n,i;
    double sal;
    float per;
    cout<<"Enter Employee name: ";
    cin>>n;
    cout<<"Enter Employee ID: ";
    cin>>i;
    cout<<"Enter Employee Current salary: ";
    cin>>sal;
    cout<<"Enter performance Rating of Employee Between 0 to 5 : ";
    cin>>per;
    
    Employee emp(n,i,sal,per);
    emp.getName();
    emp.getId();
    emp.getSal();
     emp.getper();
    emp.getsalary();
    emp.display();

}
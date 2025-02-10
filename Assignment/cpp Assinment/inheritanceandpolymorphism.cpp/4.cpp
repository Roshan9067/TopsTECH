//4. Write a C++ Program display Student Mark sheet using Multiple inheritance.

#include <iostream>
using namespace std;

class student{
    protected:
    string name;
    int rollno;

    public:
    void getdata(){
        cout<<"Enter student name: ";
        cin>>name;
        cout<<"Enter student roll number: ";
        cin>>rollno;
    }
    void display(){
        cout<<"Name: "<<name<<endl;
        cout<<"Roll-NO: "<<rollno<<endl;
    }
};
class maths{
    protected:
    int mat;
    
    public:
    void getdata(){
        cout<<"Enter marks obtain in maths: ";
        cin>>mat;
    }
    void display(){
        cout<<"Maths: "<<mat<<endl;
    }

};

class english{
     protected:
    int eng;

    public:
    void getdata(){
        cout<<"Enter marks obtain in english: ";
        cin>>eng;
    }
    void display(){
        cout<<"english: "<<eng<<endl;
    }

};

class science: public student ,maths,english{
     protected:
    int sci;

    public:
    void getdata(){
    student ::  getdata();
    maths :: getdata();
    english :: getdata();
    
        cout<<"Enter marks obtain in science: ";
        cin>>sci;
    }
    void display(){
        int total;

        

        if((mat >= 0 && mat <= 100 )&&(eng >= 0 && eng <= 100 )&&(sci >=0 && sci <= 100)){
        cout<<"Total marks: "<<mat+eng+sci<<endl;
        total = mat+eng+sci;
        cout<<"Percntage: "<<((float)total/300)*100<<" %"<<endl;
        }else{
            cout <<"Inavlid marks please enter valid marks...."<<endl;
        }
        

    student ::  display();
    maths ::  display();
    english ::  display();
    cout<<"science: "<<sci<<endl;
    }
};

int main(){
    science s;

    s.getdata();
    s.display();
}
// 6. Write a C++ Program to show access to Private Public and Protected using Inheritance 

#include<iostream>
using namespace std;

class base{
    private:
    int pvt=1;

    protected:
    int pro=2;

    public:
    int pub=3;

    int getpvt(){
      return pvt;
    }
};

class child:public base{
  public:
  int getprot(){
    return pro;
  }

  int getpub(){
    return pub;
  }
};

int main(){
  child ch;
  cout<<"The Private Member (Via public method): "<<ch.getpvt()<<endl;
  cout<<"The public Member: "<<ch.getpub()<<endl;
  cout<<"The Protected Member (Via public method): "<<ch.getprot()<<endl;

}
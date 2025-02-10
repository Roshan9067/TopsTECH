// 7. Write a C++ Program to illustrates the use of Constructors in multilevel inheritance.

#include <iostream>
using namespace std;

class Grandparent {
public:

    Grandparent() {
        cout << "This is the Grandparent class." << endl;
    }
};

class Parent : public Grandparent {
public:
    Parent() {
        cout << "This is the Parent class." << endl;
    }
};

class Child : public Parent {
public:
    Child() {
        cout << "This is the Child class." << endl;
    }
};

int main() {

    Child c;

}

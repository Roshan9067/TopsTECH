// 10. Write a program to concatenate the two strings using Operator Overloading

#include <iostream>
#include <cstring> 
using namespace std;
class strng{
    public:
    char str1[100];
    get_name(){
        cout<<"Enter String:";
        cin>>str1;
    }
    void operator+( strng &st) {
        strcat(this->str1,st.str1);
    }
};
int main(){
    strng s1 ,s2;
    s1.get_name();
    s2.get_name();
    s1 + s2;
    cout << "Result: " << s1.str1 << endl; 
}
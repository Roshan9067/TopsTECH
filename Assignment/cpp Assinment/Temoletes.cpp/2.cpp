// 2. Write a program of to sort the array using templates .

#include <iostream>
using namespace std;
template <class t>
class Sort{
    public:
        int size;
    Sort(){
        cout<<"Enter The Size Of Array:";
        cin>>size;
        t arr[size];
        for(int i = 0;i<size;i++){
            cout<<"Enter Array Element "<<i+1<<" : ";
            cin>>arr[i];
        }
        cout<<"Without Sorting Array.."<<endl;
         for(int i = 0;i<size;i++){
            cout<<arr[i]<<" ";
        }
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size;j++){
                if(arr[j]>arr[j+1]){
                    t temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        cout<<"\nSorted Array.."<<endl;
         for(int i = 0;i<size;i++){
            cout<<arr[i]<<" ";
        }
    }
};
int main(){
    Sort <int> s1;

}
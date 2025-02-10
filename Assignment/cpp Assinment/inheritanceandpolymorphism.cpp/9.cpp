// 9. Write a Program of Two 1D Matrix Addition using Operator Overloading.

#include <iostream>
using namespace std;

class Matrix {
private:
    int arr[10];  
    int size;    

public:
    Matrix(int s) {
        size = s;
        for (int i = 0; i < size; i++) {
            arr[i] = 0;  
        }
    }

    void get_data() {
        cout << "Enter " << size << " elements of the matrix: ";
        for (int i = 0; i < size; i++) {
            cin >> arr[i];
        }
    }

    void display() {
        cout << "Matrix elements: ";
        for (int i = 0; i < size; i++) {
            cout << arr[i] << " ";
        }
        cout << endl;
    }

    Matrix operator+(Matrix &m) {
        Matrix result(size);  
        for (int i = 0; i < size; i++) {
            result.arr[i] = this->arr[i] + m.arr[i];  
        }
        return result;  
    }
};

int main() {
    int size;
    cout << "Enter the size of the matrices: ";
    cin >> size;

    Matrix m1(size), m2(size);

    cout << "Enter data for first matrix:\n";
    m1.get_data();
    
    cout << "Enter data for second matrix:\n";
    m2.get_data();

    Matrix result = m1 + m2;

    cout << "After addition:\n";
    result.display();

    return 0;
}
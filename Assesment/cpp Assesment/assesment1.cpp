#include<stdio.h>
#include<string.h>
#include<ctype.h>

// Function to reverse a string
void reverseString(char* str) {
    int length = strlen(str);
    for (int i = 0; i < length / 2; ++i) {
        char temp = str[i];
        str[i] = str[length - i - 1];
        str[length - i - 1] = temp;
    }
}

// Function to concatenate two strings
void concatenateStrings(char str1[], char str2[]) {
    strcat(str1, str2);
}

// Function to count vowels and consonants in a string
void countvowelsconsonants(char str[]){
    int vowel = 0, conso = 0;
    for(int i = 0; i < strlen(str); i++){
        char ch = tolower(str[i]);
        if(ch >= 'a' && ch <= 'z'){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                vowel++;
            }
            else{
                conso++;
            }
        }
    }
    printf("Vowels: %d\nConsonants: %d\n", vowel, conso);
}

// Function to check if a string is palindrome
int isPalindrome(char str[]) {
    int len = strlen(str);
    for (int i = 0; i < len / 2; i++) {
        if (str[i] != str[len - i - 1]) {
            return 0; // Not a palindrome
        }
    }
    return 1; // Is a palindrome
}

// Function to copy a string
void copystring(char destination[], char source[]) {
    strcpy(destination, source);
}

// Function to find the length of the string
int strlength(char str[]) {
    return strlen(str);
}

// Function to count the frequency of characters in a string
void charfrequency(char str[]) {
    int frequency[256] = {0}; // Supports extended ASCII
    for(int i = 0; i < strlen(str); i++){
        frequency[(unsigned char)str[i]]++;
    }
    printf("Character Frequency:\n");
    for(int i = 0; i < 256; i++){
        if(frequency[i] > 0 && isprint(i)){
            printf("%c: %d\n", i, frequency[i]);
        }
    }
}

// Function to count blank spaces and digits in a string
void countspacedigits(char str[]) {
    int space = 0, digits = 0;
    for(int i = 0; str[i] != '\0'; i++) {
        if(str[i] == ' ') {
            space++;
        }
        if(str[i] >= '0' && str[i] <= '9') {
            digits++;
        }
    }
    printf("Spaces: %d\nDigits: %d\n", space, digits);
}

// Main function
int main() {
    char str1[100], str2[100];
    
    printf("String related operations:");
    printf("\n 1. Reverse a string");
    printf("\n 2. Concatenation");
    printf("\n 3. Palindrome");
    printf("\n 4. Copy a string");
    printf("\n 5. Length of the string");
    printf("\n 6. Frequency of character in a string");
    printf("\n 7. Find number of vowels and consonants");
    printf("\n 8. Find number of blank spaces and digits");

    int choice;
    printf("\nEnter your choice: ");
    scanf("%d", &choice);
    getchar(); // To clear the newline character after scanf

    switch(choice) {
        case 1:
            printf("Reverse a string:\nEnter string: ");
            fgets(str1, sizeof(str1), stdin);
            str1[strcspn(str1, "\n")] = '\0'; // Remove newline character
            reverseString(str1);
            printf("Reversed string: %s\n", str1);
            break;

        case 2:
            printf("Concatenation:\nEnter first string: ");
            fgets(str1, sizeof(str1), stdin);
            str1[strcspn(str1, "\n")] = '\0'; // Remove newline character
            printf("Enter second string: ");
            fgets(str2, sizeof(str2), stdin);
            str2[strcspn(str2, "\n")] = '\0'; // Remove newline character
            concatenateStrings(str1, str2);
            printf("Concatenated string: %s\n", str1);
            break;

        case 3:
            printf("Palindrome:\nEnter string: ");
            fgets(str1, sizeof(str1), stdin);
            str1[strcspn(str1, "\n")] = '\0'; // Remove newline character
            if(isPalindrome(str1)){
                printf("String is a palindrome\n");
            } else {
                printf("String is not a palindrome\n");
            }
            break;

        case 4:
            printf("Copy a string:\nEnter source string: ");
            fgets(str1, sizeof(str1), stdin);
            str1[strcspn(str1, "\n")] = '\0'; // Remove newline character
            copystring(str2, str1);
            printf("Copied string: %s\n", str2);
            break;

        case 5:
            printf("Length of the string:\nEnter string: ");
            fgets(str1, sizeof(str1), stdin);
            str1[strcspn(str1, "\n")] = '\0'; // Remove newline character
            printf("Length of the string: %d\n", strlength(str1));
            break;

        case 6:
            printf("Frequency of characters in a string:\nEnter string: ");
            fgets(str1, sizeof(str1), stdin);
            str1[strcspn(str1, "\n")] = '\0'; // Remove newline character
            charfrequency(str1);
            break;

        case 7:
            printf("Count of vowels and consonants:\nEnter string: ");
            fgets(str1, sizeof(str1), stdin);
            str1[strcspn(str1, "\n")] = '\0'; // Remove newline character
            countvowelsconsonants(str1);
            break;

        case 8:
            printf("Count blank spaces and digits:\nEnter string: ");
            fgets(str1, sizeof(str1), stdin);
            str1[strcspn(str1, "\n")] = '\0'; // Remove newline character
            countspacedigits(str1);
            break;

        default:
            printf("Invalid choice\n");
            break;
    }

    return 0;
}

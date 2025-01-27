# CYB-2311 Lab 1: Vigenère Cipher Implementation and Cryptanalysis

## Overview

In this lab, you will work with the Vigenère cipher, a polyalphabetic substitution cipher that was considered unbreakable for several centuries. You will implement its decryption algorithm and develop a program to break the cipher when the key length is known.

## Prerequisites

- Basic Java programming skills
- Understanding of modular arithmetic
- Familiarity with string manipulation in Java
- Basic knowledge of cryptography concepts

## Learning Objectives

By completing this lab, you will be able to:

1. Implement the Vigenère cipher decryption algorithm
2. Understand the relationship between encryption and decryption in classical ciphers
3. Apply frequency analysis techniques to break the cipher
4. Develop practical cryptanalysis skills
5. Gain experience with Java string manipulation and modular arithmetic

## Part 1: Implementing Vigenère Cipher Decryption

### Task Description

You are provided with the encryption implementation of the Vigenère cipher. Your task is to implement the corresponding decryption algorithm. The encryption function uses the following convention:

- Message space: lowercase English letters (a-z)
- Key space: lowercase English letters (a-z)
- No spaces or special characters are used

### Requirements

1. Implement the `decrypt` method in the `VigenereCipher` class
2. The method should take two parameters:
   - `String ciphertext`: The encrypted message (lowercase letters only)
   - `String key`: The decryption key (lowercase letters only)
3. Return the decrypted plaintext as a String
4. Handle edge cases appropriately (empty strings, invalid characters)

### Example

```java
Input:
ciphertext: "khoorgjcla"
key: "hello"
Output: "mynameisbob"
```

## Part 2: Breaking the Vigenère Cipher

### Task Description

Implement a program to break the Vigenère cipher when the key length is known. You will use frequency analysis techniques to determine the most likely key and decrypt the message.

### Requirements

1. Implement the `breakCipher` method in the `VigenereCipherBreaker` class
2. The method should take two parameters:
   - `String ciphertext`: The encrypted message
   - `int keyLength`: The known length of the key
3. Return the most likely plaintext as a String
4. Use frequency analysis to determine the likely key
5. Implement helper methods as needed for:
   - Splitting the ciphertext into groups
   - Performing frequency analysis
   - Calculating letter frequencies

### Implementation Hints

1. Split the ciphertext into keyLength groups
2. Each group is encrypted with the same key letter (equivalent to a Caesar cipher)
3. Use English letter frequencies to determine the most likely key letter for each position
4. Common English letter frequencies:
   - 'e': 12.7%
   - 't': 9.1%
   - 'a': 8.2%
   - 'o': 7.5%
   - 'i': 7.0%

## Testing

- Unit tests are provided to verify your implementation
- Test your code with the provided sample inputs
- Create additional test cases to verify edge cases
- Test with longer texts to ensure robustness

## Submission Requirements

1. Complete implementation of both parts:
   - VigenereCipher.java with decrypt method
   - VigenereCipherBreaker.java with breakCipher method
2. All tests must pass
3. Code must be well-documented with comments
4. Submit via GitHub Classroom
5. Include a brief write-up (maximum 1 page, pdf format) describing:
   - Your approach to breaking the cipher
   - Any challenges encountered
   - How you verified your implementation

## Grading Criteria

- Part 1 (40%):
  - Correct decryption implementation (30%)
  - Code quality and documentation (10%)
- Part 2 (50%):
  - Correct cipher breaking implementation (35%)
  - Code quality and documentation (15%)
- Write-up (10%)

## Academic Integrity

- You must work individually on this assignment
- You may discuss general concepts with classmates
- Code must be your own work
- Cite any references or resources used

## Resources

- Course textbook: Chapter on Classical Ciphers
- Lecture notes on Vigenère Cipher
- Java String documentation
- Provided starter code and test cases

## Questions

If you have questions about this assignment, please:

1. Attend office hours
2. Email the instructor (Zhonghao Liao, liao@msoe.edu)
3. Discuss questions during lab time

Good luck!

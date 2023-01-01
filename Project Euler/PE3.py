# Project Euler Problem 3:
# What is the largest prime factor
# of the number 600851475143?

def largestPrimeFactor(num):
    divisor = 1;
    dividend = 1;
    largest = 0;
    while (dividend < num):
        while (divisor < dividend):
            if (dividend % divisor == 0):
                largest = dividend;
        dividend += 1;

num = input("Pick a number.");
largestPrimeFactor(num);

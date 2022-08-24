# Project Euler Problem 2:
# By considering the terms in the Fibonacci sequence whose 
# values do not exceed four million, find the sum of the 
# even-valued terms.

first = 1;
second = 2;
sum = 2;

while (second < 4000000):
    secondtemp = second;
    second += first;
    if (second % 2 == 0):
        sum += second;
    first = secondtemp;

print("Sum:", sum);
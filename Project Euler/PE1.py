# Project Euler Problem 1:
# Find the sum of all the multiples of 3 or 5 below 1000.

num = 1;
sum = 0;
while (num < 1000):
    if (num % 3 == 0) or (num % 5 == 0) or (num % 15 == 0):
        sum += num;
    num += 1;
print(sum);
print(num);
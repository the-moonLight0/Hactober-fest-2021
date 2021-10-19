"""
Let a (x,y) rectangle denote an axis-aligned rectangle with width equal to x and height equal to y, where x and y are positive integers.

You are given a (N,M) rectangle. You must repeat the following process as long as your rectangle has at least one side longer than 1:

Make a horizontal or vertical cut inside the rectangle, splitting it into two rectangles. The sides of both these rectangles must still be positive integers.
If the cut is horizontal, discard the bottom rectangle, otherwise discard the right rectangle. The process continues with the remaining rectangle.
In the end, you are left with a (1,1) rectangle --- a square with side length 1.

There may be several possible ways or paths to reduce a (N,M) rectangle to a (1,1) rectangle. Let's define the cost of a path as the sum of areas of all rectangles present in that path, including the (N,M) and (1,1) rectangle.

For example, let's consider a (2,2) rectangle. There are two possible paths to reduce a (2,2) rectangle to a (1,1) rectangle:

(2,2)→(1,2)→(1,1)
(2,2)→(2,1)→(1,1)
The cost of the first path is 2⋅2+1⋅2+1⋅1=7, and similarly, the cost of the second path is 2⋅2+2⋅1+1⋅1=7.

You are also given a known prime number P. Find the sum of costs of all possible paths modulo P.

Input Format
The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
The first and only line of each test case contains three space-separated integers N, M and P.
Output Format
For each test case, print a single line containing one integer --- the sum of costs of all paths modulo P.

Constraints

1≤T≤4,000
1≤N≤105
1≤M≤108
the sum of N over all test cases does not exceed 105


Subtasks
Subtask #1 (20 points):

the sum of N over all test cases does not exceed 1,000
the sum of M over all test cases does not exceed 1,000
P=998,244,353
Subtask #2 (10 points): P=2
Subtask #3 (70 points): P=998,244,353

Sample Input 1 
4
1 1 998244353
2 2 998244353
3 3 998244353
3 3 2

Sample Output 1 
1
14
260
0

Sample Input 2 
1
10 10 998244353

Sample Output 2 
996017662
"""






t = int(input())
sol = []
dp = {}
dpc = {}
dp[1,1] = 1
dpc[1,1] = 1
x = 1

def fun0(a,b):
    for i in range(a+1,b+1):
        f = 2**(i-2)
        f1 = f//2
        s = i*f + f +((i*(i-1))//2-1)*f1
        dp[1,i] = dp[i,1] = s
        dpc[1,i] = dpc[i,1] = f
    return 0

def fun(a,b,c):
    if dp.get((a,b),False):
        return dp.get((a,b))%c
    elif a == b:
        if c == 2:
            return 0
        ch = 0
        s = 0
        for k in range(a-1,0,-1):
            s += fun(a-k,b,c) 
            ch += dpc.get((a-k,b))
        s += ch*a*b
        s *= 2
        ch *= 2
        dp[a,b] = s
        dpc[a,b] = ch
        return s%c
    else:
        ch = 0
        s = 0
        for k in range(a-1,0,-1):
            s += fun(a-k,b,c) 
            ch += dpc.get((a-k,b))
        for k in range(b-1,0,-1):
            s += fun(a,b-k,c) 
            ch += dpc.get((a,b-k))
        s += ch*a*b
        dp[a,b] = dp[b,a] = s
        dpc[a,b] = dpc[b,a] = ch
        return s%c
    
for _ in range(t):
    n,m,d = map(int,input().split())
    if m > x or n > x:
        if m>n:
            fun0(x,m)
            x = m
        else:
            fun0(x,n)
            x = n
    sol.append(fun(n,m,d))

for k in sol:
    print(k)

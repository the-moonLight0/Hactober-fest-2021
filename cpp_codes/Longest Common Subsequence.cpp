//Longest common subsequence 

#include<bits/stdc++.h>
using namespace std;

// finding longest common subsequence using dynamic programming
int lcs(int x, int y, string s1, string s2)
    {
        int dp[x+1][y+1];
        for(int i=0; i<=x; i++)
        dp[i][0]=0;
        for(int j=0; j<=y; j++)
        dp[0][j]=0;
        for(int i=1; i<=x; i++)
        {
            for(int j=1; j<=y; j++)
            {
                if(s1[i-1] == s2[j-1])
                {
                    dp[i][j]= 1+ dp[i-1][j-1];
                }
                else 
                {
                    dp[i][j] = max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[x][y];
    }
// driver code
int main()
{
    int t,x,y,ans;
    cin>>t;
    while(t--)
    {
        string s1,s2;
        cin>>s1>>s2;
        x = s1.length();
        y = s2.length();
        ans = lcs(x,y,s1,s2);
        cout<<ans<<'\n';
    }
}

//input format
//no. of test cases
//2 lines for each test case giving string1 and string2 to compare

//example
// 2
// hello
// mely
// geek
// geeky

// output format
//answer to each test case on new line

//https://www.facebook.com/codingcompetitions/hacker-cup/2021/round-1/problems/A1
#include <iostream>
#include <fstream>
#include <bits/stdc++.h>
#define fast_cin()                    \
    ios_base::sync_with_stdio(false); \
    cin.tie(NULL)

using namespace std;
using ll = long long int;

int main()
{
    /*write ypur code here*/
    fast_cin();
    int t;
    cin >> t;
    int cas = 1;
    while (t--)
    {
        int n;
        cin >> n;
        string w;
        cin >> w;
        int ans = 0, i = 0;
        char prev;
        while (w[i] == 'F')
        {
            i++;
        }
        prev = w[i];
        while (i < n)
        {
            if (w[i] == prev || w[i] == 'F')
            {
                i++;
            }
            else
            {
                ans++;
                prev = w[i];
            }
        }
        cout << "Case #" << cas << ": " << ans << "\n";
        cas++;
    }
    return 0;
}
//https://www.spoj.com/problems/FARIDA/
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
    int cases = 1;
    while (t--)
    {
        int numberOfMonsters;
        cin >> numberOfMonsters;
        int noOfCoins[numberOfMonsters];
        for (int i = 0; i < numberOfMonsters; ++i)
        {
            cin >> noOfCoins[i];
        }
        int maxNumberOfCoins[numberOfMonsters][2];
        maxNumberOfCoins[0][0] = noOfCoins[0];
        maxNumberOfCoins[0][1] = 0;
        for (int i = 1; i < numberOfMonsters; ++i)
        {
            maxNumberOfCoins[i][0] = noOfCoins[i] + maxNumberOfCoins[i - 1][1];
            maxNumberOfCoins[i][1] = max(maxNumberOfCoins[i - 1][0], maxNumberOfCoins[i - 1][1]);
        }
        cout << "case " << cases << ": " << max(maxNumberOfCoins[numberOfMonsters - 1][0], maxNumberOfCoins[numberOfMonsters - 1][1]) << "\n";
    }
    return 0;
}
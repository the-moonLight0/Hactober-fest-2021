//https://www.facebook.com/codingcompetitions/hacker-cup/2021/qualification-round/problems/A1
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
    int cas = 0;
    while (cas < t)
    {
        string s;
        cin >> s;
        map<char, int> mp;
        for (int i = 0; i < s.length(); ++i)
        {
            if (mp.find(s[i]) == mp.end())
            {
                mp[s[i]] = 1;
            }
            else
            {
                mp[s[i]]++;
            }
        }
        int maxVowel = 0, maxCons = 0, totVowel = 0, totCons = 0;
        for (auto i : mp)
        {
            if (i.first == 'A' || i.first == 'E' || i.first == 'I' || i.first == 'O' || i.first == 'U')
            {
                maxVowel = max(maxVowel, i.second);
                totVowel += i.second;
            }
            else
            {
                maxCons = max(maxCons, i.second);
                totCons = totCons + i.second;
            }
        }
        int ans = min((totVowel - maxVowel) * 2 + totCons, (totCons - maxCons) * 2 + totVowel);
        cout << "Case #" << cas + 1 << ": " << ans << "\n";

        cas++;
    }
    return 0;
}
/*
CONSISTENCY
C - 2
N - 2
S - 2
T - 1
Y - 1

O - 1
E - 1
I - 1

min(3+12, 8+4)
*/
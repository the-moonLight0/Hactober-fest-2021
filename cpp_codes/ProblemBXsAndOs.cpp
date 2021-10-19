//https://www.facebook.com/codingcompetitions/hacker-cup/2021/qualification-round/problems/B
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
    while (cas <= t)
    {
        int n;
        cin >> n;
        char arr[n][n];
        int minAnsRow = INT_MAX, freq1 = 0;
        vector<pair<int, int>> point;
        for (int i = 0; i < n; ++i)
        {
            string s;
            cin >> s;
            int noOfX = 0, noOfDot = 0, possible = 1, r = -1, c = -1;
            for (int j = 0; j < n; ++j)
            {
                arr[i][j] = s[j];
                if (possible)
                {
                    if (arr[i][j] == 'O')
                    {
                        possible = 0;
                    }
                    else if (arr[i][j] == '.')
                    {
                        noOfDot++;
                        r = i;
                        c = j;
                    }
                    else
                    {
                        noOfX++;
                    }
                }
            }
            if (possible)
            {
                if (noOfDot == 1)
                {
                    point.push_back(make_pair(r, c));
                }
                if (minAnsRow > noOfDot)
                {
                    minAnsRow = noOfDot;
                    freq1 = 1;
                }
                else if (minAnsRow == noOfDot)
                {
                    freq1++;
                }
            }
        }
        int minAnsCol = INT_MAX, freq2 = 0;
        vector<pair<int, int>> point1;
        for (int j = 0; j < n; ++j)
        {
            int noOfX = 0, noOfDot = 0, possible = 1, r = -1, c = -1;
            for (int i = 0; i < n; ++i)
            {
                if (possible)
                {
                    if (arr[i][j] == 'O')
                    {
                        possible = 0;
                    }
                    else if (arr[i][j] == '.')
                    {
                        noOfDot++;
                        r = i;
                        c = j;
                    }
                    else
                    {
                        noOfX++;
                    }
                }
            }
            if (possible)
            {
                if (noOfDot == 1)
                {
                    point1.push_back(make_pair(r, c));
                }
                if (minAnsCol > noOfDot)
                {
                    minAnsCol = noOfDot;
                    freq2 = 1;
                }
                else if (minAnsCol == noOfDot)
                {
                    freq2++;
                }
            }
        }
        int ans = 0;
        if (minAnsCol == minAnsRow && minAnsRow == 1)
        {
            ans = freq1 + freq2;
            for (int i = 0; i < point.size(); ++i)
            {
                for (int j = 0; j < point1.size(); ++j)
                {
                    if (point[i].first == point1[j].first && point[i].second == point1[j].second)
                    {
                        ans--;
                    }
                }
            }
        }
        else if (minAnsRow == minAnsCol && minAnsRow == INT_MAX)
        {
            cout << "Case #" << cas << ": Impossible\n";
            cas++;
            continue;
        }
        else if (minAnsRow == minAnsCol)
        {
            ans = freq1 + freq2;
        }
        else
        {
            ans = minAnsRow < minAnsCol ? freq1 : freq2;
            minAnsRow = min(minAnsRow, minAnsCol);
        }
        cout << "Case #" << cas << ": " << minAnsRow << " " << ans << "\n";
        // cout<<"a";

        // cout<<minAnsRow<<" "<<freq1<<"\n";
        // cout<<minAnsCol<<" "<<freq2<<"\n";
        // for (int i = 0; i < point.size(); ++i)
        // {
        // 	cout<<point[i].first<<" "<<point[i].second<<" : ";
        // }
        // cout<<"\n";
        // for (int i = 0; i < point1.size(); ++i)
        // {
        // 	cout<<point1[i].first<<" "<<point1[i].second<<" : ";
        // }
        // cout<<"\n";
        // cout<<"\n";

        cas++;
    }
    return 0;
}
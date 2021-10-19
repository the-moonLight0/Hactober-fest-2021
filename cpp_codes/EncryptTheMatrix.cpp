#include<iostream>
#include<cstdio>
using namespace std;

int main()
{
    int x,y;
    cin >> x>>y;
    int a[x][y];
    for(int i=0;i<x;i++){
        for (int j=0;j<y;j++){
            cin>>a[i][j];
            if (i==0 || j==0 || i==x-1 ||j== y-1)
                a[i][j]+=i+1;
            else 
                a[i][j]-=j;
            cout<<a[i][j]<<" ";
        }
        cout<<"\n";
    }
}

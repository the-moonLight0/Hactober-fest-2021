#include<bits/stdc++.h>
#define ll long long
#define pb push_back
#define mp make_pair
#define rep(i,a,b) for(int i = a; i < b; i++)
#define mod 1000000007
#define fast_io ios_base::sync_with_stdio(false);cin.tie(NULL)

using namespace std;

void init_code(){
    fast_io;
    #ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
    freopen("error.txt", "w", stderr);
    #endif 
} 

void solve()
{
   string s;
   cin>>s;
   int n=s.length();
   int temp=INT_MAX,flag=0,it;
   int i=n-2;
   for(;i>=0;i--)
   {
      for(int j=i+1;j<n;j++)
      {
         if(s[j]>s[i] && s[j]<temp)
         {
            temp=s[j];
            it=j;
            flag=1;
         }
      }
      if(flag == 1)
      {
         swap(s[i],s[it]);
         break;
      }
   }
   sort(s.begin()+i+1,s.end());
   cout<<s<<" ";
}
int main() {
   init_code();
   int t = 1; 
   //cin >> t;
   while(t--){
         solve();
   }
   return 0;
}

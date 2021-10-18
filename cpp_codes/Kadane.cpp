
// largest contiguous array sum
#include<iostream>
#include<climits>
using namespace std;
 
int max_sub_array(int a[], int size)
{
    int max_now = INT_MIN, max_end = 0;
 
    for (int i = 0; i < size; i++)
    {
        max_end = max_end + a[i];
        if (max_now < max_end)
            max_now = max_end;
 
        if (max_end < 0)
            max_end = 0;
    }
    return max_now;
}
 
 // main method
int main()
{
    int a[] = {-2, -3, 4, 1, -3, 4, -2, -1, 5};
    int n = sizeof(a)/sizeof(a[0]);
    int max_sum = max_sub_array(a, n);
    cout << "Maximum contiguous sum is " << max_sum;
    return 0;
}
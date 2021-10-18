#include <bits/stdc++.h>
using namespace std;
 
void mergeArray(int a[], int b[], int n, int m)
{
    int mx = 0;
     
    // Find maximum element of both array
    for (int i = 0; i < n; i++) {
        mx = max(mx, a[i]);
    }
    for (int i = 0; i < m; i++) {
        mx = max(mx, b[i]);
    }
     
    // increment by one to avoid collision of 0 and maximum
    // element of array in modulo operation
    mx++;
    int i = 0, j = 0, k = 0;
    while (i < n && j < m && k < (n + m)) {
         
        // recover back original element to compare
        int e1 = a[i] % mx;
        int e2 = b[j] % mx;
        if (e1 <= e2) {
             
            // update element by adding multiplication
            // with new number
            if (k < n)
                a[k] += (e1 * mx);
            else
                b[k - n] += (e1 * mx);
            i++;
            k++;
        }
        else {
             
            // update element by adding multiplication
            // with new number
            if (k < n)
                a[k] += (e2 * mx);
            else
                b[k - n] += (e2 * mx);
            j++;
            k++;
        }
    }
     
    // process those elements which are left in array a
    while (i < n) {
        int el = a[i] % mx;
        if (k < n)
            a[k] += (el * mx);
        else
            b[k - n] += (el * mx);
        i++;
        k++;
    }
     
    // process those elements which are left in array b
    while (j < m) {
        int el = b[j] % mx;
        if (k < n)
            a[k] += (el * mx);
        else
            b[k - n] += (el * mx);
        j++;
        k++;
    }
     
    // finally update elements by dividing
    // with maximum element
    for (int i = 0; i < n; i++)
        a[i] = a[i] / mx;
 
    // finally update elements by dividing
    // with maximum element
    for (int i = 0; i < m; i++)
        b[i] = b[i] / mx;
 
    return;
}
 
// Driver Code
int main()
{
    int a[] = { 3, 5, 6, 8, 12 };
    int b[] = { 1, 4, 9, 13 };
    int n = sizeof(a) / sizeof(int); // Length of a
    int m = sizeof(b) / sizeof(int); // length of b
 
    // Function Call
    mergeArray(a, b, n, m);
 
    cout << "First array : ";
    for (int i = 0; i < n; i++)
        cout << a[i] << " ";
    cout << endl;
 
    cout << "Second array : ";
    for (int i = 0; i < m; i++)
        cout << b[i] << " ";
    cout << endl;
 
    return 0;
}

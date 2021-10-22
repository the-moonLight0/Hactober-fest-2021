//spiral print 

#include <bits/stdc++.h>
using namespace std;

void printSpiral(int arr[][10], int n, int m){

    int startRow = 0;
    int endRow = n-1;
    int startCol = 0;
    int endCol = m-1;


    while(startCol <= endCol && startRow <= endRow){
        for(int col = startCol; col <= endCol; col++){
            cout<<arr[startRow][col]<<" ";
        }

        for(int row = startRow + 1; row <= endRow; row++){
            cout<<arr[row][endCol]<<" ";
        }

        for(int col = endCol - 1; col >= startCol; col--){
            if(startRow == endRow) break;

            cout<<arr[endRow][col]<<" ";
        }

        for(int row = endRow - 1; row >= startRow + 1; row--){
            if(startCol == endCol) break;

            cout<<arr[row][startCol]<<" ";
        }

        startRow++;
        endRow--;
        startCol++;
        endCol--;
        
    }





}

int main() {
    int n,m;
    cin>>n>>m;

    int arr[n][m];

    for(int i = 0; i < n; i++){
        for(int j = 0; j < m; j++){
            cin>>arr[i][j];
        }
    }

    printSpiral(arr, n, m);

}

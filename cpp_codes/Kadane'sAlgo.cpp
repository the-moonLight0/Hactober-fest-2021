// Kadane's Algo - to find maximum contiguous subarray sum
#include<bits/stdc++.h>
using namespace std;


//function to calculate maximum contiguous subarray sum
int maxSubArraySum(int arr[], int n)
{
	
	int currSum = 0;
	int maxSum = INT_MIN;

	for(int i = 0; i < n; i++){
		currSum = currSum + arr[i];
		if(currSum < 0){
			currSum = 0;
		}
		maxSum = max(maxSum, currSum);
	}

	return maxSum;
	
	
}


int main()
{
	
	int n; //size of array
	cin>>n;

	int arr[n]; //arr of size n

	for(int i = 0; i < n; i++){
	cin>>arr[i];
	}

	int max_sum = maxSubArraySum(arr, n);
    cout<<max_sum;
	return 0;
}

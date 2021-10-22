//container with most water

class Solution {
public:
    int maxArea(vector<int>& height) {
        
        int n = height.size();
        int maxWater = 0;
        
        int i = 0, j = n - 1;
        
        while(i < j){
            //int currMax = 0;
            int x = min(height[i], height[j]);
            int currMax = x * (j-i);
            maxWater = max(maxWater, currMax);
            
            if(height[i] < height[j]) i++;
            else j--;
        }
        
        return maxWater;
        
    }
};

class Solution {
public:
    int maxArea(vector<int>& height) {
        int i = 0;
        int j = height.size() - 1;
        
        int res = 0;
        
        while(i < j){
            
            res = max(res, (j - i) * std::min(height[i], height[j]));
            
            if(height[i] > height[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return res;
    }
};
class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {

        vector<int> arr;

        for(int i = 0; i < matrix.size(); i++) {
            for(int j = 0; j < matrix[0].size(); j++) {
                arr.push_back(matrix[i][j]);
            }
        }

        int left = 0;
        int right = arr.size() - 1;

        while(left <= right) {

            int mid = left + (right - left) / 2;

            if(arr[mid] == target)
                return true;

            else if(arr[mid] < target)
                left = mid + 1;

            else
                right = mid - 1;
        }

        return false;
    }
};
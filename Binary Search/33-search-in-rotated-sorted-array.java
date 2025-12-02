class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left<=right){
            int mid = left + (right-left)/2;

            if(nums[mid]==target) return mid;
            //if left side of mid is sorted, 
            //check target exist in between left and mid
            //if yes, move the right to mid-1
            //if not, move the left to mid+1
            if(nums[mid]>= nums[left]){
                if(nums[left]<= target && target < nums[mid]){
                    right = mid-1;
                }else{
                    left = mid+1;
                }
            }
            //if right side of mid is sorted
            //check target exist in between right and mid
            //if yes, move the left to mid+1
            //if not, move the right to mid-1
            else{
                if(nums[mid]< target && target <= nums[right]){
                    left = mid+1;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}

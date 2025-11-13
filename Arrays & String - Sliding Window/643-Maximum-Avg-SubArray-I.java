class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0, right = k;
        int frstSum=0;
        for(int i=0;i<k;i++){
            frstSum = frstSum+nums[i];
        }
        int maxSum = frstSum;
        while(right<nums.length){
            frstSum = frstSum - nums[left] + nums[right];
            left++;
            right++;
            maxSum = Math.max(maxSum, frstSum);
        }
        return (double) maxSum/k;
    }
}

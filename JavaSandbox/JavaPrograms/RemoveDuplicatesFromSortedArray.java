import java.util.Arrays;

class Solution{
	
	public static void main(String args[]) {
		
		int[] nums = {1,1,2,3,5,5,5,6};
		Solution sol = new Solution();
		 
		int []res = sol.RemoveDuplicates(nums);
		System.out.println(Arrays.toString(res));
	}
	
	public int[] RemoveDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
            return new int[0]; 
        }
		
		int slow = 0;
		
		for(int fast = 0 ; fast < nums.length ; fast++){
			if (nums[fast] != nums[slow]) {
                slow++; 
                nums[slow] = nums[fast];
            }
		}
		
		for (int i = slow + 1; i < nums.length; i++) {
            nums[i] = -1;
        }
		
		return nums;
	}
}
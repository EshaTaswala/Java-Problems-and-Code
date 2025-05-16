import java.util.Arrays;
import java.util.HashMap;

class Solution{
	
	public static void main(String args[]) {
		
		int []nums = {2, 7, 11, 15};
		int Target = 9;
		Solution sol = new Solution();
		 
		int []res = sol.TwoSum(nums , Target);
		System.out.println(Arrays.toString(res));
	}
	
	public int[] TwoSum(int[] nums ,int target) {
		HashMap<Integer, Integer> seen = new HashMap<>();
		
		for(int i = 0 ; i < nums.length ; i++) {
			int leftSum = target - nums[i];
			if (seen.containsKey(leftSum)) {
				return new int[] {i ,seen.get(leftSum)};
			}
			seen.put(nums[i],i);
		}
		return new int[]{};
	}
}
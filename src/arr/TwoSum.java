package arr;

/**
 * @author cpx
 * @Description 两数之和
 * @date 2022/8/3
 */
public class TwoSum {
    int[] twoSum(int[] nums, int target) {
        int left = 0, right = nums.length -1;
        //nums[left]是否小于target;
        //nums[right] < traget;
        //开始写计算过程
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum > target) {
                right--;
            } else if (sum < target) {
                left ++;
            } else {
                return new int[]{left + 1 , right + 1 };
            }
        }
        return new int[]{-1, -1};
    }
}

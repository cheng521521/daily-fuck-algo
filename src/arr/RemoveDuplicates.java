package arr;

/**
 * @ClassName RemoveDuplicates
 * @Author jackchen
 * @Date 2022/8/1 17:01
 * @Description 删除数组中的重复元素, 并且返回新的长度。
 * leetcode: 26
 **/
public class RemoveDuplicates {
    int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        if (fast == nums.length) {
            return fast;
        }
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            ++fast;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5};
        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int length = removeDuplicates.removeDuplicates(arr);
        System.out.println("数组的长度=>" + length);
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }
    }

}

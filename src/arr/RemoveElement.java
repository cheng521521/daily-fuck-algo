package arr;

/**
 * @ClassName RemoveElement
 * @Author jackchen
 * @Date 2022/8/1 17:51
 * @Description 移除数组中的重复元素
 * leetcode 27
 **/
public class RemoveElement {
    int removeElement(int[] nums, int val) {
        int slow =0,fast = 0;
        if (nums.length == 0) {
            return 0;
        }
        while (fast < nums.length) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
                fast++;
            } else {
            fast++;}
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5};
        RemoveElement removeElement = new RemoveElement();
        int length = removeElement.removeElement(arr, 4);
        for (int i = 0; i < length; i++) {
            System.out.println(arr[i]);
        }
    }
}

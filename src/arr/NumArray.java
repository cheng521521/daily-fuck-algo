package arr;

/**
 * @ClassName NumArray
 * @Author jackchen
 * @Date 2022/8/9 16:34
 * @Description 区域和检索数组不可变，不用每一次去查询区间的时候。都要for循环一次数组。一维数组
 **/
public class NumArray {
    private int[] preNums;

    public NumArray(int[] nums) {
        preNums = new int[nums.length + 1];
        for (int i = 1; i < preNums.length; i++) {
            preNums[i] = preNums[i - 1] + nums[i - 1];
        }
    }
    public int sumRange(int left, int right) {
        return preNums[right - 1] - preNums[left];
    }
}

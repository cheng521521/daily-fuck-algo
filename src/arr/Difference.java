package arr;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName Difference
 * @Author jackchen
 * @Date 2022/8/11 12:27
 * @Description 差分数组的主要适用场景是频繁对原始数组的某个区间的元素进行增减
 **/
public class Difference {
    //查分数组
    private int[] diff;

    //生成一个差分数组
    public Difference(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] =  nums[i] - nums[i - 1] ;
        }
    }

    //操作差分数组
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length){
            diff[j+1] -= val;
        }
    }

    //返回结果
    public int[] result() {
        //根据差分数组构造结果数组
        int[] result = new int[diff.length];
        result[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            result[i] = result[i-1] + diff[i];
        }
        return result;
    }

    public int[] getDiff() {
        return diff;
    }

    public void setDiff(int[] diff) {
        this.diff = diff;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 2, 6, 3, 1};
        Difference difference = new Difference(arr);
        int[] diff = difference.getDiff();
        for (int i = 0; i < diff.length; i++) {
            System.out.println(diff[i]);
        }
        int[] res = difference.result();
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}

package arr;

/**
 * @author cpx
 * @Description 二分查找
 * @date 2022/8/3
 */
public class BinarySearch {
    /**
     * 最普通的二分查找
     * @param nums
     * @param target
     * @return
     */
    int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            //找见中点
            int mid = (left + right) /2;
            //如果target<mid.那就把right赋值为mid
            if (target < nums[mid]) {
                right = mid - 1 ;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
            //如果target>mid,那就把left赋值为mid
            //如果target==mid,那就找见了。直接返回
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,1,2,3,4,5,6,7,8,9,10};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.binarySearch(nums, 10));
    }
}

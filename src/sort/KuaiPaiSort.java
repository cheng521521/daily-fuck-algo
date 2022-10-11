package sort;

/**
 * @ClassName KuaiPaiSort
 * @Author jackchen
 * @Date 2022/10/11 16:47
 * @Description 快速排序
 **/
public class KuaiPaiSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};
        sort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void sort(int[] nums, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        // 对 nums[lo..hi] 进行切分
        // 使得 nums[lo..p-1] <= nums[p] < nums[p+1..hi]
        int p = partition(nums, lo, hi);
        // 去左右子数组进行切分
        sort(nums, lo, p - 1);
        sort(nums, p + 1, hi);
    }

    private static int partition(int[] arr, int left, int right) {
        // 设定基准值（pivot）
        int pivot = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, pivot);
                pivot = i;
            }
        }
        return pivot;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

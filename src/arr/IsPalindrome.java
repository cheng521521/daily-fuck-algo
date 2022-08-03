package arr;

/**
 * @author cpx
 * @Description 回文串判断
 * @date 2022/8/3
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}

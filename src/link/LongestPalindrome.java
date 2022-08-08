package link;

/**
 * @ClassName LongestPalindrome
 * @Author jackchen
 * @Date 2022/8/8 14:44
 * @Description 寻找最长回文字符串，如果字符串是奇数怎么办，如果字符串是是偶数怎么办？
 **/
public class LongestPalindrome {


    String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        //如果是奇数,那么l/r的值是一样的
        //如果是偶数,那么l/r是中间的两个数
        int i = s.length() % 2;
        if (i == 0) {
            //证明是偶数
            int midIndex = s.length() / 2;
            System.out.println(midIndex);
            return palindrome(s, midIndex -1, midIndex);
        } else {
            int midIndex = s.length() / 2;
            System.out.println(midIndex);
            return palindrome(s, midIndex, midIndex);
        }

    }
    String palindrome(String s, int l, int r) {
        while (l > 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }

        return s.substring(l + 1, r);
    }



    public static void main(String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome("babad"));
    }
}

package arr;

/**
 * @author cpx
 * @Description 反转数组
 * @date 2022/8/3
 */
public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length -1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        char[] str = new char[]{'a','b','c','d'};
        ReverseString reverseString = new ReverseString();
        reverseString.reverseString(str);
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }
    }
}

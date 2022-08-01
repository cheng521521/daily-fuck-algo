package link;


/**
 * @ClassName HuiWen
 * @Author jackchen
 * @Date 2022/8/1 15:09
 * @Description 判断链表是否是回文
 **/
public class HuiWen {
    private ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return traverse(head);
    }


    private boolean traverse(ListNode right) {
        //自己写的错误代码 right.getNext() == null。思考这里为什么是right == null。而不是 right.getNext()?
        //或者以极端情况思考只有一个节点。那么当right.getNext() == null时。并不影响判断。一个节点必然是回文，那么传入null时呢？会出现空指针异常。
        //因为traverse(right.getNext())已经让指针向后移动了。如果在 if (right.getNext() == null),那么必然会出现空指针异常。
        if (right == null) {
            return true;
        }
        System.out.println("到栈底了没?");
        boolean isSame = traverse(right.getNext());
        isSame = isSame && (left.getVal() == right.getVal());
        left = left.getNext();
        return isSame;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        HuiWen huiWen = new HuiWen();
        System.out.println(huiWen.isPalindrome(node1));

    }
}

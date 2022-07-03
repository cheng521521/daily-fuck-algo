package link;

/**
 * @author cpx
 * @Description 用递归实现反转整个单链表
 * @date 2022/7/3
 */
public class ReverseLink {
    ListNode reverse(ListNode head) {
        if (head == null || head.getNext() == null) {
            return head;
        }
        ListNode last = reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return last;
    }
}

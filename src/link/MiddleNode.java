package link;

/**
 * @author cpx
 * @Description 单链表的中点，当链表为偶数的时候，返回的中点是靠后的那个节点。
 * @date 2022/6/26
 */
public class MiddleNode {
    ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
}

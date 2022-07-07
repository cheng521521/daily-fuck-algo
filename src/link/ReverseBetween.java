package link;

/**
 * @author cpx
 * @Description 反转链表得一部分
 * @date 2022/7/4
 */
public class ReverseBetween {
    ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == 1) {
            return new ReverseNLink().reverseN(head,n);
        }
        head.setNext(reverseBetween(head.getNext(), m-1 ,n-1));
        return head;
    }
}

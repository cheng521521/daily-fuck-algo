package link;

/**
 * @author cpx
 * @Description 找见倒数第K个节点。从单链表中; 
 * @date 2022/6/24
 */
public class FindFromEnd {

    ListNode findFromEnd(ListNode head, int k) {
        ListNode p = head;
        for (int i = 0; i <k; i++) {
            p = p.getNext();
        }
        ListNode q = head;
        while (p != null) {
            p = p.getNext();
            q = q.getNext();
        }
        return q;
    }
}

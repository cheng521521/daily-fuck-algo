package link;

/**
 * @author cpx
 * @Description 反转链表的前N个节点
 * @date 2022/7/3
 */
public class ReverseNLink {
    //记录后驱节点
    ListNode successor = null;
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            successor = head.getNext();
            return head;
        }
        ListNode last = reverseN(head.getNext(), n - 1);
        head.getNext().setNext(head);
        head.setNext(successor);
        return last;
    }

    public static void main(String[] args) {
        ListNode bead1 = new ListNode(1);
        ListNode bead2 = new ListNode(2);
        ListNode bead3 = new ListNode(3);
        bead1.setNext(bead2);
        bead2.setNext(bead3);
        ListNode listNode = new ReverseNLink().reverseN(bead1, 2);
        while (listNode != null) {
            System.out.println(listNode.getVal());
            listNode = listNode.getNext();
        }
    }
}

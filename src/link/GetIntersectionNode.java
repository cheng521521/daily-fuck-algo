package link;

/**
 * @author cpx
 * @Description 判断两个链表是否相交,
 * @date 2022/7/1
 */
public class GetIntersectionNode {
    static ListNode getIntersectionNode(ListNode headA, ListNode headB){
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1.getNext() != null && p2.getNext() != null) {
            p1 = p1.getNext();
            p2 = p2.getNext();

            if (p1 == p2) {
                return p1;
            }
            if (p1.getNext() == null) {
                //p1.setNext(headB); 这是错误的。因为相当于将整条链表延长了。导致比p1长的链表的 getNext不为空。所以要换指针不能设置为setNext.而是 p1 = headB;直接赋值
                p1 = headB;
            }
            if (p2.getNext()== null) {
                p2 = headA;
            }
        }
        return null;
    }

    static ListNode getIntersectionNodeTrue(ListNode headA, ListNode headB) {
        // p1 指向 A 链表头结点，p2 指向 B 链表头结点
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            // p1 走一步，如果走到 A 链表末尾，转到 B 链表
            if (p1 == null) p1 = headB;
            else            p1 = p1.getNext();
            // p2 走一步，如果走到 B 链表末尾，转到 A 链表
            if (p2 == null) p2 = headA;
            else            p2 = p2.getNext();
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode c1 = new ListNode(1);
        ListNode c2 = new ListNode(2);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        head4.setNext(head3);
        head3.setNext(c1);
        c1.setNext(c2);
        ListNode bead1 = new ListNode(5);
        ListNode bead2 = new ListNode(6);
        ListNode bead3 = new ListNode(7);
        bead3.setNext(bead2);
        bead2.setNext(bead1);
        bead1.setNext(c1);
        ListNode intersectionNode = getIntersectionNode(head4, bead3);
        System.out.println(intersectionNode.getVal());

    }
}

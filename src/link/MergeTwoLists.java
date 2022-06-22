package link;

/**
 * @author cpx
 * @Description 合并两个升序链表
 * @date 2022/6/22
 */
public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //设置一个虚拟节点
        ListNode dummy  = new ListNode(-1);
        dummy .setVal(-1);
        ListNode p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.getVal() > l2.getVal()) {
                p.setNext(l2);
                l2 = l2.getNext();
            } else {
                p.setNext(l1);
                l1 = l1.getNext();
            }
            p = p.getNext();
        }
        //这里犯错了。
        //我是用的l1.getnext();在while循环走完以后。每条链都到了最后一个节点。所以不应该在getnext了。
        if (l1 != null) {
            p.setNext(l1);
        }
        if (l2 != null) {
            p.setNext(l2);
        }
        return dummy.getNext();
    }



    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.setVal(1);
        ListNode l1 = new ListNode(3);
        l1.setVal(3);
        ListNode l2 = new ListNode(5);
        l2.setVal(5);
        l.setNext(l1);
        l1.setNext(l2);

        ListNode p = new ListNode(2);
        p.setVal(2);
        ListNode p1 = new ListNode(4);
        p1.setVal(4);
        ListNode p2 = new ListNode(7);
        p2.setVal(7);
        p.setNext(p1);
        p1.setNext(p2);

        ListNode listNode = mergeTwoLists(l, p);
        while (listNode.getNext() != null) {
            System.out.println(listNode.getVal());
            listNode = listNode.getNext();
        }
    }
}

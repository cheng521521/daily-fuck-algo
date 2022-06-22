package link;

import java.util.List;

/**
 * @author cpx
 * @Description 分隔一个单链表
 * @date 2022/6/22
 */
public class SeparationLink {

    //1.先找见比X小的节点的指针并且在指针往后移动的过程中找见第一个比X大的指针
    //2.将找见的指针放在第一个比X大的指针的前面。
    //3.指针继续向后移动。直到 p.next == null.

    public static ListNode partition(ListNode head, int x) {
        // 存放小于 x 的链表的虚拟头结点
        ListNode dummy1 = new ListNode(-1);
        // 存放大于等于 x 的链表的虚拟头结点
        ListNode dummy2 = new ListNode(-1);
        // p1, p2 指针负责生成结果链表
        ListNode p1 = dummy1, p2 = dummy2;
        // p 负责遍历原链表，类似合并两个有序链表的逻辑
        // 这里是将一个链表分解成两个链表
        ListNode p = head;
        while (p != null) {
            if (p.getVal() >= x) {
                p2.setNext(p);
                p2 = p2.getNext();
            } else {
                p1.setNext(p);
                p1 = p1.getNext();
            }
            // 断开原链表中的每个节点的 next 指针
            ListNode temp = p.getNext();
            p.setNext(null);
            p = temp;
        }
        // 连接两个链表
        p1.setNext(dummy2.getNext());

        return dummy1.getNext();
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(5);
        ListNode listNode5 = new ListNode(2);
        listNode4.setNext(listNode5);
        listNode3.setNext(listNode4);
        listNode2.setNext(listNode3);
        listNode1.setNext(listNode2);
        listNode.setNext(listNode1);
        ListNode partition = partition(listNode, 3);
        while (partition != null) {
            System.out.println(partition.getVal());
            partition= partition.getNext();
        }
    }
}

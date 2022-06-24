package link;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author cpx
 * @Description 合并K个有序链表.我一开始想到去从各个链条取一个节点拼到虚拟头节点后面了。但是我卡在了怎么从三个链条中获得一个最小值的问题。所以我打算用 K个Lsitnode来表示每个链条
 * 当前所处的位置。但是在生成K个虚拟节点命名的时候我卡住了。以后暂时不走这条路。因为命名是暂时无解的。
 * @date 2022/6/23
 */
public class MergeKLists {
    ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        //虚拟头节点
        ListNode dumpy = new ListNode(-1);
        ListNode p = dumpy;
        //优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, Comparator.comparingInt(ListNode::getVal));
        //将K个节点加入队列
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {

            ListNode node = pq.poll();
            p.setNext(node);
            if (node.getNext() != null) {
                pq.add(node.getNext());
            }
            p = p.getNext();
        }
        return dumpy;
    }
}

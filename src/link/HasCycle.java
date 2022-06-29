package link;

/**
 * @author cpx
 * @Description 判断链是否是一个环
 * @date 2022/6/28
 */
public class HasCycle {

    boolean hasCycle(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.getNext() != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                return true;
            }
        }
        // 不包含环
        return false;
    }

    //求出链表的起点
    ListNode detectCycle(ListNode head) {
        // 快慢指针初始化指向 head
        ListNode slow = head, fast = head;
        // 快指针走到末尾时停止
        while (fast != null && fast.getNext() != null) {
            // 慢指针走一步，快指针走两步
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            // 快慢指针相遇，说明含有环
            if (slow == fast) {
                break;
            }
        }
        // 上面的代码类似 hasCycle 函数
        if (fast == null || fast.getNext() == null) {
            // fast 遇到空指针说明没有环
            return null;
        }

        // 重新指向头结点
        slow = head;
        // 快慢指针同步前进，相交点就是环起点
        while (slow != fast) {
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return slow;
    }
}

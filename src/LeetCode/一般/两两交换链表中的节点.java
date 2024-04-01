package LeetCode.一般;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/9/12
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 两两交换链表中的节点 {
    public static void main(String[] args){
        ListNode item = new ListNode( 1 );
        item.next = new ListNode( 2 );
        item.next.next = new ListNode( 3 );
        item.next.next.next = new ListNode( 4 );
        ListNode result = swapPairs(item);
        while (result != null){
            System.out.println(result.val );
            result = result.next;
        }
    }

    public static ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }

        ListNode result = null;
        ListNode item = null;

        // 初始化
        result = new ListNode( head.next.val );
        item = result;
        item.next = new ListNode( head.val );
        item = item.next;
        head = head.next.next;

        while (head!=null){
            ListNode next = head.next;

            // 只剩一个时，  中断
            if(next==null){
                item.next = new ListNode( head.val );
                break;
            }

            // 两个时，进行调转
            item.next = new ListNode( next.val );
            item.next.next = new ListNode( head.val );
            item = item.next.next;
            head = head.next.next;
        }

        return result;
    }
}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

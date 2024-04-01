package LeetCode.一般;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/7/17
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 删除链表的倒数第N个节点 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
//        n1.next.next=new ListNode(3);
//        n1.next.next.next = new ListNode(4);
//        n1.next.next.next.next=new ListNode(5);
        ListNode listNode = removeNthFromEnd(n1, 1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> linkedList = new ArrayList<>( );
        ListNode backup = head;
        // 计算长度
        while (head != null) {
            linkedList.add(head);
            head = head.next;
        }

        // 直接用下标取出
        if (n <= linkedList.size( )) {
            int i = linkedList.size( ) - n - 1;
            // delete

            if (i < 0) {
                backup = backup.next;
            }
            else {
                ListNode listNode = linkedList.get(i);
                listNode.next = listNode.next != null ? listNode.next.next : null;
            }
        }

        return backup;
    }


    public static class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

package LeetCode.Easy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2024/5/30
 * @Copyright: 2024 URBAN REVIVO . All rights reserved.
 */
public class 环形链表 {


    public static void main(String[] args) {
        ListNode params = new ListNode(1);
        params.next = new ListNode(2);
//        params.next.next = new ListNode(3);
//        params.next.next.next = params;

        System.out.println(hasCycle(params));

//        System.out.println(hasCycle(new ListNode(1)));
    }

    public static boolean hasCycle(ListNode head) {
        if (Objects.isNull(head)) {
            return false;
        }

        Set<ListNode> contains = new HashSet<>( );

        while (head.next != null) {
            if (!contains.add(head)) {
                return true;
            }

            head = head.next;
        }

        return false;
    }
}

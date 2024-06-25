package LeetCode.Easy;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class 相交链表 {

    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();

        while (true) {
            if (Objects.nonNull(headA)) {
                boolean addFlag = set.add(headA);
                if (!addFlag) {
                    return headA;
                }
                headA = headA.next;
            }

            if (Objects.nonNull(headB)) {
                boolean addFlag = set.add(headB);
                if (!addFlag) {
                    return headB;
                }
                headB = headB.next;
            }

            if(Objects.isNull(headA) && Objects.isNull(headB)){
                return null;
            }
        }
    }

    /**
     * 官方解法，就是总共步长为A+B，遍历完就会知道是否有交集。
     * A走完走B  B走完走A  如果有相交的路，就相当于步长一致了，有交点就肯定会相交。
     * 情况一：两个链表相交
     *
     * 链表 headA 和 headB 的长度分别是 m 和 n。假设链表 headA 的不相交部分有 a 个节点，链表 headB 的不相交部分有 b 个节点，两个链表相交的部分有 c 个节点，则有 a+c=m，b+c=n。
     *
     * 如果 a=b，则两个指针会同时到达两个链表相交的节点，此时返回相交的节点；
     *
     * 如果 a
     * 
     * =b，则指针 pA 会遍历完链表 headA，指针 pB 会遍历完链表 headB，两个指针不会同时到达链表的尾节点，然后指针 pA 移到链表 headB 的头节点，指针 pB 移到链表 headA 的头节点，然后两个指针继续移动，在指针 pA 移动了 a+c+b 次、指针 pB 移动了 b+c+a 次之后，两个指针会同时到达两个链表相交的节点，该节点也是两个指针第一次同时指向的节点，此时返回相交的节点。
     *
     * 情况二：两个链表不相交
     *
     * 链表 headA 和 headB 的长度分别是 m 和 n。考虑当 m=n 和 m
     * 
     * =n 时，两个指针分别会如何移动：
     *
     * 如果 m=n，则两个指针会同时到达两个链表的尾节点，然后同时变成空值 null，此时返回 null；
     *
     * 如果 m
     * 
     * =n，则由于两个链表没有公共节点，两个指针也不会同时到达两个链表的尾节点，因此两个指针都会遍历完两个链表，在指针 pA 移动了 m+n 次、指针 pB 移动了 n+m 次之后，两个指针会同时变成空值 null，此时返回 null。
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNodeLeetCode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}

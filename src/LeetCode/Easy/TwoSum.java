package LeetCode.Easy;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 15:52 2019/10/24
 */
public class TwoSum {
    public static void main(String[] args){
        ListNode l1=new ListNode(5);
        ListNode l2=new ListNode(5);

        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
//        return dummyHead.next;

    }

}
class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
}

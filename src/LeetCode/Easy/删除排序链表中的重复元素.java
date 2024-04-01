package LeetCode.Easy;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 15:26 2019/11/18
 */
public class 删除排序链表中的重复元素 {
    public static void main(String[] args){
        ListNode3 listNode=new ListNode3(1);
        listNode.next=new ListNode3(1);
        listNode.next.next=new ListNode3(2);
        listNode.next.next.next=new ListNode3(3);
        listNode.next.next.next.next=new ListNode3(3);
        ListNode3 result=deleteDuplicates(listNode);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }
    public static ListNode3 deleteDuplicates(ListNode3 head) {
        if(head==null)
            return null;
        ListNode3 listNode3=new ListNode3(head.val);
        ListNode3 caption =listNode3;
        while (head!=null){
            if(listNode3.val!=head.val){
                listNode3.next=new ListNode3(head.val);
                listNode3=listNode3.next;
            }
            head=head.next;
        }
        return caption;
    }

}
class ListNode3 {
    int val;
    ListNode3 next;
    ListNode3(int x) { val = x; }
}
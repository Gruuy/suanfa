package LeetCode.Easy;

/**
 * @author: Gruuy
 * @remark:
 * @date: Create in 17:12 2019/10/30
 */
public class 合并两个有序链表 {

    public static void main(String[] args){
        ListNode2 listNode2=new ListNode2(1);
        listNode2.next=new ListNode2(2);
        listNode2.next.next=new ListNode2(4);
        ListNode2 listNode1=new ListNode2(1);
        listNode1.next=new ListNode2(3);
        listNode1.next.next=new ListNode2(4);
        ListNode2 result=mergeTwoLists(listNode2,listNode1);
        while (result!=null){
            System.out.println(result.val );
            result=result.next;
        }
    }
//    public static ListNode2 mergeTwoLists(ListNode2 l1, ListNode2 l2) {
//        //插排思想
//        //有一个为空直接return
//        if(l1==null) return l2;
//        if(l2==null) return l1;
//        //next
//        ListNode2 result=null;
//        //暂存
//        ListNode2 listNode=null;
//        //真正的头结点结果
//        ListNode2 return1=null;
//        //遍历
//        while (l1!=null||l2!=null){
//            //开始需要选出头结点
//            if(result==null){
//                listNode=l1.val<l2.val?l1:l2;
//                return1=new ListNode2(listNode.val);
//                result=return1;
//                if(l1.val<l2.val) l1=l1.next;
//                else l2=l2.next;
//            }else {
//                //其中一个为空直接中断
//                if(l1==null) {result.next=l2;break;}
//                if(l2==null) {result.next=l1;break;}
//                //判断
//                listNode=l1.val<l2.val?l1:l2;
//                result.next=new ListNode2(listNode.val);
//                result=result.next;
//                if(l1.val<l2.val) l1=l1.next;
//                else l2=l2.next;
//            }
//        }
//        return return1;
//    }
    public static ListNode2 mergeTwoLists(ListNode2 l1, ListNode2 l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
class ListNode2 {
     int val;
     ListNode2 next;
     ListNode2(int x) { val = x; }
}

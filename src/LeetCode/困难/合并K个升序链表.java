package LeetCode.困难;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/9/12
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class 合并K个升序链表 {
    public static void main(String[] args) {
        ListNode i = new ListNode(1);
        i.next = new ListNode( 2 );

        ListNode i2 = new ListNode(1);
        i2.next = new ListNode( 2 );

        ListNode[] item = {i , i2};
        ListNode result = mergeKLists(item);
        while (result != null){
            System.out.println(result.val );
            result = result.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;
        ListNode item = result;
        if (lists == null || lists.length <= 0) {
            return null;
        }

        while (true) {
            ListNode small = null;
            int index = -1;
            // 筛选出最小的
            for (int i = 0; i < lists.length; i++) {
                ListNode list = lists[i];
                if (list == null) {
                    continue;
                }
                if (small == null) {
                    small = list;
                    index = i;
                    continue;
                }
                if (list.val < small.val) {
                    small = list;
                    index = i;
                }
            }

            if (small == null) {
                break;
            }

            // 新增到尾部
            if(result==null){
                result = new ListNode(small.val);
                item = result;
            }else {
                item.next = new ListNode(small.val);
                item = item.next;
            }
            // 替换原位置
            lists[index] = small.next;
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
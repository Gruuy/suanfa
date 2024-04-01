package LeetCode.困难;

/**
 * @author Gruuy
 * @Email: 245746119@qq.com
 * @date: 2020/9/14
 * @Copyright: 2020 锦铭泰软件. All rights reserved.
 */
public class K个一组翻转链表 {

    public static void main(String[] args){
        ListNode item = new ListNode(1);
        item.next = new ListNode( 2 );
        item.next.next = new ListNode( 3 );
        item.next.next.next = new ListNode( 4 );
        item.next.next.next.next = new ListNode( 5 );
        ListNode listNode = reverseKGroup(item, 3);
        while (listNode!=null){
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode hair = new ListNode(0);
        ListNode item = hair;

        while (head!=null){
            ListNode[] itemList = new ListNode[k];
            for (int i = 0; i < k; i++) {
                if(head==null){
                    break;
                }
                itemList[i] = head;
                head = head.next;
            }

            ListNode itemNode = reverse(itemList);
            item.next = itemNode;
            item = lastNode(itemNode);
        }

        return hair.next;
    }

    /**
     * 获取最后节点
     * @param itemNode
     * @return
     */
    private static ListNode lastNode(ListNode itemNode) {
        while (itemNode.next!=null){
            itemNode = itemNode.next;
        }
        return itemNode;
    }

    /**
     * 返回反转列表
     * @param itemList
     * @return
     */
    private static ListNode reverse(ListNode[] itemList) {

        ListNode result = new ListNode( 0 );
        ListNode head = result;

        if(itemList[itemList.length-1]==null){
            for (int i = 0; i < itemList.length; i++) {
                if(itemList[i]==null){
                    break;
                }
                head.next = new ListNode( itemList[i].val );
                head = head.next;
            }
            return result.next;
        }

        for (int i = itemList.length - 1; i >= 0 ; i--) {
            // 为空排除
            if(itemList[i]==null){
                continue;
            }
            head.next = new ListNode( itemList[i].val );
            head = head.next;
        }
        return result.next;
    }
}

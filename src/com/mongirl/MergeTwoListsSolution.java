package com.mongirl;

 class ListNode {
 int val;
  ListNode next;
     ListNode(int x) { val = x; }
 }

/**
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoListsSolution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode temp = null;
        int i = 1;
        while(l1 != null || l2 != null){
            int val;
            if(l2 == null && l1 != null){
                val = l1.val;
                l1 = l1.next;
            }else if(l2 != null && l1 == null){
                val = l2.val;
                l2 = l2.next;
            }else if(l1.val < l2.val){
                val = l1.val;
                l1 = l1.next;
            }else{
                val = l2.val;
                l2 = l2.next;
            }
            ListNode next = new ListNode(val);
            if(i == 1){
                result = next;
                temp = next;
            }else{
                temp.next = next;
                temp = next;

            }
            i++;
        }
        return result;

    }


    /**
     * 何臭不要脸指导之后
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists111(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if(l1 != null){
            temp.next = l1;
        }
        if(l2 != null){
            temp.next = l2;
        }
        return result.next;

    }
}

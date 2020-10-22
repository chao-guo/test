package leetcode.listSet;

import java.util.Stack;

/**
 * @author chao.guo
 * @Date 2020/10/21 14:33
 */
public class _2_addTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = null;
        int temp = 0;
        ListNode tempListNode = null;
//        listNode.val = (tempAdd > 9) ? tempAdd - 10 : tempAdd;
        while (l1 != null || l2 != null) {
            int temp1 = l1 != null ? l1.val : 0;
            int temp2 = l2 != null ? l2.val : 0;
            int tempAdd = temp1 + temp2 + temp;
            if (listNode == null) {
                listNode = tempListNode = new ListNode(tempAdd % 10);
            } else {
                tempListNode.next = new ListNode(tempAdd % 10);
                tempListNode = tempListNode.next;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (tempAdd > 9) temp = 1;
            else temp = 0;
        }
        if (temp > 0) tempListNode.next = new ListNode(temp);
        return listNode;
    }

    public static void main(String[] args) {
        _2_addTwoNumbers addTwoNumbers = new _2_addTwoNumbers();
        ListNode listNode1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        ListNode listNode2 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode listNode = addTwoNumbers.addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode);
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

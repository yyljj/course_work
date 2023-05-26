package com.whut.reggie.LeetCodeTest.huisu;


public class test24 {
    public static void main(String[] args) {
        test24 test24 = new test24();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        test24.swapPairs(node1);
    }
    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;
        ListNode res = new ListNode();
        res.next = head;
        ListNode prev = res;
        ListNode mid = head;
        ListNode after = head.next;
        while (after != null){
            prev.next = mid .next;
            mid.next = after.next;
            after.next = mid;
            if (prev.next != null)
            prev = prev.next.next;
            if (mid.next != null)
            mid = mid.next;
            if (after.next != null)
            after = after.next.next;
            if(after != null)
            after = after.next;
        }
        return res.next;
    }
}

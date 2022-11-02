package _25_Reverse_Nodes_in_kGroup;

import util.ListNode;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dumpHead = new ListNode(0);
        dumpHead.next = head;

        ListNode hair = dumpHead;
        while (hair != null) {
            ListNode tail = hair;
            for (int i = 0; i < k; ++i) {
                tail = tail.next;
                if (tail == null) {
                    return dumpHead.next;
                }
            }
            ListNode tailNex = tail.next;
            ListNode[] reverse = reverse(hair.next, tail);
            hair.next = reverse[0];
            reverse[1].next = tailNex;

            hair = reverse[1];
        }
        return dumpHead.next;
    }

    //尾插法reverse链表
    private ListNode[] reverse(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode nex = p.next;
            p.next = prev;
            prev = p;
            p = nex;
        }
        return new ListNode[]{tail, head};
    }

    //头插法reverse链表
    private ListNode[] reverse2(ListNode head, ListNode tail) {
        ListNode dumpHead = new ListNode(0, head);
        ListNode dumpTail = tail.next;
        ListNode p = head;
        while (p != dumpTail) {
            ListNode net = p.next;
            p.next = dumpHead.next;
            dumpHead.next = p;
            p = net;
        }
        head.next = dumpTail;
        return new ListNode[]{tail, head};
    }

    public static void main(String[] args) {
        int i = 4;
        ListNode head = new ListNode(1);
        ListNode tail = new ListNode(5);
        head.next = tail;
        for (int j = 0; j < 3; j++) {
            ListNode p = new ListNode(i--);
            p.next = head.next;
            head.next = p;
        }
        Solution s = new Solution();
        ListNode p123 = s.reverseKGroup(head, 2);
        System.out.println();
    }
}


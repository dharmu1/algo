package com.leetcode.linkedlist;

public class IntersectionofTwoLinkedLists {
    public static int length(ListNode head)
    {
        int count=1;
        while(head!=null)
        {
            count++;
            head=head.next;
        }
        return count;
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1=length(headA);
        int l2=length(headB);
        if(l1>l2)
        {
            for(int i=0;i<(l1-l2);i++)
            {
                headA=headA.next;
            }
        }
        else
        {
            for(int i=0;i<(l2-l1);i++)
            {
                headB=headB.next;
            }
        }
        while(headA!=null && headB!=null)
        {
            if(headA==headB)
            {
                return headA;
            }
            else
            {
                headA=headA.next;
                headB=headB.next;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode listA = new ListNode(4);
        listA.next = new ListNode(1);
        listA.next.next = new ListNode(8);
        listA.next.next.next = new ListNode(4);
        listA.next.next.next.next = new ListNode(5);
        listA.next.next.next.next.next = null;
        ListNode listB = new ListNode(5);
        listB.next = new ListNode(6);
        listB.next.next = new ListNode(1);
        listB.next.next.next =listA.next.next;
        listB.next.next.next.next = listA.next.next.next;
        listB.next.next.next.next.next =listA.next.next.next.next;
        listB.next.next.next.next.next.next = listA.next.next.next.next.next;
        ListNode res=getIntersectionNode(listA, listB);
        System.out.println("done!!"+res);
    }
}

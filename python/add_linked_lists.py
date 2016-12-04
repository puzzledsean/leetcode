# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        carry = 0
        new_head = ListNode(0)
        
        p1 = l1
        p2 = l2
        p3 = new_head

        while p1 != None or p2 != None:
            if p1 != None:
                carry += p1.val
                p1 = p1.next
            if p2 != None:
                carry += p2.val
                p2 = p2.next
            val = carry%10
            p3.next = ListNode(val)
            p3 = p3.next
            carry = carry / 10
        if carry == 1:
            p3.next = ListNode(1)
        return new_head.next
            
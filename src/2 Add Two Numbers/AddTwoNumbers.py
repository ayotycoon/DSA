
    
# 2 Add Two Numbers https://leetcode.com/problems/add-two-numbers

class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None

def listNodePrinter(node):
    s = ""
    while node != None:
        if s != "":
            s+=" -> "
        s+=str(node.val)
        node = node.next
    return s

def bruteForce(l1,l2):
    #Time O(m+n)
    #Space O(m + n)
    l1Sb = ""
    while (l1 != None):
        l1Sb+=str(l1.val)
        l1 = l1.next
    l2Sb = ""
    while (l2 != None):
        l2Sb+=str(l2.val)
        l2 = l2.next
    ansSb = ""
    carry =0
    for i in range(max(len(l1Sb), len(l2Sb))):
        a = 0 if i >= len(l1Sb) else int(l1Sb[i])
        b = 0 if i >= len(l2Sb) else int(l2Sb[i])
        add = a+b + carry
        if add >= 10:
            carry = 1
            add = add-10
        else:
            carry =0

        ansSb+=str(add)
    if carry != 0:
        ansSb+=str(carry)
    ans = ListNode(ansSb[0])
    ref = ans
    for i in range(len(ansSb)):
        if i == 0:
            continue
        ref.next = ListNode(ansSb[i])
        ref = ref.next
    return ans

def optimized1(l1,l2):
    #Time O(m+n)
    #Space O(m + n)
    ans =None
    ref = None
    carry =0
    while l1 != None or l2 != None or carry != 0:
        a =0
        b =0
        if l1 != None:
            a = l1.val
            l1 = l1.next            
        if l2 != None:
            b = l2.val
            l2 = l2.next            
        add = a+b+carry
        if add >= 10:
            carry = 1
            add = add-10
        else:
            carry =0            
        if ans == None:
            ans =  ListNode(add)
            ref = ans
        else:
            ref.next =  ListNode(add)
            ref = ref.next
    return ans


l1 = ListNode(2)
l1.next = ListNode(4)
l1.next.next = ListNode(3)

l2 = ListNode(5)
l2.next = ListNode(6)
l2.next.next = ListNode(2)

bruteForceSolution = bruteForce(l1, l2)
optimized1Solution = optimized1(l1, l2)

print(listNodePrinter(bruteForceSolution))
print(listNodePrinter(optimized1Solution))

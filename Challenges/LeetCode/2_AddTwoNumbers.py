# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
       
# Naive
def addTwoNumbers(l1, l2):
    val1 = 0
    val2 = 0
    currentNode = l1
    currentDecimal = 1
    while currentNode is not None:
        val1 += currentNode.val * currentDecimal
        currentNode = currentNode.next
        currentDecimal *= 10
    currentNode = l2
    currentDecimal = 1
    while currentNode is not None:
        val2 += currentNode.val * currentDecimal
        currentNode = currentNode.next
        currentDecimal *= 10
    result = val1 + val2

    newNode = ListNode(result % 10)
    result //= 10
    currentNode = newNode
    while(result > 0):
        currentNode.next = ListNode(result % 10)
        result //= 10
        currentNode = currentNode.next
       
    return newNode

# Single pass
def addTwoNumbers2(l1,l2):
    current1 = l1.next
    current2 = l2.next
    result = ListNode((l1.val+l2.val) % 10)
    carriedOne = (l1.val+l2.val) // 10
    currentNode = result
    while(current1 is not None or current2 is not None or carriedOne != 0):
        val1 = 0
        val2 = 0
        if current1 is not None:
            val1 = current1.val
        if current2 is not None:
            val2 = current2.val
        currentNode.next = ListNode((val1 + val2 + carriedOne) % 10)
        carriedOne = (val1 + val2 + carriedOne) // 10
        currentNode = currentNode.next
        if current1 is not None:
            current1 = current1.next
        if current2 is not None:
            current2 = current2.next
    return result
   
l1 = ListNode(9)
l12 = ListNode(9)
l13 = ListNode(9)
l2 = ListNode(9)
l22 = ListNode(9)
l1.next = l12
l12.next = l13
l2.next = l22

node = addTwoNumbers(l1,l2)
while node is not None:
    print(node.val)
    node = node.next
   
node = addTwoNumbers2(l1,l2)
while node is not None:
    print(node.val)
    node = node.next
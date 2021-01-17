class Queue:
    def __init__(self):
        self.first = None
        self.last = None

    class Node:
        def __init__(self, value):
            self.value = value
            self.next = None

    def enqueue(self, value):
        node = self.Node(value)
        if self.last is not None:
            self.last.next = node
            self.last = node
        else:
            self.last = node
            self.first = node

    def dequeue(self):
        if self.isEmpty():
            return None
        else:
            val = self.first.value
            self.first = self.first.next
            if self.first is None:
                self.last = None 
            return val


    def peek(self):
        return self.first.value

    def isEmpty(self):
        if self.first is None and self.last is None:
            return True

    def print(self):
        string = ""
        currentNode = self.first
        if currentNode is None:
            return "Empty"
        while currentNode is not None:
            string += str(currentNode.value)
            if currentNode.next is not None:
                string += ", "
            currentNode = currentNode.next
        return string


q = Queue()
print(q.print())

q.enqueue(1)
print(q.print())

q.enqueue(2)
print(q.print())

q.enqueue(3)
print(q.print())

print(q.peek())

print(q.dequeue())
print(q.print())

print(q.dequeue())
print(q.print())

print(q.dequeue())
print(q.print())

print(q.dequeue())
print(q.print())
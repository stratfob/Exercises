
class Stack():
    def __init__(self):
        self.top = None

    class Node():
        def __init__(self, value):
            self.value = value
            self.next = None

    def pop(self):
        if self.isEmpty():
            return None
        else:
            t = self.top
            self.top = t.next
            return t.value

    def push(self, value):
        n = self.Node(value)
        n.next = self.top
        self.top = n       

    def peek(self):
        if self.isEmpty():
            return None
        else:
            return self.top.value

    def isEmpty(self):
        return self.top == None

    def print(self):
        if self.isEmpty():
            print("Empty")
        else:
            current = self.top
            string = ""
            while current is not None:
                string += str(current.value)
                if current.next is not None:
                    string += ", "
                current = current.next
            print(string)

s = Stack()
s.print()

s.pop()
s.print()

s.push(1)
s.print()

s.push(2)
s.print()

print(s.peek())

print(s.pop())
s.print()

print(s.pop())
s.print()
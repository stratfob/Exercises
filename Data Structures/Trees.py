class BinaryTree():

    def __init__(self):
        self.root = None

    class Node:
        def __init__(self, value):
            self.value = value
            self.left = None
            self.right = None

        def recPrint(self, current, left, right):
            current.append(left)
            current.append(str(self.value))
            current.append("\n")
            if(self.left is not None):
                self.left.recPrint(current, right + "├── ", right + "│   ")
            if(self.right is not None):
                self.right.recPrint(current, right + "└── ", right + "│   ")


    
    def isEmpty(self):
        return self.root is None

    def print(self):
        current = []
        self.root.recPrint(current, "", "")
        print("".join(current))

    


class BinarySearchTree(BinaryTree):
    def insert(self, value):
        if self.isEmpty():
            self.root = self.Node(value)
        else:
            currentNode = self.root
            inserted = False
            while not inserted:
                parent = currentNode
                if value == parent.value:
                    inserted = True
                elif value < parent.value:
                    currentNode = parent.left
                    if currentNode is None:
                        parent.left = self.Node(value)
                        inserted = True
                elif value > parent.value:
                    currentNode = parent.right
                    if currentNode is None:
                        parent.right = self.Node(value)
                        inserted = True

    def search(self, value):
        currentNode = self.root
        found = False
        while not found:
            if currentNode is None:
                return False
            elif currentNode.value == value:
                return True
            elif value < currentNode.value:
                currentNode = currentNode.left
            elif value > currentNode.value:
                currentNode = currentNode.right

 

elements = [10,5,3,7,20,30]
bst = BinarySearchTree()
for i in elements:
    bst.insert(i)

print(bst.search(10))
bst.print()

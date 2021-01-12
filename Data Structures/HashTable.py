class HashTable():
    def __init__(self, size):
        self.size = size
        self.array = [[] for i in range(size)]

    def hashFunction(self, string):
        hash = 0
        for letter in string:
            hash += ord(letter)
        return hash
    
    def insert(self, key, value):
        index = self.hashFunction(key) % self.size
        if self.array[index] is None:
            self.array[index] = [(key, value)]
        else:
            found = False
            for i, kvpair in enumerate(self.array[index]):
                k, v = kvpair
                if k == key:
                    self.array[index][i] = (key, value)
                    found = True
                    break
            if not found:
               self.array[index].append((key,value))

    def get(self, key):
        index = self.hashFunction(key) % self.size
        if self.array[index] is None:
            return None
        else:
            for i in self.array[index]:
                k, v = i
                if key == k:
                    return v
            return None

h = HashTable(10)
h.insert('ben',10)
h.insert('cce',20)
h.insert('ccc', 30)
h.insert('ben', 40)
print(h.array)
print(h.get('ccc'))
print(h.get('cce'))
print(h.get('ben'))
print(h.get('test'))
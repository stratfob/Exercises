class AdjacentcyListGraph:
    class Node:
        def __init__(self, key):
            self.key = key
            self.adjacent = {}
    
        def addNeighbour(self, node, cost=None):
            self.adjacent[node] = cost
        
        def getNeighbours(self):
            return self.adjacent.keys()

    def __init__(self):
        self.nodes = {}

    def addNode(self, key):
        self.nodes[key] = self.Node(key)
    
    def pairNodes(self, key1, key2, cost=0):
        if key1 not in self.nodes:
            self.addNode(key1)
        if key2 not in self.nodes:
            self.addNode(key2)
        self.nodes[key1].addNeighbour(self.nodes[key2], cost)
        self.nodes[key2].addNeighbour(self.nodes[key1], cost)

    def print(self):
        for n in self.nodes:
            string = n + ", "
            for adj in self.nodes[n].adjacent:
                string += adj.key + "(cost: " + str(self.nodes[n].adjacent[adj]) + "), "
            print(string)

g = AdjacentcyListGraph()
g.addNode("Node1")
g.addNode("Node2")
g.addNode("Node3")
g.addNode("Node4")
g.addNode("Node5")

g.pairNodes("Node1", "Node2", 1)
g.pairNodes("Node2", "Node3", 1)
g.pairNodes("Node3", "Node4", 1)
g.pairNodes("Node4", "Node5", 1)
g.pairNodes("Node5", "Node1", 1)
g.pairNodes("Node1", "Node3", 3)
g.pairNodes("Node1", "Node3", 2)
g.pairNodes("Node5", "Node6", 3)

g.print()


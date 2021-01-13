public class HashTable{
    private collisionNode[] array;
    private int size;

    public HashTable(int size){
        this.size = size;
        this.array = new collisionNode[size];
    }

    private class collisionNode{
        private String key;
        private int value;
        private collisionNode next;

        private collisionNode(String key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
        }

        private String getKey(){
            return key;
        }

        private void setValue(int value){
            this.value = value;
        }

        private int getValue(){
            return value;
        }

        private void setNext(collisionNode next){
            this.next = next;
        }

        private collisionNode getNext(){
            return next;
        }

        private String print(){
            return "(" + key + ": " + value + ")";
        }
    }

    private int hash(String string){
        int hash = 0;
		for (int i = 0; i < string.length(); i++) {
            hash += string.charAt(i);
        }
        return hash;
    }

    private void insert(String key, int value){
        int index = hash(key) % size;
        if(array[index] == null){
            array[index] = new collisionNode(key, value);
        }
        else{
            collisionNode currentNode = array[index];
            boolean found = false;
            while(currentNode != null){
                if(currentNode.getKey().equals(key)){
                    currentNode.setValue(value);
                    found = true;
                    break;
                }
                else{
                    if(currentNode.getNext() == null) break;
                    currentNode = currentNode.getNext();
                }
            }
            if(!found){
                currentNode.setNext(new collisionNode(key, value));
            }

        }
    }

    private Integer get(String key){
        int index = hash(key) % size;
        if(array[index] == null){
            return null;
        }
        else{
            collisionNode currentNode = array[index];
            while(currentNode != null){
                if(currentNode.getKey().equals(key)){
                    return currentNode.getValue();
                }
                else{
                    currentNode = currentNode.getNext();
                }
            }
            return null;
        }
    }

    private void print(){
        for (collisionNode cn : array) {
            if(cn != null){
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                collisionNode currentNode = cn;
                while(currentNode!=null){
                    sb.append(currentNode.print() + " ");
                    currentNode = currentNode.getNext();
                }
                System.out.println(sb.toString() + "]");
            }
            else{
                System.out.println("[null]");
            }
        }
    }

    public static void main(String[]args){
        HashTable h = new HashTable(10);
        System.out.println(h.hash("ben"));
        h.insert("ben",10);
        h.insert("cce",20);
        h.insert("ccc", 30);
        h.insert("ben", 40);
        h.print();
        System.out.println(h.get("ccc"));
        System.out.println(h.get("cce"));
        System.out.println(h.get("ben"));
        System.out.println(h.get("test"));
    }
}
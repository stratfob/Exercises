public class Queue<T>{

    Node<T> first;
    Node<T> last;

    public Queue(){
        first = null;
        last = null;
    }

    public class Node<I>{
        I value;
        Node<I> next;
        public Node(I value){
            this.value = value;
        }
    }

    public void enqueue(T value){
        Node<T> node = new Node<T>(value);
        if(isEmpty()){
            first = node;
            last = node;
        }
        else{
            last.next = node;
            last = node;
        }
    }

    public T dequeue(){
        if(isEmpty()){
            return null;
        }
        else{
            T val = first.value;
            first = first.next;
            if (first==null){
                last = null;
            }
            return val;
        }
    }

    public T peek(){
        if(isEmpty()){
            return null;
        }
        else{
            return first.value;
        }
    }

    public boolean isEmpty(){
        return(first == null && last == null);
    }

    public String print(){
        if(isEmpty()){
            return "Empty";
        }
        else{
            StringBuilder sb = new StringBuilder();
            Node<T> currentNode = first;
            while(currentNode != null){
                sb.append(currentNode.value);
                if(currentNode.next != null){
                    sb.append(", ");
                }
                currentNode = currentNode.next;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args){
        Queue<Integer> q = new Queue<Integer>();
        System.out.println(q.print());
        
        q.enqueue(1);
        System.out.println(q.print());
        
        q.enqueue(2);
        System.out.println(q.print());
        
        q.enqueue(3);
        System.out.println(q.print());
        
        System.out.println(q.peek());
        
        System.out.println(q.dequeue());
        System.out.println(q.print());
        
        System.out.println(q.dequeue());
        System.out.println(q.print());
        
        System.out.println(q.dequeue());
        System.out.println(q.print());
        
        System.out.println(q.dequeue());
        System.out.println(q.print());
    }
}
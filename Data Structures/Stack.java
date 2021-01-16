public class Stack<T>{

    Node<T> top;

    public Stack(){
        top = null;
    }

    private class Node<I>{
        I value;
        Node<I> next;
        private Node(I value){
            this.value = value;
            next = null;
        }
    }

    public T pop(){
        if(isEmpty()){
            return null;
        }
        else{
            Node<T> t = top;
            top = t.next;
            return t.value;
        }
    }

    public void push(T value){
        Node<T> node = new Node<T>(value);
        node.next = top;
        top = node;
    }

    public T peek(){
        return top.value;
    }

    public boolean isEmpty(){
        return top==null;
    }

    public String print(){
        if(isEmpty()){
            return "Empty";
        }
        else{
            StringBuilder sb = new StringBuilder();
            Node<T> currentNode = top;
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
        Stack<Integer> s = new Stack<Integer>();
        System.out.println(s.print());

        System.out.println(s.pop());
        System.out.println(s.print());

        s.push(1);
        System.out.println(s.print());

        s.push(2);
        System.out.println(s.print());

        System.out.println(s.peek());

        System.out.println(s.pop());
        System.out.println(s.print());

        System.out.println(s.pop());
        System.out.println(s.print());
    }
}
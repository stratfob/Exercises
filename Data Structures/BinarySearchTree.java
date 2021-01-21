public class BinarySearchTree<t extends Comparable<t>>{
    Node<t> root;
    public BinarySearchTree(){
        root = null;
    }

    private class Node<X extends Comparable<X>>{
        Node<X> left;
        Node<X> right;
        X value;
        private Node(X value){
            left = null;
            right = null;
            this.value = value;
        }

        private void addChild(X value){
            if(value.compareTo(this.value) < 0){
                if(this.left != null){
                    this.left.addChild(value);
                }
                else{
                    this.left = new Node<X>(value);
                }
            }
            else if(value.compareTo(this.value) > 0){ // no insertion on ==
                if(this.right != null){
                    this.right.addChild(value);
                }
                else{
                    this.right = new Node<X>(value);
                }
            }
        }

        private boolean search(X value){
            if(value.compareTo(this.value) == 0){
                return true;
            }
            else if(value.compareTo(this.value) < 0){
                if(this.left != null){
                    this.left.search(value);
                }
                else{
                    return false;
                }
            }
            else{
                if(this.right != null){
                    this.right.search(value);
                }
                else{
                    return false;
                }
            }
            return false;
        }

        private String print(){
            String string = "Value: " + this.value + ", left child: " + (left==null?"None":left.value) + ", right child: " + (right==null?"None":right.value) + "\n";
            if(left!=null){
                string += left.print();
            }
            if(right != null){
                string += right.print();
            }
            return string;
        }

    }

    public void insert(t value){
        if (isEmpty()){
            root = new Node<t>(value);
        }
        else{
            root.addChild(value);
        }
    }

    public boolean isEmpty(){
        return root == null;
    }

    public boolean search(t value){
        if(isEmpty()){
            return false;
        }
        return root.search(value);
    }

    public String print(){
        return root.print();
    }


    public static void main(String[] args) {
        int[] elements = {10,5,3,7,20,30};
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        for (int i : elements) {
            bst.insert(i);
        }
            
        System.out.println(bst.search(10));
        System.out.println(bst.print());
    }
}
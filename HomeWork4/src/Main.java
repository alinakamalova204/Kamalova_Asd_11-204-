import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(new Node(5));
        tree.add(2);
        tree.add(4);
        tree.add(6);
        tree.add(1);
        tree.add(8);
        tree.add(7);

        tree.traverse(tree.root);

        System.out.println(tree.find(10));

        tree.delete(6);
        tree.traverse(tree.root);

        //tree.traverseCh(tree.root);
    }

    static class Tree{
        Node root;

        public Tree(Node root) {
            this.root = root;
        }

        public void add(int value){
            root = addRecur(root, value);
        }
        private Node addRecur(Node root, int n){
            if (root == null){
                root = new Node(n);
                return root;
            } if (root.value >= n){
                root.left = addRecur(root.left,n);

            } if (root.value < n){
                root.right = addRecur(root.right,n);
            } else {
                return root;
            }
            return root;
        }

        public boolean find(int value){ //найти элемент
            return contains(root,value);
        }
        private boolean contains(Node e, int n){ //содержится ли элемент в дереве
            if (e == null){
                return false;
            } if (e.value == n){
                return true;
            } if (e.value < n){
                return contains(e.right, n);
            } else {
                return contains(e.left,n);
            }
        }

        private Node deleteRecur(Node root, int value){
            if (root == null){
                return null;
            }
            if (root.left == null && root.right == null) {
                return null;
            }
            if (root.right == null) {
                return root.left;
            }

            if (root.left == null) {
                return root.right;
            }
            int smallestValue = findSmallestValue(root.right);
            root.value = smallestValue;
            root.right = deleteRecur(root.right, smallestValue);
            return root;
        }
        private int findSmallestValue(Node root) {
            return root.left == null ? root.value : findSmallestValue(root.left);
        }

        public void delete(int value) {
            root = deleteRecur(root, value);
        }
        public void traverse(Node root){ //обход в глубину
            if (root != null) {
                traverse(root.left);
                System.out.println(root.value);
                traverse(root.right);
            }
        }
        public void traverseCh(Node root){ //обход в ширину
             if (root != null) {
                System.out.println(root.value);
                if (root.left != null) {
                    traverseCh(root.left);
                }
                if (root.right != null) {
                    traverseCh(root.right);
                }
            }
        }




        @Override
        public String toString() {
            return "Tree{" +
                    "root=" + root.value + ", left = " + root.left.value +
                    ", right = " + root.right.value +
                    '}';
        }
    }

    static class Node{
        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}
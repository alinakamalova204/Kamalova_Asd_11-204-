public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree(new Node(4));
        tree.add(1);
        tree.add(3);
        tree.add(10);
        tree.add(7);
        tree.add(8);
        tree.add(9);
        tree.add(6);
        tree.delete(9);
        tree.traverse(tree.root);
    }

    static class Tree{
        Node root; //корень

        public Tree(Node root) {
            this.root = root;
        }
        //добавление
        private Node addRecur(Node root, int n){
            if (root == null){
                return new Node(n);
            }
            if (root.value >= n){
                root.left = addRecur(root.left,n);
            }
            if (root.value < n){
                root.right = addRecur(root.right,n);
            } else {
                return root;
            }
            return root;
        }
        public void add(int value){
            root = addRecur(root, value);
        }

        //поиск элемента
        private boolean contains(Node e, int n){
            if (e == null){
                return false;
            }
            if (root.value == n){
                return true;
            }
            if (e.value < n){
                return contains(e.left, n);
            }
            else {
                return contains(e.right,n);
            }
        }
        public boolean find(int value){
            return contains(root, value);
        }
        //удаление
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

        public void traverse(Node root){
            if (root != null){
                traverse(root.left);
                System.out.println(root.value);
                traverse(root.right);
            }
        }

    }
    static class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value = value;
            left = null;
            right = null;
        }
    }
}
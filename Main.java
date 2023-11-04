

class Node {
    int key;
    Node left;
    Node right;

    public Node(int key){
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

class BinTree {
    Node root;

    public BinTree(){
        root = null;
    }

    public Node insertNode(Node node, int key){
        if(node == null){
            return new Node(key);
        }

        if(key < root.key){
            root.left = insertNode(root.left, key);
        }
        else if(key > root.key){
            root.right = insertNode(root.right, key);
        }

        return root;
    }

    public Node deleteNode(Node node, int key){
        if(node == null){
            return root;
        }

        if(key < root.key){
            root.left = deleteNode(root.left, key);
            return root;
        }
        else if(key > root.key){
            root.right = deleteNode(root.right, key);
            return root;
        }

        else{
            if(root.left == null){
                Node temp = root.right;
            }
            else if(root.right == null){
                Node temp = root.left;
            }

            node temp = ///// IMPLEMENTAR FUNÇAO DE VALOR MINIMO
        }



    }
}



class TreeNode {
    int key;
    TreeNode left;
    TreeNode right;

    public TreeNode(int key) {
        this.key = key;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    // Função para inserir um elemento na árvore
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            return new TreeNode(key);
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }

        return root;
    }

    public void printTree() {
        printTreeRec(root);
    }

    private void printTreeRec(TreeNode root) {
        if (root != null) {
            System.out.print(root.key + " ");
            printTreeRec(root.left);
            printTreeRec(root.right);
        }
    }

}



public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.insert(50);
        tree.insert(35);
        tree.insert(70);
        tree.insert(25);
        tree.insert(40);
        tree.insert(65);
        tree.insert(90);
        tree.insert(80);
        tree.insert(30);

        System.out.println("Árvore em ordem:");
        tree.printTree();
        System.out.println("\n");
    }
}

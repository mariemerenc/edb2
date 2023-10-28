

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

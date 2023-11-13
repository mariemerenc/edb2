import java.util.Stack;



class BinTree {
    class Node {
    int key;
    int value;
    Node left;
    Node right;

        public Node(int value){
        this.key = 0;
        this.value = value;
        this.left = null;
        this.right = null;
        }
    }
    Node root;
    Stack<Node> pilha = new Stack<Node>();
    String s = "";

    public BinTree(){
        root = null;
    }

    public void insertNode(int value){
        root = insertNode(root, value);
    }

    void imprimeArvore(int s) {
        if (root != null) {
            if (s == 1) {
                // Chama a função imprimeFormato1 com a raiz da árvore
                imprimeFormato1(root, 0);
                System.out.println("\n");
            } else if (s == 2) {
                // Chama a função imprimeFormato2 com a raiz da árvore
                imprimeFormato2(root);
                System.out.println("\n");
            } else {
                // Tratar erro: formato inválido
                System.out.println("Formato de impressão inválido.\n");
            }
        } else {
            System.out.println("Árvore vazia.\n");
        }
    }


    void imprimeFormato1(Node atual, int nivel) {
        if (atual != null) {
            // Imprime espaços para formatar corretamente
            for (int i = 0; i < nivel; i++) {
                System.out.print("      ");
            }

            // Imprime o valor do nó
            System.out.println(atual.value + "---------------------");

            // Chama recursivamente para os filhos
            imprimeFormato1(atual.left, nivel + 1);
            imprimeFormato1(atual.right, nivel + 1);
        }

    }

    void imprimeFormato2(Node atual) {
        if (atual != null) {
            // Imprime o valor do nó com parênteses
            System.out.print("(" + atual.value);

            // Chama recursivamente para os filhos
            imprimeFormato2(atual.left);
            imprimeFormato2(atual.right);

            // Fecha parênteses
            System.out.print(")");
        }
        
    }

    private Node insertNode(Node node, int value) {
        if (node == null) {
            // Cria um novo nó e retorna, não esqueça de atribuir à variável node
            return new Node(value);
        }

        if (value < node.value) {
            // Se o valor a ser inserido é menor, inserimos à esquerda
            node.left = insertNode(node.left, value);
        } else if (value > node.value) {
            // Se o valor a ser inserido é maior, inserimos à direita
            node.right = insertNode(node.right, value);
        }

        // Se o valor já existe, não fazemos nada (não permitimos duplicatas)

        return node;
    }


    public void deleteNode(int value){
        root = deleteNode(root, value);
    }

    private Node deleteNode(Node node, int value){
        if(node == null){
            return root;
        }

        if(value < node.value){
            node.left = deleteNode(node.left, value);
            return node;
        }
        else if(value > node.value){
            node.right = deleteNode(node.right, value);
            return node;
        }

        else{
            if(node.left == null){
                Node temp = node.right;
                return temp;
            }
            else if(node.right == null){
                Node temp = node.left;
                return temp;
            }

            Node temp = minValueNode(node.right);
            node.value = temp.value;
            node.right = deleteNode(node.right, temp.value);
        }

        return node;
    }

    private Node minValueNode(Node node){
        Node current = node;

        while(current.left != null){
            current = current.left;
        }

        return current;
    }

    public void sort(){
        sort(root);
    }

    private void sort(Node node){
        if(node == null){
            return;
        }

        sort(node.left);
        System.out.print(node.key + " ");
        sort(node.right);
    }

    public String ordemSimetrica(Node root) {
        if (root.left != null) {
            ordemSimetrica(root.left);
        }
        s += root.value + " ";
        if (root.right != null) {
            ordemSimetrica(root.right);
        }

        return s;
    }





    public void preOrdemIterativa(Node node) {
        Stack<Node> pilha = new Stack<Node>();
        pilha.push(node);
        while (!pilha.empty()) {
            Node aux = pilha.pop();
            s.concat(Integer.toString(aux.value) + " ");
            System.out.print(aux.value + " ");
            if (aux.right != null) {
                pilha.push(aux.right);
            }
            if (aux.left != null) {
                pilha.push(aux.left);
            }
        }
    }

    public int calcularAltura(Node node){
        int leftH = 0;
        int rightH = 0;

        if(node == null){
            return 0;
        }
        else{
            leftH = calcularAltura(node.left);
            rightH = calcularAltura(node.right);

            if(leftH > rightH){
                return(leftH + 1);
            }
            else{
                return(rightH + 1);
            }
        }
    }

    public void printOne(Node node) {
        Stack<Node> pilha = new Stack<Node>();
        pilha.push(node);
        while (!pilha.empty()) {
            Node aux = pilha.pop();
            System.out.print(aux.value + " ");
            if (aux.right != null) {
                pilha.push(aux.right);
            }
            if (aux.left != null) {
                pilha.push(aux.left);
            }
        }
    }

    public int totalNos(Node node) {
        int i = 0;
        Stack<Node> pilha = new Stack<Node>();
        pilha.push(node);
        while (!pilha.empty()) {
            Node aux = pilha.pop();
            i++;
            System.out.print(aux.value + " ");
            if (aux.right != null) {
                pilha.push(aux.right);
            }
            if (aux.left != null) {
                pilha.push(aux.left);
            }
        }

        return i;
    }



    public void preOrdem(Node node) {
        System.out.print(node.value + " ");
        if (node.left != null) {
            preOrdem(node.left);
        }
        if (node.right != null) {
            preOrdem(node.right);
        }
    }

    public void posOrdem(Node node) {
        if (node.left != null) {
            posOrdem(node.left);
        }
        if (node.right != null) {
            posOrdem(node.right);
        }
        System.out.print(node.value + " ");
    }

    public int ordemSimetricaSemPrint(Node node) {
        int cont = 1;

        if (node.left != null) {
            ordemSimetrica(node.left);
        }
        cont++;
        if (node.right != null) {
            ordemSimetrica(node.right);
        }

        return cont;
    }

    public int posicao(Node root, int value) {
        int cont = 1;

        // Verificar se a árvore é nula
        if (root == null)
            return 0;

        while (root.value != value) {
            if (root.value < value) {
                root = root.right;
            } else if (root.value > value) {
                root = root.left;
            }

            // Verificar se atingiu uma folha e o valor não foi encontrado
            if (root == null) {
                return -1; // ou algum valor que indique que o valor não foi encontrado
            }

            cont++;
        }

        return cont;
    }


    public int enesimoElemento(Node root, int n) {
        if (root == null || n <= 0) {
            return -1; // ou algum valor que indique que o n-ésimo elemento não existe
        }

        Stack<Node> pilha = new Stack<>();
        Node atual = root;
        int cont = 0;

        while (atual != null || !pilha.isEmpty()) {
            while (atual != null) {
                pilha.push(atual);
                atual = atual.left;
            }

            atual = pilha.pop();
            cont++;

            if (cont == n) {
                return atual.value; // Encontrou o n-ésimo elemento
            }

            atual = atual.right;
        }

        return -1; // ou algum valor que indique que o n-ésimo elemento não existe
    }


    public int busca(Node node, int valor) {
        if (root == null || root.value == valor)
            return root.value;
 
        
        if (root.value < valor)
            return busca(root.right, valor);
 
       
        return busca(root.left, valor);

    }

    public void imprimir(Node root) {
        System.out.println("Ordem Simetrica: ");
        String s = ordemSimetrica(root);
        System.out.println(s);
        System.out.println("Buscando valor de uma posição X dada: ");
        int elemento = enesimoElemento(root, 3);
        System.out.println("\n o valor encontrado foi " + elemento + "\n");
        System.out.println("Buscando posição de um valor Y fornecido: ");
        int pos = posicao(root, 20);
        System.out.println("\n a posição do elemento indicado é " + pos + "\n");
        //System.out.println("\nPre-Ordem");
        //preOrdem(root);
        //System.out.println("\nPos-Ordem");
        //posOrdem(root);

        //preOrdemIterativa(root);
        //System.out.println("\n" + s);
        //double k = teste(root.left);
        //System.out.println(k);
    }

    public boolean ehCheia(){
        int h = calcularAltura(root);
        int tot = totalNos(root);
        if(Math.pow(2, h) - 1 == tot){
            return true;
        }
        return false;
        
    }

    public boolean ehCompleta(){
        if(root == null){
            return true;
        }
        
        if(ehCheia() == true){
            return true;
        }

        return false;
    }

    public boolean ehCompleta(Node root) {
        if (root == null) {
            return true; // Árvore vazia é considerada completa
        }

        Queue<Node> fila = new LinkedList<>();
        boolean flag = false;

        // Adiciona a raiz à fila
        fila.add(root);

        while (!fila.isEmpty()) {
            Node atual = fila.poll();

            // Verifica se encontrou um nó que não está completamente preenchido
            if (atual == null) {
                flag = true;
            } else {
                // Se encontrou um nó não preenchido anteriormente, mas o nó atual não é nulo, a árvore não é completa
                if (flag) {
                    return false;
                }

                // Adiciona os filhos à fila
                fila.add(atual.left);
                fila.add(atual.right);
            }
        }

        return true; // Se a execução chegou até aqui, a árvore é completa
    }

    public int mediana(){
        int total = totalNos(root);
        int med=0;

        if(total % 2 == 0){

        }
        else{
            med = total/2 + 1;
        }


        

        return med;
    }
    
    public static void main(String[] args) {
    BinTree tree = new BinTree();
    tree.insertNode(50);
    tree.insertNode(30);
    tree.insertNode(70);
    tree.insertNode(20);
    tree.insertNode(40);
    tree.insertNode(60);
    tree.insertNode(80);
    //tree.insertNode(15);
    //tree.insertNode(90);
    tree.imprimir(tree.root);
    //tree.teste();
    //tree.printOne(tree.root);
    int h = tree.calcularAltura(tree.root);
    //System.out.println(" " + h + " ");
    boolean teste = tree.ehCheia();
    System.out.println(teste);
    tree.imprimeArvore(1);
    tree.imprimeArvore(2);
    //teste = tree.ehCompleta();
    //System.out.println(teste);
    }
}




    

    /*public Node insertNode(Node node, int value){
        if(node == null){
            return new Node(value);
        }

        if(value < root.value){
            root.left = insertNode(root.left, value);
        }
        else if(value > root.value){
            root.right = insertNode(root.right, value);
        }

        return root;
    }*/

    /*public Node deleteNode(Node node, int value){
        if(node == null){
            return root;
        }

        if(value < root.value){
            root.left = deleteNode(root.left, value);
            return root;
        }
        else if(value > root.value){
            root.right = deleteNode(root.right, value);
            return root;
        }

        else{
            if(root.left == null){
                Node temp = root.right;
                return temp;
            }
            else if(root.right == null){
                Node temp = root.left;
                return temp;
            }

            node temp = 
        }



    }*/




    

    /*public Node insertNode(Node node, int value){
        if(node == null){
            return new Node(value);
        }

        if(value < root.value){
            root.left = insertNode(root.left, value);
        }
        else if(value > root.value){
            root.right = insertNode(root.right, value);
        }

        return root;
    }*/

    /*public Node deleteNode(Node node, int value){
        if(node == null){
            return root;
        }

        if(value < root.value){
            root.left = deleteNode(root.left, value);
            return root;
        }
        else if(value > root.value){
            root.right = deleteNode(root.right, value);
            return root;
        }

        else{
            if(root.left == null){
                Node temp = root.right;
                return temp;
            }
            else if(root.right == null){
                Node temp = root.left;
                return temp;
            }

            node temp = 
        }



    }*/

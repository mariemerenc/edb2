import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;



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
    Stack<Node> stack = new Stack<Node>();
    String s = "";

    public BinTree(){
        root = null;
    }

    //inserção de nó raiz
    public void inserirNode(int value){
        root = inserirNode(root, value);
    }

    //impressão da árvore com os parâmetros indicados (1 ou 2)
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


    void imprimeFormato1(Node curr, int nivel) {
        if (curr != null) {
            // Imprime espaços para formatar corretamente
            for (int i = 0; i < nivel; i++) {
                System.out.print("      ");
            }

            // Imprime o valor do nó
            System.out.println(curr.value + "---------------------");

            // Chamada recursiva para os filhos
            imprimeFormato1(curr.left, nivel + 1);
            imprimeFormato1(curr.right, nivel + 1);
        }

    }

    void imprimeFormato2(Node curr) {
        if (curr != null) {
            // Imprime o valor do nó com parênteses
            System.out.print("(" + curr.value);

            // Chamada recursiva para os filhos
            imprimeFormato2(curr.left);
            imprimeFormato2(curr.right);

            // Fecha parênteses
            System.out.print(")");
        }
        
    }

    //inserção de um novo nó
    private Node inserirNode(Node node, int value) {
        if (node == null) {
            // Cria um novo nó e retorna
            return new Node(value);
        }

        if (value < node.value) {
            // Se o valor a ser inserido é menor, inserimos à esquerda
            node.left = inserirNode(node.left, value);
        } else if (value > node.value) {
            // Se o valor a ser inserido é maior, inserimos à direita
            node.right = inserirNode(node.right, value);
        }

        // Se o valor já existe, não fazemos nada (não permitimos duplicatas)

        return node;
    }

    //remoção de um nó
    public void removeNode(int value){
        root = removeNode(root, value);
    }

    private Node removeNode(Node node, int value){
        if(node == null){
            return root;
        }

        if(value < node.value){
            node.left = removeNode(node.left, value);
            return node;
        }
        else if(value > node.value){
            node.right = removeNode(node.right, value);
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
            node.right = removeNode(node.right, temp.value);
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

    //percurso em ordem simétrica que retorna uma string
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

    //percurso em pré-ordem que retorna uma string
    public String preOrdemString(Node node){
        String s = "";
        s += node.value + " ";
        if (node.left != null) {
            preOrdemString(node.left);
        }
        if (node.right != null) {
            preOrdemString(node.right);
        }

        return s;
    }




    //implementação do percurso pré-ordem iterativo
    public void preOrdemIterativa(Node node) {
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        while (!stack.empty()) {
            Node aux = stack.pop();
            s.concat(Integer.toString(aux.value) + " ");
            System.out.print(aux.value + " ");
            if (aux.right != null) {
                stack.push(aux.right);
            }
            if (aux.left != null) {
                stack.push(aux.left);
            }
        }
    }

    //cálculo da altura da ABB
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

    //retorna a quantidade de nós existentes em uma subárvore de raiz node
    public double totalNosNum(Node node) {
        double i = 0;
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        while (!stack.empty()) {
            Node aux = stack.pop();
            i++;
            System.out.print(aux.value + " ");
            if (aux.right != null) {
                stack.push(aux.right);
            }
            if (aux.left != null) {
                stack.push(aux.left);
            }
        }

        return i;
    }

    //retorna a soma total dos valores dos nós de uma subárvore
    public double totalSoma(Node node) {
        double i = 0;
        Stack<Node> stack = new Stack<Node>();
        stack.push(node);
        while (!stack.empty()) {
            Node aux = stack.pop();
            i += aux.value;
            System.out.print(aux.value + " ");
            if (aux.right != null) {
                stack.push(aux.right);
            }
            if (aux.left != null) {
                stack.push(aux.left);
            }
        }

        return i;
    }

    //percurso pré-ordem recursivo
    public void preOrdem(Node node) {
        System.out.print(node.value + " ");
        if (node.left != null) {
            preOrdem(node.left);
        }
        if (node.right != null) {
            preOrdem(node.right);
        }
    }

    //percurso pós-ordem recursivo
    public void posOrdem(Node node) {
        if (node.left != null) {
            posOrdem(node.left);
        }
        if (node.right != null) {
            posOrdem(node.right);
        }
        System.out.print(node.value + " ");
    }

    
    //retorna a posição em que dado valor se encontra
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


    //retorna o valor do n-ésimo elemento
    public int enesimoElemento(Node root, int n) {
        if (root == null || n <= 0) {
            return -1; // valor que indique que o n-ésimo elemento não existe
        }

        Stack<Node> stack = new Stack<>();
        Node curr = root;
        int cont = 0;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            cont++;

            if (cont == n) {
                return curr.value; // Encontrou o n-ésimo elemento
            }

            curr = curr.right;
        }

        return -1; // valor que indica que o n-ésimo elemento não existe
    }



    //busca que recebe um valor e retorna o nó que possui esse valor
    public Node buscaReturnNode(int valor) {
        if (root == null || root.value == valor)
            return root;
 
        
        if (root.value < valor)
            root = root.right;
        if(root.value > valor)
            root = root.left;
       
        return buscaReturnNode(valor);

    }

    //busca que retorna o valor de um nó buscado
    public int busca(Node node, int valor) {
        if (root == null || root.value == valor)
            return root.value;
 
        
        if (root.value < valor)
            return busca(root.right, valor);
 
       
        return busca(root.left, valor);

    }

    //retorna o nó que é mediana da ABB
    public int median(Node root) {
        if (root == null) {
            return -1; // a árvore está vazia
        }

        int totalNos = totalNos(root);
        int mid = (totalNos + 1) / 2; // Se a quantidade total é ímpar, meio é a mediana

        Stack<Node> stack = new Stack<>();
        Node curr = root;
        int cont = 0;
        int median = -1;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            cont++;

            if (cont == mid || (totalNos % 2 == 0 && cont == mid + 1)) {
                median = curr.value;
                break;
            }

            curr = curr.right;
        }

        return median;
    }

    //retorna a quantidade total de nós nesta ABB
    private int totalNos(Node root) {
        if (root == null) {
            return 0;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        int total = 0;

        while (!stack.isEmpty()) {
            Node aux = stack.pop();
            total++;

            if (aux.right != null) {
                stack.push(aux.right);
            }

            if (aux.left != null) {
                stack.push(aux.left);
            }
        }

        return total;
    }

    //calcula a média de valores dos nós da ABB
    public double media(int valor){

        Node node = buscaReturnNode(valor);
        return totalSoma(node) / totalNosNum(node);
    }
    

    //retorna um valor booleano que indica se a ABB é cheia ou não
    public boolean ehCheia(){
        int h = calcularAltura(root);
        int tot = totalNos(root);
        if(Math.pow(2, h) - 1 == tot){
            return true;
        }
        return false;
        
    }

    //retorna um valor booleano que indica se a ABB é completa ou não
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

        Queue<Node> queue = new LinkedList<>();
        boolean flag = false;

        // Adiciona a raiz à queue
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            // Verifica se encontrou um nó que não está completamente preenchido
            if (curr == null) {
                flag = true;
            } else {
                // Se encontrou um nó não preenchido anteriormente, mas o nó curr não é nulo, a árvore não é completa
                if (flag) {
                    return false;
                }

                // Adiciona os filhos à queue
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }

        return true;
    }

    
    public static void main(String[] args) {
    BinTree tree = new BinTree();
    tree.inserirNode(50);
    tree.inserirNode(30);
    tree.inserirNode(70);
    tree.inserirNode(20);
    tree.inserirNode(40);
    tree.inserirNode(60);
    tree.inserirNode(80);
    tree.inserirNode(55);
    tree.inserirNode(100);
    tree.inserirNode(94);
    tree.inserirNode(90);

    try {
            // Carrega comandos do arquivo
            File file = new File("comando.txt");
            Scanner scanner = new Scanner(file);

            // Itera sobre os comandos
            while (scanner.hasNextLine()) {
                String comando = scanner.nextLine();

                // Divide o comando em partes
                String[] partes = comando.split(" ");

                // Executa o comando correspondente
                switch (partes[0]) {
                    case "ENESIMO":
                        int n = Integer.parseInt(partes[1]);
                        int enesimo = tree.enesimoElemento(tree.root, n);
                        System.out.println("N-ésimo elemento: " + enesimo);
                        break;

                    case "POSICAO":
                        int valor = Integer.parseInt(partes[1]);
                        int posicao = tree.posicao(tree.root, valor);
                        System.out.println("Posição do valor " + valor + ": " + posicao);
                        break;

                    case "MEDIANA":
                        int mediana = tree.median(tree.root);
                        System.out.println("Mediana: " + mediana);
                        break;

                    case "CHEIA":
                        boolean ehCheia = tree.ehCheia();
                        System.out.println("É cheia? " + ehCheia);
                        break;

                    case "COMPLETA":
                        boolean ehCompleta = tree.ehCompleta(tree.root);
                        System.out.println("É completa? " + ehCompleta);
                        break;

                    case "IMPRIMA":
                        int s = Integer.parseInt(partes[1]);
                        tree.imprimeArvore(s);
                        break;

                    case "REMOVA":
                        int valorRemover = Integer.parseInt(partes[1]);
                        tree.removeNode(valorRemover);
                        System.out.println("Nó removido: " + valorRemover);
                        break;

                    case "BUSCA":
                        int valorBusca = Integer.parseInt(partes[1]);
                        int resultadoBusca = tree.busca(tree.root, valorBusca);
                        System.out.println("Resultado da busca: " + resultadoBusca);
                        break;

                    case "MEDIA":
                        int valorMedia = Integer.parseInt(partes[1]);
                        double media = tree.media(valorMedia);
                        System.out.println("Média: " + media);
                        break;

                    case "INSIRA":
                        int valorInsercao = Integer.parseInt(partes[1]);
                        tree.inserirNode(valorInsercao);
                        System.out.println("Inserção realizada: " + valorInsercao);
                        break;

                    case "ALTURA":
                        int altura = tree.calcularAltura(tree.root);
                        System.out.println("Altura da árvore: " + altura);
                        break;

                    default:
                        System.out.println("Comando inválido");
                        break;
                }
            }

            // Fecha o scanner
            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

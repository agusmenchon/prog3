package org.example.Tree;

public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    public TreeNode insert(Integer val) {
        root = insertNode(root, val);
        return root;
    }


    // Metodos auxiliares para recrear arbol de ej4.
    public TreeNode insertarDerecha(TreeNode r, int x) {
        TreeNode n = new TreeNode(x);
        r.setRight(n);
        return n;
    }

    public TreeNode insertarIzquierda(TreeNode r, int x) {
        TreeNode n = new TreeNode(x);
        r.setLeft(n);
        return n;
    }

    public void borrarNodosInternos(TreeNode root) {
        if (root == null) {
            return;
        }

        borrarNodosInternos(root.getLeft());
        borrarNodosInternos(root.getRight());

        if (!isSheet(root)) {
            root.setValue(null);
        }

    }

    // Método auxiliar para insertar un nodo en el árbol binario de forma aleatoria de manera recursiva
    private TreeNode insertNode(TreeNode root, Integer val) {
        // Si el árbol está vacío, crea un nuevo nodo y devuélvelo
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }

        if (Math.random() < 0.5) {
            root.setLeft(insertNode(root.getLeft(), val));
        } else {
            root.setRight(insertNode(root.getRight(), val));
        }

        return root;
    }

    public void printInOrder() {
        System.out.println("\nPrint in order: ");
        this.printInOrder(this.root);
    }

    private void printInOrder(TreeNode nodo) {
        if (nodo == null) {
            return;
        }
        printInOrder(nodo.getLeft());
        System.out.print(nodo.getValue() + " ");
        printInOrder(nodo.getRight());
    }

    private boolean TwoChildrens(TreeNode node) {
        if (node.getLeft() != null && node.getRight() != null) {
            return true;
        }
        return false;
    }

    private boolean oneChildren(TreeNode node) {
        if ((node.getLeft() == null && node.getRight() != null) || (node.getLeft() != null && node.getRight() == null)) { //modificar condicional
            return true;
        }
        return false;
    }

    private boolean isSheet(TreeNode node) {
        if (node.getLeft() == null && node.getRight() == null) {
            return true;
        }
        return false;
    }

    public void colocarValoresANodosVacios() {
        colocarValoresANodosVacios(this.root);
    }

    private int colocarValoresANodosVacios(TreeNode root) {
        if(root == null){
            return 0;
        }
        int izq = colocarValoresANodosVacios(root.getLeft());
        int der = colocarValoresANodosVacios(root.getRight());

        if(!isSheet(root)){
            root.setValue(der-izq);
        }
        return root.getValue();
    }
}

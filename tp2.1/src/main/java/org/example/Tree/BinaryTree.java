package org.example.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {
    TreeNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public TreeNode<T> insert(T val) {
        root = insertNode(root, val);
        return root;
    }


    // Metodos auxiliares para recrear arbol de ej4.
    public TreeNode<T> insertarDerecha(TreeNode<T> r, T x) {
        TreeNode<T> n = new TreeNode<T>(x);
        r.setRight(n);
        return n;
    }

    public TreeNode<T> insertarIzquierda(TreeNode<T> r, T x) {
        TreeNode<T> n = new TreeNode<T>(x);
        r.setLeft(n);
        return n;
    }

    public void borrarNodosInternos(TreeNode<T> root) {
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
    private TreeNode<T> insertNode(TreeNode<T> root, T val) {
        // Si el árbol está vacío, crea un nuevo nodo y devuélvelo
        if (root == null) {
            root = new TreeNode<T>(val);
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

    private void printInOrder(TreeNode<T> nodo) {
        if (nodo == null) {
            return;
        }
        printInOrder(nodo.getLeft());
        System.out.print(nodo.getValue() + " ");
        printInOrder(nodo.getRight());
    }

    private boolean TwoChildrens(TreeNode<T> node) {
        return node.getLeft() != null && node.getRight() != null;
    }

    private boolean oneChildren(TreeNode<T> node) {
        //modificar condicional
        return (node.getLeft() == null && node.getRight() != null) || (node.getLeft() != null && node.getRight() == null);
    }

    private boolean isSheet(TreeNode<T> node) {
        return node.getLeft() == null && node.getRight() == null;
    }

    public void colocarValoresANodosVacios() {
        colocarValoresANodosVacios(this.root);
    }

    private int colocarValoresANodosVacios(TreeNode<T> root) {
        if(root == null){
            return 0;
        }
        Integer izq = colocarValoresANodosVacios(root.getLeft());
        Integer der = colocarValoresANodosVacios(root.getRight());
        Integer sum = izq-der;
        if(!isSheet(root)){
            root.setValue((T) sum);
        }
        return (Integer) root.getValue();
    }

    public void printPreety() {
        List<TreeNode<T>> list = new ArrayList<>();
        list.add(this.root);
        printTree(list, getHeight(this.root));
    }

    public int getHeight(TreeNode<T> head) {

        if (head == null) {
            return 0;
        } else {
            return 1 + Math.max(getHeight(head.getLeft()), getHeight(head.getRight()));
        }
    }

    /**
     * pass head node in list and height of the tree
     *
     * @param levelNodes
     * @param level
     */
    private void printTree(List<TreeNode<T>> levelNodes, int level) {

        List<TreeNode<T>> nodes = new ArrayList<>();

        //indentation for first node in given level
        printIndentForLevel(level);

        for (TreeNode<T> treeNode : levelNodes) {

            //print node data
            System.out.print(treeNode == null?" ":treeNode.getValue());

            //spacing between nodes
            printSpacingBetweenNodes(level);

            //if its not a leaf node
            if(level>1){
                nodes.add(treeNode == null? null:treeNode.getLeft());
                nodes.add(treeNode == null? null:treeNode.getRight());
            }
        }
        System.out.println();

        if(level>1){
            printTree(nodes, level-1);
        }
    }

    private void printIndentForLevel(int level){
        for (int i = (int) (Math.pow(2,level-1)); i >0; i--) {
            System.out.print(" ");
        }
    }

    private void printSpacingBetweenNodes(int level){
        //spacing between nodes
        for (int i = (int) ((Math.pow(2,level-1))*2)-1; i >0; i--) {
            System.out.print(" ");
        }
    }

    public ArrayList<StringBuilder> ej5(int cantVocales){
        ArrayList<StringBuilder> resultado = new ArrayList<>();
        ArrayList<T> actual = new ArrayList<>();
        ej5(this.root, resultado, actual,  cantVocales,0, false);

        return resultado;
    }

    private void ej5(TreeNode<T> actual, ArrayList<StringBuilder> resultado, ArrayList<T> palabraActual, int cantVocales, int sumVocal, boolean cumple) {
        if(actual == null){
            return;
        }

        palabraActual.add(actual.getValue());
        if(esVocal(actual.getValue())){
            sumVocal++;
        }

        ej5(actual.getLeft(), resultado, palabraActual, cantVocales, sumVocal, cumple);
        ej5(actual.getRight(), resultado, palabraActual, cantVocales, sumVocal, cumple);
        if(sumVocal == cantVocales){
            cumple = true;
        }

        if(cumple && isSheet(actual)){
            StringBuilder a = new StringBuilder();
//            System.out.print(palabraActual);
            for(T i : palabraActual){
                a.append(i);
            }
            resultado.add(a);
            cumple = false;
        }

        cumple = false;
        palabraActual.remove(palabraActual.size()-1);
    }

    private boolean esVocal(T value) {
        if( value.equals("A") || value.equals("E") || value.equals("I") || value.equals("O") || value.equals("U")){
            return true;
        }
        return false;
    }

}

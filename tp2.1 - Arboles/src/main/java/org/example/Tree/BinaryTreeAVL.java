package org.example.Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeAVL<T extends Comparable<T>> {

    private TreeNode<T> root;

    public BinaryTreeAVL() {
        this.root = null;
    }

    public void insert(T value) {
        this.root = add(this.root, value);
    }


    private TreeNode<T> add(TreeNode<T> nodo, T valor) {
        if (nodo == null) {
            return new TreeNode<T>(valor);
        }

        int i = nodo.compareTo(valor);
        if (i > 0) {
            nodo.setLeft(add(nodo.getLeft(), valor));
        } else if (i < 0) {
            nodo.setRight(add(nodo.getRight(), valor));
        } else {
            // El valor ya está en el árbol, no hacemos nada
            return nodo;
        }

        calcularFactorDeEquilibrio(nodo);
        return balancear(nodo);
    }

    private TreeNode<T> balancear(TreeNode<T> nodo) {
        if (nodo.getFactorDeEquilibrio() > 1) {
            if (calcularFactorDeEquilibrio(nodo.getRight()) < 0) {
                nodo.setRight(rotarDerecha(nodo.getRight()));
            }
            return rotarIzquierda(nodo);
        } else if (nodo.getFactorDeEquilibrio() < -1) {
            if (calcularFactorDeEquilibrio(nodo.getLeft()) > 0) {
                nodo.setLeft(rotarIzquierda(nodo.getRight()));
            }
            return rotarDerecha(nodo);
        }
        return nodo;
    }

    TreeNode<T> rotarIzquierda(TreeNode<T> nodo) {
        TreeNode<T> nuevaRaiz = nodo.getRight();
        nodo.setRight(nuevaRaiz.getLeft());
        nuevaRaiz.setLeft(nodo);
        calcularFactorDeEquilibrio(nodo);
        calcularFactorDeEquilibrio(nuevaRaiz);
        return nuevaRaiz;
    }

    TreeNode<T> rotarDerecha(TreeNode<T> nodo) {
        TreeNode<T> nuevaRaiz = nodo.getLeft();
        nodo.setLeft(nuevaRaiz.getRight());
        nuevaRaiz.setRight(nodo);
        calcularFactorDeEquilibrio(nodo);
        calcularFactorDeEquilibrio(nuevaRaiz);
        return nuevaRaiz;
    }

    private int calcularFactorDeEquilibrio(TreeNode<T> nodo) {
        int alturaIzquierda = getHeight(nodo.getLeft());
        int alturaDerecha = getHeight(nodo.getRight());
        nodo.setFactorDeEquilibrio(alturaDerecha - alturaIzquierda);
        return alturaDerecha - alturaIzquierda;
    }

    public TreeNode<T> getRootNode(){
        return this.root;
    }
    public T getRoot(){
        return this.root.getValue();
    }

    /* chequea si el numero se encuentra en el arbol binario. Funciona de forma recursiva. */
    public boolean hasElem(T it){
        return this.hasElem(this.root, it);
    }

    private boolean hasElem(TreeNode<T> root, T it) {
        if(root.getValue() == it){
            return true;
        }
        int i = root.compareTo(it);
        if(i > 0){
            if(root.getLeft() != null){
                return hasElem(root.getLeft(), it);
            }
        } else if(i < 0){
            if(root.getRight() != null) {
                return hasElem(root.getRight(), it);
            }
        }
        return false;
    }

    public boolean isEmpty(){
        return root == null;
    }

    //Nodo mas izquierdo
    private TreeNode<T> NMI(TreeNode<T> root){
        if(root.getLeft()!=null){
            return NMI(root.getLeft());
        }
        return root;
    }

    //Nodo mas derecho
    private TreeNode<T> NMD(TreeNode<T> root){
        if(root.getRight()!=null){
            return NMD(root.getRight());
        }
        return root;
    }

    //Eliminar un nodo del ABB. Complejidad: O(h).
    public void delete(T value) {
        this.root = delete(this.root, value);
    }

    private TreeNode<T> delete(TreeNode<T> nodo, T valor) {
        if (nodo == null) {
            return null;
        }

        int i = nodo.compareTo(valor);
        if (i > 0) {
            nodo.setLeft(delete(nodo.getLeft(), valor));
        } else if (i < 0) {
            nodo.setRight(delete(nodo.getRight(), valor));
        } else {
            // Nodo a eliminar encontrado

            // Caso 1: Nodo hoja o con un solo hijo
            if (nodo.getLeft() == null || nodo.getRight() == null) {
                TreeNode<T> hijoNoNulo = (nodo.getLeft() != null) ? nodo.getLeft() : nodo.getRight();

                // Si el nodo es hoja
                if (hijoNoNulo == null) {
                    return null;
                } else {
                    return hijoNoNulo;
                }
            }

//            // Caso 2: Nodo con dos hijos
//            TreeNode<T> sucesor = this.NMI(nodo.getRight());
//            nodo.setValue(sucesor.getValue());
//            nodo.setRight(delete(nodo.getRight(), (T) sucesor.getValue()));
        }

        calcularFactorDeEquilibrio(nodo);
        return balancear(nodo);
    }

    private boolean TwoChildrens(TreeNode<T> node) {
        return node.getLeft() != null && node.getRight() != null;
    }

    private boolean oneChildren(TreeNode<T> node) {
        //modificar condicional
        return (node.getLeft() == null && node.getRight() != null) || (node.getLeft() != null && node.getRight() == null);
    }

    public boolean isSheet(TreeNode<T> node){
        return node.getLeft() == null && node.getRight() == null;
    }

    //calcular la altura al arbol
    public int getHeight(){
        return getHeight(this.root);
    }

    public void printPosOrder(){
        this.printPosOrder(this.root);
    }

    private void printPosOrder(TreeNode<T> nodo) {
        if(nodo == null){
            return;
        }
        printPosOrder(nodo.getLeft());
        printPosOrder(nodo.getRight());
        System.out.print(nodo.getValue() + " ");
    }

    public void printPreOrder() {
        this.printPreOrder(this.root);
    }

    private void printPreOrder(TreeNode<T> nodo) {
        if(nodo == null){
            System.out.print("- "); /* opcional para marcar hijos nulos */
            return;
        }
        System.out.print(nodo.getValue() + " ");
        printPreOrder(nodo.getLeft());
        printPreOrder(nodo.getRight());
    }
    public void printInOrder(){
        this.printInOrder(this.root);
    }

    protected void printInOrder(TreeNode<T> nodo) {
        if(nodo == null){
            return;
        }
        printInOrder(nodo.getLeft());
        System.out.print(nodo.getValue() + " ");
        printInOrder(nodo.getRight());
    }

    public List<TreeNode<T>> getLongestBranch(){
        ArrayList<TreeNode<T>> longestBranch = new ArrayList<>();
        ArrayList<TreeNode<T>> rutaActual = new ArrayList<>();
        this.getLongestBranch(this.root, longestBranch, rutaActual);
        return longestBranch;
    }

    private void getLongestBranch(TreeNode<T> root, List longestBranch, List rutaActual) {

        if(root==null){
            return;
        }

        rutaActual.add(root);
        if(isSheet(root)){
            if(rutaActual.size() > longestBranch.size()){
                longestBranch.clear();
                longestBranch.addAll(rutaActual);
            }
        }

        this.getLongestBranch(root.getLeft(), longestBranch, rutaActual);
        this.getLongestBranch(root.getRight(), longestBranch, rutaActual);

        rutaActual.remove(rutaActual.size()-1);
    }

    public List getFrontera(){
        ArrayList<TreeNode<T>> l = new ArrayList<>();
        return (ArrayList) this.getFrontera(this.root, l);
    }

    private List getFrontera(TreeNode<T> root, List l) {
        if(root==null){
            return l;
        }
        if(isSheet(root)){
            l.add(root);
        }
        getFrontera(root.getLeft(), l);
        getFrontera(root.getRight(), l);

        return l;
    }

    public T getMaxElem(){
        TreeNode<T> a = this.NMD(this.root);
        return a.getValue();
    }

    public ArrayList getElemAtLevel(int i){
        ArrayList<TreeNode<T>> l = new ArrayList<>();
        this.getElemAtLevel(this.root, l, i, 0);
        return l;
    }

    private void getElemAtLevel(TreeNode<T> root, ArrayList<TreeNode<T>> l,int lvl, int x) {
        if(x>lvl || root == null){
            return;
        }
        if(lvl == x){
            l.add(root);
        }
        getElemAtLevel(root.getLeft(), l, lvl, x+1);
        getElemAtLevel(root.getRight(), l, lvl, x+1);
    }

    /**----------------------- EJERCICIO 2  -----------------------**/
    //Ejercicio 2:
    // implementar un algoritmo que retorne la suma de todos los nodos internos del árbol.
    public int sumOfAllInternalNodes(){
        return sumOfAllInternalNodes(this.root);
    }

    private int sumOfAllInternalNodes(TreeNode<T> root) {
        if(root == null){
            return 0;
        }
        int izq = sumOfAllInternalNodes(root.getLeft());
        int der = sumOfAllInternalNodes(root.getRight());

        if(oneChildren(root) || TwoChildrens(root)){
            return (Integer)root.getValue() + izq + der;
        }
        return 0;
    }

    /**----------------------- EJERCICIO 3  -----------------------**/
    /* implementar un algoritmo que permita obtener un listado con
    los valores de todas las hojas cuyo valor supere K. */
    public List ej3(T x){
        ArrayList<TreeNode<T>> l = new ArrayList<>();
        this.ej3(this.root, l, x);
        return l;
    }

    private void ej3(TreeNode<T> root, ArrayList<TreeNode<T>> l, T x) {
        if(root==null){
            return;
        }
        int i = root.compareTo(x);
        if(i>0){
            l.add(root);
        }

        ej3(root.getLeft(), l, x);
        ej3(root.getRight(), l, x);
    }

    /**----------------------- IMPRESION DEL ARBOL EN ORDEN  -----------------------**/
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
            System.out.print(treeNode == null?"-":treeNode.getValue());

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

}
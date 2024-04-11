package org.example.Tree;

import java.util.ArrayList;
import java.util.List;

public class Tree {

    private TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void insert(Integer value) {
        if (this.root == null)
            this.root = new TreeNode(value);
        else
            this.add(this.root,value);
    }

    private void add(TreeNode actual, Integer value) {
        if (actual.getValue() > value) {
            if (actual.getLeft() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setLeft(temp);
            } else {
                add(actual.getLeft(),value);
            }
        } else if (actual.getValue() < value) {
            if (actual.getRight() == null) {
                TreeNode temp = new TreeNode(value);
                actual.setRight(temp);
            } else {
                add(actual.getRight(),value);
            }
        }
    }

    public Integer getRoot(){
        return this.root.getValue();
    }


    /* chequea si el numero se encuentra en el arbol binario. Funciona de forma recursiva. */
    public boolean hasElem(Integer it){
        return this.hasElem(this.root, it);
    }

    private boolean hasElem(TreeNode root, Integer it) {
        if(root.getValue() == it){
            return true;
        }
        if(root.getValue() > it){
            if(root.getLeft() != null){
                return hasElem(root.getLeft(), it);
            }
        } else if(root.getValue() < it){
            if(root.getRight() != null) {
                return hasElem(root.getRight(), it);
            }
        }
        return false;
    }

    public boolean isEmpty(){
        return (root==null) ? true : false;
    }

    //Nodo mas izquierdo
    private TreeNode NMI(TreeNode root){
        if(root.getLeft()!=null){
            return NMI(root.getLeft());
        }
        return root;
    }

    //Nodo mas derecho
    private TreeNode NMD(TreeNode root){
        if(root.getRight()!=null){
            return NMD(root.getRight());
        }
        return root;
    }

    //Eliminar un nodo del ABB. Complejidad: O(h).
    public boolean delete(Integer i){
        if(this.hasElem(i)){
            TreeNode n = delete(this.root, i);
            if(n!=null){
                return true;
            }
        }
        return false;
    }

    private TreeNode delete(TreeNode nodo, int i){
        if(nodo!=null){
            if(nodo.getValue() == i){
                //case1 = es hoja
                if(isSheet(nodo)){
                    nodo = null;
                    return nodo;
                }
                //case2 = tiene 1 solo hijo
                else if(oneChildren(nodo)){
                    if(nodo.getLeft() == null){
                        nodo = nodo.getRight();
                    } else {
                        nodo = nodo.getLeft();
                    }
                    return nodo;
                }
                //case3 = tiene 2 hijos
                else if (TwoChildrens(nodo)){
                    TreeNode der = nodo.getRight();
                    TreeNode aux = this.NMI(der);
                    nodo.setValue(aux.getValue());
                    return delete(nodo.getRight(), aux.getValue());
                    //TODO CORREGIR
        //            else if (TwoChildrens(actual.getLeft())) {
        //                TreeNode aux = this.NMI(actual.getLeft().getRight());
        //                int j = aux.getValue();
        //                delete(this.NMI(actual.getRight()), j);
        //                actual.getLeft().setValue(j);
        //            }


//                    aux.setLeft(nodo.getLeft());
//                    return aux;

                }
            }

            if(i < nodo.getValue()){
                return delete(nodo.getLeft(), i);
            } else {
                return delete(nodo.getRight(), i);
            }
        }

        return null;
    }

    private boolean TwoChildrens(TreeNode node) {
        if(node.getLeft() != null && node.getRight() != null){
            return true;
        }
        return false;
    }

    private boolean oneChildren(TreeNode node) {
        if((node.getLeft() == null && node.getRight() != null) || (node.getLeft() != null && node.getRight() == null)){ //modificar condicional
            return true;
        }
        return false;
    }

    public boolean isSheet(TreeNode node){
        if(node.getLeft() == null && node.getRight() == null){
            return true;
        }
        return false;
    }

    //calcular la altura al arbol
    public int getHeight(){
        return getHeight(this.root);
    }

    private int getHeight(TreeNode root) {
        if(root== null){
            return 0;
        } else{
            int leftHeight = getHeight(root.getLeft());
            int rightHeight = getHeight(root.getRight());

            if(leftHeight >= rightHeight){
                return leftHeight+1;
            }
            return rightHeight+1;
        }
    }

    public void printPosOrder(){
        this.printPosOrder(this.root);
    }

    private void printPosOrder(TreeNode nodo) {
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

    private void printPreOrder(TreeNode nodo) {
        if(nodo == null){
            return;
        }
        System.out.print(nodo.getValue() + " ");
        printPreOrder(nodo.getLeft());
        printPreOrder(nodo.getRight());
    }
    public void printInOrder(){
        this.printInOrder(this.root);
    }

    private void printInOrder(TreeNode nodo) {
        if(nodo == null){
            return;
        }
        printInOrder(nodo.getLeft());
        System.out.print(nodo.getValue() + " ");
        printInOrder(nodo.getRight());
    }

    public List getLongestBranch(){
        ArrayList l = new ArrayList<>();
        return this.getLongestBranch(this.root, l);
        //TODO
    }

    private List getLongestBranch(TreeNode root, List l) {
        return l;
    }

    public ArrayList getFrontera(){
        ArrayList<TreeNode> l = new ArrayList<>();
        return (ArrayList) this.getFrontera(this.root, l);
    }

    private List getFrontera(TreeNode root, List l) {
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

    public Integer getMaxElem(){
        TreeNode a = this.NMD(this.root);
        return a.getValue();
    }

    public List getElemAtLevel(int i){
        return null;
        //TODO
    }

}
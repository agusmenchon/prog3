package org.example;

import org.example.Tree.Tree;
import org.example.Tree.TreeNode;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Tree arbol = new Tree();
        arbol.insert(20);
        arbol.insert(10);
        arbol.insert(25);
        arbol.insert(5);
        arbol.insert(15);
        arbol.insert(4);
        arbol.insert(8);
        arbol.insert(13);
        arbol.insert(17);
        arbol.insert(22);
        arbol.insert(35);
        arbol.insert(16);
        arbol.insert(19);

        System.out.println("Pre order: ");
        arbol.printPreOrder();
        System.out.println("\nIn order: ");
        arbol.printInOrder();
        System.out.println("\nPost order: ");
        arbol.printPosOrder();

        System.out.println("\nget max Elem: " + arbol.getMaxElem());

        System.out.println("Nodos hojas: ");
        ArrayList<TreeNode> frontera = arbol.getFrontera();
        for(TreeNode l: frontera) {
            System.out.print(l.getValue() + " | ");
        }

        System.out.println("\nDelete nodo: 15");
        arbol.delete(15);
        System.out.println("Pre order: ");
        arbol.printPreOrder();
        System.out.println("\nIn order: ");
        arbol.printInOrder();
        System.out.println("\nPost order: ");
        arbol.printPosOrder();

        System.out.println("\nAltura del arbol: " + arbol.getHeight());

    }
}
package org.example;

import org.example.Tree.BinaryTree;
import org.example.Tree.BinaryTreeAVL;
import org.example.Tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Maintp2 {
    public static void main(String[] args) {
        //Ejercicio 1
        System.out.println("EJERCICIO 1");
        BinaryTreeAVL<Integer> arbol = new BinaryTreeAVL<>();
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
        arbol.insert(30);
        arbol.insert(40);
        arbol.printPreety();

        System.out.println("Max Elem: " + arbol.getMaxElem());
        System.out.println("Altura del arbol: " + arbol.getHeight());

        System.out.print("Nodos hojas: ");
        ArrayList<TreeNode> frontera = (ArrayList<TreeNode>) arbol.getFrontera();
        for (TreeNode l : frontera) {
            System.out.print(l.getValue() + " | ");
        }
        System.out.println("");

        System.out.print("Ruta mas larga: ");
        List<TreeNode<Integer>> ruta = arbol.getLongestBranch();
        for (TreeNode l : ruta) {
            System.out.print(l.getValue() + " | ");
        }
        System.out.println("");

        Integer j = 22;
        System.out.println("\nDelete nodo: " + j);
        arbol.delete(j);
        System.out.println("");
        arbol.printPreety();

        //Ejercicio 2
        ArrayList<TreeNode> listNodos = arbol.getElemAtLevel(2);
//        System.out.println("");
        System.out.print("Nodos en la altura 2: ");
        for (TreeNode l : listNodos) {
            System.out.print(l.getValue() + " | ");
        }

        int i = arbol.sumOfAllInternalNodes();
        System.out.println("");
        System.out.println("\nEJERCICIO 2: la suma de todos los nodos es: " + i);

        //Ejercicio 3
        System.out.println("");
        ArrayList<TreeNode> listMayoresA = (ArrayList<TreeNode>) arbol.ej3(22);
        System.out.println("EJERCICIO 3: Nodos HOJAS mayores a 22: ");
        for (TreeNode<Integer> l : listMayoresA) {
            System.out.print(l.getValue() + " | ");
        }

        System.out.println("");
        System.out.println("EJERCICIO 4: ");
        BinaryTree<Integer> tree = new BinaryTree<>();
        TreeNode<Integer> raiz = tree.insert(37);
        TreeNode x = tree.insertarIzquierda(raiz, -26);
        TreeNode z = tree.insertarDerecha(raiz, 11);
        TreeNode a = tree.insertarIzquierda(x, 14);
        TreeNode b = tree.insertarDerecha(x, -12);
        TreeNode s = tree.insertarIzquierda(b, 7);
        TreeNode d = tree.insertarDerecha(b, -5);
        TreeNode f = tree.insertarIzquierda(z, 9);
        TreeNode g = tree.insertarDerecha(z, 20);
        TreeNode h = tree.insertarDerecha(f, 9);

//        tree.printPreety();
        tree.borrarNodosInternos(raiz);
        tree.printPreety();
        System.out.println("-------------------------");
        // Metodo para volver a calcular recursivamente el valor de los nodos.
        tree.colocarValoresANodosVacios();
        tree.printPreety();

        //Ejercicio 5
        System.out.println("EJERCICIO 5: ");
        BinaryTree<String> ej5 = new BinaryTree<>();
        TreeNode<String> raiz2 = ej5.insert("M");
        TreeNode<String> aa = ej5.insertarIzquierda( raiz2, "A");
        TreeNode<String> ii = ej5.insertarDerecha( raiz2, "I");
        TreeNode<String> ll = ej5.insertarIzquierda( aa, "L");
        TreeNode<String> nn = ej5.insertarDerecha( aa, "N");
        TreeNode<String> aaa = ej5.insertarIzquierda( nn, "A");
        TreeNode<String> oo = ej5.insertarDerecha( nn, "O");
        TreeNode<String> ss = ej5.insertarIzquierda( ii, "S");
        TreeNode<String> ooo = ej5.insertarDerecha( ii, "S");
        TreeNode<String> aaaa = ej5.insertarDerecha( ss, "A");
//        ej5.printPreety();
        ArrayList<StringBuilder> listaej5 = ej5.ej5(1);
        for (StringBuilder string : listaej5) {
            System.out.print(string + ",");
        }


    }
}
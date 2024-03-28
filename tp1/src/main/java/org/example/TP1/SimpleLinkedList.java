package org.example.TP1;

import java.util.Iterator;

public class SimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    private int size;

    public SimpleLinkedList() {
        this.first = null;
        this.last = null;
        size = 0;
    }

    public void addLast(T info) {
        Node<T> aux = new Node<>(info, null);
        if (this.first == null) {
            this.setFirst(aux);
        } else {
            this.last.setNext(aux);
            this.last = aux;
        }
        this.size++;
    }

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
        this.last = first;
//        this.size++;
    }

    //Ejercicio 1
    public void insertFront(T info) {
        Node<T> tmp = new Node<T>(info, null);
        tmp.setNext(this.first);
        this.first = tmp;
        this.size++;
    }

    public T extractFront() {
        Node<T> tmp = this.first;
        this.first = first.getNext();
        this.size--;
        return tmp.getInfo();
    }

    public boolean isEmpty() {
        return size > 0;
    }

    public T get(int index) {
        Node<T> aux = this.first;
        for (int i = 1; i <= this.size; i++) {
            if (i == index) {
                return aux.getInfo();
            }
            aux = aux.getNext();
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    @Override
    public String toString() {
        String t = "";
        Node<T> aux = this.first;
        for (int i = 1; i <= this.size; i++) {
            t += aux.getInfo() + " | ";
            aux = aux.getNext();
        }
        return "SimpleLinkedList: " + t;
    }

    //Ejercicio 3
    public int indexOf(T info) {
        Node<T> aux = this.first;
        for (int i = 1; i <= this.size; i++) {
            if (aux.getInfo() == info) {
                return i;
            }
            aux = aux.getNext();
        }
        return -1;
    }

    //Ejercicio 4
    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {
            int index = 1;
            Node<T> current = getFirst();

            @Override
            public boolean hasNext() {
                if(index <= size && current != null){
                    return true;
                } else {
                    return false;
                }
            }

            @Override
            public T next() {
                return get(index++);
            }
        };
        return it;
    }

    /* Ejercicio 5
Escriba un procedimiento que dadas dos listas construya otra con los elementos comunes,
suponiendo que: a) Las listas están desordenadas y la lista resultante debe quedar ordenada. b)
Las listas están ordenadas y la lista resultante debe mantenerse ordenada.
    */
    public SimpleLinkedList<T> concatListEj5(SimpleLinkedList<T> l2){
        SimpleLinkedList<T> listAux = new SimpleLinkedList<T>();
        int pos = 1;
        Node<T> current = this.first;
        while(pos<=size){
            for(T element: l2){
                if(current.getInfo().equals(element)){
                    listAux.insertOrdered(current.getInfo());
                    break;
                }
            }
            pos++;
            current = current.getNext();
        }
        return listAux;
    }

    public void insertOrdered(T info){
        Node<T> aux = new Node<>(info,null);

        Node<T> prev = null;

        if(this.first==null){
            this.setFirst(aux);
            this.size++;
            return;
        }

        Node<T> current = this.first;

        int pos = 1;
        while(pos<=this.size && current!=null){
            if(current.getInfo().compareTo(info) > 0 ){
                aux.setNext(current);
                if(this.first == current){
                    this.first = aux;
                } else {
                    prev.setNext(aux);
                }
                this.size++;
                return;
            } else if (current.getNext()==null){
                current.setNext(aux);
                this.last = aux;
                return;
            }
            this.size++;
            pos++;
            prev = current;
            current = current.getNext();
        }
    }


//    Ejercicio 6
//    Escriba una función que dadas dos listas construya otra con los elementos que están en la
//    primera pero no en la segunda.
    public SimpleLinkedList<T> concatListEj6(SimpleLinkedList<T> l2){
        SimpleLinkedList<T> listAux = new SimpleLinkedList<T>();
        int pos = 1;
        boolean bandera = false;
        Node<T> current = this.first;
        while(pos<=size){
            for(T element: l2){
                if(current.getInfo().equals(element)){
                    bandera = true;
                }
            }
            if(bandera == false){
                listAux.insertOrdered(current.getInfo());
            }
            pos++;
            current = current.getNext();
            bandera = false;
        }
        return listAux;
    }
}

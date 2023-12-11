package com.solvd.mavenFarm.listick;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class MyList<T> implements Serializable {


    private Node<T> firstNode;
    private Node<T> lastNode;
    private ArrayList<T> returnList = new ArrayList<>();
    private int size;
    private int iterator;

    private static class Node<T>
    {
        private T value;
        private Node<T> previous;
        private Node<T> next;
        private Node()
        {
            previous = null;
            next=null;
            this.value = null;
        }
        private Node(T object)
        {
            super();
            this.value = object;
        }
        private Node(Node<T> currentNode, T object)
        {
            previous = currentNode;
            currentNode.next=this;
            this.value = object;
        }
    }
    public MyList()
    {
        this.firstNode = new Node<>();
    }
    public void add(T object)
    {
        if(firstNode.value == null) {
            firstNode.value = object;
            lastNode=firstNode;
        }
        else {
            lastNode = new Node<T>(lastNode, object);
        }
        size++;
    }
    public boolean add(int index, T object)
    {
        if(index==0)
        {
            Node<T> node = new Node<T>(object);
            Node<T> tmpNodeF = new Node<T>(firstNode.value);
            tmpNodeF.next = firstNode.next;
            firstNode = node;
            firstNode.next = tmpNodeF;
            size++;
            return true;

        }
        if(index == size-1)
        {
            Node<T> node = new Node<T>(object);
            lastNode.next = node;
            node.previous=lastNode;
            lastNode=node;
            size++;
            return true;
        }

        if(indexInList(index))
        {
            Node<T> node = new Node<>(object);
            Node<T> indexedNode = findNodeByIndex(index).previous;
            node.next = indexedNode.next;
            indexedNode.next.previous=node;
            node.previous = indexedNode;
            node.previous.next = node;
            size++;
            return true;
        }
        return false;
    }
    public boolean set(int index, T object)
    {
        if(index==0)
        {
            firstNode.value = object;
            return true;

        }
        if(index == size-1)
        {
            lastNode.value = object;
            return true;
        }

        if(indexInList(index))
        {

            Node<T> indexedNode = findNodeByIndex(index);
            indexedNode.value = object;
            size++;
            return true;

        }
        return false;
    }
    public boolean empty()
    {
        return firstNode.value != null;
    }
    public boolean clear()
    {
        if (lastNode.previous == null)
        {
            firstNode.value = null;
            return true;
        }
        clearNode(lastNode);
        firstNode.next = null;
        firstNode.value = null;
        size(0);
        return true;
    }

    private void clearNode(Node<T> currentNode) {
        /*if(currentNode.next != null)
        {
            currentNode.next = null;
            size--;

            if(currentNode.previous != null)
            {
                clearNode(currentNode.previous);
            }

            currentNode = null;
            size--;


        }*/
        if(currentNode.previous!= null)
        {
            Node<T> a = currentNode.previous;
            currentNode.next = null;
            currentNode.previous = null;
            currentNode.value = null;
            clearNode(a);
        }
    }
    private Node<T> findNodeByIndex(int index)
    {
        Node<T> returnNode = iteratingNode(firstNode);
        while (iterator!=index)
        {
            iterator++;
            returnNode = iteratingNode(returnNode.next);
        }
        iterator = 0;
        return returnNode;
    }

    private Node<T> iteratingNode(Node<T> currentNode)
    {

        return currentNode;
    }
    private boolean indexInList(int index)
    {

        return index < size - 1 && index > 0;
    }

    private boolean checkFirstValue(T object)
    {
        if(firstNode.value == null) {
            firstNode.value = object;
            lastNode=firstNode;
            return false;
        }
        return true;
    }
    private void addInArrayList(Node<T> currentNode)
    {

        returnList.add(currentNode.value);
        if(currentNode.next !=null)
        {
            addInArrayList(currentNode.next);
        }
    }
    public ArrayList<T> toArrayList()
    {
        addInArrayList(firstNode);
        return returnList;
    }
    public int size()
    {
        if(firstNode.value == null) {
            size(0);
            return size;
        }
        return size;
    }
    private void size(int size)
    {
        this.size = size;
    }
    public boolean remove(int index)
    {
        if(index==0)
        {
            firstNode = firstNode.next;
            firstNode.previous = null;
            size--;
            return true;

        }
        if(index == size-1)
        {
            lastNode = lastNode.previous;
            lastNode.next = null;
            size--;
            return true;
        }

        if(indexInList(index))
        {
            Node<T> indexedNode = findNodeByIndex(index);
            indexedNode.previous.next = indexedNode.next;
            indexedNode.next.previous = indexedNode.previous;

            indexedNode.previous = null;
            indexedNode.next = null;
            indexedNode.value = null;
            return true;

        }
        return false;
    }
    private Node<T> findNodeByValue(T object)
    {
        Node<T> returnNode = iteratingNode(firstNode);
        while (!returnNode.value.equals( object))
        {
            returnNode = iteratingNode(returnNode.next);
        }
        return returnNode;
    }
    public void remove(T object)
    {
       var findableNode = findNodeByValue(object);
        Node<T> prev = findableNode.previous;
        Node<T> next = findableNode.next;
        prev.next = next;
        next.previous = prev;

        findableNode.previous = null;
        findableNode.next = null;
        findableNode.value = null;

    }

}

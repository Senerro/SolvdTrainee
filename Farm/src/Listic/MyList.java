package Listic;

import java.util.ArrayList;

public class MyList<T> {

    private int maxSize;
    private int currentSize;
    private float sizeFactor;
    private Node<T> firstNode;
    private Node<T> lastNode;

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
    public void addInEnd(T object)
    {
            if(firstNode.value == null) {
                firstNode.value = object;
                lastNode=firstNode;
            }
            else {
                lastNode = new Node<T>(lastNode, object);
                System.out.println("FD");
            }
    }
    public void addInStart(T object)
    {
        if(CheckFirstElement(object))
        {
            lastNode = new Node<T>(lastNode, object);
            System.out.println("FD");
        }
    }
    private boolean CheckFirstElement(T object)
    {
        if(firstNode.value == null) {
            firstNode.value = object;
            lastNode=firstNode;
            return false;
        }
        return true;
    }
    public void deleteLast()
    {
        this.lastNode.previous.next=null;
        this.lastNode.previous=null;
    }
    /*public Node search(Node<T> currentNode) //поиск последней заполненной ноды
    {
        if (currentNode.next != null)
        {
            var a = currentNode.next;
            search(a);
        }
        return currentNode;
    }*/
    public ArrayList<T> toArrayList()
    {
        ArrayList<T> returnList = new ArrayList<>();
        returnList.add(firstNode.value);
        boolean isEnd = false;
        do {
            var node = getNextNode(firstNode.next);
            returnList.add(node.value);
            if (node.next==null)
                isEnd=true;
            else getNextNode(node.next);
        }
        while (!isEnd);
       return returnList;
    }
    private Node<T> getNextNode(Node<T> currentNode)
    {
        System.out.println("add value " + currentNode.value);
        return currentNode.next;
    }
    public void Println()
    {
        System.out.println("value " + firstNode.value);
        if(firstNode.next!=null)
        {
            Println(firstNode.next);
        }
    }
}

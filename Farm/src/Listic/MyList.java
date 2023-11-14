package Listic;

import java.util.ArrayList;

public class MyList<T> {

    private int maxSize;
    private int currentSize;
    private float sizeFactor;
    private Node<T> firstNode;
    private Node<T> lastNode;
    private ArrayList<T> returnList = new ArrayList<>();

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
            }
    }
    public void addInStart(T object)
    {
        if(CheckFirstElement(object))
        {
            lastNode = new Node<T>(lastNode, object);
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
    private void getNextNode(Node<T> currentNode)
    {
        System.out.println(currentNode.value);
        returnList.add(currentNode.value);
        if(currentNode.next !=null)
        {
            getNextNode(currentNode.next);
        }

    }
    public ArrayList<T> toArrayList()
    {
        getNextNode(firstNode);
        return returnList;
    }
}

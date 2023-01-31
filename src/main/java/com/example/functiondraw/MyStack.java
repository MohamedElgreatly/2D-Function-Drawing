package com.example.functiondraw;


public class MyStack {
    class Node{
        Object data;
        Node next;
        public Node(Object data)
        {
            this.data=data;
        }
    }
    Node Top=null;
    public Object pop()
    {
        Node temp=Top;
        Top=Top.next;
        temp.next=null;
        return temp.data;

    }
    public Object peek()throws Exception
    {
        return Top.data;
    }
    public void push(Object element)throws Exception {
        Node tempNode=new Node(element);
        if(Top==null)
        {
            Top=tempNode;
            tempNode.next=null;
        }
        else {
            tempNode.next=Top;
            Top=tempNode;
        }
    }
    public boolean isEmpty()
    {
        return (Top==null);
    }
}
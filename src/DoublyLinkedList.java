// package com.example.datastructures;
import java.util.Iterator;
public class DoublyLinkedList<T> implements Iterable<T>{
    Node head;
    Node tail;
    class Node{
        T data;
        Node prev;
        Node next;
        Node(T val){
            data = val;
            next = null;
            prev = null;
        }
    }
    DoublyLinkedList(){
        head = null;
        tail = null;
    }
    public void insertAtBeginning(T val){
        Node newNode = new Node(val);
        newNode.next = head;
        if(head==null){ //when list is empty
            tail = newNode;
        }
        else{ //list is not empty;
            head.prev = newNode;
        }
        head = newNode;
    }
    public void FindKey(T searchkey){
        Node temp = head; 
        if(head == null) {
            throw new IndexOutOfBoundsException("Search attempted in empty list");
        }
        while(temp != null) {
            if(temp.data == searchkey){
               System.out.println();
               System.out.println("search key found "+temp.data);
               return;
            }
            temp = temp.next;
        }
        System.out.println();
        System.out.println(searchkey+" search key not found");
    }
    public int countOfList(){
        Node temp = head;
        if(head == null) {
            return 0;
        }
        int count = 0;
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    public void displayrev(){
        Node temp = tail;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }
    }
    public void insertAtPos(int pos,T val){
        if(pos==0){
            insertAtBeginning(val);
            return;
        }
        Node newNode  = new Node(val);
        Node temp = head;
        for(int i=1;i<pos;i++){
            temp = temp.next;
            if(temp==null){
                throw new IndexOutOfBoundsException("Invalid position "+pos);
            }
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        if(temp==tail)
            tail = newNode;
        else
            temp.next.prev = newNode; 
            temp.next = newNode;
    }
    public void insertAtLast(T val){
        Node newNode = new Node(val);
        if(head==null){
            head = newNode;
            newNode.prev = null;
            return;
        }
        newNode.next = null;
    
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
            newNode.prev = temp;
        }
        temp.next = newNode;
        return;
    }
    public void deleteAtPos(int pos){
        if(head == null){
           throw new IndexOutOfBoundsException("deletion attempted in empty list"); 
        }
        if(pos ==0){
            head = head.next;
            if(head==null)
                tail=null;
            else
                head.prev = null;
            return;
        }
        Node temp = head;
        Node prev = null;
        for(int i=1;i<=pos;i++){
            prev = temp;
            temp = temp.next;
            if(temp == null)throw new IndexOutOfBoundsException("Invalid position"); 
        }
        prev.next = temp.next;
        if(temp.next==null)
            tail = prev;
        else    
            temp.next.prev = prev;
    }
    public void deleteAtBeginning(){
        if(head==null)  throw new IndexOutOfBoundsException();
        head = head.next;
        if(head==null)
                tail=null;
        else
            head.prev = null;
        return;
    }  
    public void deleteAtLast(){
        if(head == null){
            throw new IndexOutOfBoundsException("deletion attempted in empty list"); 
         }
        Node temp = head;
        Node prev = null;
        while(temp.next!=null){
            prev = temp;
            temp = temp.next;
        }
        prev.next=null;
        tail = prev;
    }
    public Iterator<T> iterator(){
        return new Iterator<T>() {
            Node temp = head;
            public boolean hasNext(){
                return temp!=null;
            }
            public T next() {
                T val = temp.data;
                temp = temp.next;
                return val;
            }
        };
    }
}
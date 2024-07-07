import java.util.*;
// import com.example.datastructures.DoublyLinkedList;
public class Demo {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        list.insertAtBeginning(9);
        list.insertAtBeginning(5);
        list.insertAtPos(2,10);
        list.insertAtLast(3);
        for(int a:list){
            System.out.print(a+" ");
           }
         list.deleteAtPos(5);
         System.out.println();
         for(int a:list){
             System.out.print(a+" ");
            }
        System.out.println();
        list.displayrev();
        //list.FindKey(7);
        //System.out.println("Count of the List is "+list.countOfList());
    }
}

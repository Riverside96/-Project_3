package graphalgos;
import java.util.Iterator;

import com.google.common.base.Predicate;

public class MyLinkedList<T> implements Iterable<T>{
    
    private int size;
    Node head;

    
  // class composition
    public class Node {
         Node(T d){
            data = d;
            next = null;
        }
    T data;
    Node next;

    public void setNextNode(Node node) {
        this.next = node;
    }

    public Node getNextNode() {
        return this.next;
    }
   }

public void removeIf(Predicate<T> predicate) {
    Node current = head;
    while (current != null) {
        if (predicate.test(current.data)) {
            deleteValue(current.data);
             current = current.next;
             size--;
        }
       
    }
}


public T get(int index) {
    if (index < 0 || index >= size) {
        throw new IndexOutOfBoundsException("Index out of bounds: " + index);
    }
    Node current = head;
    for (int i = 0; i < index; i++) {
        current = current.next;
    }
    return current.data;
}

public void addAtIndex(int index, T val) {
    if (index == 0) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    } else {
        Node prev = head;
        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }
        Node newNode = new Node(val);
        newNode.next = prev.next;
        prev.next = newNode;
    }
    size++;
}


  public boolean contains(T element) {
      Node current = head;
      while (current != null) {
          if (current.data.equals(element)) {
              return true;
          }
          current = current.next;
      }
      return false;
  }

    public T peek(){
      if (head == null){
      System.out.println("List is empty");
      return null;
    } else {
      return head.data;
    }
  }

    public T peekEnd(){
      if (head == null){
        System.out.println("list is empty");
        return null;
    } else {
      Node current = head;
      while (current.next != null) {
        current = current.next;
      }
      return current.data;
    }
      
  }


    public T pop(){
    if (head == null) {
      System.out.println("List is empty");
      return null;
    }
      T value = head.data;
      head = head.next;
      size--;
      return value;
  }

  public MyLinkedList<T> popEnd(){
       if (head == null) {
       System.out.println("List is empty");  
     }
      else{
        if (head.next == null){
          head = null;
          size--;
          
      } else {
        Node current = head;
        while (current.next.next != null){
          current = current.next;
        }
        current.next = null;
        size--;
      }
    }
      return this;
    
     
   }

    public MyLinkedList<T> push(T data){
      Node newNode = new Node(data);
      if (this.head == null) {
                this.head = newNode;
      } else {
        newNode.next = head;
        head = newNode;
    }
    size++;
    return this;
  }


    public MyLinkedList<T> pushEnd(T data)
    {
        // Instantiate node with argument
        Node newNode = new Node(data);
         
        // check for emptyness, set head if true
        if (this.head == null) {
            this.head = newNode;
        }
        else {
            // traverse the list & insert at the null position
            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        size++;
        return this;
    }

    public  MyLinkedList<T> deleteAt(int index)
    {
        // Store head node
        Node current = this.head, previous = null;
 
        // If index == 0, delete head & confirm deletion.
        if (index == 0 && current != null) {
            this.head = current.next; // Changed head
            size--;
            return this;
        }

        // if the index argument is less then the size size of LinkedList
        // then if at any point our counter = the argument, connect previous & next
        // then confirm deletion
        // else traverse & increment tracker
        int tracker = 0;
        while (current != null) {
            if (tracker== index) {
                previous.next = current.next;
                size--;
                break;
            }
            else {
                previous = current;
                current = current.next;
                tracker++;
            }
        }
        // if the end of the list is reached, the argument is out of bounds
        if (current == null) {
            System.out.println(index + " position element not found");
        }
        return this;
    }

    public MyLinkedList<T> deleteValue(T value)
    {
        Node current = this.head, previous = null;
        // check for emptyness. If the head contains the value, delete
        if (current != null && current.data == value) {
            this.head = current.next; 
            System.out.println(value + "has been deleted");
            size--;
            return this;
        }

        // else iterate until val is found or end(null) is reached
        while (current != null && current.data != value) {
            previous = current;
            current = current.next;
        }
        // if iteration stopped before the end, connect previous & next
        if (current != null) {
            previous.next = current.next;
            System.out.println(value + " has been deleted");
            size--;
        }
        
        // if end is reached, value does not exist. 
        if (current == null) {
            System.out.println("this list does not contain" + value);
        }
        return this;
    }



    public T removeHead() {
        Node removedHead = this.head;
        if (removedHead == null) {
          return null;
        }
        this.head = removedHead.getNextNode();
        size--;
        return removedHead.data;
    }
 
    public int getSize(){return size;}

    public void display()
    {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("\n");
    }


//============iterable implements================//
//
@Override
  public Iterator<T> iterator() {
    return new MyLinkedListIterator();
  }

  private class MyLinkedListIterator implements Iterator<T> {
    private Node current = head;

    @Override
    public boolean hasNext() {
      return current != null;
    }

    @Override
    public T next() {
      T data = current.data;
      current = current.next;
      return data;
    }
  }
}



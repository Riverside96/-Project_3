package graphalgos;

public class Queue<T> {



    public MyLinkedList<T> queue;
    public int size;
  
    public Queue() {
      this.queue = new MyLinkedList();
      this.size = 0;
    }
  
    public boolean isEmpty() {
      return this.size == 0;
    }
  
    public void enqueue(T data) {
      this.queue.pushEnd(data);
      this.size++;
    }
  
    public T peek() {
      if (this.isEmpty()) {
        return null;
      } else {
        return this.queue.head.data;
      }    
    }
  
    public T dequeue() {
      if (!this.isEmpty()) {
        T data = this.queue.removeHead();
        this.size--;
        return data;
      } else {
        throw new Error("This queue is empty");
      }
    }
  
  }

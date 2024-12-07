// Node class, contains value and pointer to next node in linked list.
public class Node<T> {
  private T value; // Node element value
  private Node<T> nextNode; // Next node pointer

  protected Node(T value, Node<T> nextNode) {
    this.value = value;
    this.nextNode = nextNode;
  }

  // Allow access to value
  protected T value() {
    return value;
  }

  // Allow access to next pointer
  protected Node<T> next() {
    return nextNode;
  }

  // Allow changing value of node
  protected void setValue(T value) {
    this.value = value;
  }

  // Allow altering next node pointer
  protected void setNext(Node<T> nextNode) {
    this.nextNode = nextNode;
  }
}
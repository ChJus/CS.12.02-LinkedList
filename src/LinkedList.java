public class LinkedList<T> {
  private int size = 0; // Store number of elements in linked list
  private Node<T> head; // Stores the pointer reference to the first node in LinkedList

  // Reference of methods to include and purpose:
  // https://www.w3schools.com/java/java_ref_linkedlist.asp
  public LinkedList() {
  }

  // Adds an element at specified index.
  public void add(int index, T element) {
    // Reject invalid index values (negative or larger than size)
    // Note that adding at index == size is equivalent to add()
    if (index > size || index < 0) return;

    // If we are handling adding to the start of the LinkedList,
    // we create a node for the element pointing to the original head node
    // and change the head pointer to point to this new node
    if (index == 0) {
      Node<T> newNode = new Node<>(element, head);
      head = newNode;
    } else {
      // Otherwise, we count until we reach index - 1 (to get the node
      // that will be before our new node.
      int counter = 0;
      Node<T> node = head;
      while (counter != index - 1) {
        node = node.next();
        counter++;
      }

      // Create our new node that points to original element at index
      Node<T> newNode = new Node<>(element, node.next());

      // Make node at previous index point to our newly inserted node
      node.setNext(newNode);
    }
    size++; // Increment size counter
  }

  // Adds an element to the end of the LinkedList
  public void add(T element) {
    // If there are no elements, create the first node
    if (size == 0) {
      head = new Node<>(element, null);
    } else {
      // Otherwise, create a new ending node and iterate
      // through our LinkedList until we reach the final node.
      // Then, we assign its pointer to point to our new last node
      Node<T> newNode = new Node<>(element, null);
      Node<T> currentNode = head;
      while (currentNode.next() != null) currentNode = currentNode.next();
      currentNode.setNext(newNode);
    }
    size++; // Increment size counter
  }

  // Returns whether linked list contains an element
  public boolean contains(T element) {
    // Iterate through the linked list and check whether
    // any nodes have a value that is equivalent to the specified argument.
    Node<T> currentNode = head;
    while (currentNode != null) {
      if (currentNode.value().equals(element)) return true;
      currentNode = currentNode.next();
    }
    return false;
  }

  // Returns element value at a given index
  public T get(int index) {
    // If the index is invalid, return null
    if (getNode(index) == null) return null;

    // Otherwise get value of node at that index
    return getNode(index).value();
  }

  // Returns node at specified index (helper method)
  private Node<T> getNode(int index) {
    int counter = 0;
    Node<T> currentNode = head;

    // Traverse linked list until we reach counter position
    while (counter != index) {
      // If the index is out of bounds, return null
      if (currentNode.next() == null) return null;

      currentNode = currentNode.next();
      counter++;
    }
    return currentNode;
  }

  // Returns index of element (if it exists)
  // Otherwise, returns -1.
  public int indexOf(T element) {
    Node<T> currentNode = head;
    int index = 0;

    // Traverse linked list and see if we can find the
    // position of the node with the corresponding element value.
    while (currentNode != null) {
      if (currentNode.value().equals(element)) return index;
      currentNode = currentNode.next();
      index++; // Keep record of index position we are checking
    }

    // Return -1 if it does not exist
    return -1;
  }

  // Removes element from LinkedList
  // If element does not exist, returns false; otherwise, true;
  public boolean remove(T element) {
    // Keep track of previous and current node.
    // This is useful as we want to remove current node, so we need to alter
    // the next node pointer reference in the previous node to point to
    // the next node for the current node.
    Node<T> previousNode = null;
    Node<T> currentNode = head;

    while (currentNode != null) {
      // If we find the element we are looking for, begin removal operation
      if (currentNode.value().equals(element)) {
        // If the element is not the first element, we relink pointer references
        if (previousNode != null) previousNode.setNext(currentNode.next());

          // Otherwise, simply make the head pointer point to the next node
        else head = head.next();

        // Decrement size counter and return true (removed node)
        size--;
        return true;
      }

      // Shift previous node and current node to next nodes.
      previousNode = currentNode;
      currentNode = currentNode.next();
    }
    // Did not remove element
    return false;
  }

  // Removes element at index
  public boolean remove(int index) {
    // Ensure index value is valid
    if (index >= 0 && index < size) {
      int counter = 0;

      // Process is similar to remove(T element), but we simply remove the element at a known index
      Node<T> previousNode = null;
      Node<T> currentNode = head;
      while (counter != index) {
        previousNode = currentNode;
        currentNode = currentNode.next();
        counter++;
      }

      // If index is 0, we simply alter head pointer
      if (previousNode == null) head = head.next();

        // Otherwise, we link previous node's pointer to current node
      else previousNode.setNext(currentNode.next());

      // decrement counter, return true (element removed)
      size--;
      return true;
    } else {
      return false;
    }
  }

  // Replaces an existing element value with a new element value
  public boolean replace(T oldElement, T newElement) {
    if (contains(oldElement)) {
      getNode(indexOf(oldElement)).setValue(newElement);
      return true;
    } else {
      return false;
    }
  }

  // Sets element value at position
  public void set(int index, T element) {
    if (index >= 0 && index < size) {
      getNode(index).setValue(element);
    }
  }

  // Returns linked list size
  public int size() {
    return size;
  }

  // Prints linked list in array format
  public void print() {
    Node<T> currentNode = head;
    System.out.print("{");
    do {
      System.out.print(currentNode.value());
      if (currentNode.next() != null) System.out.print(", ");
      else System.out.println("}");
      currentNode = currentNode.next();
    } while (currentNode != null);
  }
}

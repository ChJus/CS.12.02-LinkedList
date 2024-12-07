import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Main {
  /*
  Performs array-like operations on linked list, particularly, making use of
  indexOf, contains, add, remove, get, and print.
  */
  @Test
  void main() {
    // Start with bad list of alphabet
    String[] values = {"A", "B", "C", "E", "F", "G", "GG", "J", "K"};
    LinkedList<String> alphabet = new LinkedList<>();

    // Add all elements to linked list
    for (String value : values) {
      alphabet.add(value);
    }

    // Ensure elements are added properly
    for (int i = 0; i < values.length; i++) {
      assertTrue(alphabet.contains(values[i]));
      assertEquals(values[i], alphabet.get(i));
    }

    // Check and work with contains() method
    assertFalse(alphabet.contains("L"));
    assertFalse(alphabet.contains("M"));

    // Remove element and check to see it was removed
    alphabet.remove(6);
    assertFalse(alphabet.contains("GG"));

    // Add elements to specific indices
    alphabet.add(3, "D");
    alphabet.add(7, "I");
    alphabet.add(7, "H");

    // Remove element by value
    alphabet.remove("K");

    // Debug printing information
    alphabet.print();

    // Check to see linked list matches the desired output array
    values = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
    for (int i = 0; i < values.length; i++) {
      assertTrue(alphabet.contains(values[i]));
      assertEquals(i, alphabet.indexOf(values[i]));
      assertEquals(values[i], alphabet.get(i));
    }
  }
}
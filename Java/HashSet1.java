import java.util.*;

class HashSet1 {
  public static void main(String args[]) {
    // Creating HashSet and adding elements
    // HashSet<String> set = new HashSet<>();
    // set.add("One");
    // set.add("Two");
    // set.add("Three");
    // set.add("Four");
    // set.add("Five");
    PriorityQueue<Integer> set = new PriorityQueue<>();
    set.add(10);
    set.add(1);
    set.add(3);
    set.add(35);
    set.add(2);
    // Iterator<Integer> i = set.iterator();
    // while (i.hasNext()) {
    // System.out.println(i.next());
    // }
    System.out.println(set);
  }
}
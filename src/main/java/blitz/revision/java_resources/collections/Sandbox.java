package blitz.revision.java_resources.collections;

import java.util.*;

public class Sandbox {

  public static void main(String[] args) {
    System.out.println("===collections===");
    System.out.println("ArrayList");
    List<Integer> list = new ArrayList<>();
    for (int i=0; i<5; i++) {
      list.add(i);
    }
    System.out.println(list);

    System.out.println("===Maps===");
    Map<String, Integer> map = new HashMap<>();
    for (int i=10; i>0; i--) {
      String val = "VAL-" + i;
      map.put(val, i);
    }
    System.out.println("HASH-MAP: " + map);
    
    map = new TreeMap<>();
    for (int i=10; i>0; i--) {
      String val = "VAL-" + i;
      map.put(val, i);
    }
    System.out.println("TREE-MAP: " + map);
    
    map = new TreeMap<>(Collections.reverseOrder());
    for (int i=10; i>0; i--) {
      String val = "VAL-" + i;
      map.put(val, i);
    }
    System.out.println("TREE-MAP: " + map);
  }
}


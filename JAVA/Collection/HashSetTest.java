import java.util.*;

public class HashSetTest {
	public static void main(String[] args) {
     Set<String> set = new HashSet<String>();
     
     set.add("one");
     set.add("two");
     set.add("three");
     set.add("four");
     System.out.println(set.add(new String("one")));
     
     System.out.println(set.size());
     System.out.println(set.contains("four"));
     System.out.println(set.contains("one"));
     System.out.println(set.contains(new String("one")));
     
     set.remove("four");
     set.remove(new String("one"));
     System.out.println(set.size());
     set.clear();
     System.out.println(set.size());
   }
}

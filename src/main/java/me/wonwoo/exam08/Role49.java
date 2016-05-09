package me.wonwoo.exam08;

import java.util.Comparator;

/**
 * Created by wonwoo on 2016. 5. 9..
 */
public class Role49 {

  private static final Comparator<Integer> naturalOrder = new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
      return o1 < o2 ? -1 : (o1 == o2 ? 0 : 1);
    }
  };
  private static final Comparator<Integer> naturalOrder1 = new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
      int f = o1;
      int s = o2;
      return f < s ? -1 : (f == s ? 0 : 1);
    }
  };
  static int i;

  public static void main(String[] args) {
    int compare = naturalOrder.compare(new Integer(42), new Integer(42));
    System.out.println(compare);

    int compare1 = naturalOrder1.compare(new Integer(42), new Integer(42));
    System.out.println(compare1);

    if (i == 42) {
      System.out.println("Unbelievable");
    }
  }
}

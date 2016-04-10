package me.wonwoo.exam03;

import java.awt.*;

/**
 * Created by wonwoo on 2016. 4. 9..
 */
public class Role08 {
  public static void main(String[] args) {

    System.out.println("============ 대칭성 ===============");
    //대칭성
    CaseInsensitiveString caseInsensitiveString = new CaseInsensitiveString("Polish");
    String s = "polish";
    System.out.println(s.equals(caseInsensitiveString));
    System.out.println(caseInsensitiveString.equals(s));

//    List<CaseInsensitiveString> list = new ArrayList<>();
//    list.add(caseInsensitiveString);
//    System.out.println(list.contains(s));

    System.out.println("============ 추이성 ===============");
    //추이성
Point point = new Point(1, 2);
ColorPoint colorPoint = new ColorPoint(1, 2, Color.RED);
ColorPoint colorPoint1 = new ColorPoint(1, 2, Color.black);
System.out.println(point.equals(colorPoint));
System.out.println(colorPoint.equals(point));
System.out.println(colorPoint.equals(colorPoint1));

  }
}

//대칭성
final class CaseInsensitiveString {
  private final String s;

  public CaseInsensitiveString(String s) {
    if (s == null) {
      throw new NullPointerException();
    }
    this.s = s;
  }

  @Override
  public boolean equals(Object o) {
    return o instanceof CaseInsensitiveString && ((CaseInsensitiveString) o).s.equalsIgnoreCase(s);
  }

//  @Override
//  public boolean equals(Object o){
//    if(o instanceof CaseInsensitiveString){
//      return s.equalsIgnoreCase(((CaseInsensitiveString)o).s);
//    }
//    if(o instanceof String){
//      return s.equalsIgnoreCase((String) o);
//    }
//    return false;
//  }
}

class Point {
  private final int x;
  private final int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof Point)) {
      return false;
    }
    Point that = (Point) o;
    return that.x == this.x && that.y == y;
  }
}

class ColorPoint extends Point {
  private final Color color;

  public ColorPoint(int x, int y, Color color) {
    super(x, y);
    this.color = color;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof ColorPoint)) {
      return false;
    }
    return super.equals(o) && ((ColorPoint) o).color == color;
  }
//  @Override
//  public boolean equals(Object o) {
//    if (!(o instanceof Point)) {
//      return false;
//    }
//    if (!(o instanceof ColorPoint)) {
//      return o.equals(this);
//    }
//    return super.equals(o) && ((ColorPoint) o).color == color;
//  }
}
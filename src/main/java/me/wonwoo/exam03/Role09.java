package me.wonwoo.exam03;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wonwoo on 2016. 4. 10..
 */
public class Role09 {
  public static void main(String[] args) {

    Map<PhoneNumber, String> m = new HashMap<>();
    m.put(new PhoneNumber(707, 867, 5309), "Jenny");

    String s = m.get(new PhoneNumber(707, 867, 5309));
    System.out.println(s);
  }
}

final class PhoneNumber {
  private final short areaCode;
  private final short prefix;
  private final short lineNumber;

  public PhoneNumber(int areaCode, int prefix, int lineNumber) {
    rangeCheck(areaCode, 999, "area code");
    rangeCheck(prefix, 999, "prefix");
    rangeCheck(lineNumber, 9999, "line number");
    this.areaCode = (short) areaCode;
    this.prefix = (short) prefix;
    this.lineNumber = (short) lineNumber;
  }

  private static void rangeCheck(int arg, int max, String name) {
    if (arg < 0 || arg > max) {
      throw new IllegalArgumentException(name + ":" + arg);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof PhoneNumber)) {
      return false;
    }
    PhoneNumber pn = (PhoneNumber) o;
    return pn.lineNumber == lineNumber && pn.prefix == prefix && pn.areaCode == areaCode;
  }

  @Override
  public int hashCode() {
    int result = 17;
    result = 31 * result + areaCode;
    result = 31 * result + prefix;
    result = 31 * result + lineNumber;
    return result;
  }
//  이렇게 하지 말자!
//  @Override
//  public int hashCode() {
//    return 42;
//  }
}

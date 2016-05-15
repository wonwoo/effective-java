package me.wonwoo.exam06;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by wonwoo on 2016. 5. 15..
 */
public class Role34 {
  public static void main(String[] args) {
    test(ExtendedOperration.class, 20, 14);
    test1(Arrays.asList(ExtendedOperration.values()), 20, 14);
  }

  private static void test1(Collection<? extends Operation> opSet, double x, double y) {
    for (Operation op : opSet) {
      System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
  }

  private static <T extends Enum<T> & Operation> void test(Class<T> opSet, double x, double y) {
    for (Operation op : opSet.getEnumConstants()) {
      System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
    }
  }
}

enum ExtendedOperration implements Operation {
  EXP("^") {
    public double apply(double x, double y) {
      return Math.pow(x, y);
    }
  },
  REMAINDER("%") {
    public double apply(double x, double y) {
      return x % y;
    }
  };
  private final String s;

  ExtendedOperration(String s) {
    this.s = s;
  }

  @Override
  public String toString() {
    return s;
  }
}

enum BasicOperation implements Operation {
  EXP("^") {
    public double apply(double x, double y) {
      return Math.pow(x, y);
    }
  },
  REMAINDER("%") {
    public double apply(double x, double y) {
      return x % y;
    }
  },

  PLUS("+") {
    public double apply(double x, double y) {
      return x + y;
    }
  },
  MINUS("-") {
    public double apply(double x, double y) {
      return x - y;
    }
  },
  TIMES("*") {
    public double apply(double x, double y) {
      return x * y;
    }
  },
  DIVIDE("/") {
    public double apply(double x, double y) {
      return x / y;
    }
  };

  private final String s;

  BasicOperation(String s) {
    this.s = s;
  }

  @Override
  public String toString() {
    return s;
  }
}

interface Operation {
  double apply(double x, double y);
}

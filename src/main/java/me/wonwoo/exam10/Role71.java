package me.wonwoo.exam10;

import java.io.*;
import java.util.function.Function;


/**
 * Created by wonwoo on 2016. 4. 20..
 */
public class Role71 {
  //객체 필드를 일반적으로 초기화하는 방법
  private static final FieldType field = new FieldType();

  //동기화 된 접근자를 사용한 객체 필드 초기화 지연방법
  private FieldType fieldType;

  synchronized FieldType getField() {
    if (fieldType == null) {
      fieldType = new FieldType();
    }
    return fieldType;
  }

  //정적 필드에 대한 초기화 지연 담당 클래스
  private static class FieldHolder {
    static final FieldType field = new FieldType();
  }

  static FieldType getFieldType() {
    return field;
  }

  private volatile FieldType field1;

  FieldType getField1() {
    FieldType result = field1;
    if (result == null) {
      synchronized (this) {
        result = field1;
        if (result == null) {
          field1 = result = new FieldType();
        }
      }
    }
    return result;
  }



  public static void main(String[] args) {

    FieldType fieldType = Role71.getFieldType();

    try (FileOutputStream fos = new FileOutputStream("/Users/wonwoo/test/s.ser"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
      oos.writeObject(fieldType);
    } catch (Exception e) {
    }

    try (FileInputStream fis = new FileInputStream("/Users/wonwoo/test/s.ser"); ObjectInputStream ois = new ObjectInputStream(fis)) {
      FieldType obj = (FieldType) ois.readObject();
      System.out.println(fieldType == obj);
    } catch (Exception e) {
    }


//    Singleton fieldType = Singleton.getInstance();
//
//    try (FileOutputStream fos = new FileOutputStream("/Users/wonwoo/test/s.ser"); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
//      oos.writeObject(fieldType);
//    } catch (Exception e) {
//    }
//
//    try (FileInputStream fis = new FileInputStream("/Users/wonwoo/test/s.ser"); ObjectInputStream ois = new ObjectInputStream(fis)) {
//      Singleton obj = (Singleton) ois.readObject();
//      System.out.println(fieldType == obj);
//    } catch (Exception e) {
//    }
  }

}

enum Singleton {
  INSTANCE;

  public static Singleton getInstance() {
    return INSTANCE;
  }
}

class FieldType implements Serializable{

}
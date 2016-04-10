package me.wonwoo.exam02;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by wonwoo on 2016. 4. 9..
 */
public class Role05 {
  public static void main(String[] args) {
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    calendar.set(1951, Calendar.MONTH,21,8,1,10);

    OldPerson oldPerson = new OldPerson(calendar.getTime());
    NewPerson newPerson = new NewPerson(calendar.getTime());
    System.out.println(oldPerson.isBabyBoomer());
    System.out.println(newPerson.isBabyBoomer());

  }
}

class OldPerson{
  private final Date birthDate;

  public OldPerson(Date birthDate){
    this.birthDate = birthDate;
  }

  public boolean isBabyBoomer(){
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    calendar.set(1946, Calendar.JANUARY,1,0,0,0);
    Date boomStart = calendar.getTime();
    calendar.set(1965, Calendar.JANUARY,1,0,0,0);
    Date boomEnd = calendar.getTime();
    return birthDate.compareTo(boomStart) >= 0 && birthDate.compareTo(boomEnd) < 0;
  }
}

class NewPerson{
  private final Date birthDate;
  public static final Date BOOM_START;
  public static final Date BOOM_END;

  public NewPerson(Date birthDate){
    this.birthDate = birthDate;
  }

  static{
    Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
    calendar.set(1946, Calendar.JANUARY,1,0,0,0);
    BOOM_START = calendar.getTime();
    calendar.set(1965, Calendar.JANUARY,1,0,0,0);
    BOOM_END = calendar.getTime();
  }

  public boolean isBabyBoomer(){
    return birthDate.compareTo(BOOM_START) >= 0 && birthDate.compareTo(BOOM_END) < 0;
  }
}
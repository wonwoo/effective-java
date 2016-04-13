package me.wonwoo.exam04;

import java.util.*;

/**
 * Created by wonwoo on 2016. 4. 13..
 */
public class Role16 {
  public static void main(String[] args) {
    InstrumentedHashSet<String> s = new InstrumentedHashSet<>();
    s.addAll(Arrays.asList("Snap","Crackle","Pop"));
    System.out.println(s.getAddCount());

    Set<String> tmp = new HashSet<>();
    InstrumentedSet<String> s1 = new InstrumentedSet<>(tmp);
    s1.addAll(Arrays.asList("Snap","Crackle","Pop"));
    System.out.println(s1.getAddCount());
  }
}


class InstrumentedSet<E> extends ForwardingSet<E>{

  private int addCount = 0;

  public InstrumentedSet(Set<E> s) {
    super(s);

  }

  @Override
  public boolean add(E e){
    addCount++;
    return super.add(e);
  }

  @Override
  public boolean addAll(Collection<? extends E> c){
    addCount += c.size();
    return super.addAll(c);
  }

  public int getAddCount(){
    return addCount;
  }
}

class ForwardingSet<E> implements Set<E> {

  private final Set<E> s;

  public ForwardingSet(Set<E> s){
    this.s = s;
  }

  @Override
  public int size() {
    return s.size();
  }

  @Override
  public boolean isEmpty() {
    return s.isEmpty();
  }

  @Override
  public boolean contains(Object o) {
    return s.contains(o);
  }

  @Override
  public Iterator<E> iterator() {
    return s.iterator();
  }

  @Override
  public Object[] toArray() {
    return s.toArray();
  }

  @Override
  public <T> T[] toArray(T[] a) {
    return s.toArray(a);
  }

  @Override
  public boolean add(E e) {
    return s.add(e);
  }

  @Override
  public boolean remove(Object o) {
    return s.remove(o);
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    return s.containsAll(c);
  }

  @Override
  public boolean addAll(Collection<? extends E> c) {
    return s.addAll(c);
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    return s.retainAll(c);
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    return s.retainAll(c);
  }

  @Override
  public void clear() {
    s.clear();
  }
}



//계승
class InstrumentedHashSet<E> extends HashSet<E> {
  //요소를 삽입하려 한 횟수
  private int addCount = 0;

  public InstrumentedHashSet(){
  }

  public InstrumentedHashSet(int initCap, float loadFactor){
    super(initCap,loadFactor);
  }

  @Override
  public boolean add(E e){
    addCount++;
    return super.add(e);
  }

  @Override
  public boolean addAll(Collection<? extends E> c){
    addCount += c.size();
    return super.addAll(c);
  }

  public int getAddCount(){
    return addCount;
  }
}

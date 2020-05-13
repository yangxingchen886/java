package club.banyuan;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayList implements List {
  private int size;
  private int addCount;
  private int capability = 8;
  private Object[] array;


  @Override
  public Object set(int index, Object element) {
    if (index >= size) {
      System.out.println("下标不合法");
      return null;
    }
    Object temp = array[index];
    array[index] = element;
    return temp;
  }

  @Override
  public Object get(int index) {
    if (index >= size) {
      System.out.println("下标不合法");
      return null;
    }
    return array[index];
  }

  @Override
  public void clear() {
    for(int i = 0; i < size; i++){
      array[i] = null;
    }
    size = 0;
  }

  @Override
  public Object remove(int index) {
    if (index >= size) {
      System.out.println("下标不合法");
      return null;
    }
    Object temp = array[index];
    System.arraycopy(array, index + 1, array, index, size - index);
    size--;
    return temp;
  }

  @Override
  public boolean remove(Object o) {
    int mark = 0;//用来标记是否找到过，找到过标记为1
    for(int i = 0; i < size; i++){
      if(array[i] == o){
        int index = i;
        System.arraycopy(array, index + 1, array, index, size - index);
        size--;
        i--;
        mark = 1;
      }
    }
    return mark == 1;
  }

  @Override
  public boolean add(Object o) {
    if(addCount == 0){//表示从未进行过add操作
      Object[] ob = new Object[capability];
      array = ob;
      array[0] = o;
      addCount++;
      size++;
      return true;
    }else if(array[array.length -1] == null){
      int index = 0;
      while(array[index] != null){
        index++;
      }
      array[index] = o;
      size++;
      addCount++;
      return true;
    }else{//此时表示数组已经满了
      Object[] array1 = array;
      capability = capability << 1;//扩容两倍
      array = Arrays.copyOf(array1, capability);
      int index = 0;
      while(array[index] != null){
        index++;
      }
      array[index] = o;
      size++;
      addCount++;
      return true;
    }
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public int size() {

    return size;
  }
}

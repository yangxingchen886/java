package club.banyuan;

import club.banyuan.collection.ArrayList;
import club.banyuan.collection.List;
import club.banyuan.util.Iterator;

public class HashMap implements Map {

  public static final int INIT_LENGTH = 20;
  private final List[] listArr = new List[INIT_LENGTH];
  private int size;

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean containsKey(Object key) {
    if (key == null) {
      return false;
    }

    int hashCode = key.hashCode();
    List list = listArr[hashCode % INIT_LENGTH];
    if (list == null) {//找出的list为空，说明没有key放到这儿，说明没有放过
      return false;
    }
    //走到这儿说明找到了对应的list,且list不为空
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      Entry entry = (Entry) iterator.next();
      if (entry.getKey().equals(key)) {
        return true;
      }
    }
    //走到这儿说明即使list不为空，里面也没有要找的key
    return false;
  }

  @Override
  public boolean containsValue(Object value) {
    for(int i = 0; i < INIT_LENGTH; i++){
      List list = listArr[i];
      if(list == null){
        continue;
      }
      Iterator iterator = list.iterator();
      while (iterator.hasNext()) {
        Entry entry = (Entry) iterator.next();
        if (entry.getValue().equals(value)) {
          return true;
        }
      }
    }
    return false;
  }

  @Override
  public Object get(Object key) {
    if (key == null) {//要单独讨论，不然不能调用hashCode()方法
      return null;
    }

    int hashCode = key.hashCode();
    List list = listArr[hashCode % INIT_LENGTH];
    if (list == null) {//找出的list为空，说明没有key放到这儿，说明没有放过
      return null;
    }
    //走到这儿说明找到了对应的list,且list不为空
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      Entry entry = (Entry) iterator.next();
      if (entry.getKey().equals(key)) {
        return entry.getValue();
      }
    }
    //走到这儿说明即使list不为空，里面也没有要找的key
    return null;
  }

  @Override
  public Object put(Object key, Object value) {
    if (key == null) {
      return null;
    }

    int hashCode = key.hashCode();
    List list = listArr[hashCode % INIT_LENGTH];
    if (list == null) {
      list = new ArrayList();
      listArr[hashCode % INIT_LENGTH] = list;
    }
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {//此循环是找此hashcode对应的list中每个entry元素中的key是否与传入的key相同，相同就要覆盖掉这个entry中的value
      Entry entry = (Entry) iterator.next();
      if (entry.getKey().equals(key)) {
        entry.setValue(value);
        return value;
      }
    }
    //走到这一步说明list中没有哪个entry的key与传入的key相同
    list.add(new Entry(key, value));
    size++;
    return value;
  }

  @Override
  public Object remove(Object key) {
    if(!containsKey(key)){
      System.out.println("输入非法");
      return null;
    }
    int hashCode = key.hashCode();
    List list = listArr[hashCode % INIT_LENGTH];
    Iterator iterator = list.iterator();
    while (iterator.hasNext()) {
      Entry entry = (Entry) iterator.next();
      if (entry.getKey().equals(key)) {
        Object obj = entry.getValue();
        list.remove(entry);
        size--;
        return obj;
      }
    }
    return null;//其实走不到这一步就已经return了
  }
}

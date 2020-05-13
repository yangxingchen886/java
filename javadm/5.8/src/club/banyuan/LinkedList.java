package club.banyuan;

public class LinkedList implements List {

  private Node head = new Node();
  private Node tail = head;
  private int size;

  @Override
  public Object set(int index, Object element) {
    if (index >= size) {
      System.out.println("下标不合法");
      return null;
    }
    int count = index;
    Node cur = head;
    while (count != -1) {
      cur = cur.getNext();
      count--;
    }
    Object o = cur.getData();
    cur.setData(element);
    return o;
  }

  @Override
  public Object get(int index) {
    if (index >= size) {
      System.out.println("下标不合法");
      return null;
    }
    int count = index;
    Node cur = head;
    while (count != -1) {
      cur = cur.getNext();
      count--;
    }
    return cur.getData();
  }

  @Override
  public void clear() {
    head.setNext(null);
    tail = head;
    size = 0;
  }

  @Override
  public Object remove(int index) {
    if (index >= size) {
      System.out.println("下标不合法");
      return null;
    }
    int count = index;
    Node cur = head;
    while (count != -1) {
      cur = cur.getNext();
      count--;
    }
    Object o = cur.getData();
    if(cur != tail){
      cur.getPrev().setNext(cur.getNext());
      cur.getNext().setPrev(cur.getPrev());
      size--;
    }else {
      cur.getPrev().setNext(null);
      tail = cur.getPrev();
      size--;
    }
    return o;
  }

  @Override
  public boolean remove(Object o) {
    int mark = 0;//用来标记是否找到过，找到过标记为1
    while (true) {
      Node cur = head;
      while (cur.getData() != o && cur != tail) {
        cur = cur.getNext();
      }
      if (cur != tail) {
        cur.getPrev().setNext(cur.getNext());
        cur.getNext().setPrev(cur.getPrev());
        size--;
        mark = 1;//一旦找到了o,mark赋值1
      }//此时cur == tail
      else if (cur.getData() == o) {
        cur.getPrev().setNext(null);
        tail = cur.getPrev();
        size--;
        mark = 1;
      }//此时cur == tail但cur.getData() != o
      else if (cur.getData() != o && mark == 0) {
        return false;
      } else {//走到这儿说明cur == tail且cur没有要找的内容，且之前已经删除过了，此时已经没有要删的了，返回true
        return true;
      }
    }
  }

  @Override
  public boolean add(Object o) {
    Node node = new Node();
    node.setData(o);
    node.setPrev(tail);
    tail.setNext(node);
    tail = node;
    size++;
    return true;
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

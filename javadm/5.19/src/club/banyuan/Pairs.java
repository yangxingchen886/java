package club.banyuan;

import java.util.Iterator;

public class Pairs<K, V> implements Iterable<Pair<K, V>> {

  /* 声明一对对象的固定大小的数组（最多10个元素） */
  final int FINAL_LENGTH = 10;
  @SuppressWarnings("unchecked")
  Pair<K,V>[] pairsArray = new Pair[FINAL_LENGTH];
  int size = 0;
  /**
   * 创建一个集合，该集合将存储成对添加的项目。
   */

  public Pairs() {
  }

  /**
   * 创建一个新的对，并在有空间的情况下将其添加到集合中。
   *
   * @param first  The first object.
   * @param second The second object.
   */
  public boolean addPair(K first, V second) {
    if(size == FINAL_LENGTH){
      return false;
    }
    pairsArray[size] = new Pair<K,V>(first,second);
    size++;
    return true;
  }


  @Override
  public Iterator<Pair<K, V>> iterator() {
    return new PairIterator();
  }

  /*
   * 根据以下位置的API文档在此处实现迭代器
   * https://docs.oracle.com/javase/10/docs/api/java/util/Iterator.html
   * 按照规定抛出异常
   */
  private class PairIterator implements Iterator<Pair<K,V>> {

    int pos;//下一个取的元素的下标



    @Override
    public boolean hasNext() {
      return pos != size;
    }

    /**
     * 返回迭代器中的下一个对象
     */
    @Override
    public Pair<K, V> next() {
      if(pos >= size){
        throw new UnsupportedOperationException();
      }
      return pairsArray[pos++];
    }

    /**
     * 从集合中移除next（）返回的上一个对象。
     */
    @Override
    public void remove() {
      int lastPos = pos -1;//上一个已经取过的元素的下标
      if(lastPos < 0){
        throw new UnsupportedOperationException();
      }

      System.arraycopy(pairsArray,pos,pairsArray,lastPos,size - pos);
      pairsArray[size - 1] = null;
      size--;
      pos--;
    }
  }
}
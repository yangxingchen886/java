package club.banyuan;

public class StringMeasurer implements Measurer{
    @Override
    public double measure(Object anObject) {
        return ((String)anObject).length();
    }
    // TODO: 创建实现Measurer接口的StringMeasurer类。提示：measure（）应该返回字符串的长度。

}
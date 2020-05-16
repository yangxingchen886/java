#### 1.
```
class Main {
   public static void main(String args[]) {
      try {
         throw 10;//throw 后只能加 Throwable的子类对象
      }
      catch(int e) {//catch()括号中必须加Throwable 子类类型变量
         System.out.println("Got the  Exception " + e);
      }
  }
}
```

#### 2.
```
class Test extends Exception { }
  
class Main {
   public static void main(String args[]) { 
      try {
         throw new Test();
      }
      catch(Test t) {
         System.out.println("Got the Test Exception");
      }
      finally {
         System.out.println("Inside finally block ");
         //Got the Test Exception
         //Inside finally block

      }
  }
}
```
#### 3.
```
class Main {
   public static void main(String args[]) {
      int x = 0;
      int y = 10;
      int z = y/x;
  }//Exception in thread "main" java.lang.ArithmeticException: / by zero
  	//at Main.main(TTT.java:5)
}
```
#### 4.
```
class Base extends Exception {}
class Derived extends Base  {}
 
public class Main {
  public static void main(String args[]) {
   // some other stuff
   try {
       // Some monitored code
       throw new Derived();
    }
    catch(Base b)     { 
       System.out.println("Caught base class exception"); 
    }
    catch(Derived d)  { 
       System.out.println("Caught derived class exception"); //会报错，new Derived()异常已经在上一步catch(Base b)中捕获了
    }
  }
} 
```
#### 5.
```
class Test
{
    public static void main (String[] args)
    {
        try
        {
            int a = 0;
            System.out.println ("a = " + a);
            int b = 20 / a;
            System.out.println ("b = " + b);
        }
 
        catch(ArithmeticException e)
        {
            System.out.println ("Divide by zero error");
        }
 
        finally
        {
            System.out.println ("inside the finally block");
            //a = 0
  			//Divide by zero error
  			//inside the finally block
        }
    }
}
```
#### 6.
```
class Test
{
    public static void main(String[] args)
    {
        try
        {
            int a[]= {1, 2, 3, 4};
            for (int i = 1; i <= 4; i++)
            {
                System.out.println ("a[" + i + "]=" + a[i] + "n");
            }
        }
         
        catch (Exception e)
        {
            System.out.println ("error = " + e);
        }
         
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println ("ArrayIndexOutOfBoundsException");//报错：异常已经在上一步被捕获了
        }
    }
}
```
#### 7.
```
class Test
{
    String str = "a";//第二步
 
    void A()
    {
        try
        {
            str +="b";//第三步
            B();
        }
        catch (Exception e)
        {
            str += "c";//第七步
        }
    }
 
    void B() throws Exception
    {
        try
        {
            str += "d";//第四步
            C();
        }
        catch(Exception e)
        {
            throw new Exception();//因为在catch语句中又抛出了新的异常，只会接着执行下面的finally，但try,catch整体后的不会继续执行
        }
        finally
        {
            str += "e";//第六步
        }
 
        str += "f";
 
    }
     
    void C() throws Exception
    {
        throw new Exception();//第五步
    }
 
    void display()
    {
        System.out.println(str);
    }
 
    public static void main(String[] args)
    {
        Test object = new Test();
        object.A();//第一步
        object.display();
    }
 
}

```
#### 8.
```
//5

class Test
{   int count = 0;
 
    void A() throws Exception
    {
        try
        {
            count++;
             
            try
            {
                count++;
 
                try
                {
                    count++;
                    throw new Exception();
 
                }
                 
                catch(Exception ex)
                {
                    count++;
                    throw new Exception();
                }
            }
             
            catch(Exception ex)
            {
                count++;
            }
        }
         
        catch(Exception ex)
        {
            count++;
        }
 
    }
 
    void display()
    {
        System.out.println(count);
    }
 
    public static void main(String[] args) throws Exception
    {
        Test obj = new Test();
        obj.A();
        obj.display();
    }
}
```

#### 9.方法返回值是
```
public int myMethod(){

  try {

  return 1;//直接返回了

  }

  Catch (Exception e){

  return 2;

  }

  finally{

  return 3;

 }

}
```
#### 10.

```
 try {

      File file = new File("filename.txt");

      Scanner sc = new Scanner(file);

      throw new IOException();
    }

    catch (FileNotFoundException e) {

      System.out.println("FileNotFoundException called!!!");

    }

    catch (IOException e) {

      System.out.println("IOException called!!!");

    } 

```
#### 11.

```
try {

      File file = new File("filename.txt");

      Scanner sc = new Scanner(file);

      throw new IOException();
    }

    catch (IOException e) {

      System.out.println("IOException called!!!");

    } 
```

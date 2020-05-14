### 写出以下程序的输出结果

#### 1. 以下代码能否通过编译，为什么
```
class Outer{
 public static void main(String[] args){
  new Inner(); //编译报错，不允许直接new内部类，需要先new 外部类对象再new内部类对象，之后再调用内部类定义的方法
 } 
 class Inner { 
  Inner() {} 
 }  
}
```
#### 2. 以下代码能否通过编译，为什么
```
static class Outer{//编译报错，外部类静态时里面所有内容都要是静态的
 public static void main(String[] args){
 //
 }
 private class Inner{
  Inner() {} 
 }
}
```

#### 3.
```
//Java
Certification
Exam

class Outer {
 String s1 = "Java";
 String s2 = "2";

 public static void main(String[] args) { 
  Outer outer = new Outer();  
 }
 Outer() { 
  Inner inner = new Inner();  
 }
 class Inner {
  String s1 = "Certification";
  String s2 = "Exam";
        
  Inner() {
   System.out.println(Outer.this.s1);
   System.out.println(this.s1);
   System.out.println(s2);
  }
 }
}
```
#### 4. 以下代码能否通过编译，为什么
```
class A
{
    class B
    {
        static void methodB()//编译报错，内部类中不能有静态变量和方法，
//因为静态变量不用new对象就能调用，程序不能判断new完外部类对象，创建外部类区域后要不要继续创建内部类区域
        {
            System.out.println("Method B");
        }
    }
}
```
#### 5.
```
//Java
  Certification
  Exam


class OuterInnerStatic {
 static String s1 = "Java"; 
 static String s2 = "2";
 public static void main(String[] args) { 
  Inner inner = new Inner();  
}

 static class Inner {
  String s1 = "Certification";
  String s2 = "Exam";
  Inner() {
   System.out.println(OuterInnerStatic.s1);
   System.out.println(this.s1);
   System.out.println(s2);
  }
 }
}

```
#### 6.
```
class X
{
    static int x = 3131;
     
    static class Y
    {
        static int y = x++;//返回的是++之前的值
         
        static class Z
        {
            static int z = y++;
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        System.out.println(X.x);//3131
         
        System.out.println(X.Y.y);//3131
         
        System.out.println(X.Y.Z.z);//3131
    }
}
```

#### 7. 在下面的示例中，如何访问"XYZ"类的"i"字段？
```
//new ABC().new XYZ().i

class ABC
{
    class XYZ
    {
        int i = 111;
    }
}
```

#### 8. 运行以下程序时，它是否在控制台上打印“SUCCESS”？
```
class A
{
    {
        new B();
    }
     
    static class B
    {
        {
            new A().new C();//第二步；此处会造成死循环
        }
    }
     
    class C
    {
        {
            System.out.println("SUCCESS");
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        new A();//第一步
    }
}
```

#### 9. 以下代码能否通过编译，为什么
```
class A
{
    String s = "AAA";
     
    void methodA()
    {
        System.out.println(s);
    }
     
    static class B
    {
        void methodB()
        {
            methodA();//编译报错，类是静态的，加载类A的时候就能先加载出来，methodA()要在加载静态类之后才会加载，
//
        }
    }
}
```

#### 10.
```
//2
  1
abstract class A
{
    {
        System.out.println(1);
    }
     
    static
    {
        System.out.println(2);
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        A a = new A() { };
    }
}
```
#### 11.
```
//AAA
  BBB
  BBB

class A
{
    static String s = "AAA";
     
    class B
    {
        String s = "BBB";
         
        void methodB()
        {
            System.out.println(s);
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        A a = new A();
         
        System.out.println(a.s);
         
        A.B b = a.new B();
         
        System.out.println(b.s);
         
        b.methodB();
    }
}
```

#### 12. 以下代码能否通过编译，为什么
```
//需要先new 外部类对象再new内部类对象，之后再调用内部类定义的方法
class A
{
    void methodOne()
    {
        class B
        {
            void methodTwo()
            {
                System.out.println("Method Two");
            }
        }
    }
     
    void methodThree()
    {
        new B().methodTwo();
    }
}
```

#### 13
```
class X
{
    {
        System.out.println(1);
    }
     
    static
    {
        System.out.println(2);
    }
     
    public X()
    {
        new Y();
    }
     
    static class Y
    {
        {
            System.out.println(3);
        }
         
        static
        {
            System.out.println(4);
//此处因为内部类是静态的，程序加载外部类时就会加载内部类，所以不用考虑啥时候加载内部类方法的问题，
//加载类内部类，内部类的静态方法就已经加载类
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        X x = new X();//2 1 4 3 
         
        X.Y y = new X.Y();//3
    }
}
```

#### 14. 以下代码能否通过编译，为什么
```
class A
{
    class B
    {
        {
            System.out.println(1);
        }
         
        static//编译报错，内部类中不能有静态方法
        {
            System.out.println(2);
        }
    }
}
```

#### 15.
```
class ABC
{
    int i = 10101;
     
    {
        i--;
    }
     
    public ABC()
    {
        --i;
    }
     
    class XYZ
    {
        int i = this.i;
         
        {
            i++;
        }
         
        public XYZ() 
        {
            ++i;
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        ABC abc = new ABC();
         
        System.out.println(abc.i);//10099
         
        ABC.XYZ xyz = abc.new XYZ();
         
        System.out.println(xyz.i);//2
         
        ABC.XYZ xyz1 = new ABC().new XYZ();
         
        System.out.println(xyz1.i);//2
    }
}
```
#### 16.
```
//PPP
  PPPQQQ
  PPPQQQPPP

class P
{
    String s = "PPP";
     
    {
        System.out.println(s);//第一步:PPP
    }
     
    String methodP()
    {
        class Q
        {
            String s = P.this.s+"QQQ";
             
            {
                System.out.println(s);//第二步：PPPQQQ
            }
        }
         
        return new Q().s+s;//第三步：PPPQQQPPP
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        P p = new P();
         
        System.out.println(p.methodP());
    }
}

```

#### 17. 

```
class A
{
    void methodA1(int i)
    {
        System.out.println(i+++i);//i++ + i和i + ++i结果一样，返回的是21
    }
     
    void methodA2(int i)
    {
        System.out.println(--i-i--);//9 - 9 = 0
    }
}
 
class B
{
    A a = new A()
    {
        void methodA1(int i)
        {
            System.out.println(++i+i++);//传入参数为10， 11 + 11 = 22；
        }
         
        void methodA2(int i)
        {
            System.out.println(i---i);//10 - 9 = 1
        }
    };
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        A a = new A();
         
        a.methodA1(10);
         
        a.methodA2(10);
         
        B b = new B();
         
        b.a.methodA1(10);
         
        b.a.methodA2(10);
    }
}

```

#### 18. 以下代码能否通过编译，为什么
```
class One
{
    void methodOne()
    {
        public class Two//此处public没意义，内部类在方法里面，方法调用结束后内部类就不存在了
        {
             
        }
    }
}
```


#### 19.

```
class One
{
    {
        System.out.println("ONE");
    }
     
    class Two
    {
        {
            System.out.println("TWO");
        }
    }
     
    static
    {
        System.out.println("THREE");
    }
     
    static class Three
    {
        {
            System.out.println("FOUR");
        }
         
        static
        {
            System.out.println("FIVE");
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        One one = new One();//THREE ONE
         
        One.Two two = one.new Two();//TWO
         
        One.Three three = new One.Three();//FIVE FOUR
    }
}
```

#### 20. 以下代码能否通过编译，为什么
```
//循环结构？
class A
{
    class B extends A
    {
        class C extends B
        {
            class D extends C
            {
                 
            }
        }
    }
}
```

#### 21.
```
//STATIC NON-STATIC
  NON-STATIC STATIC

abstract class X
{
    static String s1 = "STATIC";
     
    String s2 = "NON-STATIC";
     
    abstract void methodX(); 
     
    static abstract class Y
    {
        String s1 = "NON-STATIC";
         
        static String s2 = "STATIC";
         
        abstract void methodY();
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        new X() 
        {   
            void methodX()
            {
                System.out.println(s1+" "+s2);
            }
        }.methodX();
         
        new X.Y() 
        {   
            void methodY() 
            {
                System.out.println(s1+" "+s2);
            }
        }.methodY();
    }
}
```

#### 22. 在下面的示例中，如何访问“内部类”的“i”字段？
```
//new OuterClass.InnerClass().i

class OuterClass
{
    static class InnerClass
    {
        int i;//静态内部类中可以有非静态成员变量，static只是保证内部类先加载，其中的成员变量也一并加载
    }
}
```

#### 23.
```
//没有任何输出，没有new一个对象时，classY不会加载
class X
{   
    static
    {
        class Y
        {   
            {
                System.out.println(1);
            }
        }
    }
     
    {
        class Y
        {
            {
                System.out.println(2);
            }
        }
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        new X();
    }
}
```

#### 24.
```
//BBB

class A
{   
    abstract class B
    {
        abstract void method();
    }
     
    {
        new B()
        {
             
            @Override
            void method()
            {
                System.out.println("BBB");
            }
        }.method();
    }
}
 
public class MainClass
{
    public static void main(String[] args)
    {
        new A();
    }
}
```

#### 25.
```
//内部类中不能有静态方法
class X
{   
    void methodX()
    {
        class Y
        {
            static void methodY()
            {
                 
            }
        }
    }
}
```

#### 26. 如何在class A以外的其他类中实例化 class B
```
//new A().methodA().new B

class A
{
    void methodA()
    {
        class B
        {
             
        }
    }
}
```

#### 27.
```
public class Outer 
{ 
	public static int temp1 = 1; 
	private static int temp2 = 2; 
	public int temp3 = 3; 
	private int temp4 = 4; 
	
	public static class Inner 
	{ 
		private static int temp5 = 5; 
		
		private static int getSum() 
		{ 
			return (temp1 + temp2 + temp3 + temp4 + temp5); //编译报错，静态类中调用了可能还没加载的部分
		} 
	} 
	
	public static void main(String[] args) 
	{ 
		Outer.Inner obj = new Outer.Inner(); 
		System.out.println(obj.getSum()); 
	} 
	
} 

```

#### 28.
```
//200
public class Outer  
{ 
    private static int data = 10; 
    private static int LocalClass() 
    { 
        class Inner 
        { 
            public int data = 20; 
            private int getData() 
            { 
                return data; 
            } 
        }; 
        Inner inner = new Inner(); 
        return inner.getData(); 
    } 
      
    public static void main(String[] args) 
    { 
        System.out.println(data * LocalClass()); 
    } 
} 

```

#### 29.
```
interface Anonymous 
{ 
	public int getValue(); 
} 
public class Outer 
{ 
	private int data = 15; 
	public static void main(String[] args) 
	{ 
		Anonymous inner = new Anonymous() 
				{ 
					int data = 5; 
					public int getValue() 
					{ 
						return data; 
					} 
					public int getData() 
					{ 
						return data; 
					} 
				}; 
		Outer outer = new Outer(); 
		System.out.println(inner.getValue() + inner.getData() + outer.data); 
//会报错，inner.getData()调不到，inner的接口类型Anonymous中没有此方法
	} 
} 

```

#### 30.
```
public class Outer 
{ 
    private int data = 10; 
      
    class Inner 
    { 
        private int data = 20; 
        private int getData() 
        { 
            return data; 
        } 
        public void main(String[] args) 
        { 
            Inner inner = new Inner(); 
            System.out.println(inner.getData()); 
              
        } 
    } 
    private int getData() 
    { 
        return data; 
    } 
    public static void main(String[] args) 
    { 
        Outer outer = new Outer(); 
        Outer.Inner inner = outer.new Inner(); 
        System.out.printf("%d", outer.getData()); //10
        inner.main(args); //20
    } 
} 
```

#### 31.
```
//100

interface OuterInterface 
{ 
    public void InnerMethod(); 
    public interface InnerInterface 
    { 
        public void InnerMethod(); 
    } 
} 
public class Outer implements OuterInterface.InnerInterface, OuterInterface 
{ 
    public void InnerMethod() 
    { 
        System.out.println(100); 
    } 
      
      
    public static void main(String[] args) 
    { 
        Outer obj = new Outer(); 
        obj.InnerMethod(); 
    } 
} 
```

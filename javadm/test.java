class A{
	private static final String ADDRESS="栖霞区下水道...";
	public static int count = 1;
	private String password;
	static{
		count++;
	}
	public A(){
		count++;
	}
	{
		count++;
	}
}
class B{
	public static void main(String[] args) {
		new A();
		new A();
		System.out.println(A.count);
	}
}
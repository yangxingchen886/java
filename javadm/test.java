interface ABC
{
	void methodOne();
}

interface PQR extends ABC
{
	void methodTwo();
}

abstract class XYZ implements PQR
{
	public void methodOne()
	{
		methodTwo();
	}
}

class MNO extends XYZ
{
	public void methodTwo()
	{
		methodOne();
	}
}

class MainClass1
{
	public static void main(String[] args)
	{
		ABC abc = new MNO();

		abc.methodOne();
	}
}
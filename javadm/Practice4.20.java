class  Predicate420{

	public static void main(String[] args) {
char[][] twoDimensionalArr = new char[3][];
twoDimensionalArr[0]=new char[]{'你','我','他'};
twoDimensionalArr[1]=new char[]{'金','木','水','火','土'};
twoDimensionalArr[2]=new char[]{'天','地'};
		for(char a[]:twoDimensionalArr){
			for(char i:a){
				System.out.println(i+"\n");
			}
	}
}
}
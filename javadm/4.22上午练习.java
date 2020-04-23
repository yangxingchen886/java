//第1.2题
// class Elephant {

//     int heightInCM; //field properties

// }

// class Lion{
// 	int heightInCM;
// } //狮子类
// // 实例 instance   class => object

// class Fridge {

//     int heightInCM;
//     Elephant store;
//     Lion lStore;
//     // method
//     void store(Elephant elephant) {
//         if (store !=null){
//         	System.out.println("冰箱已经满了");
//         }else{
//         	store = elephant;
//     	}//判断是否装满冰箱
//     }
//     void lStore(Lion lion){
//     	if (lStore !=null){
//         	System.out.println("冰箱已经满了");
//         }else{
//         	lStore = lion;
//     	}
//     }
//     void Elephantremove(Elephant elephant){ //将大象从store中取出。
//     	store = null;
//     	System.out.println(elephant);
//     }
// }


// class Main{
// 	public static void main(String[] args) {
// 		Elephant elephant = new Elephant();
// 		elephant.heightInCM = 300;

// 		Fridge fridge = new Fridge();
// 		fridge.heightInCM = 500;
// 		fridge.store(elephant);
// 		System.out.println(fridge.store);
// 		fridge.Elephantremove(elephant);
// 		System.out.println(fridge.store);


// 		Lion lion = new Lion();
// 		lion.heightInCM = 200;
// 	}
// }


//第三题

  
// class Elephant {

//   int heightInCM;
// }

// class Lion{
// 	int heightInCM;
// }

// class Fridge {

//   int heightInCM;
//   Elephant storage;
//   Lion lStorage;

//   void store(Elephant elephant) {
//     storage = elephant;
//   }
//   void lStore(Lion lion){
//   	lStorage = lion;
//   }
// }

// class ObjectDemo {
//   static Elephant createElephant(int heightInCM) {
//     System.out.printf("创建一个大象，高度%d厘米\n", heightInCM);
//     // 使用定义的类作为数据类型
//     // 使用new 创建一个对象（实例）
//     Elephant elephant = new Elephant();
//     // 使用. 访问对象的属性，可以对属性赋值或使用
//     elephant.heightInCM = heightInCM;
//     return elephant;
//   }

//   static Lion createLion(int heightInCM){
//   	System.out.printf("创建一个狮子，高度%d厘米\n",heightInCM);
//   	Lion lion = new Lion();
//   	lion.heightInCM = heightInCM;
//   	return lion;
//   }


//   static Fridge createFridge(int heightInCM) {
//     System.out.printf("创建一个冰箱，高度%d厘米\n", heightInCM);
//     Fridge fridge = new Fridge();
//     fridge.heightInCM = heightInCM;
//     return fridge;
//   }

//   static void putInElephant(Elephant elephant, Fridge fridge) {
//     System.out.printf("把%d厘米高的大象装进%d厘米高的冰箱\n", elephant.heightInCM, fridge.heightInCM);
//     if(elephant.heightInCM < fridge.heightInCM) {

//       // 使用对象方法
//       fridge.store(elephant);
//       System.out.printf("冰箱里面的大象高度是%d厘米\n", fridge.storage.heightInCM);
//     } else {
//       System.out.printf("冰箱装不下!\n");
//     }
// }
//   static void putInLion(Lion lion, Fridge fridge) {
//     System.out.printf("把%d厘米高的狮子装进%d厘米高的冰箱\n", lion.heightInCM, fridge.heightInCM);
//     if(lion.heightInCM < fridge.heightInCM) {

//       // 使用对象方法
//       fridge.lStore(lion);
//       System.out.printf("冰箱里面的狮子高度是%d厘米\n", fridge.lStorage.heightInCM);
//     } else {
//       System.out.printf("冰箱装不下!\n");
//     }
// }


//   public static void main(String[] args) {
//     Elephant elephant = createElephant(300);
//     Fridge fridge = createFridge(500);
//     putInElephant(elephant, fridge);
//     Lion lion = createLion(200);
//     putInLion(lion,fridge); 
//   }
// }


class Commpany {
	int count = 0 ;
	Employee[] employeelist = new Employee[10];

	void addEmployee (Employee employee){
		employeelist[count++] = employee;
	}

	void rmEmployee (String name){
		for (int i = 0; i < count; i++) {
      		if (employeelist[i].name.equals(name)) {
        		for (int j = i; j < count - 1; j++) {
          			employeelist[j] = employeelist[j + 1];
        			}
        		count--;
			}
		}
	}

	void printgongzi (String name){
	for (int i = 0;i<count;i++){
		if(employeelist[i].name.equals(name)){
		System.out.printf(name+"工资为："+employeelist[i].jibengongzi);
			}
		}
	}

	void printall (){
		int sum = 0;
		for(int i = 0;i<count;i++){
			sum += employeelist[i].getgongzi();
		}
		System.out.printf("所有%d位员工工资为%d\n",count,sum);
	}
}
class Employee {
	String name;
	int workhours;
	int jibengongzi = 2020;

	void setworkhours(int workhours){
		workhours = workhours;
	}

	int getgongzi(){
		if (workhours>196){
			return jibengongzi+200*(workhours-196);
		}else{
			return jibengongzi;
		}
	}
}

class main {


public static void main(String[] args) {
	Commpany commpany = new Commpany();
	Employee e1 = new Employee();
	e1.name = "张一";
	e1.setworkhours(205);

	Employee e2 = new Employee();
	e2.name = "张二";
	e2.setworkhours(220);

	Employee e3 = new Employee();
	e3.name = "张四";
	e3.setworkhours(180);

	Employee e4 = new Employee();
	e4.name = "张五";
	e4.setworkhours(196);

	commpany.addEmployee(e1);
	commpany.addEmployee(e2);
	commpany.addEmployee(e3);
	commpany.addEmployee(e4);

	commpany.printall();
}


}
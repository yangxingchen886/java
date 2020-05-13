public class OuterClass {
    private int a;

    private int test() {
        return a;
    }

    public class InnercClass {
        private int a;

        public void method() {
            System.out.println(this.a);
            System.out.println(a);
        }
    }
}

//    public static void main(String[] args) {
//        new OuterClass().new InnercClass().method();
//
//    }
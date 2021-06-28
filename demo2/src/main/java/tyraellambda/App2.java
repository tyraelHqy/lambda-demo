package tyraellambda;

public class App2 {
    String s1 = "全局变量";

    // 1. 匿名内部类型中对于变量的访问
    public void testInnerClass(){
        String s2 = "局部变量";

        new Thread(new Runnable() {
            String s3 = "内部变量";

            @Override
            public void run() {
                // 访问全局变量
                System.out.println(s1);

                // 访问局部变量，不能对局部变量进行数据的修改
                System.out.println(s2);

                System.out.println(s3);
                System.out.println(this.s3);
            }
        }).start();
    }

    // 2. lambda表达式变量捕获
    public void testLambda(){
        String s2 = "局部变量lambda";

        new Thread(()->{
            String s3 = "内部变量lambda";
            System.out.println(this.s1); // this关键字，表示的是所属方法所在类型的对象

            // 访问局部变量
            System.out.println(s2);
//            s2 = "hello";  // 不能进行数据修改，默认推导变量的修饰符：final

            System.out.println(s3);
            s3 = "lambda 内部变量直接修改";
            System.out.println(s3);

        }).start();
    }

    public static void main(String[] args) {
        App2 app =new App2();
        app.testInnerClass();
        app.testLambda();
    }
}

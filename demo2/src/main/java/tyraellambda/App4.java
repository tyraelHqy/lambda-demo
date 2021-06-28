package tyraellambda;

/**
 * 方法重载对于lambda表达式的影响
 */
public class App4 {

    interface Param1{
        void outInfo(String info);
    }

    interface Param2{
        void outInfo(String info);
    }

    // 定义重载方法
    public void lambdaMethod(Param1 param){
        param.outInfo("Hello param1!");
    }
    public void lambdaMethod(Param2 param){
        param.outInfo("Hello param2!");
    }

    public static void main(String[] args) {
        App4 app = new App4();
        app.lambdaMethod(new Param1() {
            @Override
            public void outInfo(String info) {
                System.out.println(info);
            }
        });

        app.lambdaMethod(new Param2() {
            @Override
            public void outInfo(String info) {
                System.out.println("------");
                System.out.println(info);
            }
        });

        /**
         * lambda表达式存在类型检查-> 自动推导lambda表达式的目标类型
         */
//        app.lambdaMethod((String info)->{
//            System.out.println(info);
//        });
    }
}

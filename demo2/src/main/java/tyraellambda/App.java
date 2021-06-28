package tyraellambda;

import lambda.IMessageFormat;
import lambda.IUserCredential;
import lambda.impl.MessageFormateImpl;
import lambda.impl.UserCredentialImpl;

import java.sql.SQLOutput;
import java.util.UUID;
import java.util.function.*;

/**
 * 需求改动：
 * 所有的用户验证，可以同时获取用户的验证信息【是否认证成功|成功返回用户\NULL】
 */
public class App {
    public static void main(String[] args) {
//        IUserCredential ic = new UserCredentialImpl();
//        System.out.println(ic.verifyUser("admin"));
//        System.out.println(ic.getCredential("admin"));
//
//        // 2. 静态方法
//        String message = "hello world";
//        if(IMessageFormat.verifyMessage(message)){
//            IMessageFormat format = new MessageFormateImpl();
//            format.format("hello","json");
//        }
//
//        // 3. 匿名内部类，实现接口的抽象方法
//        IUserCredential ic2 = new IUserCredential() {
//            @Override
//            public String verifyUser(String username) {
//                return "admin".equals(username)?"管理员":"会员";
//            }
//        };
//        System.out.println(ic2.verifyUser("manager"));
//        System.out.println(ic2.verifyUser("admin"));
//
//        // lambda表达式，针对函数式接口的简单实现
//        IUserCredential ic3 = (String username) -> {
//            return "admin".equals(username)?"lbd管理员":"lbd会员";
//        };
//        System.out.println(ic2.verifyUser("manager"));
//        System.out.println(ic2.verifyUser("admin"));

        Predicate<String> pre = (String username) -> {
            return "admin".equals(username);
        };
        System.out.println(pre.test("manager"));
        System.out.println(pre.test("admin"));

        Consumer<String> con = (String message) -> {
            System.out.println("要发送的消息:" + message);
            System.out.println("消息发送完成");
        };
        con.accept("hello world..");
        con.accept("hello lambda..");

        Function<String, Integer> fun = (String gender) -> {
            return "male".equals(gender) ? 1 : 0;
        };
        System.out.println(fun.apply("male"));
        System.out.println(fun.apply("female"));

        Supplier<String> supplier = () -> {
            return UUID.randomUUID().toString();
        };
        System.out.println(supplier.get());
        System.out.println(supplier.get());
        System.out.println(supplier.get());

        UnaryOperator<String> unaryOperator = (String img) -> {
            img += "[100*200]";
            return img;
        };
        System.out.println(unaryOperator.apply("immmmss"));

        BinaryOperator<Integer> bo = (Integer i1, Integer i2) -> {
            return i1 > i2 ? i1 : i2;
        };
        System.out.println(bo.apply(12, 13));

        Ilambda i1 = () -> {
            System.out.println("hello lambda");
            System.out.println("hello lambda!!");
        };
        i1.test();

        Ilambda2 i2 = (String name, int age) -> {
            System.out.println(name + " say: my name is " + age);
        };
        i2.test("leo", 22);

        Ilambda3 i3 = (x, y) -> {
            int z = x + y;
            return z;
        };
        System.out.println(i3.test(11, 22));

        Ilambda3 i31 = (x, y) -> x + y;
        System.out.println(i31.test(111, 22));
    }


    interface Ilambda {
        void test();
    }

    interface Ilambda2 {
        void test(String name, int age);
    }

    interface Ilambda3 {
        int test(int x, int y);
    }
}

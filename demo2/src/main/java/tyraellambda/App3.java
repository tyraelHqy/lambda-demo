package tyraellambda;

import java.util.ArrayList;
import java.util.List;

public class App3 {

    public static void test(MyInterface<String, List> inter) {
        List<String> list = inter.strategy("Hello!", new ArrayList());
        System.out.println(list);
    }

    public static void main(String[] args) {
        test(new MyInterface<String, List>() {
            @Override
            public List strategy(String s, List list) {
                list.add(s);
                return list;
            }
        });

        test((x, y) -> {
            y.add(x);
            return y;
        });
    }
}


@FunctionalInterface
interface MyInterface<T, R> {
    R strategy(T t, R r);
}
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        // 整数列表
        List<Integer> list = new ArrayList<>();

        // 增加数据
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }

        // 串行Stream
        List<Integer> list2 =  new ArrayList<>();
        list.stream().forEach(x -> list2.add(x));
        System.out.println(list.size());
        System.out.println(list2.size());

        // 并行Stream
        List<Integer> list3 = new ArrayList<>();
        list.parallelStream().forEach(x -> list3.add(x));
        System.out.println(list3.size());

        // 使用线程安全的集合规范数据源
        List<Integer> list4 = list.parallelStream().collect(Collectors.toList());
        System.out.println(list4.size());
    }
}

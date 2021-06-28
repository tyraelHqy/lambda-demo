import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {
        /**
         * 批量数据 -> Stream 对象
         */

        // 多个数据
        Stream stream = Stream.of("admin", "tom", "damu");

        // 数组
        String[] strArr = new String[]{"xueqi", "xixi", "damu"};
        Stream<String> stream2 = Arrays.stream(strArr);

        // 列表
        List<String> list = new ArrayList<>();
        list.add("少陵");
        list.add("武当");
        list.add("倥侗");
        list.add("峨眉");
        list.add("少林");
        Stream<String> stream3 = list.stream();

        // 集合
        Set<String> set = new HashSet<>();
        set.add("少林罗汉拳");
        set.add("兰花拂穴手");
        set.add("峨眉减法");
        Stream<String> stream4 = set.stream();

        // Map
        Map<String, Integer> map = new HashMap<>();
        map.put("tom", 10000);
        map.put("jerry", 12000);
        map.put("robbin ", 14000);
        map.put("luffy", 16000);
        map.put("shanks", 17000);
        Stream<Map.Entry<String, Integer>> stream5 = map.entrySet().stream();

        // 2. Stream对象对于基本数据类型的功能封装
        // int / long / double
//        IntStream.of(new int[]{1, 2, 4, 5, 6, 7}).forEach(System.out::println);
//        IntStream.range(1, 5).forEach(System.out::println);
//        IntStream.rangeClosed(1, 5).forEach(System.out::println);

        // 3. Stream对象 -> 转换成指定的数据类型
//        Object[] objects = stream.toArray(String[]::new);

        // 字符串
//        String str = stream.collect(Collectors.joining()).toString();
//        System.out.println(str);

        // 列表
//        List<String> lists = (List<String>) stream.collect(Collectors.toList());
//        System.out.println(lists);

//        // 集合
//        Set<String> setx = (Set<String>) stream.collect(Collectors.toSet());
//        System.out.println(setx);
//        // Map
//        Map<String, String> mapx = (Map<String, String>) stream.collect(Collectors.toMap(x -> x, y -> "value" + y));
//        System.out.println(mapx);

        // 4. Stream中常见的API操作
        List<String> accountList = new ArrayList<>();
        accountList.add("xongjiang");
        accountList.add("lujunyi");
        accountList.add("wuyong");
        accountList.add("linghcong");
        accountList.add("luzhishen");
        accountList.add("likui");
        accountList.add("wusong");

        // map()中间操作，map()方法接收一个functional接口
//        accountList = accountList.stream().map(x -> "梁山好汉:" +x).collect(Collectors.toList());

        // 添加过滤条件，过滤符合条件的用户
//        accountList = accountList.stream().filter(x -> x.length() > 5).collect(Collectors.toList());

        // foreach 增强型循环
//        accountList.forEach(x -> System.out.println("foreach->" +x));

        // peek() 迭代数据完成数据的依次处理过程
//        accountList.stream()
//                .peek(x -> System.out.println("peek 1:" + x))
//                .peek(x -> System.out.println("peek 2:" + x))
//                .forEach(System.out::println);
//
//        System.out.println(accountList);

        // Stream中对数字运算的支持
        List<Integer> intlist = new ArrayList<>();
        intlist.add(20);
        intlist.add(19);
        intlist.add(14);
        intlist.add(22);
        intlist.add(113);
        intlist.add(821);
        intlist.add(11);

        // skip() 中间操作，有状态，跳过部分数据
//        intlist.stream().skip(3).forEach(System.out::println);

        // limit() 中间操作，有状态，限制输出数据量
        intlist.stream().skip(3).limit(2).forEach(System.out::println);

        // distinct() 中间操作，有状态，剔除重复的数据
        intlist.stream().distinct().forEach(System.out::println);

        // sorted() 中间操作，有状态，排序
        Optional<Integer> optional = intlist.stream().max((x, y) -> x - y);
        System.out.println(optional.get());

        // min() 中间操作，有状态，获得最大值

        // max() 中间操作，有状态，获取最小值

        // reduce() 合并数据处理
        Optional<Integer> optional1 = intlist.stream().reduce((sum, x) -> sum + x);
        System.out.println(optional1.get());
    }
}

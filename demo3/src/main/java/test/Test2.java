package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        // 1. 添加测试数据：存储多个账号列表
        List<String> accounts = new ArrayList<String>();
        accounts.add("tom");
        accounts.add("jerry");
        accounts.add("xixi");
        accounts.add("hahah");
        accounts.add("lIlI");

        // 1.1 业务要求：长度大于等于5的有效账号
        for (String account : accounts) {
            if (account.length() >= 5) {
                System.out.println("有效账号：" +account);
            }
        }

        // 1.2 迭代方式进行操作
        Iterator<String> it = accounts.iterator();
        while (it.hasNext()){
            String account = it.next();
            if(account.length() >= 5){
                System.out.println("it有效账号：" + account);
            }
        }

        // 1.3 通过Stream结合lambda表达式
        List validAccounts = accounts.stream().filter(s -> s.length()>=5).collect(Collectors.toList());
        System.out.println(validAccounts);
    }
}

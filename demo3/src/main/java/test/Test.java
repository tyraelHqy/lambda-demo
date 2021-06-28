package test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        // 存储Person对象的列表
        List<Person> list = new ArrayList<>();
        list.add(new Person("tom","男",15));
        list.add(new Person("jerry","男",17));
        list.add(new Person("lisa","女",19));
        list.add(new Person("fas","男",21));
        list.add(new Person("enjun","女",34));

        // 1. 匿名内部类实现方式
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        System.out.println(list);

        // 2. lambda表达式实现方式
        Collections.sort(list,(p1,p2)-> p1.getAge()-p2.getAge());
        System.out.println(list);

        // 3. 静态方法引用
        Collections.sort(list,Person::compareByAge);

        // 4. 实例方法引用
        PersonUtil personUtil = new PersonUtil();
        Collections.sort(list,personUtil::compareByName);
        System.out.println(list);

        // 5. 构造方法引用
        IPerson iPerson = Person::new;
        Person person = iPerson.initPerson("jjjjj", "男", 23);
        System.out.println(person);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person{
    private String name;
    private String gender;
    private int age;

    public static int compareByAge(Person p1, Person p2){
        return p1.getAge() - p2.getAge();
    }
}

class PersonUtil{
    public int compareByName(Person p1, Person p2){
        return p1.getName().hashCode() - p2.getName().hashCode();
    }
}

interface IPerson{
    // 抽象方法：通过指定类型的构造方法初始化对象数据
    Person initPerson(String name,String gender,int age);
}
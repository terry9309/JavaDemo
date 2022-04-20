import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingLong;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;


/**
 *   Terry
 *   去除重复元素
 *
 */

public class MoveRepeatData {


    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("JAMES");
        list.add("KOBE");
        list.add("KOBE");
        list.add("JAMES");
        list.add("WEDE");
        moveRepeatString(list);
        System.out.println(list.toString());



        //JAVA 8中的写法
        List<String> unique = list.stream().distinct().collect(Collectors.toList());
        System.out.println(unique.toString());



        Person p1 = new Person(11,"JAMES");
        Person p2 = new Person(12,"CURRY");
        Person p3 = new Person(13,"KOBE");
        Person p4 = new Person(14,"BOSH");


        List<Person> persons = Arrays.asList(p1,p1,p2,p3,p3,p2,p4);
        List<Person>  personList = new ArrayList<>();

        /**
         *  对象去重
         */
        persons.stream().forEach(
                person -> {
                    if (!personList.contains(person)){
                         personList.add(person);
                    }
                }
        );
        System.out.println(personList);



        Person p11 = new Person(11,"JAMES");
        Person p111 = new Person(11,"JAMES2");
        Person p12 = new Person(12,"CURRY");
        Person p122 = new Person(12,"CURRY2");
        Person p13 = new Person(13,"KOBE");
        Person p133 = new Person(13,"KOBE3");
        Person p14 = new Person(14,"BOSH");
        Person p144 = new Person(14,"BOSH4");


        List<Person> personList1 = Arrays.asList(p11,p111,p12,p122,p13,p133,p14,p144);
        /**
         *  根据对象属性去重
         */
        List<Person> uniques = personList1.stream().collect(
                collectingAndThen(
                        toCollection(() -> new TreeSet<>(comparingLong(Person::getId))), ArrayList::new)
        );
        System.out.println(uniques);

    }







    /**
     *  利用 LinkedHashSet 去重
     */
    public static List<String> moveRepeatString(List<String> strings){
        Set<String> set = new LinkedHashSet<>();
        set.addAll(strings);
        strings.clear();
        strings.addAll(set);
        return strings;
    }






}

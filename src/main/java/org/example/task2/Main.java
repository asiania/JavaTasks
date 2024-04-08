package org.example.task2;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Integer> testList = new ArrayList<>(Arrays.asList(5, 2, 10, 9, 4, 3, 10, 1, 13));

        //Реализуйте удаление из листа всех дубликатов
        List<Integer> resultTestList = testList.stream()
                .distinct()
                .toList();
        System.out.println(resultTestList);

        //Найдите в списке целых чисел 3-е наибольшее число (пример: 5 2 10 9 4 3 10 1 13 => 10)
        int resultTestList2 = testList.stream()
                .sorted(Collections.reverseOrder())
                .skip(2)
                .findFirst()
                .orElse(-1);
        System.out.println(resultTestList2);

        //Найдите в списке целых чисел 3-е наибольшее «уникальное» число (пример: 5 2 10 9 4 3 10 1 13 => 9,
        //в отличие от прошлой задачи здесь разные 10 считает за одно число)
        int resultTestList3 = testList.stream()
                .distinct()
                .sorted(Collections.reverseOrder())
                .skip(2)
                .findFirst()
                .orElse(-1);
        System.out.println(resultTestList3);

        List<Person> persons = new ArrayList<>(Arrays.asList(
                new Person("Person1", 35, Person.Position.MANAGER),
                new Person("Person2", 40, Person.Position.DIRECTOR),
                new Person("Person3", 38, Person.Position.ENGINEER),
                new Person("Person4", 40, Person.Position.MANAGER),
                new Person("Person5", 41, Person.Position.ENGINEER),
                new Person("Person6", 35, Person.Position.ENGINEER),
                new Person("Person7", 37, Person.Position.ENGINEER),
                new Person("Person8", 39, Person.Position.ENGINEER)
        ));

        //Имеется список объектов типа Сотрудник (имя, возраст, должность),
        //необходимо получить список имен 3 самых старших сотрудников с должностью «Инженер», в порядке убывания возраста
        List<Person> resultPersons = persons.stream()
                .filter(it->it.position()==Person.Position.ENGINEER)
                .sorted(Comparator.comparingInt(Person::age).reversed())
                .limit(3)
                .toList();
        System.out.println(resultPersons);

        //Имеется список объектов типа Сотрудник (имя, возраст, должность),
        //посчитайте средний возраст сотрудников с должностью «Инженер»
        Double result = persons.stream()
                .filter(it->it.position()==Person.Position.ENGINEER)
                .collect(Collectors.averagingDouble(Person::age));
        System.out.println(result);


        //Найдите в списке слов самое длинное
        List<String> stringList = new ArrayList<>(Arrays.asList("string1","string55555","string666666","string7777777","string333","string7777777","string22","string4444"));
        String resultstringList = stringList.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println(resultstringList);


        //Имеется строка с набором слов в нижнем регистре, разделенных пробелом. Постройте хеш-мапы,
        //в которой будут хранится пары: слово - сколько раз оно встречается во входной строке
        String str = "zxc qwe asd asd zxc str qwe zxc dsa ewq dsa qwe";
        Map<String, Long> cntStr = Arrays.stream(str.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(cntStr);

        //Отпечатайте в консоль строки из списка в порядке увеличения длины слова,
        //если слова имеют одинаковую длины, то должен быть сохранен алфавитный порядок
        List<String> stringList2 = new ArrayList<>(Arrays.asList("ertrt","vgy","rthjikn","rt","aw","tyh","der","asdfg"));
        List<String> resultstringList2 = stringList2.stream()
                .sorted(Comparator.comparingInt(String::length).thenComparing(Function.identity()))
                .toList();
        System.out.println(resultstringList2);

        //Имеется массив строк, в каждой из которых лежит набор из 5 строк, разделенных пробелом,
        //найдите среди всех слов самое длинное, если таких слов несколько, получите любое из них
        List<String> stringList3 = new ArrayList<>(Arrays.asList("ertrt dfg rtyujnb rtyuj ertthbnje"
                                                                ,"rfghn ertyhnb rtyyhnbvf rtghnb rtghnj"
                                                                ,"rthjikn rtyhnbuy ertthbnjy rfg tghyn"
                                                                ,"rt tyhjn ertyhnji ertyh ertynju"
                                                                ,"aw tyhj ertyhjn awerfgt ertgbnhyu"
                                                                ,"aw tyujk ertghnb ertgbnh rtyujk"));
        String resultstringList3 = stringList3.stream()
                .flatMap(it -> Arrays.stream(it.split(" "))).max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println(resultstringList3);
    }
}

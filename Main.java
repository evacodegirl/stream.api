import java.util.*;
import java.util.stream.Collectors;


import static java.util.Arrays.asList;


public class Main {
    public static void main(String[] args) {

    }
    public void flattenCollection () {

            List<List<String>> collection = asList(asList("Viktor", "Farcic"), asList("John", "Doe", "Third"));
            List<String> items = new ArrayList<>();
            List<String> strings = collection.stream()
                    .flatMap(list -> {
                        return list.stream();
                    })
                    .collect(Collectors.toList());

            System.out.println(strings);
        }

        public void oldestPerson () {
            List<Person> collection = Arrays.asList(
                    new Person("Sara", 4),
                    new Person("Viktor", 40),
                    new Person("Eva", 42));
            Person oldest = collection.stream()

                    .max((person1, person2) -> Integer.compare(person1.getAge(), person2.getAge()))
                    .get();

            System.out.println(oldest);

        }

        public void sumAllNumbers () {

            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
            Integer sum = numbers.stream()
                    .reduce(0, Integer::sum);
            System.out.println(sum);

        }


        public void getKidNameShouldReturnNamesOfAllKidsUnder18 () {
            Person sara = new Person("Sara", 4);
            Person viktor = new Person("Viktor", 40);
            Person eva = new Person("Eva", 42);
            Person anna = new Person("Anna", 5);
            List<Person> collection = asList(sara, eva, viktor, anna);
            List<String> kidsUnder18 = collection.stream()

                    .filter(person -> person.getAge() < 18)
                    .map(person -> person.getName())
                    .collect(Collectors.toList());

            System.out.println(kidsUnder18);


        }


        public void partitionAdultsShouldSeparateKidsFromAdults () {
            Person sara = new Person("Sara", 4);
            Person viktor = new Person("Viktor", 40);
            Person eva = new Person("Eva", 42);
            List<Person> collection = asList(sara, eva, viktor);


            Map<Boolean, List<Person>> result = collection.stream()

                    .collect(Collectors.partitioningBy(person -> person.getAge() > 18));

            System.out.println(result.toString());
        }


        public void groupByNationalityTest () {
            Person sara = new Person("Sara", 4, "Norwegian");
            Person viktor = new Person("Viktor", 40, "Serbian");
            Person eva = new Person("Eva", 42, "Norwegian");
            List<Person> collection = asList(sara, eva, viktor);


            Map<String, List<Person>> result = collection.stream()

                    .collect(Collectors.groupingBy(person -> person.getNationality()));

            System.out.println(result);
        }


        public void toStringShouldReturnPeopleNamesSeparatedByComma () {
            Person sara = new Person("Sara", 4);
            Person viktor = new Person("Viktor", 40);
            Person eva = new Person("Eva", 42);
            List<Person> collection = asList(sara, viktor, eva);

            String names = collection.stream()

                    .map(person -> person.getName())
                    .collect(Collectors.joining(","));

            System.out.println(names);

        }
    }

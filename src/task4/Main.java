package task4;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<User> users1List = new ArrayList<>();
        users1List.add(new User(12, "Lev"));
        users1List.add(new User(14, "Dima"));
        users1List.add(new User(36, "Sasha"));
        users1List.add(new User(36, "Sasha"));

        List<User> users2List = new ArrayList<>();
        users2List.add(new User(12, "Lev"));
        users2List.add(new User(14, "Dima"));
        users2List.add(new User(12, "Olya"));
        users2List.add(new User(45, "Masha"));

        Set<User> users1Set = new HashSet<>();
        users1Set.add(new User(12, "Lev"));
        users1Set.add(new User(14, "Dima"));
        users1Set.add(new User(36, "Sasha"));
        users1Set.add(new User(36, "Sasha"));

        Set<User> users2Set = new HashSet<>();
        users2Set.add(new User(12, "Lev"));
        users2Set.add(new User(14, "Dima"));
        users2Set.add(new User(12, "Olya"));
        users2Set.add(new User(45, "Masha"));

        //Реализовать метод, который принимает на вход 2 листа и возвращает лист,
        // состоящий только из тех элементов, которые присутствуют в обоих листах.
        List<User> users3 = getSameUsersFromTwoLists(users1List, users2List);
        System.out.println("1: getSameUsersFromTwoLists: " + users3.toString());

        //Задание из 1го пункта, но вместо List нужно использовать Set.
        Set<User> users4 = getSameUsersFromTwoSets(users1Set, users2Set);
        System.out.println("2: getSameUsersFromTwoSets: " + users4.toString());

        //Создайте ArrayList с несколькими элементами (используя дубликаты) и проитерируйтесь
        // по нему, выводя на консоль информацию в виде: <индекс>: <элемент>
        System.out.println("3: showElementsInArrayListWithIndex");
        showElementsInArrayListWithIndex(users1List);

        //Создайте HashSet с несколькими элементами (используя дубликаты) и
        // проитерируйтесь по нему, выводя на консоль информацию в виде: <элемент>
        System.out.println("4: showElementsInHashSets");
        showElementsInHashSets(users1Set);

        Map<Integer, User> usersMap = new HashMap<>();
        usersMap.put(1, new User(12, "Lev"));
        usersMap.put(1, new User(12, "Lev"));
        usersMap.put(2, new User(12, "Lev"));
        usersMap.put(3, new User(12, "Dima"));

        //Создайте HashMap с несколькими элементами (используя дубликаты) и проитерируйтесь по нему, выводя на консоль информацию в виде:
        //    a.  итерация по значениям: <значение>
        System.out.println("5a: showHashMapValuesIteration");
        showHashMapValuesIteration(usersMap);

        //Создайте HashMap с несколькими элементами (используя дубликаты) и проитерируйтесь по нему, выводя на консоль информацию в виде:
        //    b.  итерация по ключам: <ключ>: <значение>
        System.out.println("5b: showHashMapKeysIteration");
        showHashMapKeysIteration(usersMap);

        //Создайте HashMap с несколькими элементами (используя дубликаты) и проитерируйтесь по нему, выводя на консоль информацию в виде:
        //      c.  итерация по парам: <ключ>: <значение>
        System.out.println("5c: showHashMapValuesAndKeysIteration");
        showHashMapValuesAndKeysIteration(usersMap);
    }

    //Создайте HashMap с несколькими элементами (используя дубликаты) и проитерируйтесь по нему, выводя на консоль информацию в виде:
    //    a.  итерация по значениям: <значение>
    public static void showHashMapValuesIteration(Map<Integer, User> usersMap) {
        for (User user : usersMap.values()) {
            System.out.println("Value is " + user);
        }
    }

    //Создайте HashMap с несколькими элементами (используя дубликаты) и проитерируйтесь по нему, выводя на консоль информацию в виде:
    //    b.  итерация по ключам: <ключ>: <значение>
    public static void showHashMapKeysIteration(Map<Integer, User> usersMap) {
        for (Integer key : usersMap.keySet()) {
            System.out.println("Key = " + key + ", value = " + usersMap.get(key));
        }
    }

    //Создайте HashMap с несколькими элементами (используя дубликаты) и проитерируйтесь по нему, выводя на консоль информацию в виде:
    //    c.  итерация по парам: <ключ>: <значение>
    public static void showHashMapValuesAndKeysIteration(Map<Integer, User> usersMap) {
        for (Map.Entry<Integer, User> entry : usersMap.entrySet()) {
            System.out.println("Map Value is " + entry.getValue() + ", map key is " + entry.getKey());
        }
    }

    //Создайте ArrayList с несколькими элементами (используя дубликаты) и проитерируйтесь
    // по нему, выводя на консоль информацию в виде: <индекс>: <элемент>
    public static void showElementsInArrayListWithIndex(List<User> users) {
        for (int i = 0; i < users.size(); i++) {
            System.out.println("Index is " + i + ", value is " + users.get(i));
        }
    }

    //Создайте HashSet с несколькими элементами (используя дубликаты) и
    // проитерируйтесь по нему, выводя на консоль информацию в виде: <элемент>
    public static void showElementsInHashSets(Set<User> users) {
        for (User user : users) {
            System.out.println("Element is " + user);
        }
    }

    //Реализовать метод, который принимает на вход 2 листа и возвращает лист,
    // состоящий только из тех элементов, которые присутствуют в обоих листах.
    public static List<User> getSameUsersFromTwoLists(List<User> users1, List<User> users2) {
        List<User> newList = new ArrayList<>();
        for (User user: users1) {
            if (users2.contains(user)) {
                newList.add(user);
            }
        }
        return newList;
    }

    //Задание из 1го пункта, но вместо List нужно использовать Set.
    public static Set<User> getSameUsersFromTwoSets(Set<User> userSet1, Set<User> userSet2) {
        Set<User> newSet = new HashSet<>();
        for (User user: userSet1) {
            if (userSet2.contains(user)) {
                newSet.add(user);
            }
        }
        return newSet;
    }
}

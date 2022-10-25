package olga.fedianina.lesson15;

import java.util.*;

public class MapLesson {

    public static void main(String[] args) {



        //HashMap

        HashMap<String, Integer> hashMap = new HashMap<>();

        //добавление эл тов

        hashMap.put("Москва", 790);
        hashMap.put("Ростов", 240);
        hashMap.put("Великий Новгород", 20);
        hashMap.put(null,null);
        System.out.println(hashMap);


        //удаление


        hashMap.remove(null);
        hashMap.remove("Ростов", 240);

        // замена

        hashMap.replace("Москва", 800);
        hashMap.replace("Великий Новгород", 20, 18);

        //получение

        System.out.println(hashMap.get("Москва"));
        System.out.println(hashMap.getOrDefault("Москва", 100));

        //проверить, содержится ли ключ в мапе
        System.out.println(hashMap.containsKey("СПБ"));

        //содержится ли значение

        System.out.println(hashMap.containsValue(800));


        //перебор в цикле

        //мапа.keySet(); только ключи (Set) - вернет все ключи
        //мапа.values(); только значения (Collection)
        //мапа.entrySet(); ключи и значения(Map.Entry<Тип ключа, тип значения>)
        for (Map.Entry<String,Integer> pair : hashMap.entrySet()){
            System.out.println("Город (ключ): "+pair.getKey());
            System.out.println("Количество...(значение):"+ pair.getValue());


            //EnumMap - в качестве ключей используются перечисления
            EnumMap<Role,String> enumMap = new EnumMap<>(Role.class);
            enumMap.put(Role.USER, "Пользователь");
            enumMap.put(Role.ADMIN, "Администратор");
        }


        User user1 = new User("a", "a1", Role.ADMIN, 18);
        User user2 = new User("b", "b1", Role.USER, 22);
        User user3 = new User("c", "c1", Role.USER, 22);
        User user4 = new User("d", "d1", Role.USER, 44);
        User user5 = new User("f", "f1", Role.ADMIN, 18);


        HashMap<String, User> userHashMap = new HashMap<>();
        userHashMap.put(user1.getLogin(),user1);
        userHashMap.put(user2.getLogin(),user2);
        userHashMap.put(user3.getLogin(),user3);
        userHashMap.put(user4.getLogin(),user4);
        userHashMap.put(user5.getLogin(),user5);

       HashSet<String> logins = new HashSet<>();
        for (Map.Entry<String, User> pair: userHashMap.entrySet()) {
            if (pair.getValue().getAge()>20) logins.add(pair.getKey());
        }

        HashMap<Integer,ArrayList<User>> ageMap = new HashMap<>();
        for (User user : userHashMap.values()){
            if (! ageMap.containsKey(user.getAge())){
                ArrayList<User> users = new ArrayList<>();
                users.add(user);
                ageMap.put(user.getAge(), users);
            } else{
                ageMap.get(user.getAge()).add(user);
            }
        }
        System.out.println(ageMap);







        EnumMap<Role, ArrayList<User>> enumMap2 = new EnumMap<>(Role.class);
        ArrayList<User> users = new ArrayList<>(Arrays.asList(user2,user3,user4));
        ArrayList<User> admins = new ArrayList<>();
        admins.add(user1);
        admins.add(user5);

        enumMap2.put(Role.ADMIN, admins);
        enumMap2.put(Role.USER, users);

        User user6 = new User("z", "z1", Role.USER, 39);
        Role role = user6.getRole();
        ArrayList<User> list = enumMap2.get(role);
        list.add(user6);

        //enumMap2.get(user6.getRole().add(user6));


    }
}
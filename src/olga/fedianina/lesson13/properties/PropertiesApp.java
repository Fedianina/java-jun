package olga.fedianina.lesson13.properties;

import java.util.Locale;

public class PropertiesApp {
    public static void main(String[] args) {
        User user = new User();
        user.setLogin("gfdf");
        user.setId("user01");

        System.out.println(user.getId());


        User<String> stringUser = new User<>();
        stringUser.setLogin("sfh");
        stringUser.setId("user02");
        String stringId = stringUser.getId();


        User<Integer> intUser = new User<>();
        intUser.setLogin("fds");
        intUser.setId(2334);
        Integer intId = intUser.getId();


        PairContainer<String, Integer> container = new PairContainer<>("A", 1);
        System.out.println(container.getKey());//String
        System.out.println(container.getValue());//Integer


        PairContainer<String,User> container2 = new PairContainer<>("x", stringUser);
        Object oId = container2.getValue().getId();



        PairContainer<String,User<String>> container3 = new PairContainer<>("x", stringUser);
        String sId = container3.getValue().getId();
        System.out.println(sId.toUpperCase());



        PairContainer <Integer, PairContainer <Integer, User<String>>> container4 = new PairContainer<>(1, new PairContainer<>(12,stringUser));
        System.out.println(container4.getValue().getValue().getId().toLowerCase(Locale.ROOT));




    }
}

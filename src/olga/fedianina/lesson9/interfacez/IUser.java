package olga.fedianina.lesson9.interfacez;

public interface IUser {
    default void enterInfo (String message){
        System.out.println("Авторизованные пользователь " + message);
    }
    String getUserName();

}

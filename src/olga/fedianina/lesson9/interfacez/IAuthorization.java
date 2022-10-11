package olga.fedianina.lesson9.interfacez;

public interface IAuthorization {
    //
    String getToken ();
    default void enterInfo (String message){
        System.out.println("Авторизованные пользователь " + message);
    }
}

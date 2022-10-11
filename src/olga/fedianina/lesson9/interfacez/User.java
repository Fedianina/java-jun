package olga.fedianina.lesson9.interfacez;

public class User implements IUser, IAuthorization {
    @Override
    public String getToken() {
        return "ll;";
    }


    @Override
    public String getUserName() {
        return "fsdf";
    }

    @Override
    public void enterInfo(String message) {
        System.out.println("Авторизованные пользователь " + message);
    }
}

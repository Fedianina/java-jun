package olga.fedianina.lesson21;

import olga.fedianina.lesson21.common.Connection;
import olga.fedianina.lesson21.common.Message;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerIO {
    private int port;
    private static int countMessage;


    public TCPServerIO(int port) {
        this.port = port;
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) { // включает режим "прослушивания" сервера. Работает толкьо с IO
            System.out.println("сервер запущен");
            System.out.println(port);
            String str = "Сообщение от сервера";
            while (true) {
                Socket socket = serverSocket.accept();// устанавл соединение, происходит блокировка пока не подключен клиент. Сокет со стороны сервера создается автоматом
                // взаимодействие с клиентом
                Connection<Message> connection = new Connection<>(socket);
                Message fromClient = connection.readMessage();
                System.out.println("Сигнал получен!");
                countMessage++;
                if (fromClient.getText().equalsIgnoreCase("/count")){
                    str = String.valueOf(countMessage);

                }
                if (fromClient.getText().startsWith("/ping")){
                    str = fromClient.getText().substring("/ping".length());
                }

                System.out.println("От клиента " + fromClient);

                Message message = new Message("Server", str);
                connection.sendMessage(message);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Обработка IOException и ClassNotFoundException");
        }
    }

    public int getCountMessage() {
        return countMessage;
    }

    public static void main(String[] args) {
        //new TCPServerIO(8090).run();

        new TCPServerIO(Integer.parseInt(args[0])).run();
    }
}

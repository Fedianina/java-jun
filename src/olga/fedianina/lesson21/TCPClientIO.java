package olga.fedianina.lesson21;

import olga.fedianina.ArgsAndProps;
import olga.fedianina.lesson21.common.Connection;
import olga.fedianina.lesson21.common.Message;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.Socket;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

import olga.fedianina.lesson21.TCPServerIO;

public class TCPClientIO {
    private final String ip; //адрес сервера
    private final int port; // порт, на котором серверная программа ожидает клиента


    public TCPClientIO(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println(port);
        while (true) {
            System.out.println("Введите сообщение");
            String text = scanner.nextLine();
            if ("/exit".equalsIgnoreCase(text)) {
                System.out.println("Закрыть приложение");
                return;
            } else if (text.equalsIgnoreCase("/help")) {
                System.out.println("Список доступных команд: \n" +
                        "/count - отобразить пользователю количество сообщений, которые получил сервер (от всех клиентов)\n" +
                        "/exit - выход из приложения\n" +
                        "/ping - время, за которое сообщение доходит до сервера и возвращается обратно");
            } else if (text.equalsIgnoreCase("/count")) {
                System.out.println("кол-во сообщений");
            } else if (text.equalsIgnoreCase("/ping")) {
                text += LocalTime.now();
                System.out.println("Сообщение доставляется за ");
            } else if (text.contains("/")) {
                System.out.println("Введенная команда не найдена, попробуйте еще раз");
                continue;
            }

            Message message = new Message(name, text);

            try (Connection<Message> connection = new Connection<>(new Socket(ip, port))) {
                connection.sendMessage(message);
                Message fromServer = connection.readMessage();
                if (text.startsWith("/ping")) {
                    System.out.println(ChronoUnit.MICROS.between(LocalTime.parse(fromServer.getText()), LocalTime.now()));
                }
                System.out.println("Сообщение от сервера " + fromServer);
            } catch (IIOException | ClassNotFoundException e) {
                System.out.println("обработкаIIOException и ClassNotFoundException");
            } catch (Exception e) {
                System.out.println("Обработка Exception");
            }
        }

    }

    private static boolean checkIP(Properties properties) {
        if (properties == null) {
            System.out.println("Значение IP не передано");
            return false;
        }
        String[] key = new String[4];
        int j = 0;
        int[] keys = new int[4];
        while (j < properties.size()) {
            for (Object o : properties.keySet()) {
                if (o.toString().split("\\.").length != 4) {
                    System.out.println("Длинна IP не корректна");
                    return false;
                }
                key = o.toString().split("\\.");
                System.out.println(Arrays.toString(key));
                for (String s : key) {
                    for (int i = 0; i < key.length; ++i) {
                        keys[i] = Integer.parseInt(s);
                        if (keys[i] > 225) {
                            System.out.println("IP адресс не корректен");
                            return false;
                        }
                    }
                }
            }
            ++j;
            System.out.println("IP адресс № " + j + " корректен");
        }

        return true;
    }


    private static boolean checkPort(Properties properties) {
        if (properties == null) {
            System.out.println("Значение порта не передано");
            return false;
        }
        for (Object s : properties.keySet()) {
            if (Integer.parseInt(properties.getProperty(s.toString())) < 1024 && Integer.parseInt(properties.getProperty(s.toString())) > 49151) {
                System.out.println("адрес порта не корректен");
                return false;
            }
        }
        return true;
    }

    private static boolean checkAll(Properties properties) {
        if (checkIP(properties) && checkPort(properties)) {
            return true;
        }
        throw new IllegalArgumentException("Переданы некорректные данные");
    }


    public static void main(String[] args) {
        //new TCPClientIO("127.0.0.1", 8090).run();

        Properties properties = new Properties();

        try (InputStream input = ArgsAndProps.class.getClassLoader().getResourceAsStream("clientsIP.properties")) {
            properties.load(input);

        } catch (IOException e) {
            System.out.println("Проблемы с чтением файла");
        }
        checkAll(properties);
        String a = properties.keySet().toArray()[0].toString();
        System.out.println(a);
        new TCPClientIO(a, Integer.parseInt(properties.getProperty(a).toString())).run();
    }

}

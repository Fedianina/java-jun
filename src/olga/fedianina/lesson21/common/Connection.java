package olga.fedianina.lesson21.common;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection <T extends Message> implements AutoCloseable{ //автоматически закроется после трая с ресурсами
   private Socket socket;
   private ObjectInputStream input;
   private ObjectOutputStream output;

   public Connection(Socket socket) throws IOException {// исключение выносим сюда, чтобы была возможность сделать свой способ обработки для разных случаев
       this.socket = socket;
       output = new ObjectOutputStream(this.socket.getOutputStream());
       input = new ObjectInputStream(this.socket.getInputStream());
   }

   public void sendMessage (T message)throws IOException{
       message.setDateTime();
       output.writeObject(message); // представит сообщение как послед байт, вошьет тип,версию и св-ва сообщения (не традиентные) и их значения, потом вызовет метод из конструктора выше
       output.flush();//принудительно выталкивает данные. нужно обязательно

   }

   public T readMessage()throws IOException, ClassNotFoundException{
       return (T) input.readObject();// вызовет метод read у сокета, получит последовательность байт, дессериализует в Objekt, - его - в нужный тип

   }


    @Override
    public void close() throws Exception { // описываем, что закрываем при закрытии
       input.close();
       output.close();
       socket.close();

    }
}

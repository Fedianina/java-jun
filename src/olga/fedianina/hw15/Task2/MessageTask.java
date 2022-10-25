package olga.fedianina.hw15.Task2;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        int l = 0, m = 0, h = 0, u = 0;
        for (Message message : messageList) {
            switch (message.getPriority()) {
                case LOW -> l++;
                case MEDIUM -> m++;
                case HIGH -> h++;
                case URGENT -> u++;
            }
        }
        System.out.println("Количество сообщений для приоритетов:"
                + MessagePriority.values()[0] + " " + l + "\n"
                + MessagePriority.values()[1] + " " + m + "\n"
                + MessagePriority.values()[2] + " " + h + "\n"
                + MessagePriority.values()[3] + " " + u);
    }

    public static void countEachCode(List<Message> messageList) {
        for (int i = 0; i <= 10; ++i) {
            int l = 0;
            for (Message message : messageList) {
                if (message.getCode() == i) ++l;
            }
            System.out.println("Количество сообщений для кода " + i + " " + l);
        }

    }


    public static void uniqueMessageCount(List<Message> messageList) {
        HashSet<Message> mes = new HashSet<Message>(messageList);
        System.out.println(mes.size());

    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        HashSet<Message> mes = new HashSet<Message>(messageList);
        System.out.println(mes);
        return null;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority) {
        System.out.println(messageList);
        for (int i = 0; i< messageList.size(); ++i){
            if (messageList.get(i).getPriority().equals(priority)) {
                messageList.remove(i);
                if (i==messageList.size()) break;
                --i;
            }
        }
        System.out.println(messageList);
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority) {
        System.out.println(messageList);
        for (int i = 0; i< messageList.size(); ++i){
            if (!messageList.get(i).getPriority().equals(priority)){
                messageList.remove(i);
                if (i==messageList.size()) break;
                --i;
            }
        }
        System.out.println(messageList);

    }

    public static void main(String[] args) {
        List<Message> messages = Message.generate(34);
        MessageTask.countEachPriority(messages);
        MessageTask.countEachCode(messages);
        MessageTask.uniqueMessageCount(messages);
        MessageTask.uniqueMessagesInOriginalOrder(messages);
        MessageTask.removeEach(messages, MessagePriority.LOW);
        MessageTask.removeOther(messages, MessagePriority.HIGH);

    }


}

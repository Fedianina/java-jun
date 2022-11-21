package olga.fedianina.hw25;

import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class ScannerThreads extends Thread {
private CopyOnWriteArrayList list;
    public ScannerThreads(CopyOnWriteArrayList list) {
        this.list = list;
    }

    public void run(){
       Scanner scanner = new Scanner(System.in);
       String userString;
       System.out.println("что нибудь введи");

       while (!Thread.currentThread().isInterrupted()){
          userString = scanner.nextLine();
           list.add(userString);
           System.out.println("что нибудь введи");
           if (userString.equalsIgnoreCase("stop")){
               interrupt();
           }

       }
    }
}

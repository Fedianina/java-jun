package olga.fedianina.hw25;

import olga.fedianina.hw25.BinHandler;

import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;


public class Application {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> strings = new CopyOnWriteArrayList<>();
        strings.add("das");
        olga.fedianina.hw25.BinHandler<String> binHandler = new BinHandler<>();
        binHandler.writeToFile(strings.get(0));
        RecordThreads recordT = new RecordThreads(strings);
        recordT.setPriority(2);
        ScannerThreads scannerThreads  = new ScannerThreads(strings);
        scannerThreads.setPriority(9);
        recordT.start();
        scannerThreads.start();


        try {
            scannerThreads.join();
            recordT.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

package olga.fedianina.hw25;

import olga.fedianina.hw25.BinHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CopyOnWriteArrayList;

public class RecordThreads extends Thread {
    private CopyOnWriteArrayList <String> list;
    public RecordThreads(CopyOnWriteArrayList <String> list) {
        this.list = list;

    }

    private static void writeToFileinThread (String s){
        BinHandler<String> binHandler = new BinHandler<>();
        binHandler.writeToFile(s);
    }



   /* private static boolean writeToFile(String strings, File file) {
        boolean result = false;
        try (FileOutputStream output = new FileOutputStream(file, true)) {
            output.write(strings.getBytes(StandardCharsets.UTF_8));
            result = true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
    */



    private String miniString (CopyOnWriteArrayList <String> list){
        return list.stream().min((e1, e2) -> e1.length() - e2.length()).toString();
    }


    public void run(CopyOnWriteArrayList <String> list){
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            writeToFileinThread(miniString(list));
            list.remove(miniString(list));

        }

    }


}

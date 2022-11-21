package olga.fedianina.hw25;

    import java.io.*;

public class BinHandler<T> {
        private File file;
        public BinHandler() {
            file = new File("hw25.bin");
        }
        public void writeToFile(T object){
            try (FileOutputStream fileOutput = new FileOutputStream(file);
                 ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)
            )
            {
                objectOutput.writeObject(object);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


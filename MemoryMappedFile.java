import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MemoryMappedFile {

    private static String currentFile = "test.xls";

    public static void main(String[] args) {
        MemoryMappedFile mmf = new MemoryMappedFile();
        mmf.writeMemoryMappedFile();
        mmf.readMemoryMappedFile();
    }

    void readMemoryMappedFile() {
        //Create file object
        File file = new File(currentFile);

        FileChannel fileChannel;
        //Get file channel in readonly mode
        try {
            fileChannel = new RandomAccessFile(file, "r").getChannel();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Unable to find file: " + currentFile);
            return;
        }

        MappedByteBuffer buffer;
        //Get direct byte buffer access using channel.map() operation
        try {
            buffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
        } catch (java.io.IOException e) {
            System.out.println("Unable to read the size of file: " + currentFile);
            return;
        }

        // the buffer now reads the file as if it were loaded in memory.
        System.out.println(buffer.isLoaded());  //prints false
        System.out.println(buffer.capacity());  //Get the size based on content size of file

        //You can read the file from this buffer the way you like.
        for (int i = 0; i < buffer.limit(); i++) {
            System.out.print((char) buffer.get()); //Print the content of file
        }
    }

    void writeMemoryMappedFile() {
        // Create file object
        File file = new File(currentFile);

        //Delete the file; we will create a new file
        if (file.exists()) {
            boolean deleteRC = file.delete();

            if (!deleteRC) {
                System.out.println("Unable to delete: " + currentFile);
                return;
            }
        }

        FileChannel fileChannel;
        // Get file channel in readonly mode
        try {
            fileChannel = new RandomAccessFile(file, "rw").getChannel();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Unable to find file: " + currentFile);
            return;
        }

        MappedByteBuffer buffer;
        // Get direct byte buffer access using channel.map() operation
        try {
            buffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 4096 * 8 * 8);
        } catch (java.io.IOException e) {
            System.out.println("Unable to read the size of file: " + currentFile);
            return;
        }

        //Write the content using put methods
        buffer.put("test put".getBytes());
    }

}

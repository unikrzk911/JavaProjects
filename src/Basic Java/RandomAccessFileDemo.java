import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class RandomAccessFileDemo {
    public static void main(String[] args) {
        try {
            writeRandom();
            readRandom();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void writeRandom() throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("E:\\CSIT\\Semester VII\\Advanced Java\\Java\\Files\\bytestream.txt", "rw");
        String text = "7th sem students";
        randomAccessFile.seek(17);
        randomAccessFile.write(text.getBytes(StandardCharsets.UTF_8));
        randomAccessFile.close();
    }

    static void readRandom() throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("E:\\CSIT\\Semester VII\\Advanced Java\\Java\\Files\\bytestream.txt", "r");
        randomAccessFile.seek(6);
        byte[] bytes = new byte[100];
        randomAccessFile.read(bytes);
        randomAccessFile.close();
        System.out.println(new String(bytes));
    }
}

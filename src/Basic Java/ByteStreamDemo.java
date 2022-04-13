import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class ByteStreamDemo {
    public static void main(String[] args) {
        try {
            fileOutputStreamDemo();
            fileInputStreamDemo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void fileOutputStreamDemo() throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("E:\\CSIT\\Semester VII\\Advanced Java\\Java\\Files\\bytestream.txt", true);
        String text = "test text";
        byte b[] = text.getBytes(StandardCharsets.UTF_8);
        fileOutputStream.write(b);
        fileOutputStream.close();
    }

    static void fileInputStreamDemo() throws Exception {
        FileInputStream fileInputStream = new FileInputStream("E:\\CSIT\\Semester VII\\Advanced Java\\Java\\Files\\bytestream.txt");
        int i;
        while ((i = fileInputStream.read()) != -1) {
            System.out.print((char) i);
        }
        fileInputStream.close();
    }
}

/*
Byte Stream      -> one byte(collection of 8 bits ) at a time
FileInputStream | FileOutputStream

Character Stream -> one character at a time
FileReader      | FileWriter
*/


import java.io.FileReader;
import java.io.FileWriter;


public class FileIO {
    public static void main(String[] args) throws Exception {
        //fileWriterDemo();
        fileReaderDemo();
    }

    static void fileWriterDemo() {
        try {
            FileWriter fileWriter = new FileWriter("E:\\CSIT\\Semester VII\\Advanced Java\\Java\\Files\\test.txt", true);
            fileWriter.write((" This is new added text."));
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void fileReaderDemo() throws Exception {
        FileReader fileReader = new FileReader("E:\\CSIT\\Semester VII\\Advanced Java\\Java\\Files\\test.txt");
        int i;
        while ((i = fileReader.read()) != -1) {
            System.out.print((char) i);
        }
        fileReader.close();
    }
}

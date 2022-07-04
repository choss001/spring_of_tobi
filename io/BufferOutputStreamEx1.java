package io;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferOutputStreamEx1 {
    public static void main(String[] args) {
        try{
            FileOutputStream fos =
                    new FileOutputStream("123.txt");
            BufferedOutputStream bos =
                    new BufferedOutputStream(fos, 5);

            for (int i = '1'; i <= '9'; i++) {
                bos.write(i);
            }
            bos.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

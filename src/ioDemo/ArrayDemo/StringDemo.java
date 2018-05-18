package ioDemo.ArrayDemo;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

// �ַ�����
public class StringDemo {

    public static void main(String[] args) throws IOException {
        StringWriter writer = new StringWriter();
        writer.write("�ַ�����������鷳");

        StringReader reader = new StringReader(writer.toString());
        char[] buffer = new char[5];
        int len;
        while ((len = reader.read(buffer)) > 0) {
            System.out.print(new String(buffer, 0, len));
        }
        // StringWriter ���� close() ��Ч������ StringReader ���� close() ����Ч��
        reader.close();
        System.out.println();
    }

}

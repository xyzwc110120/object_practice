import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PracticeThrows implements PracticeThrowsParent {

    public static void main(String[] args) {
    }

    @Override
    public void throwsDemo() throws NullPointerException, ArithmeticException {
    }

    public void enhanceThrowDemo() throws IOException {
        try (OutputStream out = new FileOutputStream("")) {
            // 可能会出现异常的代码
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

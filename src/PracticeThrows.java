import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class PracticeThrows implements PracticeThrowsParent {

    public static void main(String[] args) {
    }

    /*
        方法的覆盖（Override）：
            一同：方法的签名必须相同。
            两小：
                1、子类方法的返回类型和父类方法返回类型相同或者是子类。
                2、子类方法可以同时声明抛出多个属于父类方法声明抛出的异常类型的子类。
            一大：子类的方法权限必须大于等于父类方法的访问权限。
    */
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

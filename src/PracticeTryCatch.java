public class PracticeTryCatch {

    public static void main(String[] args) {
        tryCatchDemo1("10", "2b");
        tryCatchDemo2("10", "0");
    }

    private static void tryCatchDemo1(String input1, String input2) {
        try {
            Integer num1 = Integer.valueOf(input1);
            Integer num2 = Integer.valueOf(input2);

            Integer quotient = num1 / num2;
            System.out.println(quotient);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println("数字格式异常");
        } catch (ArithmeticException e) {
            e.printStackTrace();
            System.out.println("算数异常");
        } catch (Exception e) {         // 所有异常的父类，可以捕获所有异常，有时候不知道会发生其他什么异常，所以最后用父类异常捕捉
            // Exception 只能在捕获异常的最后，因为可以捕获所有异常，如果放在前面，则后面的catch根本不会执行到
            e.printStackTrace();
        }
    }

    private static void tryCatchDemo2(String input1, String input2) {
        try {
            Integer num1 = Integer.valueOf(input1);
            Integer num2 = Integer.valueOf(input2);

            Integer quotient = num1 / num2;
            System.out.println(quotient);
        } catch (NumberFormatException | ArithmeticException e) {
            e.printStackTrace();
            System.out.println("输入问题");
        } catch (Exception e) {         // 在一个catch块中捕获多以场时，多个异常类型是不相交的，所以Exception不可和其子类在一个catch中捕获
            e.printStackTrace();
        }
    }

}

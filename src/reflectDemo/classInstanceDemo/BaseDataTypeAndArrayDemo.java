package reflectDemo.classInstanceDemo;

public class BaseDataTypeAndArrayDemo {

    public static void main(String[] args) {
        /*
        Class 类的实例表示正在运行的 Java 应用程序中的类和接口。枚举是一种类，注释是一种接口。
        每个数组属于被映射为 Class 对象的一个类，所有具有相同元素类型和维数的数组都共享该 Class 对象。
        基本的 Java 类型（boolean、byte、char、short、int、long、float 和 double）和关键字 void 也表示为 Class 对象
        */
        // 8大基本数据类型的 Class 实例
        Class intClass1 = int.class;
        // 因为泛型类型只能使用引用类型，不能使用基本类型，所以这里的泛型要用基本类型的封装类型
        // Class<byte> byteClass = byte.class;
        Class<Byte> byteClass = byte.class;

        // Integer 的字节码对象和 int 的字节码对象相同吗？ false ，得出 Integer 和 int 是不同的数据类型
        System.out.println(intClass1 == Integer.class);     // false
        // 在八大基本数据类型的包装类中，都有一个常量：TYPE ，用于返回该包装类型对应的基本类型的字节码对象
        System.out.println(Integer.TYPE == intClass1);      // true
        System.out.println("----------------------------------");


        /*
        如何来表示数组的 Class 实例：
                方式1：数组类型.class;
                方式2：数组对象.getClass();
        */
        int[] arr1 = {1, 2, 3};
        Class arr1Class = arr1.getClass();
        System.out.println(arr1Class);      // class [I

        // 所有的具有相同的维数（一维数组、二维数组）和相同的元素类型的数组共享同一个字节码对象，和元素没有关系。
        Class<int[]> arr2Class = int[].class;
        // 是否是同一份字节码
        System.out.println(arr1Class == arr2Class);     // true
        int[] arr3 = {4, 5, 1, 5};
        System.out.println(arr1Class == arr3.getClass());       // true
        // 二维数组
        int[][] arr4 = {};
        System.out.println(arr1Class == arr4.getClass());       // false
        byte[] arr5 = {1, 2, 3};
        System.out.println(arr1Class == arr5.getClass());       // false

    }

}

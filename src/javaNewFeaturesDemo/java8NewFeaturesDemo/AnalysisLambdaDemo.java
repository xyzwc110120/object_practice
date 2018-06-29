package javaNewFeaturesDemo.java8NewFeaturesDemo;

import java.util.Arrays;
import java.util.Comparator;

class Student {
    public String name;
    public int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Studen{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

// Lambda 表达式的简单分析
public class AnalysisLambdaDemo {

    public static void main(String[] args) {
        Student[] students = new Student[]{
                new Student("熊大", 75),new Student("熊二", 80),
                new Student("光头", 69),new Student("八哥", 90),};

        newSort1(students);
        newSort2(students);

        newTread1();
        newTread2();
    }

    /**
     * 通过学生分数排序，Java8 之前的排序写法
     */
    private static void oldSort(Student[] students) {
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                /*
                    这里直接用 int 类型相减来判断有个问题，就是第一个数为极大的正整型，第二个数为一个极小的负整形整型，
                    相减极有可能超出 int 的范围。所以这里使用 Integer 类中的 compare 方法（从 Java7 开始提供该方法）。
                */
                // return o1.score - o2.score;
                return Integer.compare(o1.score, o2.score);
            }
        });
        // Arrays.sort(students, (o1, o2) -> Integer.compare(o1.score, o2.score));
        System.out.println(Arrays.toString(students));
        System.out.println("-----------------------------------");
    }

    /**
     * Java8 中新的排序写法：Lambda 表达式
     */
    private static void newSort1(Student[] students) {
        /*
            在 sort 方法中我们可以确定3个一定的地方，因为是一定的，所以 JVM 在编译时可以推到出原来的写法：
                1)：sort 方法的第二个参数一定是 Comparator 接口的实现，那么我们就可以不写它：
                    Arrays.sort(students,
                        public int compare(Student o1, Student o2) {
                            return Integer.compare(o1.score, o2.score);
                        }
                    );

                2)：在 Comparator 接口中我们一定要实现 compare 方法，所以我们也不写它：
                    Arrays.sort(students,
                        public int (Student o1, Student o2) {
                            return Integer.compare(o1.score, o2.score);
                        }
                    );

                3)：compare 方法一定返回 int 类型的返回值，不写它，然后再参数列表和方法体之间加上“->”：
                    Arrays.sort(students,
                        (Student o1, Student o2) -> {
                            return Integer.compare(o1.score, o2.score);
                        }
                    );
        */
        Arrays.sort(students,
            (Student o1, Student o2) -> {
                return Integer.compare(o1.score, o2.score);
            }
        );
        System.out.println(Arrays.toString(students));
        System.out.println("-----------------------------------");
    }

    /**
     * 在 newSort1 的基础上，再进行 Lambda 表达式的简化
     */
    private static void newSort2(Student[] students) {
        /*
            如果代码块中只有一行代码，那么可以删掉花括号：
                Arrays.sort(students, (Student o1, Student o2) -> return Integer.compare(o1.score, o2.score); );

            Integer.compare 方法肯定会返回一个 int 值，而它再代码块中的目的就是为了返回 compare 方法的 int 值，所以 return 也删掉
                Arrays.sort(students, (Student o1, Student o2) -> Integer.compare(o1.score, o2.score); );

            表达式只是 sort 方法的第二个参数，所以表达式后面的分号不需要：
                Arrays.sort(students, (Student o1, Student o2) -> Integer.compare(o1.score, o2.score));
        */
        Arrays.sort(students, (Student o1, Student o2) -> Integer.compare(o1.score, o2.score));
        System.out.println(Arrays.toString(students));
        System.out.println("-----------------------------------");
    }

    /**
     * 在 newSort2 的基础上，再进行 Lambda 表达式的简化
     */
    private static void newSort3(Student[] students) {
        /*
            compare 方法的参数类型一定是 sort 中传入的数组的元素的类型，所以我们删掉 compare 方法的参数类型
        */
        Arrays.sort(students, (o1, o2) -> Integer.compare(o1.score, o2.score));
        System.out.println(Arrays.toString(students));
        System.out.println("-----------------------------------");
    }


    /**
     * Java8 之前启动线程的写法
     */
    private static void oldTread1() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程启动");
            }
        }).start();
    }

    private static void newTread1() {
        /*
            1)：Thread 类的构造器的参数一定是 Runnable 接口的实现：
                new Thread(
                    public void run() {
                        System.out.println("线程启动");
                    }
                ).start();

            2)：Runnable 接口一定要实现 run 方法，并且方法的返回值一定是 void
                new Thread(
                    () -> {
                        System.out.println("线程启动");
                    }
                ).start();
            3)：run 方法中只有一条语句：
                new Thread(() -> System.out.println("线程启动")).start();

            注意：不管方法中是否有参数，参数的括号一定要，为了说明这是一个方法
        */
        new Thread(() -> System.out.println("线程启动")).start();
    }

    /**
     * 将匿名内部类赋值给 Runnable 的引用，这样就可以多次使用
     */
    private static void oldTread2() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("启动一个线程");
            }
        };
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    private static void newTread2() {
        Runnable runnable = () -> System.out.println("启动一个线程");
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

}

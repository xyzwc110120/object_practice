import entity.Member;

public class PracticeObject2 {

    public static void main(String[] args) {
        // 匿名对象
        new Member();
        System.out.println("new Member == new Member：" + (new Member() == new Member()));
    }

}

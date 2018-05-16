import entity.Member;

/**
 * Created by BM0010 on 2017/6/5.
 */
public class PracticeObject2 {

    public static void main(String[] args) {
        // 匿名对象
        new Member();
        System.out.println("new Member == new Member：" + (new Member() == new Member()));
    }

}

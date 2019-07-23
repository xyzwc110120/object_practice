import entity.Member;

public class PracticeObject1 {

    public static void main(String[] args) {

        Member member1 = new Member();
        member1.name = "测试1";
        member1.age = 1;
        System.out.println("member1.name：" + member1.name);

        Member member2 = member1;
        System.out.println("member2.name：" + member2.name);

        Member member3 = new Member();
        member3.name = "测试1";
        member3.age = 1;

        member2.name = "测试2";
        System.out.println("member2.name：" + member2.name);
        System.out.println("member1.name：" + member1.name);
        System.out.println("member1.name == member3.name：" + (member1.name == member3.name) );

        System.out.println("对象　member1　地址：" + member1);
        System.out.println("对象　member2　地址：" + member2);
        System.out.println("对象　member3　地址：" + member3);
        System.out.println("member1 == member2：" + (member1 == member2));
        System.out.println("member1 == member3：" + (member1 == member3));

    }
}

package ioDemo.file.serializableDemo;

import java.io.Serializable;

// 实现 Serializable 接口对象
public class User implements Serializable {

    // 指定序列化版本
    private static final long serialVersionUID = 1066741276063733547L;

    private String nickname;
    private String sex;
    private Integer age;

    public User(String nickname, String sex, Integer age) {
        this.nickname = nickname;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "nickname='" + nickname + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}

package genericType;

// 点对象（记录坐标的x、y数据）
// 在本类中 T 表示一种类型，该类型具体是什么，由该类的调用者来决定
// 一般使用这4个字符来表示泛型： T：Type；  E：Element；  K：Key；  V：Value；
public class Point<T> {

    private T x;
    private T y;

    public T getX() {
        return x;
    }

    public void setX(T x) {
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public void setY(T y) {
        this.y = y;
    }
}

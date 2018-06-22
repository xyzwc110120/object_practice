package javaNewFeaturesDemo.java5NewFeaturesDemo;

// 购物车类
class ShoppingCar {

    private String name;
    private Integer quantity;
    private Integer price;

    public ShoppingCar() {
    }

    public ShoppingCar(String name, Integer quantity, Integer price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ShoppingCar{" +
                "name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getPrice() {
        return price;
    }

}

// 可变参数示例
public class VarargsDemo {

    public static void main(String[] args) {
        ShoppingCar car1 = new ShoppingCar("飞机玩具", 5, 100);
        ShoppingCar car2 = new ShoppingCar("坦克玩具", 20, 200);
        ShoppingCar car3 = new ShoppingCar("汽车玩具", 15, 60);

        // 用数组的方式
        // System.out.println(getTotalPrice(new ShoppingCar[]{car1, car2, car3}));

        // 用可变参数的方式
        System.out.println(getTotalPrice(car1, car2, car3));
        // 编译后
        // System.out.println(getTotalPrice(new ShoppingCar[] { car1, car2, car3 }));
    }

    /**
     * 用数组的方式传入多参数
     */
    /*private static Integer getTotalPrice(ShoppingCar[] cars) {
        Integer totalPrice = 0;
        if (cars != null) {
            for (ShoppingCar car : cars) {
                totalPrice += (car.getQuantity() * car.getPrice());
            }
        }
        return totalPrice;
    }*/

    /**
     * 用可变参数的方式传入参数
     * （若没有屏蔽 getTotalPrice(ShoppingCar[] cars) 方法，则会报错方法重复，所以可以看出可变参数其实就是数组）
     */
    private static Integer getTotalPrice(ShoppingCar... cars) {
        Integer totalPrice = 0;
        if (cars != null) {
            for (ShoppingCar car : cars) {
                totalPrice += (car.getQuantity() * car.getPrice());
            }
        }
        return totalPrice;
    }

}

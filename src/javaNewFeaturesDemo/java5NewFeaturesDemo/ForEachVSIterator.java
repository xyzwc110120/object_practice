package javaNewFeaturesDemo.java5NewFeaturesDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// for-each 和 Iterator
public class ForEachVSIterator {

    public static void main(String[] args) {
        List<ShoppingCar> cars = new ArrayList<>();
        cars.add(new ShoppingCar("飞机", 5, 500));
        cars.add(new ShoppingCar("坦克", 10, 300));
        cars.add(new ShoppingCar("汽车", 20, 100));

        // 使用 for-each 遍历
        for (ShoppingCar car : cars) {
            /*
                java.util.ConcurrentModificationException：并发修改异常：
                    因为在迭代 Collection 对象时，会产生另一个线程生成一个相同的集合副本，
                    若源集合与集合副本的元素数量不一致，便会产生异常。
                    所以不可以在迭代时使用 Collection 对象的 remove 方法，但是可以修改几何元素，因为集合数量没变
            */
            /*if (car.getPrice() < 300) {
                cars.remove(car);
            }*/
            System.out.println(car);
        }
        System.out.println("-----------------------------------");

        // 使用 Iterator 遍历
        for (Iterator<ShoppingCar> iterator = cars.iterator(); iterator.hasNext(); ) {
            // 如果要在迭代是删除集合中的元素，使用迭代器中的 remove 方法，因为它会把源集合和集合副本同步
            ShoppingCar car = iterator.next();
            if (car.getPrice() < 300) {
                iterator.remove();
            }
            System.out.println(car);
        }
        System.out.println(cars);
    }

}

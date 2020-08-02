package ru.job4j.pojo;

public class Shop {
    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 10);
        products[1] = new Product("Bread", 4);
        products[2] = new Product("Egg", 19);
        System.out.println(Shop.indexOfNull(products));
    }

    public static int indexOfNull(Product[] products) {
        int empty = -1;
        for (int index = 0; index < products.length; index++) {
            if (products[index] == null) {
                empty = index;
                break;
            }
        }
        return empty;
    }
}

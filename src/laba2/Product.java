package laba2;

class Product {
    private String name;
    private float price;
    private int amount;

    Product(String sName, float sPrice, int sAmount){
        name = sName;
        price = sPrice;
        amount = sAmount;
    }

    void printProductInfo(){
        System.out.println("Product is " + name + ": price - " + price + ", amount - " + amount);
    }

    String getName(){
        return this.name;
    }

    float getPrice(){
        return this.price;
    }

    int getAmount(){
        return this.amount;
    }
}

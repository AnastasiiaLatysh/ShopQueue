package laba2;

import java.util.Scanner;

class Shop {
    private String name;
    private String address;
    private String city;
    private String street;
    private String buildNumber;
    int nomenclature;
    Product[] products;

    Shop(String sName, String sCity, String sStreet, String sBuildNumber, int sNomenclature){
        name = sName;
        city = sCity;
        street = sStreet;
        buildNumber = sBuildNumber;
        nomenclature = sNomenclature;
        address = "Shop's address is: " + city + ", " + street + ", " + buildNumber;
        products = new Product[nomenclature];
    }

    void printShopInfo(){
        System.out.println("\nShop is " + name + ". " + address + ". Amount of nomenclature is " + nomenclature + ".");
    }

    void addProduct(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scan.next();
        System.out.println("Enter product price: ");
        float price = scan.nextFloat();
        System.out.println("Enter product amount: ");
        int amount = scan.nextInt();

        if (productIndex() != -1)
            products[productIndex()] = new Product(name, price, amount);
    }

    private int productIndex(){
        int result = -1;
        for(int i = 0; i < products.length; i++){
            if (products[i] == null) {
                result = i;
                break;
            }
        }
        return result;
    }

    float getCostOfProduct(String productName){
        float result = 0;
        for (Product product : products) {
            if (product.getName().toLowerCase().equals(productName.toLowerCase())) {
                result += product.getAmount() * product.getPrice();
            }
        }
        return result;
    }
}

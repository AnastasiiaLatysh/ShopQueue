package laba2;

import java.util.Iterator;
import java.util.Scanner;

class Helpers {

    static void addShopToQueue(ShopsQueue shopsQueue, Scanner scan) {
        do {
            shopsQueue.insert(createShop(scan));
            System.out.println("Shop added to the queue!)");
            System.out.println("Do you want to continue to add shops? y/n");
            String userInput = scan.next();
            if (userInput.equals("n"))
                break;
        } while (true);
    }

    static Shop createShop(Scanner scan) {
        System.out.println("Enter shop name: ");
        String name = scan.next();
        System.out.println("Enter shop city: ");
        String city = scan.next();
        System.out.println("Enter shop street: ");
        String street = scan.next();
        System.out.println("Enter shop build number: ");
        String buildNumber = scan.next();
        System.out.println("Enter shop amount of products' nomenclature: ");
        int nomenclature = scan.nextInt();

        Shop shop = new Shop(name, city, street, buildNumber, nomenclature);

        System.out.println("Let's add products to this shop");

        for (int i = 0; i < nomenclature; i++)
            shop.addProduct();

        return shop;
    }

    static void printTotalCostOfProduct(ShopsQueue shopsQueue, Scanner scan){
        do{
            System.out.println("Enter product name: ");
            String productName = scan.next();
            float result = 0;

            for (Iterator<Shop> it = shopsQueue.iterator(); it.hasNext(); ) {
                Shop shop = it.next();
                result += shop.getCostOfProduct(productName);
            }

            System.out.println("Total cost of product with name " + productName + " is: " + result);
            System.out.println("Do you want to calculate cost of other product? y/n");
            String userInput = scan.next();
            if (userInput.equals("n"))
                break;
        } while (true);

    }

    static void actionsSwitcher(ShopsQueue shopsQueue, Scanner scan){
        System.out.println("What do you want to do next?");
        String action = scan.next();

        while (!action.equals("exit")) {
            switch (action) {
                case "rm":
                    shopsQueue.remove();
                    break;
                case "in":
                    shopsQueue.insert(Helpers.createShop(scan));
                    break;
                case "br":
                    shopsQueue.browseCurrentQueue();
                    break;
                case "cl":
                    Helpers.printTotalCostOfProduct(shopsQueue, scan);
            }
            System.out.println("What do you want to do next?");
            System.out.println("You have next options: 'in' - insert, 'rm' - remove, 'br' - browse, " +
                    "'cl' - calculate total cost of product");
            action = scan.next();
        }
    }

    static void greetingsAndAddInitialShops(ShopsQueue shopsQueue, Scanner scan){
        System.out.println("Let's check working of shops' queue. Please, enter 'exit' if you want to stop program");
        System.out.println("You have next options: 'in' - insert, 'rm' - remove, 'br' - browse, " +
                "'cl' - calculate total cost of product");
        System.out.println("Firstly, let's create and add some shops to queue");
        Helpers.addShopToQueue(shopsQueue, scan);
        System.out.println("You have next options: 'in' - insert, 'rm' - remove, 'br' - browse, " +
                "'cl' - calculate total cost of product");
    }
}

package laba2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ShopsQueue shopsQueue = new ShopsQueue();
        Scanner scan =  new Scanner(System.in);
        Helpers.greetingsAndAddInitialShops(shopsQueue, scan);
        Helpers.actionsSwitcher(shopsQueue, scan);
    }
}

package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            double price = sc.nextDouble();
            if (ch == 'c') {
                Product prod = new Product(name, price);
                list.add(prod);
            } else if (ch == 'i') {
                System.out.print("Customs fee: ");
                double customsFee = sc.nextDouble();
                Product prod = new ImportedProduct(name, price, customsFee);
                list.add(prod);
            } else if (ch == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String date = sc.next();
                Product prod = new UsedProduct(name, price, sdf.parse(date));
                list.add(prod);
            }
        }

        System.out.printf("%nPRICE TAGS:%n");
        for (Product prod : list) {
            System.out.println(prod.priceTag());
        }

        sc.close();

    }
}

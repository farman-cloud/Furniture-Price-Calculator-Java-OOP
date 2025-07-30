import java.util.Objects;
import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Customer Name");
        String customerName = scanner.next();
        System.out.println("Enter Phone Number");
        long phoneNumber = scanner.nextLong();
        scanner.nextLine();
        System.out.println("Enter Address");
        String address = scanner.nextLine();
        System.out.println("Enter Bero Type");
        String beroType = scanner.nextLine();
        Discount discount = new Discount();
        if (Objects.equals(beroType, "Steel Bero")) {
            System.out.println("Enter Bero Color");
            String beroColor = scanner.next();
            System.out.println("Enter Bero Height");
            int beroHeight = scanner.nextInt();
            SteelBero steelbero = new SteelBero(beroType, beroColor, beroHeight);
            steelbero.calculatePrice();
            System.out.println("Amount needs to be paid "+(steelbero.getPrice() - discount.calculateDiscount(steelbero)));
        } else if (Objects.equals(beroType, "Wooden Bero")) {
            System.out.println("Enter Bero Color");
            String beroColor = scanner.next();
            scanner.nextLine();
            System.out.println("Enter Wood Type");
            String woodType = scanner.nextLine();
            WoodenBero woodenBero = new WoodenBero(beroType, beroColor, woodType);
            woodenBero.calculatePrice();
            System.out.println("Amount needs to be paid "+(woodenBero.getPrice() - discount.calculateDiscount(woodenBero)));
        }

    }
}

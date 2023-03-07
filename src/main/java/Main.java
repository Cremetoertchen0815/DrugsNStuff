import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var cartel = new SinaloaCartel();
        var scanner = new Scanner(System.in);
        System.out.println("Enter number of sub location to order drugs:");
        while (true) {
            System.out.println("location-");
            var i = scanner.nextInt();
            if (i > 20 || i < 1) {
                System.out.println("Invalid number!");
                continue;
            }
            cartel.getSubLocations()[i].requestDrugs();
            var msa = new MSA(cartel);
            try {
                msa.crackRequest(cartel.getSubLocations()[i].getDrugRequest());
            } catch (Exception e) {
                System.out.println(e);
            }
        }


    }
}

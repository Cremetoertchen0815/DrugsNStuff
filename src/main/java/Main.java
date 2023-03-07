import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws RSACrackerException {
        var cartel = new SinaloaCartel();
        var scanner = new Scanner(System.in);
        var msa = new MSA(cartel);
        System.out.println("Enter number of sub location to order drugs:");
        while(true) {
            System.out.println("location-");
            var i = scanner.nextInt();
            if (i > 20 || i < 1) {
                System.out.println("Invalid number!");
                continue;
            }
            cartel.getSubLocations()[i].requestDrugs();
            //Uncomment, when encryption and decryption of rsa is implemented
//            msa.crackRequest(cartel.getSubLocations()[i].getDrugRequest());
        }
    }
}

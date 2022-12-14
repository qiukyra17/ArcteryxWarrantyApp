import Service.Cancel;
import Service.Request;
import Service.Status;
import Service.Update;
import org.apache.log4j.Logger;


import java.io.FileNotFoundException;
import java.util.Scanner;

public class arcteryxWarrantyMenu {
    //In this app users will be able to request, check status, and/or cancel their request
    public static void main(String[] args) throws FileNotFoundException {

        Logger logger = Logger.getLogger(arcteryxWarrantyMenu.class);
        logger.info("App Started");

        ReadFile rf = new ReadFile("src/main/resources/Welcome");
        rf.ReadFiletoMenu();

        Request r = new Request();
        Status s = new Status();
        Update u = new Update();
        Cancel c = new Cancel();

        boolean usingApp = true;
        while (usingApp) {
            Scanner input = new Scanner(System.in);
            System.out.println("Type Option for Warranty: Request - Status - Cancel - Update - Exit");
            String userInput = input.nextLine();
            if (userInput.equals("Exit")) {
                usingApp = false;
                logger.info("App Exited");
            }
            else if (userInput.equals("Request")) {
                System.out.println("Please type Name");
                String name = input.nextLine();
                System.out.println("Please type Email");
                String email = input.nextLine();
                System.out.println("Please type Phone");
                String phone = input.nextLine();
                r.addCustomerInformation(name, email, phone);

                System.out.println("Please type enter the number corresponding to the brand: 1:Arcteryx - 2:Veilance " +
                        "- 3:System_A");
                int brandID = input.nextInt();
                int customerID = r.getCustomerIdByEmail(email);
                System.out.println("Name of Product/Product Type - Ex: Men's Beta AR Jacket");
                String productType = new Scanner(System.in).nextLine();
                System.out.println("What is the issue? - Ex: Hem of Jacket is starting to delaminate");
                String productIssue = new Scanner(System.in).nextLine();
                String status = "New";
                r.addWarrantyInformation(customerID, brandID, productType, productIssue, status);
                int warrantyNo = r.getWarrantyIDFromWarrantyInfo(customerID, brandID, productType, productIssue,
                        status);
                System.out.println("Your Warranty Number: " + warrantyNo);

            } else if (userInput.equals("Status")) {
                System.out.println("Please Type in Warranty Number");
                int warrantyNo = input.nextInt();
                if (s.getAllWarrantyInfoByWarrantyNo(warrantyNo) == null) {
                    System.out.println("This warranty does not exist");
                } else
                    System.out.println(s.getAllWarrantyInfoByWarrantyNo(warrantyNo));
            }
            else if(userInput.equals("Update")){
                System.out.println("Please Type in Warranty Number");
                int warrantyNo = input.nextInt();
                System.out.println("Please Type in Status Change");
                String status = new Scanner(System.in).nextLine();
                u.updateWarrantyInformation(status,warrantyNo);
            }
            else if (userInput.equals("Cancel")) {
                System.out.println("Please enter Warranty Number");
                int warrantyNo = input.nextInt();
                c.deleteWarrantyInformation(warrantyNo);
            }
        }

    }
}


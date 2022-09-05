import DAO.CancelRepo;
import DAO.RequestRepo;
import DAO.StatusRepo;
import Service.Cancel;
import Service.Request;
import Service.Status;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Scanner;

public class arcteryxWarrantyMenu {
    /*
    In this app users will be able to request, check status, and/or cancel their request
     */

    public static void main(String[] args) throws FileNotFoundException {

        ReadFile rf = new ReadFile("src/main/resources/Welcome");
        rf.ReadFiletoMenu();

        //need boolean to be sure the user wants to use or exit
        Request r = new Request();
        RequestRepo rr = new RequestRepo();
        Status s = new Status();
        Cancel c = new Cancel();

        boolean usingApp = true;
        while (usingApp) {
            Scanner input = new Scanner(System.in);
            System.out.println("Select Option for Warranty: Request - Status - Cancel - Exit");
            String userInput = input.nextLine();
            if (userInput.equals("Exit")) {
                usingApp = false;
            } else if (userInput.equals("Request")) {
                //ADD - new request - ContactInfo - Brand - ProductInfo
                //All input should INSERT into your TABLE
                System.out.println("Please provide contact information: Name");
                String name = input.nextLine();
                System.out.println("Please provide contact information: Email");
                String email = input.nextLine();
                System.out.println("Please provide contact information: Phone");
                String phone = input.nextLine();
                r.addCustomerInformation(name, email, phone);

                // could we add something to tell the user this is your customerID

                System.out.println("Please type enter the number corresponding to the brand: 1:Arcteryx - 2:Veilance " +
                        "- " +
                        "3:System_A");
                int brandID = input.nextInt();
//                System.out.println("Please provide your: Customer ID");
//                int customerID = input.nextInt();
                int customerID = r.getCustomerIdByEmail(email);
                System.out.println("What type of product is it? Example: Jacket");
                input = new Scanner(System.in);
                String productType = input.nextLine();
                System.out.println("What is the issue? Example: Hem of Jacket is starting to delaminate");
                String productIssue = input.nextLine();
                String status = "New";
                r.addWarrantyInformation(customerID, brandID, productType, productIssue, status);
                //This is your Warranty Number:
                int warrantyNo = r.getWarrantyIDFromWarrantyInfo(customerID, brandID, productType, productIssue,
                        status);
                System.out.println("Your Warranty Number: " + warrantyNo);


            } else if (userInput.equals("Status")) {
                //Look up status through the unique identifier OR through email
                System.out.println("Please Type in Warranty Number");
                int warrantyNo = input.nextInt();
                if (s.getAllWarrantyInfoByWarrantyNo(warrantyNo) == null) {
                    System.out.println("This warranty does not exist");
                } else
                    System.out.println(s.getAllWarrantyInfoByWarrantyNo(warrantyNo));
            } else if (userInput.equals("Cancel")) {
                //Look up status through the unique identifier OR through email AND DELETE IT
                System.out.println("Please enter Warranty Number");
                int warrantyNo = input.nextInt();
                c.deleteWarrantyInformation(warrantyNo);
            }
        }

    }
}


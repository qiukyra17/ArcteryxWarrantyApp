import Service.Request;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class arcteryxWarrantyMenu {
    /*
    In this app users will be able to request, check status, and/or cancel their request
     */

    //Before presenting menu, there will be a Welcome bit
    public static void main(String[] args) throws FileNotFoundException {
        ReadFile rf = new ReadFile("C:\\Users\\kywahhhhhhh\\IdeaProjects\\arcteryxWarrantyApp\\src\\main\\resources" +
                "\\Welcome");
        while (rf.fileHasText()) {
            System.out.println(rf.readNextLine());
        }

        //need boolean to be sure the user wants to use or exit

        boolean usingApp = true;
        Request r = new Request();
        while (usingApp) {
            Scanner input = new Scanner(System.in);
            System.out.println("Select Option for Warranty: Request - Status - Cancel - Exit");
            String userInput = input.nextLine();
            if (userInput.equals("Exit")) {
                usingApp = false;
            }
            else if (userInput.equals("Request")) {
                //ADD - new request - ContactInfo - Brand - ProductInfo
                //All input should INSERT into your TABLE
                System.out.println("Please provide contact information: Name");
                String name = input.nextLine();
                System.out.println("Please provide contact information: Email");
                String email = input.nextLine();
                System.out.println("Please provide contact information: Phone");
                int phone = Integer.parseInt(input.nextLine());
                r.addCustomerInformation(name,email,phone);

                System.out.println("Please pick Brand: Arcteryx - Veilance - System_A");
                String brand = input.nextLine();
                System.out.println("Please provide: Product Type - Production Year - Issue");
                String productIssue = input.nextLine();
                //see if SQL output aa unique identifier for the user
            }
            else if (userInput.equals("Status")) {
                //Look up status through the unique identifier OR through email
                System.out.println("Please Type in ");
                String customerName = input.nextLine();
            }
            else if (userInput.equals("Cancel")) {
                //Look up status through the unique identifier OR through email AND DELETE IT
            }

        }
    }
}


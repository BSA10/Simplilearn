import java.util.Scanner;

public class prototype {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // for get the user input
        OperationFiles operationFiles = new OperationFiles(); // instance object to call methods that we need to add,delete,search,get.

        System.out.println("=== Welcome to LockedMe.com. ===\n=== Developer: BASSAM ALHARBI. ===\n");

        while (true) {

            System.out.println("\nThere is three generic feature:" +
                    "\n1. Retrieving the file names." +
                    "\n2. Business-level operations." +
                    "\n3. Close the application.\n");


            System.out.print("Enter the number: ");
            int enteredNumber = sc.nextInt();

            if (enteredNumber == 1) {
                System.out.println("\nThis is the files in the directory: \n");
                for (String tempFile : operationFiles.getFiles()){
                    System.out.println(tempFile);
                }
                operationFiles.checkContinue();// ask the user of he want to continue with the options

            } else if (enteredNumber == 2) {
                while (true) { // loop to make sure the application doesn't close unless the user ask for it.
                    System.out.println("\nThe business-level operations is:" +
                            "\n1. Add file in existing directory." +
                            "\n2. Delete a specific file in the existing directory." +
                            "\n3. Search for a specific file." +
                            "\n4. Return to the main.\n");

                    System.out.print("Enter the number:");
                    int enteredBusinessOperation = sc.nextInt();

                    if (enteredBusinessOperation == 1) {
                        System.out.print("Name the file: ");
                        String fileName = sc.next();
                        operationFiles.addFile(fileName); // call the method addFile
                        operationFiles.checkContinue();// ask the user of he want to continue with the options

                    } else if (enteredBusinessOperation == 2) {
                        System.out.print("Name the file to delete: ");
                        String fileName = sc.next();
                        operationFiles.deleteFile(fileName); // call a method deleteFile with specific fileName from the user
                        operationFiles.checkContinue();// ask the user of he want to continue with the options
                    } else if (enteredBusinessOperation == 3) {
                        System.out.print("Enter the name of the file: ");
                        String nameOfTheFile = sc.next();
                        operationFiles.searchFile(nameOfTheFile); //call a method searchFile with specific fileName from the user
                        operationFiles.checkContinue(); // ask the user of he want to continue with the options

                    } else if (enteredBusinessOperation == 4) {
                         break; // break to cut off and get to main while loop
                    }
                }
            } else if (enteredNumber == 3) {
                System.exit(0); // end the application.
            }


        }

    }

}

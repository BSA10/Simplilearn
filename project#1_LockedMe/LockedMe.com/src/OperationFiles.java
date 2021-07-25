import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class OperationFiles implements file {

    private File file;
    private SortingAlgo sortingAlgo;
    @Override
    public String[] getFiles() { // get files in ascending order by using Bubble Sort
        file = new File("."); // reference the directory
        sortingAlgo = new SortingAlgo(); // create object of SortingAlgo

        String fileNames[] = file.list(); // make the file names into String array
        sortingAlgo.bubbleSort(fileNames, fileNames.length); // sorting with bubble sort algorithms with string array
        return fileNames; // return string array sorted
    }

    @Override
    public void addFile(String fileName) {
        if(!fileExist(fileName)){ // check if the fileName doesn't exist
            try{
                createFile(fileName); // create the file
                System.out.println("The file is created.\n");
            }
            catch (IOException e){ // catch the exception and print message
                System.out.println("Try Another Name.");
            }
        }
        else
            System.out.println("Try Another Name.");
    }


    public ArrayList<String> getFileNames(){
        file = new File("."); // reference the directory
        ArrayList<String> filesExist = new ArrayList<String>(); // make an ArrayList
        if(file.isDirectory()) // check if the refrence file i create is directory or not.
            for (File tempfile : file.listFiles()) // for loop to check every file in the directory
                filesExist.add(tempfile.getName()); // add the file in the arrayList

        return filesExist; // return the file names with ArrayList type
    }

    @Override
    public void searchFile(String fileName) { // search a specific file name
        if (fileName.isBlank() || fileName.equals(".")) // check if the file name blank or "."
            getFiles(); // call the method getFiles to get all the files in ascending order for more efficient way
        else {
            boolean found = false , foundFolder = false;
            for (String tempFileName : getFileNames()) {
                if (getFile(fileName).isDirectory()) { // check if it folder or not
                    foundFolder = true;
                    break;
                }
                if (fileName.equals(tempFileName)) {
                    found = true;
                    break;
                }
            }

            if (found) // if the file found will print message
                System.out.println("The file is found");
            else if (foundFolder)
                System.out.println("The folder is found"); // if the it folder
            else
                System.out.println("The file is not found"); // if the file or folder not found .
        }

    }


    @Override
    public void deleteFile(String fileName){
        if(fileExist(fileName)){ // check first if it exist
            getFile(fileName).deleteOnExit(); // delete a file if exist
            System.out.println("The file is deleted.");
        }
        else{
            System.out.println("The File not found."); // otherwise will display message
        }
    }

    @Override
    public File getFile(String fileName){
        File tempFile = new File(fileName);
        return tempFile; // return a specific file name with File type
    }
    @Override
    public boolean fileExist (String fileName){ // check if the file exist
        File file = new File(fileName);
        if(file.exists())
            return true;
        else
            return false;
    }
    @Override
    public boolean createFile (String fileName) throws IOException { // create a file with specific name and throws IOException if get Error
        return new File(fileName).createNewFile();
    }

    @Override
    public void checkContinue(){ // this for reading the options on the main class so the user doesn't miss chance of reading
        Scanner sc = new Scanner(System.in);
        System.out.print("\nDo you want to continue ? (Press Enter): "); // i ask the user everytime if he want to continue with the options
        String answer = sc.nextLine(); // all he need just press enter
    }
}

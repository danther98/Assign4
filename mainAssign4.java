import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class mainAssign4 { 
    static binaryHeap heap=new binaryHeap();
    static int patientCount=0;
    static int linecount=0;
    public static void main(String[] args){
        menu();
           //create priority queue with first priority of unos status and second priority of age (oldest first)
//create a menu with options to add a patient, peek at list, next patient, remove patient, size of list, and exit

//create a method to add a patient to the list


//create a method to peek at the list

//create a method to remove the next patient

//create a method to remove a patient

//create a method to return the size of the list

//create a method to exit the program
}
//create menu method
public static void menu(){
//create menu header text
//clear screen
System.out.print("\033\143");

System.out.println("+-----------------------------------------------------+");
System.out.println("| Welcome to the Main menu of Heart Transplant Queue  |");
System.out.println("+-----------------------------------------------------+");
System.out.println("Please select an option from the menu below");


    System.out.println("1. Read patient data" );
    System.out.println("2. Peek at list");
    System.out.println("3. Next patient");
    System.out.println("4. Remove patient");
    System.out.println("5. Size of list");
System.out.println("6. Find all patients with status");
    System.out.println("7. Set patient Unos Status");
    System.out.println("8. Exit");
    System.out.println("");
    System.out.println("Enter a number: ");
    Scanner input=new Scanner(System.in);
    int choice=input.nextInt();
    switch(choice){
        case 1:
           //read data method
            readData();
            System.out.println("Data has been read");
            System.out.println("Returning to main menu");
            //wait 1.5 seconds
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
          
           
            
            menu();
            break;
        case 2:
        System.out.print("\033\143");
            peek();
            //wait to return to menu until user presses enter
            System.out.println("");
            System.out.println("Press enter to return to menu");
            Scanner input2=new Scanner(System.in);
            String choice2=input2.nextLine();

            menu();
            break;
        case 3:
            System.out.print("\033\143");
            nextPatient();
            System.out.println("");
            System.out.println("Press enter to return to menu");
            Scanner input3=new Scanner(System.in);
            String choice3=input3.nextLine();
            menu();
            break;
        case 4:
        System.out.print("\033\143");
            deletePatientMenu();
            System.out.println("");
            System.out.println("Press enter to return to menu");
            Scanner input4=new Scanner(System.in);
            String choice4=input4.nextLine();
            
            menu();
            break;
        case 5:
        System.out.print("\033\143");
            System.out.println("The Number of records in data base: "+heap.getSize());
            System.out.println("");
            System.out.println("Press enter to return to menu");
            Scanner input5=new Scanner(System.in);
            String choice5=input5.nextLine();
           
           menu();
            break;
        case 6:
        System.out.print("\033\143");
            System.out.println("Enter Status to search for (1A, 1B, 2, 7): ");
            Scanner input6=new Scanner(System.in);
            String choice6=input6.nextLine();
            searchStatus(choice6);
           System.out.println("");
           System.out.println("Press enter to return to menu");
           String innnnn=input6.nextLine();

           menu();
            break;
        case 7:
        System.out.print("\033\143");
        System.out.println("+---------------------------------+");
        System.out.println("| Patient UNOS Status Update Menu |");
        System.out.println("+---------------------------------+");
        System.out.println("");
        System.out.println("");
        System.out.println("Enter Patient First name: ");
        Scanner input7=new Scanner(System.in);
        String choice7=input7.nextLine();
        System.out.println("Enter Patient Last name: ");
       
        String choice8=input7.nextLine();
        System.out.println("Enter Patient Unos status (Status 1A, Status 1B, Status 2, Status 7): ");
        String choice9=input7.nextLine();
       heap.updateUnosStatus(choice7,choice8,choice9);
        System.out.println("");
        System.out.println("Press enter to return to menu");
        String innnn=input7.nextLine();
        menu();
            break;

        case 8:
            System.exit(0);
            break;
        default:
            System.out.println("Invalid choice");
            menu();
            break;
    }
}
private static void searchStatus(String choice6) {
    //search for all patients with a certain status
    System.out.println("Patients with that status: ");
    heap.findPatientsWithUnosStatus(heap.getUnosInt(choice6));
    //print out all patients with that status
    

}
static public void deletePatientMenu(){
    System.out.println("Enter the first name of the patient you want to delete: ");
    Scanner input=new Scanner(System.in);
    String firstName=input.nextLine();
    System.out.println("Enter the last name of the patient you want to delete: ");
    String lastName=input.nextLine();
    //show details of patient at found index
    System.out.println("Patient to be removed is ");
    heap.peek(heap.findPatientIndex(firstName,lastName));
    System.out.println("");
            System.out.println("Press enter to return to menu");
            Scanner inputr=new Scanner(System.in);
            String choicer=inputr.nextLine();
    removePatient(heap.findPatientIndex(firstName, lastName));

    menu();

}




public static void readData(){
        //read in text file deliminited by semi-colons
        BufferedReader bfReader=null;
        try{
            bfReader=new BufferedReader(new FileReader("C:\\Users\\danth\\Desktop\\Fall 2022\\Data Structures and Algorithm Analysis CS3353\\java\\Assign4\\Assign4\\inputFile.txt"));
            String line;
            while((line=bfReader.readLine())!=null){
                String[] data=line.split(";");
               //remove first line
                if(data[0].equals("first_name")){
                    //skip line in file
                    continue;
                }

                  
                //create new patient object
                Patient patient=new Patient();
                //set patient data
                patient.setFirstName(data[0]);
                patient.setLastName(data[1]);
                patient.setAddress(data[2]);
                patient.setCity(data[3]);
                patient.setCounty(data[4]);
                patient.setState(data[5]);
                patient.setZip(data[6]);
                patient.setPhone1(data[7]);
                patient.setPhone2(data[8]);
                patient.setEmail(data[9]);
                patient.setDateListed(data[10]);
                patient.setUnosStatus(data[11]);
                patient.setDateOfBirth(data[12]);
                System.out.println("DOB: "+data[12]+" Line "+linecount);
                patient.setAge(data[12]);
               heap.insert(patient);
               patientCount++;
               linecount++;
            }
        }catch(IOException e){
            e.printStackTrace();
    



    }
  








       
        //add patients to priority queue
       
        //print out patients in order of priority
      //  heap.printHeap();
       
    }
public static void peek(){
        //peek at the next patient
        System.out.println("Top priority patient: ");
        heap.peek();
    }
public static void nextPatient(){
        //remove highest priority patient and replace with second highest priority patient

        heap.remove();
    }
public static void removePatient(int index){
        //remove a patient
        heap.remove(index);
    }
public static void exit(){
        System.exit(0); //method to exit program 
    }
  
}


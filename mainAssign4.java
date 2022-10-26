import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class mainAssign4 { 
    static binaryHeap heap=new binaryHeap();
    static int patientCount=0;
    public static void main(String[] args){
       //create priority queue with first priority of unos status and second priority of age (oldest first)
//create a menu with options to add a patient, peek at list, next patient, remove patient, size of list, and exit

//create a method to add a patient to the list

readData();
peek();
//nextPatient();
//peek();
removePatient(0);
peek();
//create a method to peek at the list

//create a method to remove the next patient

//create a method to remove a patient

//create a method to return the size of the list

//create a method to exit the program
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
                patient.setAge(data[12]);
               heap.insert(patient);
               patientCount++;
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
        heap.peek();
    }
public static void nextPatient(){
        //remove the next patient
        heap.remove();
    }
    public static void removePatient(int index){
        //remove a patient
        heap.remove(index);
    }
}


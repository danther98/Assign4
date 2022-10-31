import java.time.LocalDate;

import javax.lang.model.element.Element;

public class binaryHeap {
    // create array of patients
    private Patient[] heap;
    // create size variable
    private int size;
    // create capacity variable
    private int capacity;

    // create constructor
    public binaryHeap() {
        // set capacity to 100
        capacity = 100;
        // set size to 0
        size = 0;
        // create array of patients
        heap = new Patient[capacity];
    }

    // create insert method
    public void insert(Patient patient) {
        // check if heap is full
        if (size == capacity) {
            // double capacity
            capacity = capacity * 2;
            // create new array
            Patient[] newHeap = new Patient[capacity];
            // copy old array to new array
            for (int i = 0; i < heap.length; i++) {
                newHeap[i] = heap[i];
            }
            // set heap to new array
            heap = newHeap;
        }
        // add patient to heap
        heap[size] = patient;
        // increment size
        size++;
        // call heapify up
        heapifyUp(size - 1);
        sortHeapByUnosStatusAndAge();
    }

    // create heapify up method
    public void heapifyUp(int index) {
        // check if index is greater than 0
        if (index > 0) {
            // create parent index
            int parentIndex = (index - 1) / 2;
            // check if parent is less than child
            if (heap[parentIndex].getUnosStatus() > heap[index].getUnosStatus()) {
                // swap parent and child
                Patient temp = heap[parentIndex];
                heap[parentIndex] = heap[index];
                heap[index] = temp;
            
                    heapifyUp(parentIndex);
                // call heapify up on parent

            }else {  
                    if(heap[parentIndex].getAge()<heap[index].getAge()){
                        // swap parent and child
                        Patient temp2 = heap[parentIndex];
                        heap[parentIndex] = heap[index];
                        heap[index] = temp2;
                        heapifyUp(parentIndex);

                    }
                      
                   }

               
        }
    }

    // create print heap method
    public void printHeap() {
        // loop through heap
        for (int i = 0; i < size; i++) {
            // print out patient
            System.out.println(heap[i].getFirstName() + " " + heap[i].getLastName() + " " + heap[i].getUnosStatus());
        }
    }

    public void peek() {
        // return the data of patient with highest priority
        System.out.println(" ");
        System.out.println(" ");
        //System.out.println("The patient detail with the highest priority is as follows:");
        System.out.println("Patient's First Name: " + heap[0].getFirstName());
        System.out.println("Patient's Last Name: " + heap[0].getLastName());
        System.out.println("Patient's date of Birth " + heap[0].getDateOfBirth());
        System.out.println("Patient's Address: " + heap[0].getAddress());
        System.out.println("Patient's City: " + heap[0].getCity());
        System.out.println("Patient's County: " + heap[0].getCounty());
        System.out.println("Patient's State: " + heap[0].getState());
        System.out.println("Patient's Zip: " + heap[0].getZip());
        System.out.println("Phone number (1st Preference): " + heap[0].getPhone1());
        System.out.println("Phone number (2nd Preference): " + heap[0].getPhone2());
        System.out.println("Patient's Email: " + heap[0].getEmail());
        System.out.println("Patient's Unos Status: " + heap[0].getUnosStatusName(heap[0].getUnosStatus()));
        System.out.println("Patient's Date listed on "+heap[0].getUnosStatusName(heap[0].getUnosStatus())+": " + heap[0].getDateListed());
        System.out.println(" ");
        System.out.println("Patient History: ");
        if(heap[0].changedUNOSStatus1==null){
        System.out.println("No History");
        }else{
        System.out.println("On "+heap[0].getDateChanged1()+", UNOS Status changed to "+heap[0].getChangedUNOSStatus1());
        }
        if(!(heap[0].changedUNOSStatus2==null)){
            System.out.println("On "+heap[0].getDateChanged2()+", UNOS Status changed to "+heap[0].getChangedUNOSStatus2());
        }
        if(!(heap[0].changedUNOSStatus3==null)){
            System.out.println("On "+heap[0].getDateChanged3()+", UNOS Status changed to "+heap[0].getChangedUNOSStatus3());
        }

    }

    public void remove() {
       
       //remove highest priority patient and set second highest to top
       //show patient that was removed details 
       System.out.println("Patient removed from the list is as follows:");
       System.out.println(" ");
         System.out.println("Patient's First Name: " + heap[0].getFirstName());
        System.out.println("Patient's Last Name: " + heap[0].getLastName());
        System.out.println("Patient's date of Birth " + heap[0].getDateOfBirth());
        System.out.println("Patient's Address: " + heap[0].getAddress());
        System.out.println("Patient's City: " + heap[0].getCity());
        System.out.println("Patient's County: " + heap[0].getCounty());
        System.out.println("Patient's State: " + heap[0].getState());
        System.out.println("Patient's Zip: " + heap[0].getZip());
        System.out.println("Phone number (1st Preference): " + heap[0].getPhone1());
        System.out.println("Phone number (2nd Preference): " + heap[0].getPhone2());
        System.out.println("Patient's Email: " + heap[0].getEmail());
        System.out.println("Patient's Unos Status: " + heap[0].getUnosStatusName(heap[0].getUnosStatus()));
        System.out.println("Patient's Date listed on "+heap[0].getUnosStatusName(heap[0].getUnosStatus())+": " + heap[0].getDateListed());
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Patient History: ");
        if(heap[0].changedUNOSStatus1==null){
        System.out.println("No History");
        }else{
        System.out.println("On "+heap[0].getDateChanged1()+", UNOS Status changed to "+heap[0].getChangedUNOSStatus1());
        }
        if(!(heap[0].changedUNOSStatus2==null)){
            System.out.println("On "+heap[0].getDateChanged2()+", UNOS Status changed to "+heap[0].getChangedUNOSStatus2());
        }
        if(!(heap[0].changedUNOSStatus3==null)){
            System.out.println("On "+heap[0].getDateChanged3()+", UNOS Status changed to "+heap[0].getChangedUNOSStatus3());
        }


      //heapify down to set second highest to top
        heap[0] = heap[size - 1];
        size--;
      //  heapifyDown(0);
      sortHeapByUnosStatusAndAge();
        
    }

    private void heapifyDown(int i) {
       
        int min = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        


       // create heapify down method
       //if unos status is equal then compare age
        if (left < size && heap[left].getUnosStatus() ==heap[min].getUnosStatus()) {
            if (heap[left].getAge() < heap[min].getAge()) {
                min = left;
            }
        }
        if (right < size && heap[right].getUnosStatus() ==heap[min].getUnosStatus()) {
            if (heap[right].getAge() < heap[min].getAge()) {
                min = right;
            }
        }
        if (left < size && heap[left].getUnosStatus() < heap[min].getUnosStatus()) {
            min = left;
        }
        if (right < size && heap[right].getUnosStatus() < heap[min].getUnosStatus()) {
            min = right;
        }


        if (left < size && heap[left].getUnosStatus() < heap[i].getUnosStatus()) {
            min = left;
        }
        if (right < size && heap[right].getUnosStatus() < heap[min].getUnosStatus()) {
            min = right;
        }
        if (min != i) {
            Patient temp = heap[i];
            heap[i] = heap[min];
            heap[min] = temp;
            //if unos status matches then use sortHeap() to sort by age
            
            sortHeapByUnosStatusAndAge();
           // heapifyDown(min);
        }

    }

    public void remove(int index) {
        // remove patient at index
        // set patient at index to last patient
        heap[index] = heap[size - 1];
        // decrement size
        size--;
        // call heapify down
       // heapifyDown(index);
        sortHeapByUnosStatusAndAge();
        peek(index);
    }

    public void peek(int index) {
        //show patient data at index
        System.out.println(" ");
        System.out.println(" ");
        //System.out.println("The patient detail with the highest priority is as follows:");
        System.out.println("Patient's First Name: " + heap[index].getFirstName());
        System.out.println("Patient's Last Name: " + heap[index].getLastName());
        System.out.println("Patient's date of Birth " + heap[index].getDateOfBirth());
        System.out.println("Patient's Address: " + heap[index].getAddress());
        System.out.println("Patient's City: " + heap[index].getCity());
        System.out.println("Patient's County: " + heap[index].getCounty());
        System.out.println("Patient's State: " + heap[index].getState());
        System.out.println("Patient's Zip: " + heap[index].getZip());
        System.out.println("Phone number (1st Preference): " + heap[index].getPhone1());
        System.out.println("Phone number (2nd Preference): " + heap[index].getPhone2());
        System.out.println("Patient's Email: " + heap[index].getEmail());
        System.out.println("Patient's Unos Status: " + heap[index].getUnosStatusName(heap[index].getUnosStatus()));
        System.out.println("Patient's Date listed on "+heap[index].getUnosStatusName(heap[index].getUnosStatus())+": " + heap[index].getDateListed());
        System.out.println(" ");
        System.out.println("Patient History: ");
        if(heap[index].changedUNOSStatus1==null){
        System.out.println("No History");
        }else{
        System.out.println("On "+heap[index].getDateChanged1()+", UNOS Status changed to "+heap[index].getChangedUNOSStatus1());
        }
        if(!(heap[0].changedUNOSStatus2==null)){
            System.out.println("On "+heap[index].getDateChanged2()+", UNOS Status changed to "+heap[index].getChangedUNOSStatus2());
        }
        if(!(heap[0].changedUNOSStatus3==null)){
            System.out.println("On "+heap[index].getDateChanged3()+", UNOS Status changed to "+heap[index].getChangedUNOSStatus3());
        }
        System.out.println(" ");
        System.out.println("The requested patient has been removed from the queue");
    }

    //method to find patient index
    public int findPatientIndex(String firstName, String lastName) {
        //loop through heap
        //set first name and last name to correct format first letter capital and rest lower case
        firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();
        //removing any spaces in the first name and last name
        firstName = firstName.replaceAll("\\s+", "");
        lastName = lastName.replaceAll("\\s+", "");
        
        for (int i = 0; i < size; i++) {
            //check if patient is in heap
            if (heap[i].getFirstName().equals(firstName) && heap[i].getLastName().equals(lastName)) {
                //return index
                return i;
            }
        }
        //return -1 if patient is not in heap
        return -1;
    }
    //method to find heap size
    public int getSize() {
        return size;
    }

    //method to sort heap based on age, oldest first
    public void sortHeap() {
        //loop through heap
        for (int i = 0; i < size; i++) {
            //loop through heap
            for (int j = 0; j < size; j++) {
                //if age is greater than age of next patient
                if (heap[i].getAge() > heap[j].getAge()) {
                    //swap patients
                    Patient temp = heap[i];
                    heap[i] = heap[j];
                    heap[j] = temp;
                }
            }
        }
    }
    //create method that sorts heap based on unos status, if unos status is equal then sort by age oldest first
    public void sortHeapByUnosStatusAndAge() {
        //loop through heap
        for (int i = 0; i < size; i++) {
            //loop through heap
            for (int j = 0; j < size; j++) {
                //if unos status is greater than unos status of next patient
                if (heap[i].getUnosStatus() < heap[j].getUnosStatus()) {
                    //swap patients
                    Patient temp = heap[i];
                    heap[i] = heap[j];
                    heap[j] = temp;
                }
                //if unos status is equal then sort by age oldest first
                if (heap[i].getUnosStatus() == heap[j].getUnosStatus()) {
                    if (heap[i].getAge() > heap[j].getAge()) {
                        //swap patients
                        Patient temp = heap[i];
                        heap[i] = heap[j];
                        heap[j] = temp;
                    }
                }
            }
        }
    }
    //find all patients with certain unos status
    public void findPatientsWithUnosStatus(int unosStatus) {
        //loop through heap
        System.out.printf("%-20s", "Patient's First Name: ");
        System.out.printf("%-40s %n", "Patient's Last Name: ");
        System.out.println("");
        
        for (int i = 0; i < size; i++) {
            //if unos status matches unos status passed in
            if (heap[i].getUnosStatus() == unosStatus) {
                //print patient data
                System.out.printf("%-20s", heap[i].getFirstName()); 
                System.out.printf("%-40s %n", heap[i].getLastName()); 
                
            }
        }
    }
    public int getUnosInt(String unosStatus){ //setting priority based on unos status
        
        switch(unosStatus){
            case "1A":
                return 1;
               
            case "1B":
                return 2;
           
            case "2":
                return 3;
              
            case "7":
                return 4;
            
            case "":
                return 4;
         

        }
        return 0;
    }
    //method to update patient Unos status and list current date as date listed
    public void updateUnosStatus(String firstName, String lastName, String unosStatus) {
        int patientIndexChanged = findPatientIndex(firstName, lastName);
      
        //set first name and last name to correct format first letter capital and rest lower case
        firstName = firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase();
        lastName = lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase();

        //removing any spaces in the first name and last name
        firstName = firstName.replaceAll("\\s+", "");
        lastName = lastName.replaceAll("\\s+", "");

        //removing "Status"or "status" from unos status input
        unosStatus = unosStatus.replaceAll("Status", "");
        unosStatus = unosStatus.replaceAll("status", "");
        //updating patient data
        heap[patientIndexChanged].setUnosStatus(unosStatus);
        heap[patientIndexChanged].addUnosStatusChange(unosStatus);
        heap[patientIndexChanged].setDateListed(LocalDate.now());
        System.out.println(" ");
        System.out.println("Patient data that has been updated: ");
        System.out.println(" ");
        System.out.println("Patient's First Name: " + heap[patientIndexChanged].getFirstName());
        System.out.println("Patient's Last Name: " + heap[patientIndexChanged].getLastName());
        System.out.println("Patient's DOB: " + heap[patientIndexChanged].getDateOfBirth());
        System.out.println("Address: " + heap[patientIndexChanged].getAddress());
        System.out.println("City: " + heap[patientIndexChanged].getCity());
        System.out.println("State: " + heap[patientIndexChanged].getState());
        System.out.println("Zip Code: " + heap[patientIndexChanged].getZip());
        System.out.println("Phone Number (First Preference): " + heap[patientIndexChanged].getPhone1());
        System.out.println("Phone Number (Second Preference): " + heap[patientIndexChanged].getPhone2());
        System.out.println("Patient's Email: " + heap[patientIndexChanged].getEmail());
        System.out.println("Patient's Unos Status: " + heap[patientIndexChanged].getUnosStatusName(heap[patientIndexChanged].getUnosStatus()));
        System.out.println("Patient's Date listed on "+heap[patientIndexChanged].getUnosStatusName(heap[patientIndexChanged].getUnosStatus())+": " + heap[patientIndexChanged].getDateListed());
        System.out.println(" ");
        System.out.println("Patient History: ");
        if(heap[patientIndexChanged].changedUNOSStatus1==null){
        System.out.println("No History");
        }else{
        System.out.println("On "+heap[patientIndexChanged].getDateChanged1()+", UNOS Status changed to "+heap[patientIndexChanged].getChangedUNOSStatus1());
        }
        if(!(heap[patientIndexChanged].changedUNOSStatus2==null)){
            System.out.println("On "+heap[patientIndexChanged].getDateChanged2()+", UNOS Status changed to "+heap[patientIndexChanged].getChangedUNOSStatus2());
        }
        if(!(heap[patientIndexChanged].changedUNOSStatus3==null)){
            System.out.println("On "+heap[patientIndexChanged].getDateChanged3()+", UNOS Status changed to "+heap[patientIndexChanged].getChangedUNOSStatus3());
        }

//add previous and current changes to unos status to patient data
        heap[patientIndexChanged].addUnosStatusChange(unosStatus);
        
        
       
       
   


        
        sortHeapByUnosStatusAndAge();
        
            

            
                

               
            }
        }
    


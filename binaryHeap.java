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
        System.out.println("The patient detail with the highest priority is as follows:");
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

    }

    public void remove() {
        // remove the patient with highest priority
        // set the root to the last patient

        heap[0] = heap[size - 1];
        // decrement size
        size--;
        // call heapify down
        heapifyDown(0);
    }

    private void heapifyDown(int i) {
        //heapify down
        int min = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
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
            heapifyDown(min);
        }

    }

    public void remove(int index) {
        // remove patient at index
        // set patient at index to last patient
        heap[index] = heap[size - 1];
        // decrement size
        size--;
        // call heapify down
        heapifyDown(index);
        peek(index);
    }

    private void peek(int index) {
        //show patient data at index
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("The patient detail with the highest priority is as follows:");
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
        System.out.println("The requested patient has been removed from the queue");
    }

    
    

}

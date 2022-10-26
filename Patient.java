import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Patient {
    String firstName;
    String lastName;
    String address;
    String city;
    String county;
    String state;
    String zip;
    String phone1;
    String phone2;
    String email;
    String dateListed;
    int unosStatus;
    String dateOfBirth;
    int age;

    public void setAge(String dateofBirth){
        //get age from date of birth
        String[] dob=dateofBirth.split("/");
        int year=Integer.parseInt(dob[2]);
        int month=Integer.parseInt(dob[0]);
        int day=Integer.parseInt(dob[1]);
        LocalDate start=LocalDate.of(year, month, day);
        LocalDate end=LocalDate.now();
        int years = (int) ChronoUnit.YEARS.between(start, end);
        this.age=years;
        
       

    }
    public int getAge(){
        return age;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city){
        this.city=city;
    }

    public void setCounty(String county){
        this.county=county;
    }

    //constructors for each field
    public void setState(String state){
        this.state=state;
    }

    public void setZip(String zip){
        this.zip=zip;
    }

    public void setPhone1(String phone1){
        this.phone1=phone1;
    }

    public void setPhone2(String phone2){
        this.phone2=phone2;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public void setDateListed(String dateListed){
        this.dateListed=dateListed;
    }

    public void setUnosStatus(String unosStatus){ //setting priority based on unos status
        switch(unosStatus){
            case "Status 1A":
                this.unosStatus=1;
                break;
            case "Status 1B":
                this.unosStatus=2;
                break;
            case "Status 2":
                this.unosStatus=3;
                break;
            case "Status 7":
                this.unosStatus=4;
                break;
            case "":
                this.unosStatus=4;
                break;

        }
    }

    public void setDateOfBirth(String dateOfBirth){
        this.dateOfBirth=dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCounty() {
        return county;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getEmail() {
        return email;
    }

    public String getDateListed() {
        return dateListed;
    }

    public int getUnosStatus() {
        return unosStatus;
    }
    public String getUnosStatusName(int unosStatus){
        switch(unosStatus){
            case 1:
                return "Status 1A";
            case 2:
                return "Status 1B";
            case 3:
                return "Status 2";
            case 4:
                return "Status 7";
            default:
                return "Status 7";
        }
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }


}

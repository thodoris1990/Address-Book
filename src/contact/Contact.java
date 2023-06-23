package contact;

/**
 * Η κλάση Contact περιγράφει μια επαφή που μπορεί να βρίκσεται στο κατάλογο.
 * @author gmele
 */
public class Contact {
    private String Name;
    private String SurName;
    private String Tel;
    private String Mail;
    private String Addr;
 /**
  * Αρχικοποιεί μια επαφή. Η αρχικοποίηση περιλαμβάνει όλα τα attributes 
  * @param name
  * @param tel
  * @param mail
  * @param addr 
  */
public Contact (String name, String surname,  String tel, String mail, String addr){
    Name = name;
    SurName = surname;
    Tel = tel;
    Mail = mail;
    Addr = addr;
}
    public String getName (){
    return Name;
    }
    public void setName (String Name){
    this.Name = Name;
    } 

    public String getSurName (){
    return SurName;
    }
    public void setSurName (String SurName){
    this.SurName = SurName;
    }
    
    public String getTel() {
        return Tel;
    }

    public void setTel(String Tel) {
        this.Tel = Tel;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String Mail) {
        this.Mail = Mail;
    }

    public String getAddr() {
        return Addr;
    }

    public void setAddr(String Addr) {
        this.Addr = Addr;
    }
    /**
     * Τυπώνει στην οθόνη την καρτέλα της επαφής.
     */
    public void Print(){
        System.out.println("Όνομα Επαφής......." + Name);
        System.out.println("Επώνυμο Επαφής....." + SurName);
        System.out.println("Τηλέφωνο Επαφής...." + Tel);
        System.out.println("E-mail Επαφής......" + Mail);
        System.out.println("Διεύθυνση Επαφής..." + Addr);
    }
    /**
     * Επιστρέφει όλα τα στοιχεία σε μία συμβλοσειρά.
     * @return 
     */
    @Override
    public String toString(){
    return Name + ", " + SurName + ", "  + Tel + ", " + Mail + ", " + Addr; 
}
}

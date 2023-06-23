package address.book;

import contact.Contact;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.charset.Charset;

/**
 * Η κλάση AddressBook αποτελεί την βασική κλάση του προγράμματος. Αποθηκεύει το σύνολο της πληροφορίας και αποτελεί το UI της εφαρμογής.
 * @author Thodoris
 */
public class AddressBook {

   private ArrayList <Contact> AllContacts;
   private Scanner Keyb;
    /**
    * Αρχικοποιεί το βασικό αντικείμενο της εφαρμογής. Η αρχικοποίηση περιλαμβάει την δημιουργία του ArrayList των επαφών, την εισαγωγή
    * επαφών "καρφωτά" και την αρχικοποίηση του Scanner για την standard είσοδο.
    */
    public AddressBook() {
    AllContacts = new ArrayList();
    Demo();
    Keyb = new Scanner(System.in, Charset.forName("Windows-1253"));
    }
    /**
     * Εισάγει "καρφωτά" 3 επαφές.
     */
    void Demo(){
        Contact Tmp1, Tmp2,Tmp3;
        Tmp1 = new Contact("Anastasia", "Stamatiou", "2104900000", "anastasia.stamatiou@mail.com", "Leoforos Patision, Athens");
        Tmp2 = new Contact("Δημήτρης", "Παπαδόπουλος", "2104900001", "dimitris.papadopoulos@mail.com", "Λεωφόρος Αλεξάνδρας, Θεσσαλονίκη");
        Tmp3 = new Contact("Maria", "Andreou", "2104900002", "maria.andreou@mail.com", "Agiou Nikolaou, Patras");
        AllContacts.add(Tmp1);
        AllContacts.add(Tmp2);
        AllContacts.add(Tmp3); 
    }
    /**
     * Αποτελεί το κύριο μενού της εφαρμογής.
     */
    void Menu(){
        int ch;    
        do{
        System.out.println("           M E N O Y");
        System.out.println("           ---------");
        System.out.println("[1]...Προσθήκη νέας επαφής");
        System.out.println("[2]...Παρουσίαση Επαφής βάσει τηλεφώνου");
        System.out.println("[3]...Επεξεργασία επαφής βάσει ονόματος");
        System.out.println("[4]...Διαγραφή επαφής βάσει ονόματος");
        System.out.println("[5]...Προβολή όλων των διαθέσιμων επαφών");
        System.out.println("[6]...Αναζήτηση επαφής βάσει ονόματος");
        System.out.println("[7]...Έ ξ ο δ ο ς");
        System.out.print("Επιλογή: ");
        ch = Keyb.nextInt();
        Keyb.nextLine();
        switch (ch){
            case 1: DoInsertCon();break;
            case 2: DoShowCon();break;
            case 3: DoEditCon();break;
            case 4: DoDelCon();break;
            case 5: DoListCon (); break;
            case 6: DoShowConDescr (); break;
        }
        }
        while (ch != 7);
    }
    /**
     * Υλοποιεί την λειτουργία "Προσθήκη νέας επαφής".
     */
    void DoInsertCon (){
        Contact t;
        String Tel;
        String Name;
        String SurName;
        String Mail;
        String Addr;
        
        System.out.println("\n           Εισαγωγή Επαφής");
        System.out.println("           ---------------");
        System.out.print("Αριθμός Τηλεφώνου: ");
        Tel = Keyb.next();
        Keyb.nextLine();
        t = SearchByName(Tel);
        if (t != null)
            System.out.println("Υπάρχει καταχωρημένη επαφή με αυτό τον αριθμό τηλεφώνου");
        else{
            System.out.print("Όνομα Επαφής: ");
            Name = Keyb.nextLine();
            System.out.print("Επώνυμο Επαφής: ");
            SurName = Keyb.nextLine();
            System.out.print("E-mail Επαφής: ");
            Mail = Keyb.nextLine();
            System.out.print("Διεύθυνση Επαφής: ");
            Addr = Keyb.nextLine();       
            t = new Contact(Name, SurName, Tel, Mail, Addr);
            AllContacts.add (t);
            System.out.println("Η εισαγωγή ολοκληρώθηκε με επιτυχία");
        }
        Pause();
}
  
    /**
     * Υλοποιεί την λειτουργία "Παρουσίαση Επαφής".
     */
    void DoShowCon (){
        String Tel;
        Contact t;
        System.out.println("\n           Παρουσίαση Επαφής");
        System.out.println("           -----------------");
        System.out.print("Αριθμός Τηλεφώνου: ");
        Tel = Keyb.nextLine();
        t = SearchByName(Tel);
        if(t != null)
            t.Print();
        else
            System.out.println("Δεν υπάρχει επαφή με αριθμό τηλεφώνου: " +Tel);
        Pause();
    }
    /**
     * Υλοποιεί την λειτουργία "Επεξεργασία επαφής βάσει ονόματος".
     */
    void DoEditCon() {
        String Name;
        Contact t;
        System.out.println("\n           Επεξεργασία Επαφής Βάσει Ονόματος");
        System.out.println("           ---------------------------------");
        System.out.print("Όνομα ή Επώνυμο Επαφής: ");
        Name = Keyb.nextLine();
        t = SearchByName2(Name);
        if (t == null) {
            System.out.println("Δεν υπάρχει επαφή με αυτό το όνομα: " + Name);
        } else {
            t.Print();
            String choice;
            do {
            System.out.println("\n[1] Επεξεργασία Επωνύμου");
            System.out.println("[2] Επεξεργασία Όνοματος");
            System.out.println("[3] Επεξεργασία Τηλεφώνου");
            System.out.println("[4] Επεξεργασία E-mail");
            System.out.println("[5] Επεξεργασία Διεύθυνσης");
            System.out.println("[6] Επιστροφή στο Αρχικό Μενού");
            System.out.print("Επιλογή: ");
            choice = Keyb.nextLine();
                
            switch (choice) {
                case "1":
                    System.out.print("Νέο Επώνυμο Επαφής: ");
                    String newSurName = Keyb.nextLine();
                    t.setSurName(newSurName);
                    System.out.println("Το επώνυμο επαφής ενημερώθηκε με επιτυχία!");
                    break;
                case "2":
                    System.out.print("Νέο Όνομα Επαφής: ");
                    String newName = Keyb.nextLine();
                    t.setName(newName);
                    System.out.println("Το όνομα επαφής ενημερώθηκε με επιτυχία!");
                    break;
                case "3":
                    System.out.print("Νέο Τηλέφωνο Επαφής: ");
                    String newTel = Keyb.nextLine();
                    t.setTel(newTel);
                    System.out.println("Το τηλέφωνο επαφής ενημερώθηκε με επιτυχία!");
                    break;
                case "4":
                    System.out.print("Νέο E-mail Επαφής: ");
                    String newMail = Keyb.nextLine();
                    t.setMail(newMail);
                    System.out.println("Το e-mail επαφής ενημερώθηκε με επιτυχία!");
                    break;
                case "5":
                    System.out.print("Νέα Διεύθυνση Επαφής: ");
                    String newAddr = Keyb.nextLine();
                    t.setAddr(newAddr);
                    System.out.println("Η διεύθυνση επαφής ενημερώθηκε με επιτυχία!");
                    break;
                case "6":
                    break;
                default:
                    System.out.println("Μη έγκυρη επιλογή. Παρακαλώ επιλέξτε ξανά.");
            }
        } while (!choice.equals("6"));
    }
        Pause();
    }
    /**
     * Υλοποιεί την λειτουργία "Διαγραφή επαφής βάσει ονόματος"
     */
    void DoDelCon (){
        Contact t;        
        String Name;
        String ch;        
        System.out.println("\n         Διαγραφή Επαφής");
        System.out.println("         ---------------");
        System.out.print("Όνομα ή Επώνυμο Επαφής: ");
        Name = Keyb.nextLine();
        t = SearchByName2(Name);
        if (t == null)
            System.out.println("Δεν υπάρχει επαφή με αυτό το όνομα.");
        else{
            t.Print();
            do{
            System.out.print("Θέλετε σίγουρα να προχωρήσετε σε διαγραφή (Y/N) : ");
            ch = Keyb.nextLine ();
            }
            while (!ch.equals("Y") && !ch.equals("y") && !ch.equals("N") &&!ch.equals("n"));
            if(ch.equals ("Y")||ch.equals("y")){
            boolean deletionSuccess = DeleteByName(Name);       
            if (deletionSuccess) {
                System.out.println("Η διαγραφή ολοκληρώθηκε με επιτυχία.");
            } else {
                System.out.println("Σφάλμα κατά τη διαγραφή.");
            }
        } else {
            System.out.println("Η διαγραφή ακυρώθηκε.");
        }
    }
        Pause();

}
    /**
     * Υλοποιεί την λειτουργία "Προβολή όλων των διαθέσιμων επαφών".
     */
    void DoListCon (){
        System.out.println("\n           Λίστα Επαφών");
        System.out.println("           ------------");
        int i;
        for (i = 0; i < AllContacts.size(); i++)
            System.out.println(AllContacts.get(i).toString());
        Pause();
    }
        /**
         * Τυπώνει μήνυμα το οποίο ζητά από τον χρήστη να πατήσει Enter και περιμένει μέχρι να πατηθεί το πλήκτρο.
         */
        public void Pause(){        
        Keyb.nextLine(); 
        System.out.print("\n\n     Πιέστε <Enter> για συνέχεια ");
        Keyb.nextLine();        
    }
        /**
         * Υλοποιεί την λειτουργία "Αναζήτηση Επαφής με βάση το Όνομα".
         */
        void DoShowConDescr (){
        String Descr;
        Contact t;
        System.out.println("\n           Παρουσίαση Επαφής");
        System.out.println("           -----------------");
        System.out.print("Όνομα ή Επώνυμο επαφής (ή μέρος του): ");
        Descr = Keyb.nextLine();
        t = SearchByName3(Descr);
        if(t != null)
            t.Print();
        else
            System.out.println("Δεν υπάρχει επαφή με αυτό το όνομα: " + Descr);
        Pause();
    }
        /**
         * Αναζητεί στην λίστα των επαφών ένα τηλέφωνο που δίνει ο χρήστης.
         * @param Onoma Το προς αναζήτηση string (τηλέφωνο).
         * @return Το τηλέφωνο που ταιριάζει ή null αν δεν βρεθεί ταίριασμα.
         */
        Contact SearchByName (String Onoma){
        for (Contact tmp: AllContacts){
            if (tmp.getTel().equals(Onoma))
                return tmp;
        }
        return null;
        }
        /**
         * Αναζητεί στην λίστα των επαφών ένα όνομα (με κεφαλαία ή μικρά) που δίνει ο χρήστης.
         * @param Onoma Το προς αναζήτηση string (όνομα).
         * @return Το όνομα που ταιριάζει ή null αν δεν βρεθεί ταίριασμα.
         */
        Contact SearchByName2 (String Onoma){
        for (Contact tmp: AllContacts){
            if (tmp.getName().equalsIgnoreCase(Onoma) || tmp.getSurName().equalsIgnoreCase(Onoma))
                return tmp;
        }
        return null;
        }
        /**
         * Αναζητεί στην λίστα των επαφών ένα όνομα (ή μέρος του ονόματος) που δίνει ο χρήστης.
         * @param Onoma Το προς αναζήτηση string (όνομα).
         * @return Το όνομα που ταιριάζει ή null αν δεν βρεθεί ταίριασμα.
         */
        Contact SearchByName3(String Onoma) {
        for (Contact tmp : AllContacts) {
        if (tmp.getName().toLowerCase().contains(Onoma.toLowerCase()) || tmp.getSurName().toLowerCase().contains(Onoma.toLowerCase()))
            return tmp;
        }
        return null;
        }

        /**
         * Διαγράφει από τη λίστα μια επαφή βάσει του ονόματος.
         * @param Onoma Το όνομα της επαφής που θα διαγραφεί.
         * @return true αν η επαφή υπάρχει και διαγραφή, false αν δεν υπάρχει επαφή με το συγκεκρικένο όνομα.
         */
        boolean DeleteByName (String Onoma){
        int i;
        for(i = 0; i < AllContacts.size(); i++){
            if (AllContacts.get(i).getName().equals(Onoma)){
                AllContacts.remove(i);
                return true;
            }                
        }
        return false;
    }
            
    
    public static void main(String[] args) {
        AddressBook MP;
        MP = new AddressBook();
        MP.Menu();
        System.out.println("\nΗ εφαρμογή τερματίστηκε");              
    }
}
    


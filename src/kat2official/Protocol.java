
package kat2official;

public class Protocol {
    public String menu(int n){

       switch(n){
           case 1: return (" 1. Validate Card  2.Deposit  3. withdraw  4. Update  5.Close");
           case 2: return (" 2.Deposit  3. withdraw  4. Update  5.Close ");
           case 3: return (" Enter PIN: ");
           case 4: return (" Successful Validate!! Acount Number: ");
           case 5: return (" Choose Action ");
           case 6: return ("Unsuccessful Validate");
           case 7: return ("You haven't been authenticated");
           case 8: return ("Enter amount for deposit");
           case 9: return ("Enter amount for withdraw");
           case 10: return ("Your Ammount is :");


           default:
               return ("0");
       }
    }

}



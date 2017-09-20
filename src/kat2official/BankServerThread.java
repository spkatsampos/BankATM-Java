package kat2official;

import java.net.*;
import java.io.*;
//import java.lang.*;
public class BankServerThread extends Thread{

    private static final int MAX = 3;
    private static boolean state = false;//private gia asfaleia
    private static final String validate = "1";
    private static final String deposit = "2";
    private static final String withdraw = "3";
    private static final String update = "4";
    private static final String close = "5";

    

        Socket ATM = null;
        public BankServerThread(Socket bank) {
        super("BankServer");
	this.ATM=bank;
    }
         public void run() {
        try {
            //bank = new ServerSocket(25200); //dimiourgoume socket gia ton server
            //Socket ATM;
           // ATM = bank.accept(); //perimenoume na sindethei kapoios client
            PrintWriter outstream = new PrintWriter(ATM.getOutputStream(), true);  //grafoume ston client
            BufferedReader instream = new BufferedReader(new InputStreamReader(ATM.getInputStream())); //kai diabazoume apo ton client
            String input = null, output = null;

            Protocol protocol = new Protocol(); //diimiourgoume antikeimeno tou protocol
            //---------------------------------------------------------------------------
            Account a[];
            a = new Account[MAX];
            a[0] = new Account(100, 1000, 10000);
            a[1] = new Account(200, 2000, 5000);
            a[2] = new Account(300, 3000, 6000);
            //----------------------------------------------------------------------------

            output = protocol.menu(1);
            outstream.println(output); //tiponei ston client ta minimata pou dinei to protokolo

            int acc = -1, i = 0, pos = 0, pin = 0, found = 0;



            while ((input = instream.readLine()) != null) {//Big While

                if (input.equals(validate)) {

                    while ((acc == -1)) {
                        outstream.println(protocol.menu(3));
                        pin = Integer.parseInt(instream.readLine());

                        for (i = 0; i < MAX; i++) {
                            if (a[i].validate(pin) != -1) {
                                pos = i;
                                acc = a[i].validate(pin);
                                break;

                            }//if
                        }//for
                        if (acc != -1) {
                            outstream.println(protocol.menu(4) + acc + protocol.menu(5) + protocol.menu(2));
                            state = true;
                        }//if
                        else {//Gia to la8os
                            outstream.println(protocol.menu(6)+protocol.menu(5) + protocol.menu(1));

                        }//else

                    }//while
                }//if equals 1
                else if (input.equals(deposit)) {
                    if (state == true) {//an einai au8entikopoiimenos
                        outstream.println(protocol.menu(8));
                        outstream.println(a[pos].deposit(Integer.parseInt(instream.readLine())) + protocol.menu(2));//kate8esi
                    }//if
                    else {
                        outstream.println(protocol.menu(7)+protocol.menu(5) + protocol.menu(1));
                    }//else

                }//if 2
                else if (input.equals(withdraw)) {
                    if (state == true) {//an einai au8entikopoiimenos
                        outstream.println(protocol.menu(9));
                        outstream.println(a[pos].withdraw(Integer.parseInt(instream.readLine())) + protocol.menu(2));//analipsi
                    }//if
                    else {
                        outstream.println(protocol.menu(7)+protocol.menu(5) + protocol.menu(1));
                    }//else

                }//if 3
                else if (input.equals(update)) {
                    if (state == true) {//an einai au8entikopoiimenos
                        outstream.println(protocol.menu(10) + a[pos].update() + protocol.menu(2));


                    }//if
                    else {
                        outstream.println(protocol.menu(7)+protocol.menu(5)+ protocol.menu(1));
                    }//else

                }//if 4
                else if (input.equals(close)) {
                    outstream.close();
                    instream.close();
                    ATM.close();
                    

                }//if 3
 }//Big while




        } catch (IOException e) {
            System.err.println("IO error ServerSocket");
        }


    }
}

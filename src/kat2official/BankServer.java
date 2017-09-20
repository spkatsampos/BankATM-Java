

package kat2official;


    import java.net.*;
import java.io.*;

public class BankServer {
    public static void main(String[] args) throws IOException {
        ServerSocket bank = null;
       boolean bool=true;

        try {
            bank = new ServerSocket(25200); //dimiourgoume ena socket gia ton server
        } catch (IOException e) {
            System.err.println("IOerror");

        }

        while (bool){//oso einai true (gia panta)
	    BankServerThread BS=new BankServerThread(bank.accept());// dimiourgoume antikeimeno tupou kkmultipleserver
             BS.start();                                                         // ksekiname ti run gia to antikeimeno tou kkmultipleserver
        }
        bank.close(); //kleinoume to socket
    }
}



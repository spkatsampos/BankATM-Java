

package kat2official;

import java.io.*;
import java.net.*;
public class ATM2  {
    public static void main(String[] args) throws IOException {
        Socket ATM = null;
        PrintWriter outstream = null;
        BufferedReader instream = null;
        BufferedReader keyboardIn=null;
        try {
            ATM = new Socket("localhost",25200);                                          //dimiourgia socket tou client
            outstream = new PrintWriter(ATM.getOutputStream(), true);                    //anoigma stream gia eggrafi kai anagnosi
            instream = new BufferedReader (new InputStreamReader(ATM.getInputStream()));//metaksi server kai client


         keyboardIn = new BufferedReader(new InputStreamReader(System.in));//diabasma client apo pliktrologio kai apothikeusi ston buffer.
         String fromATM=null;
         String frombank=null;

         while((frombank=instream.readLine())!=null){
            System.out.println("Bank: " + frombank);
            fromATM = keyboardIn.readLine(); //diabazoume apo to pliktrologia tin apantisi tou client
            outstream.println(fromATM); //kai ti stelnoume ston server

                                                    }
        }
        catch (IOException e) {
            System.err.println("IO error");
            }



//kleinoume tis roes kai to socket
        outstream.close();
        instream.close();
        keyboardIn.close();
        ATM.close();

}
}


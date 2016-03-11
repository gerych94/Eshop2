import com.sun.org.apache.xpath.internal.operations.Mod;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by vitaliy on 09.03.16.
 */
public class Logic {



    public void generateKeys(){
        int t=1024;
        BigInteger fi;
        BigInteger d;
        BigInteger e;
        try {
            BigInteger p=BigInteger.probablePrime(t,new Random());
            BigInteger q=BigInteger.probablePrime(t,new Random());
            BigInteger n;
            PrintWriter printWriter=new PrintWriter(new File("/home/vitaliy/IdeaProjects/Eshop2/src/main/resources/OpenKeys.txt"));
            PrintWriter printWriter2=new PrintWriter(new File("/home/vitaliy/IdeaProjects/Eshop2/src/main/resources/CloseKeys.txt"));
            n=p.multiply(q);
            printWriter.println(n);
            fi=p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
           // System.out.println(fi);
            // BigInteger bigInteger=BigInteger.valueOf(65537);
            // d=searchPrime(fi,bigInteger);
            int k=0;
            while (!isPrime(BigInteger.valueOf(k = new Random().nextInt(1000)),fi)){
            }
            e=BigInteger.valueOf(k);
            printWriter.println(e);
            BigInteger key=BigInteger.ONE;
            while (!(key.multiply(fi).add(BigInteger.ONE).mod(e).equals(BigInteger.ZERO))){
                key=key.add(BigInteger.ONE);
            }
            d=key.multiply(fi).add(BigInteger.ONE).divide(e);
            printWriter2.println(d);

        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    public void encryption(String message){
        BigInteger c=BigInteger.ONE;
        BigInteger e=null;
        BigInteger n=null;
        int k=0;
        try {
            PrintWriter printWriter=new PrintWriter(new File("/home/vitaliy/IdeaProjects/Eshop2/src/main/resources/Massage.txt"));
            Scanner scanner=new Scanner(new File("/home/vitaliy/IdeaProjects/Eshop2/src/main/resources/OpenKeys.txt"));
            while (scanner.hasNextLine()){
                k++;
                if(k==1){
                    n=new BigInteger(scanner.nextLine());
                }else {
                    e=new BigInteger(scanner.nextLine());
                }
//                switch (k){
//                    case 1:
//
//                        break;
//                    case 2:
//
//                        break;
//                }
            }
            System.out.println(n);
            System.out.println(e);
            BigInteger m=new BigInteger(message.getBytes());
            System.out.println(m);
            c=m.modPow(e,n);
            printWriter.println(c);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }



    }

    public void decryption(){
        BigInteger c=null;
        BigInteger d=null;
        BigInteger n=null;
        Scanner scannerCloseKeys=new Scanner("/home/vitaliy/IdeaProjects/Eshop2/src/main/resources/CloseKeys.txt");
        Scanner scannerOpenKeys=new Scanner("/home/vitaliy/IdeaProjects/Eshop2/src/main/resources/OpenKeys.txt");
        Scanner scannerMessage=new Scanner("/home/vitaliy/IdeaProjects/Eshop2/src/main/resources/Massage.txt");
        while (scannerCloseKeys.hasNextLine()){
            n=new BigInteger(scannerCloseKeys.nextLine());
            break;
        }
        while (scannerOpenKeys.hasNextLine()){
            d=new BigInteger(scannerOpenKeys.nextLine());
            break;
        }
        while (scannerMessage.hasNextLine()){
            c=new BigInteger(scannerMessage.nextLine());
        }
        BigInteger bigInteger=c.modPow(d,n);
        System.out.println(bigInteger.toByteArray());
//
//        System.out.println("n="+n);
//        System.out.println("e="+e);
//        System.out.println("d="+d);
//        System.out.println("c="+c);
//        System.out.println("Message:");
//        System.out.println(new String(bigInteger.toByteArray()));

    }

    public BigInteger searchMod(BigInteger a,BigInteger b){
        return  b.equals(BigInteger.ZERO)?a: searchMod(b, a.mod(b));
    }

    public boolean isPrime(BigInteger a,BigInteger b){
        return searchMod(a,b).equals(BigInteger.ONE)?true:false;
    }
}

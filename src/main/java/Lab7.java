import java.math.BigInteger;

/**
 * Created by vitaliy on 09.03.16.
 */
public class Lab7 {


    public static void main(String[] args) {
        //BigInteger bigInteger=new BigInteger(String.valueOf(10));
       // System.out.println(bigInteger.equals(BigInteger.valueOf(10)));

        String message=new String("HelloWorld");
        Logic logic=new Logic();
        logic.generateKeys();
        logic.encryption(message);
        logic.decryption();




//     int a=12;
//     Object object=a;
//     String str="string";
//        str.getBytes();
//        System.out.println(str.getBytes());
//        String string="string";
//
//        System.out.println(string.getBytes());
//
//        String string2="234eвівівіfvbvc32";
//
//        BigInteger bigInteger=new BigInteger(str.getBytes());
//        System.out.println(bigInteger.toString());
//
//
//
//        System.out.println(bigInteger.toByteArray());
//
//
//        System.out.println(new String(bigInteger.toByteArray()));
//
//        System.out.println(string.getBytes());
//
//
//
//
//
//        System.out.println(object.hashCode());
//        System.out.println(object.toString());
//
//
//        System.out.println(new String(str.getBytes()));
//        System.out.println(new String(string.getBytes()));
//        System.out.println(new String(string2.getBytes()));
//        byte [] bytes=str.getBytes();
//        for (int i = 0; i <bytes.length ; i++) {
//            System.out.println(bytes[i]);
//        }

    }
}

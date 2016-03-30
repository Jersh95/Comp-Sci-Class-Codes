import java.math.BigInteger;
import java.util.Random;


public class RSA {

    public static void main(String[] args) {
        BigInteger p;
        BigInteger q;
        BigInteger n;
        BigInteger phi;
        BigInteger e;
        BigInteger d;

        Random rand = new Random();
        p = new BigInteger(2048, 1, rand);
        q = new BigInteger(2048, 1, rand);

        n = p.multiply(q);

        p = p.subtract((new BigInteger(Integer.toString(1))));
        q = q.subtract((new BigInteger(Integer.toString(1))));
        phi = p.multiply(q);

//        e = 3;
//        while(phi%e == 0){
//            e +=2;
//        }

        e = new BigInteger((Integer.toString(3)));
        while(phi.mod(e).equals("0")){
            e.add((new BigInteger(Integer.toString(2))));
        }
        System.out.println("P: " + p);
        System.out.println("Q: " + q);
        System.out.println("N: " + n);
        System.out.println("Phi: " + phi);
        System.out.println("E: " + e);
        //System.out.println("D: " + d);
    }
}
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
        p = BigInteger.probablePrime(2048,rand);
        q = BigInteger.probablePrime(2048,rand);
        //p = new BigInteger(200, 1, rand);
        //q = new BigInteger(200, 1, rand);

        n = p.multiply(q);
        p = p.subtract((new BigInteger(Integer.toString(1))));
        q = q.subtract((new BigInteger(Integer.toString(1))));
        phi = p.multiply(q);

        e = new BigInteger("3");
        while(phi.mod(e).equals(BigInteger.ZERO)){
            e = e.add((new BigInteger("2")));
        }

        d = e.modInverse(phi);

        System.out.println("p: " + p);
        System.out.println("q: " + q);
        System.out.println("n: " + n);
        System.out.println("phi: " + phi);
        System.out.println("e: " + e);
        System.out.println("Public Key: " + e + ", " + n);
        System.out.println("Sum of the bits: " + p.bitCount() + q.bitCount());

        BigInteger m = new BigInteger("123456789");
        BigInteger r = m.modPow(e, n);
        BigInteger m2 = r.modPow(d, n);
        System.out.println("m: " + m);
        System.out.println("r: " + r);
        System.out.println("m2: " + m2);
    }
}
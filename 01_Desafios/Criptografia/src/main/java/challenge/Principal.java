package challenge;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        CriptografiaCesariana Crip = new CriptografiaCesariana();

        String res = Crip.criptografar("S 1avio");
        System.out.println(res);
        String des = Crip.descriptografar(res);
        System.out.println(des);

    }
}

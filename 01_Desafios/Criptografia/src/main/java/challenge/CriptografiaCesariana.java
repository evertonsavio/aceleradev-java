package challenge;

import java.util.ArrayList;

public class CriptografiaCesariana implements Criptografia {


    char[] alphabet = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz".toCharArray();
    char[] alphateb = "zyxwvutsrqponmlkjihgfedcbazyxwvutsrqponmlkjihgfedcba".toCharArray();


    @Override
    public String criptografar(String texto) {

        if (texto.length() > 0 ){
            char[] letras = texto.toLowerCase().toCharArray();
            System.out.println(letras.length);

            ArrayList<Character> resultado = new ArrayList();

            for(int i=0; i<letras.length; i++  ){

                char letra = letras[i];
                System.out.println(letra);
                if(letra == ' '){
                    resultado.add(' ');
                }
                if (Character.isDigit(letra)){
                    resultado.add(letra);
                }
                for(int a = 0; a < this.alphabet.length; a++){
                    char letra_alp = alphabet[a];
                    if (letra_alp == letra){
                        resultado.add(alphabet[a + 3]);
                        break;
                    }
                }
            }

            String listString = "";
            for (Character s : resultado)
            {
                listString += s + "";
            }
            return listString;

        }else {
            throw new IllegalArgumentException("Deve ser maior que zero a string");
        }
    }

    @Override
    public String descriptografar(String texto) {

        if (texto.length() > 0 ){
        char[] letras = texto.toLowerCase().toCharArray();
        System.out.println(letras.length);

        ArrayList<Character> resultado = new ArrayList();

        for(int i=0; i<letras.length; i++  ){

            char letra = letras[i];
            if(letra == ' ') {
                resultado.add(' ');
            }
            if (Character.isDigit(letra)){
                resultado.add(letra);
            }
            for(int a = 0; a < this.alphateb.length; a++){
                char letra_alp = alphateb[a];
                if (letra_alp == letra){
                    resultado.add(alphateb[a + 3]);
                    break;
                }
            }
        }

        String listString = "";
        for (Character s : resultado)
        {
            listString += s + "";
        }
        return listString;
    }else {
            throw new IllegalArgumentException("Deve ser maior que zero a string");
        }
    }

}

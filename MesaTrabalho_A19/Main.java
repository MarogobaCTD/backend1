package MesaTrabalho_A19;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Contatos> contatos = new ArrayList<>();

        Contatos contato1 = new Contatos("Marcelo", "marcelo@gmail.com", "61988989809");
        Contatos contato2 = new Contatos("Patricia", "patricia@gmail.com", "6197373834");
        Contatos contato3 = new Contatos("Iris", "iris@gmail.com", "6111111111");
        Contatos contato4 = new Contatos("Iasmim", "iasmim@gmail.com", "61222222222");

        contatos.add(contato1);
        contatos.add(contato2);
        contatos.add(contato3);
        contatos.add(contato4);

        FileOutputStream fo = null;

        try {
            fo = new FileOutputStream("contatos.dat");
            ObjectOutputStream op = new ObjectOutputStream(fo);

            op.writeObject(contatos);

            op.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<Contatos> contatos2 = null;

        FileInputStream fi = null;

        try {
            fi = new FileInputStream("contatos.dat");
            ObjectInputStream oi = new ObjectInputStream(fi);

            contatos2 = (ArrayList<Contatos>) oi.readObject();

            for (Contatos c: contatos2) {
                System.out.println(c.toString());
            }

            oi.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}

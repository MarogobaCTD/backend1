package Aula19_Serializacao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Cachorro> cachorros = new ArrayList<>();

        Cachorro cachorro1 = new Cachorro("Toto", 3);
        Cachorro cachorro2 = new Cachorro("Bobby", 2);
        Cachorro cachorro3 = new Cachorro("Skye", 2);
        Cachorro cachorro4 = new Cachorro("Everest", 5);
        Cachorro cachorro5 = new Cachorro("Zuma", 7);

        cachorros.add(cachorro1);
        cachorros.add(cachorro2);
        cachorros.add(cachorro3);
        cachorros.add(cachorro4);
        cachorros.add(cachorro5);

        FileOutputStream fo = null;

        try{
          fo = new FileOutputStream("OutputFile.txt");
          ObjectOutputStream objectOutputStream = new ObjectOutputStream(fo);

          objectOutputStream.writeObject(cachorros);

          objectOutputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Cachorro> cachorros2 = null;
        FileInputStream fi = null;

        try {
            fi = new FileInputStream("OutputFile.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fi);

            cachorros2 = (ArrayList) objectInputStream.readObject();

            for (Cachorro c: cachorros2) {
                System.out.println(c.toString());
            }

            objectInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }


    }
}

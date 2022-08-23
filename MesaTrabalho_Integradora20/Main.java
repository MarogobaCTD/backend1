package MesaTrabalho_Integradora20;

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Empresa> empresas = new ArrayList<>();
        Empresa empresa = new Empresa("19189228000100", "DH Treinamentos");
        empresas.add(empresa);


        ArrayList<Funcionarios> funcionarios = new ArrayList<>();
        Funcionarios funcionario1 = new Funcionarios("Rodrigo", "Rodrigues", "272627267", 10000.00);
        Funcionarios funcionario2 = new Funcionarios("Alexander", "Bandeira", "839383983", 12000.00);
        Funcionarios funcionario3 = new Funcionarios("Jhonny", "Pecego", "918191819", 12000.00);
        Funcionarios funcionario4 = new Funcionarios("Ruggiero", "Stello", "61716177171", 11000.00);
        Funcionarios funcionario5 = new Funcionarios("Marcelo", "Barbosa", "0292928922", 9000.00);

        funcionarios.add(funcionario1);
        funcionarios.add(funcionario2);
        funcionarios.add(funcionario3);
        funcionarios.add(funcionario4);
        funcionarios.add(funcionario5);

        String arqEmpresas = "empresas.txt";
        String arqFuncionarios = "funcionarios.txt";

        ArrayList<Empresa> lerEmpresas = null;
        ArrayList<Funcionarios> lerFuncionarios = null;

        try {
            FileOutputStream foempresas = new FileOutputStream(arqEmpresas);
            ObjectOutputStream opempresas = new ObjectOutputStream(foempresas);

            opempresas.writeObject(empresas);
            opempresas.close();

            FileOutputStream fofuncionarios = new FileOutputStream(arqFuncionarios);
            ObjectOutputStream opfuncionarios = new ObjectOutputStream(fofuncionarios);

            opfuncionarios.writeObject(funcionarios);
            opfuncionarios.close();

            FileInputStream fiempresas = new FileInputStream(arqEmpresas);
            ObjectInputStream oiempresas = new ObjectInputStream(fiempresas);

            lerEmpresas = (ArrayList<Empresa>) oiempresas.readObject();

            for (Empresa e: lerEmpresas) {
                System.out.println(e.toString());
            }

            FileInputStream fifuncionarios = new FileInputStream(arqFuncionarios);
            ObjectInputStream oifuncionarios = new ObjectInputStream(fifuncionarios);

            lerFuncionarios = (ArrayList<Funcionarios>) oifuncionarios.readObject();

            for (Funcionarios f: lerFuncionarios) {
                System.out.println(f.toString());
            }

            oiempresas.close();
            oifuncionarios.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            OutputStream op = new FileOutputStream("empregados.txt");
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(op));

            String linha;
            for (Funcionarios f : funcionarios) {
                linha = f.getNome() + ";" + f.getSobreNome() + ";" + f.getCpf() + ";" + f.getSalario();
                bw.write(linha);
                bw.newLine();
            }

            bw.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

package Aula14_Pratica;

import java.sql.*;

public class Main {
    private static final String sqlCreateTable = "DROP TABLE IF EXISTS Paciente; CREATE TABLE Paciente" +
            "("+"id INT PRIMARY KEY,"
            +"Nome VARCHAR(100) NOT NULL,"
            +"Sobrenome VARCHAR(100) NOT NULL,"
            +"endereco VARCHAR(100) NOT NULL,"
            +"RG VARCHAR(100) NOT NULL,"
            +"DataCadastro VARCHAR(10) NOT NULL,"
            +"NomeUsuario VARCHAR(100) NOT NULL,"
            +"Senha VARCHAR(10) NOT NULL"
            +")";

    private static final String sqlInsert1 = "INSERT INTO Paciente(id,Nome,Sobrenome,endereco,RG,DataCadastro,NomeUsuario,Senha) VALUES (?, ?, ?, ?,  ?, ? , ?, ?)";
    private static final String sqlUpdate = "UPDATE Paciente set Senha = ? WHERE id = ?";


    public static void main(String[] args) throws Exception {
        Connection connection = null;
        Paciente paciente = new Paciente("Marcelo","Barbosa","Rua dos Bálsamos","1010101","15/05/2017","marogoba","123456");

        try
        {
            connection = getConnection();
            Statement statement = connection.createStatement();

            statement.execute(sqlCreateTable);

            PreparedStatement ps = connection.prepareStatement(sqlInsert1);

            ps.setInt(1,1);
            ps.setString(2,paciente.getNome());
            ps.setString(3,paciente.getSobrenome());
            ps.setString(4, paciente.getEndereço());
            ps.setString(5,paciente.getRG());
            ps.setString(6,paciente.getDataCadastro());
            ps.setString(7,paciente.getNomeUsuário());
            ps.setString(8,paciente.getSenha());

            ps.execute();

            connection.setAutoCommit(false);

            PreparedStatement psUpdate = connection.prepareStatement(sqlUpdate);
            psUpdate.setInt(1,89890);
            psUpdate.setInt(2,1);
            psUpdate.execute();

            int a = 1/0;
            //throw new Exception("Não é para gravar!!!");

            connection.commit();

            connection.setAutoCommit(true);


        } catch (Exception e){
            e.printStackTrace();
            connection.rollback();
        } finally {
            String sql = "SELECT * FROM Paciente";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getInt(1) + " Usuário: " + rs.getString(7) + " Senha: " + rs.getString(8));
            }
            connection.close();
        }
    }


    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }
}

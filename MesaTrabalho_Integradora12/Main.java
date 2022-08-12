package MesaTrabalho_Integradora12;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.*;

public class Main {
    private static final String sqlCreateTable = "DROP TABLE IF EXISTS Funcionarios; CREATE TABLE Funcionarios " +
            "(id INT PRIMARY KEY, Primeiro_Nome varchar(100) NOT NULL, Sobrenome varchar(100) NOT NULL, Idade INT NOT NULL, Empresa varchar(100))";

    private static final String sqlInsert1 = "INSERT INTO Funcionarios(id, Primeiro_Nome, Sobrenome, Idade, Empresa) VALUES (1, 'Marcelo', 'Barbosa', 43, 'Mercado Livre')";
    private static final String sqlInsert2 = "INSERT INTO Funcionarios(id, Primeiro_Nome, Sobrenome, Idade, Empresa) VALUES (2, 'Patrica', 'Gomes', 40, 'Digital House')";
    private static final String sqlInsert3 = "INSERT INTO Funcionarios(id, Primeiro_Nome, Sobrenome, Idade, Empresa) VALUES (1, 'Iasmim', 'Barbosa', 35, 'Globant')";

    private static final String sqlUpdate = "UPDATE Funcionarios SET Primeiro_Nome = 'Maria' WHERE id = 2 ";

    private static final String sqlDelete = "DELETE FROM Funcionarios WHERE id = 1";

    private static final String sqlDelete2 = "DELETE FROM Funcionarios WHERE Primeiro_Nome = 'Maria' ";

    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws Exception{
        BasicConfigurator.configure();
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();

            statement.execute(sqlCreateTable);
            inserirFuncionario(connection, sqlInsert1);
            inserirFuncionario(connection, sqlInsert2);
            inserirFuncionario(connection, sqlInsert3);

            ShowUsuario(connection);

            statement.execute(sqlUpdate);
            logger.debug("Alterado o nome do registro id = 2");
            ShowUsuario(connection);

            logger.info("Excluindo o registro id = 1 - Informações do Funcionário: " + ShowUsuarioId(connection, 1) );
            statement.execute(sqlDelete);
            ShowUsuario(connection);

            logger.info("Excluindo o registro Primeiro_Nome = Maria - Informações do Funcionário: " + ShowUsuarioPrimeiroNome(connection, "Maria") );
            statement.execute(sqlDelete2);
            ShowUsuario(connection);

            connection.close();

        } catch (Exception e){
            e.printStackTrace();
        } finally {

            if (connection==null){
                return;
            }
            connection.close();
        }


    }

    private static void ShowUsuario(Connection connection) throws SQLException {
        String sqlQuery = "Select * FROM Funcionarios";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        while(resultSet.next()){
            System.out.println(resultSet.getInt(1)+ " - " + resultSet.getString(2) + " - " +
                    resultSet.getString(3)+ " - " + resultSet.getString(4)+ " - " + resultSet.getString(5));
        }
    }

    private static String ShowUsuarioId(Connection connection, int id) throws SQLException {
        String sqlQuery = "Select * FROM Funcionarios WHERE id = " + id;

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        resultSet.next();
        return resultSet.getInt(1)+ " - " + resultSet.getString(2) + " - " +
                    resultSet.getString(3)+ " - " + resultSet.getString(4)+ " - " + resultSet.getString(5);
    }

    private static String ShowUsuarioPrimeiroNome(Connection connection, String nome) throws SQLException {
        String sqlQuery = "Select * FROM Funcionarios WHERE Primeiro_Nome = " + "'" + nome + "'";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);
        resultSet.next();
        return  resultSet.getInt(1)+ " - " + resultSet.getString(2) + " - " +
                resultSet.getString(3)+ " - " + resultSet.getString(4)+ " - " + resultSet.getString(5);
    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }

    public static void inserirFuncionario(Connection connection, String s) throws SQLException {
        try {
            Statement statement = connection.createStatement();
            statement.execute(s);
        } catch (org.h2.jdbc.JdbcSQLIntegrityConstraintViolationException e){
            logger.error("Erro ao inserir: " + e);
        }
    }

}

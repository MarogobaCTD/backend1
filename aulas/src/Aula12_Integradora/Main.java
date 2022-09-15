package Aula12_Integradora;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.sql.*;

public class Main {

    private static final String sqlCreateTable = "DROP TABLE IF EXISTS Usuario; CREATE TABLE Usuario " +
            "(id INT PRIMARY KEY, Primeiro_Nome varchar(100) NOT NULL, Sobrenome varchar(100) NOT NULL, Idade INT NOT NULL)";

    private static final String sqlInsert1 = "INSERT INTO Usuario(id, Primeiro_Nome, Sobrenome, Idade) VALUES (1, 'Marcelo', 'Barbosa', 43)";
    private static final String sqlInsert2 = "INSERT INTO Usuario(id, Primeiro_Nome, Sobrenome, Idade) VALUES (2, 'Patrica', 'Gomes', 40)";
    private static final String sqlInsert3 = "INSERT INTO Usuario(id, Primeiro_Nome, Sobrenome, Idade) VALUES (3, 'Iasmim', 'Barbosa', 6)";

    private static final String sqlDelete = "DELETE FROM Usuario WHERE id = 2";

    private static final Logger logger = Logger.getLogger(Aula10_Logger.Main.class);

    public static void main(String[] args) throws Exception{
        BasicConfigurator.configure();
        Connection connection = null;
        try {
            connection = getConnection();
            Statement statement = connection.createStatement();

            statement.execute(sqlCreateTable);
            statement.execute(sqlInsert1);
            statement.execute(sqlInsert2);
            statement.execute(sqlInsert3);

            ShowUsuario(connection);
            logger.info("Excluindo o registro 2");
            statement.execute(sqlDelete);
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
        String sqlQuery = "Select * FROM Usuario";

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        while(resultSet.next()){
            System.out.println(resultSet.getInt(1)+ " - " + resultSet.getString(2) + " - " +
                    resultSet.getString(3)+ " - " + resultSet.getString(4));
        }
    }

    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver").newInstance();
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
    }


}

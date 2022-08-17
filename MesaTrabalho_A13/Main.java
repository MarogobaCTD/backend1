package MesaTrabalho_A13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

    private static final String sqlCreate = "DROP TABLE IF EXISTS Dentista; CREATE TABLE Dentista" +
            "("+"id INT PRIMARY KEY,"
            +"sobrenome VARCHAR(100) NOT NULL,"
            +"nome VARCHAR(10) NOT NULL,"
            +"matricula INT NOT NULL"
            +");";

    private static final String sqlInsert = "INSERT INTO Dentista(id, sobrenome, nome, matricula) VALUES (?, ?, ?, ?)";

    private static final String sqlUpdate = "UPDATE Dentista SET matricula = ? WHERE id = ?;";

    public static void main(String[] args) throws Exception {

        Dentista dentista = new Dentista(1, "Barbosa", "Marcelo", 1);

        Connection connection = null;

        try{
            connection = ConnectionJDBC.getConnection();
            Statement statement = connection.createStatement();
            statement.execute(sqlCreate);

            PreparedStatement preparedStatementInsert = connection.prepareStatement(sqlInsert);
            preparedStatementInsert.setInt(1, dentista.getId());
            preparedStatementInsert.setString(2, dentista.getSobrenome());
            preparedStatementInsert.setString(3, dentista.getNome());
            preparedStatementInsert.setDouble(4, dentista.getMatricula());
            preparedStatementInsert.execute();

            connection.setAutoCommit(false);
            PreparedStatement preparedStatementUpdate = connection.prepareStatement(sqlUpdate);
            preparedStatementUpdate.setDouble(1, 2);
            preparedStatementUpdate.setInt(2,dentista.getId());
            preparedStatementUpdate.execute();
            connection.commit();

            String sql = "SELECT * FROM Dentista";
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while(rs.next()){
                System.out.println(rs.getInt(1) + " Sobrenome: " + rs.getString(2) + " Nome: " + rs.getString(3) + " Matricula: " + rs.getInt(4));
            }
            connection.setAutoCommit(true);

        } catch (Exception e){
            e.printStackTrace();
            connection.rollback();
        } finally {
            connection.close();
        }

    }
}

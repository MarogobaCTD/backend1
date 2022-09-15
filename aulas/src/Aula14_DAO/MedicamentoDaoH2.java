package Aula14_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

public class MedicamentoDaoH2 implements IDao<Medicamento>{

    private ConfiguracaoJDBC configuracaoJDBC;

    final static Logger log = Logger.getLogger(String.valueOf(MedicamentoDaoH2.class));

    public MedicamentoDaoH2(ConfiguracaoJDBC configuracaoJDBC){
        this.configuracaoJDBC = configuracaoJDBC;
    }

    @Override
    public Medicamento salvar(Medicamento medicamento) throws SQLException {
        log.info("Registrando um novo medicamento" + medicamento.toString());
        Connection conneection = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;

        String query = String.format("INSERT INTO medicamentos (nome, laboratorio, quantidade, preco) " +
                        "VALUES ('%s', '%s', '%s', '%s')",
                        medicamento.getNome(), medicamento.getLaboratorio(), medicamento.getQuantidade(), medicamento.getPreco());

        try {
            statement = conneection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = statement.getGeneratedKeys();

            if(keys.next()){
                medicamento.setId(keys.getInt(1));
                statement.close();
                conneection.close();
            }


        } catch (SQLException e){
            e.printStackTrace();
        }

        return medicamento;
    }

    public Medicamento buscar(Integer id) throws SQLException {
        log.info("Buscando medicamento com id: " + id);
        Connection connection = configuracaoJDBC.conectarComBancoDeDados();
        Statement statement = null;

        String query = String.format("SELECT id,nome,laboratorio,quantidade,preco FROM medicamentos WHERE id = '%s'", id);
        Medicamento medicamento = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                medicamento = new Medicamento(resultSet.getInt("id"),
                        resultSet.getString("nome"), resultSet.getString("laboratorio"),
                        resultSet.getInt("quantidade"), resultSet.getDouble("preco"));

            }

            statement.close();

        } catch (SQLException throwables){
            throwables.printStackTrace();
        }
        return medicamento;
    }

}

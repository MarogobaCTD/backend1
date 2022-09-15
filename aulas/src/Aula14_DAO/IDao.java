package Aula14_DAO;

import java.sql.SQLException;

public interface IDao <T> {

    public T salvar(T t) throws SQLException;
    public T buscar(Integer id) throws SQLException;

}

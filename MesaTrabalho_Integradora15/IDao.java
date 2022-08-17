package MesaTrabalho_Integradora15;

import java.sql.SQLException;

public interface IDao <T> {

    public T salvar(T t) throws SQLException;
    public T buscar(Integer id) throws SQLException;

    public void excluir(Integer id) throws SQLException;

    public void buscarTodos() throws SQLException;

}

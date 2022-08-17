package MesaTrabalho_Integradora15;

import java.sql.SQLException;

public class ClienteService {

    private IDao<Paciente> pacienteIDao;

    public ClienteService (IDao<Paciente> pacienteIDao){
        this.pacienteIDao = pacienteIDao;
    }

    public Paciente salvar(Paciente paciente) throws SQLException {
        return pacienteIDao.salvar(paciente);
    }

    public Paciente buscar(Integer id) throws SQLException {
        return pacienteIDao.buscar(id);
    }

    public void excluir(Integer id) throws SQLException {
        pacienteIDao.excluir(id);
    }

    public void buscarTodos() throws SQLException {
        pacienteIDao.buscarTodos();
    }

}

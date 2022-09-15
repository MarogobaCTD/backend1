package medicamentos;

import java.sql.SQLException;

public class MedicamentoService {

    private IDao<Medicamento> medicamentoIDao;

    public MedicamentoService (IDao<Medicamento> medicamentoIDao){

        this.medicamentoIDao = medicamentoIDao;

    }

    public Medicamento salvar(Medicamento medicamento) throws SQLException {
        return  medicamentoIDao.salvar(medicamento);
    }

    public Medicamento buscar(Integer id) throws SQLException {
        return medicamentoIDao.buscar(id);
    }


}

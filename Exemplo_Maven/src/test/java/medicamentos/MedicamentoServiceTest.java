package medicamentos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MedicamentoServiceTest {

    MedicamentoService medicamentoService;

    @BeforeEach
    void doBefore(){
        medicamentoService = new MedicamentoService(new MedicamentoDaoH2((new ConfiguracaoJDBC())));
    }

    @Test
    public void guardarMedicamento() throws SQLException {
        Medicamento medicamento = new Medicamento("Ibuprofeno", "Aché", 395, 23.00);
        medicamentoService.salvar(medicamento);
        assertTrue(medicamento.getId()!=null);

        Medicamento medicamento1 = new Medicamento("Dorflex", "SanofiLascou", 550, 26.50);
        medicamentoService.salvar(medicamento1);
        assertTrue(medicamento1.getId()!=null);

    }




}
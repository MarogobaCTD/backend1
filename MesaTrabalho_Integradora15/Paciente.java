package MesaTrabalho_Integradora15;

import java.time.LocalDate;

public class Paciente {

    private Integer id;
    private String nome;
    private String sobrenome;
    private String RG;
    private String dataCadastro;
    private Endereco endereco;

    public Paciente(Integer id, String nome, String sobrenome, String RG, String dataCadastro, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.RG = RG;
        this.dataCadastro = dataCadastro;
        this.endereco = endereco;
    }

    public Paciente(String nome, String sobrenome, String RG, String dataCadastro, Endereco endereco) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.RG = RG;
        this.dataCadastro = dataCadastro;
        this.endereco = endereco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", RG='" + RG + '\'' +
                ", dataCadastro='" + dataCadastro + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}

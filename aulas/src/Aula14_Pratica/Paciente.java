package Aula14_Pratica;

public class Paciente {
    private String nome, sobrenome, endereço, RG, dataCadastro, nomeUsuário, senha;


    public Paciente(String nome, String sobrenome, String endereço, String RG, String dataCadastro, String nomeUsuário, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.endereço = endereço;
        this.RG = RG;
        this.dataCadastro = dataCadastro;
        this.nomeUsuário = nomeUsuário;
        this.senha = senha;
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

    public String getEndereço() {
        return endereço;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
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

    public String getNomeUsuário() {
        return nomeUsuário;
    }

    public void setNomeUsuário(String nomeUsuário) {
        this.nomeUsuário = nomeUsuário;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}

package MesaTrabalho_A13;

public class Dentista {
    private Integer id;
    private String sobrenome;
    private String nome;
    private Integer matricula;


    public Dentista(Integer id, String sobrenome, String nome, Integer matricula) {
        this.id = id;
        this.sobrenome = sobrenome;
        this.nome = nome;
        this.matricula = matricula;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getMatricula() {
        return matricula;
    }

    public void setMatricula(Integer matricula) {
        this.matricula = matricula;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

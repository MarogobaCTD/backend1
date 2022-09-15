import java.io.Serializable;

public class Cachorro implements Serializable {
    private String nome;
    private String raca;
    private int idade;
    private String direcao;

    public Cachorro(String nome, String raca, int idade, String direcao) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.direcao = direcao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDirecao() {
        return direcao;
    }

    public void setDirecao(String direcao) {
        this.direcao = direcao;
    }

    @Override
    public String toString() {
        return "Cachorro{" +
                "nome='" + nome + '\'' +
                ", raca='" + raca + '\'' +
                ", idade=" + idade +
                ", direcao='" + direcao + '\'' +
                '}';
    }
}

package src;
public class Participante {
    private String nome;
    private String email;

    public Participante(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Participante(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Participante: " + nome + ", Email: " + email;
    }
}

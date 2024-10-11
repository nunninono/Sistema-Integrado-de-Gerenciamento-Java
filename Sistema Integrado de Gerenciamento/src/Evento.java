package src;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nome;
    private String data;
    private Local local;
    private int capacidadeMaxima;
    private List<Participante> participantes;

    public Evento(String nome, String data, Local local, int capacidadeMaxima) {
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.capacidadeMaxima = capacidadeMaxima;
        this.participantes = new ArrayList<>();
    }

    public boolean registrarParticipante(Participante participante) {
        if (participantes.size() < capacidadeMaxima) {
            participantes.add(participante);
            System.out.println("participante adicionado!");
            return true;
        } else {
            System.out.println("Evento lotado!");
            return false;
        }
    }

    public boolean verificarLotacao() {
        return participantes.size() >= capacidadeMaxima;
    }

    public void gerarRelatorio() {
        System.out.println("Relatório do Evento: " + nome);
        System.out.println("Local: " + local);
        System.out.println("Data: " + data);
        System.out.println("Participantes (" + participantes.size() + "/" + capacidadeMaxima + "):");
        for (Participante p : participantes) {
            System.out.println(p);
        }
    }

    public List<Participante> getParticipante() {
        return participantes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public int getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(int capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }
}

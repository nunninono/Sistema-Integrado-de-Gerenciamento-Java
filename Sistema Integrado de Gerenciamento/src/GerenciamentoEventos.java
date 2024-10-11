package src;
public class GerenciamentoEventos {

    public static void main(String[] args) {
        Local local = new Local("Centro de Convenções", "Av. Principal, 100");

        Evento evento = new Evento("Conferência de Tecnologia", "10/12/2024", local, 3);

        Participante p1 = new Participante("João Silva", "joao@example.com");
        Participante p2 = new Participante("Maria Souza", "maria@example.com");
        Participante p3 = new Participante("Carlos Pereira", "carlos@example.com");
        Participante p4 = new Participante("Ana Costa", "ana@example.com");

        evento.registrarParticipante(p1);
        evento.registrarParticipante(p2);
        evento.registrarParticipante(p3);
        evento.registrarParticipante(p4);

        evento.gerarRelatorio();
    }
}

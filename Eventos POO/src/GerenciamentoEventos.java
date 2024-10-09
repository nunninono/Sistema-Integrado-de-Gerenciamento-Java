public class GerenciamentoEventos {
    public static void main(String[] args) {
        // Criar local
        Local local = new Local("Centro de Convenções", "Av. Principal, 100");

        // Criar evento
        Evento evento = new Evento("Conferência de Tecnologia", "10/12/2024", local, 3);

        // Criar participantes
        Participante p1 = new Participante("João Silva", "joao@example.com");
        Participante p2 = new Participante("Maria Souza", "maria@example.com");
        Participante p3 = new Participante("Carlos Pereira", "carlos@example.com");
        Participante p4 = new Participante("Ana Costa", "ana@example.com");

        // Registrar participantes
        evento.registrarParticipante(p1);
        evento.registrarParticipante(p2);
        evento.registrarParticipante(p3);
        evento.registrarParticipante(p4); // Este não será registrado porque o evento já estará lotado

        // Gerar relatório
        evento.gerarRelatorio();
    }
}

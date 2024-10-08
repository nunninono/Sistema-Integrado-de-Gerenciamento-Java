public class Consulta {
    // Atributos da classe
    private String data;
    private String horario;
    private boolean prioridade;
    private Medico medico;
    private Paciente paciente;


    public Consulta (String data, String horario, boolean prioridade, Medico medico, Paciente paciente){
        // Construtor da classe
        this.data = data;
        this.horario = horario;
        this.prioridade = false;
        this.medico = medico;
        this.paciente = paciente;
    }
        
    // Cria os gets e sets para acessar os atributos (get para ler, set para editar)
        
    // Gets

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public boolean getPrioridade() {
        return prioridade;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    // Sets

    public void setData (String data) {
        this.data = data;
    }

    public void setHorario (String horario) {
        this.horario = horario;
    }

    // bolean é diferente
    public boolean isPrioridade() {
        return prioridade;
    }

    public void setPrioridade (boolean prioridade) {
        this.prioridade = prioridade;
    }

    public void setMedico (Medico medico) {
        this.medico = medico;
    }

    public void setPaciente (Paciente paciente) {
        this.paciente = paciente;
    }

    // Porcedimentos

    public void possivelPrioridade(boolean Prioridade) {
        if (prioridade == true) {
            System.out.println("E prioritario!!");
        }
        else {
            System.out.println("Nao e prioridade!!");
        }
    }
}

package src;
public class Consulta {
    private String data;
    private String horario;
    private boolean prioridade;
    private Medico medico;
    private Paciente paciente;


    public Consulta (String data, String horario, boolean prioridade, Medico medico, Paciente paciente){
        this.data = data;
        this.horario = horario;
        this.prioridade = prioridade;
        this.medico = medico;
        this.paciente = paciente;
    }

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

    public void possivelPrioridade(boolean Prioridade) {
        if (prioridade == true) {
            System.out.println("    Prioridade: E prioridade");
        }
        else {
            System.out.println("    Prioridade: Nao e prioridade");
        }
    }
}

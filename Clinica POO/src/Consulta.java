public class Consulta {
    // Atributos da classe
    private String data;
    private String horario;
    private String motivo;
    private boolean prioridade;

    public Consulta (String data, String horario, String motivo, boolean prioridade){
        // Construtor da classe
        this.data = data;
        this.horario = horario;
        this.motivo = motivo;
        this.prioridade = false;
    }
        
    // Cria os gets e sets para acessar os atributos (get para ler, set para editar)
        
    // Gets

    public String getData() {
        return data;
    }

    public String getHorario() {
        return horario;
    }

    public String getMotivo() {
        return motivo;
    }

    public boolean getPrioridade() {
        return prioridade;
    }

    // Sets

    public void setData (String data) {
        this.data = data;
    }

    public void setHorario (String horario) {
        this.horario = horario;
    }

    public void setMotivo (String motivo) {
        this.motivo = motivo;
    }

    // bolean é diferente
    public boolean isPrioridade() {
        return prioridade;
    }

    public void setPrioridade (boolean prioridade) {
        this.prioridade = prioridade;
    }
}

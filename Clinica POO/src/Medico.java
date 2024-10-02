public class Medico {
    // Atributos da classe
    private String nomeMedico;
    private boolean disponibilidade;
    private String especialidade;
    private int crm;
    
    public Medico (String nomeMedico, boolean disponibilidade, String especialidade, int crm) {
        // Construtor da classe
        this.nomeMedico = nomeMedico;
        this.disponibilidade = true;
        this.especialidade = especialidade;
        this.crm = crm;

    }

    // Cria os gets e sets pra acessar os atributos (get para ler  set para editar)

    // Gets

    public String getNomeMedico() {
        return nomeMedico;
    }

    public boolean getDisponibilidade() {
        return disponibilidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public int getCrm() {
        return crm;
    }

    // Sets

    public void setNomeMedico (String nomeMedico) {
        this.nomeMedico = nomeMedico;
    }

    public boolean isDisponibiliade() {
        return disponibilidade;
    }

    public void setDisponibilidade (boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void setEspecialidade (String especialidade) {
        this.especialidade = especialidade;
    }

    public void setCrm (int crm) {
        this.crm = crm;
    }

}

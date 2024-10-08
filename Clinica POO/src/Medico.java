public class Medico {
    // Atributos da classe
    private String nomeMedico;
    private boolean disponibilidade;
    private String especializacao;
    private int crm;
    
    public Medico (String nomeMedico, boolean disponibilidade, String especializacao, int crm) {
        // Construtor da classe
        this.nomeMedico = nomeMedico;
        this.disponibilidade = disponibilidade;
        this.especializacao = especializacao;
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

    public String getEspecializacao() {
        return especializacao;
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

    public void setEspecializacao (String especializacao) {
        this.especializacao = especializacao;
    }

    public void setCrm (int crm) {
        this.crm = crm;
    }

    // Procediemntos

    public void estaDisponivel (boolean disponibilidade) {
        if (disponibilidade == true) {
            System.out.println("    Disponibilidade: Disponivel");
        }
        else {
            System.out.println("    Disponibilidade: Indisponivel");
        }
    }

}

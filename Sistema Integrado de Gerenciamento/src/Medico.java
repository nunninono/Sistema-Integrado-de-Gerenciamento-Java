package src;

public class Medico {
    private String nomeMedico;
    private boolean disponibilidade;
    private String especializacao;
    private int crm;
    private int contadorDeConsultas;
    
    public Medico (String nomeMedico, boolean disponibilidade, String especializacao, int crm, int contadorDeConsulta) {
        this.nomeMedico = nomeMedico;
        this.disponibilidade = disponibilidade;
        this.especializacao = especializacao;
        this.crm = crm;
        this.contadorDeConsultas = 0;
    }

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

    public int getContadorDeConsultas() {
        return contadorDeConsultas;
    }

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

    public void estaDisponivel (boolean disponibilidade) {
        if (disponibilidade == true) {
            System.out.println("    Disponibilidade: Disponivel");
        }
        else {
            System.out.println("    Disponibilidade: Indisponivel");
        }
    }

    public void incrementarContadorDeConsultas() {
        this.contadorDeConsultas++;
    }

}

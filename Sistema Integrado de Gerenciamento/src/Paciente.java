package src;
public class Paciente {
    private String nomePaciente;
    private int idade;
    private String sintoma;
    private boolean planoSaude;
    private String numeroContato;
    private String tipoSanguineo;
    
    public Paciente (String nomePaciente, int idade, String sintoma, boolean planoSaude, String numeroContato, String tipoSanguineo){
        this.nomePaciente = nomePaciente;
        this.idade = idade;
        this.sintoma = sintoma;
        this.planoSaude = planoSaude;
        this.numeroContato = numeroContato;
        this.tipoSanguineo = tipoSanguineo;
    }
    
    public String getNomePaciente() {
        return nomePaciente;
    }
    
    public int getIdade() {
        return idade;
    }
    
    public String getSintoma() {
        return sintoma;
    }
    
    public boolean getPlanoSaude() {
        return planoSaude;
    }
    
    public String getNumeroContato() {
        return numeroContato;
    }
    
    public String getTipoSanguineo() {
        return tipoSanguineo;
    }
    
    public void setNomePaciente (String nomePaciente) {
        this.nomePaciente = nomePaciente;
    }
    
    public void setIdade (int idade) {
        this.idade = idade;
    }
    
    public void setSintoma (String sintoma) {
        this.sintoma = sintoma;
    }
    
    public boolean isPlanoSaude (){
        return planoSaude;
    }
    
    public void setPlanoSaude (boolean planoSaude) {
        this.planoSaude = planoSaude;
    }
    
    public void setNumeroContato (String numeroContato) {
        this.numeroContato = numeroContato;
    }
    
    public void setTipoSanguineo (String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }
    
    public void temPlanoSaude(boolean planoSaude) {
        if (planoSaude == true) {
            System.out.println("    Plano de saude: Possui");
        }
        else {
            System.out.println("    Plano de saude: Nao possui");
        }
    }
}

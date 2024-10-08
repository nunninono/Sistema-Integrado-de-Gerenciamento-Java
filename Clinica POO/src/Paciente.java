public class Paciente {
   private String nomePaciente;
   private int idade;
   private String sintoma;
   private boolean planoSaude;
   private String numeroContato;
   private String tipoSanguineo;

   public Paciente(String var1, int var2, String var3, boolean var4, String var5, String var6) {
      this.nomePaciente = var1;
      this.idade = var2;
      this.sintoma = var3;
      this.planoSaude = false;
      this.numeroContato = var5;
      this.tipoSanguineo = var6;
   }

   public String getNomePaciente() {
      return this.nomePaciente;
   }

   public int getIdade() {
      return this.idade;
   }

   public String getSintoma() {
      return this.sintoma;
   }

   public boolean getPlanoSaude() {
      return this.planoSaude;
   }

   public String getNumeroContato() {
      return this.numeroContato;
   }

   public String getTipoSanguineo() {
      return this.tipoSanguineo;
   }

   public void setNomePaciente(String var1) {
      this.nomePaciente = var1;
   }

   public void setIdade(int var1) {
      this.idade = var1;
   }

   public void setSintoma(String var1) {
      this.sintoma = var1;
   }

   public boolean isPlanoSaude() {
      return this.planoSaude;
   }

   public void setPlanoSaude(boolean var1) {
      this.planoSaude = var1;
   }

   public void setNumeroContato(String var1) {
      this.numeroContato = var1;
   }

   public void setTipoSanguineo(String var1) {
      this.tipoSanguineo = var1;
   }

   public void temPlanoSaude(boolean var1) {
      if (var1) {
         System.out.println("Possui plano de saude!");
      } else {
         System.out.println("Nao possui plano de saude!");
      }

   }
}

public class Clinica {
    
    public static void main (String[] args) {
        Consulta consulta = new Consulta("27/08/2024", "16:00", "dor de garganta", false);
        Paciente paciente = new Paciente("Nunno", 19, "Tosse", true, "+55(81)99607-6104", "B-");
        Medico medico = new Medico("João", true, "Cardiologista", 123456);

        System.out.println(consulta.getData());
        System.out.println(paciente.getNomePaciente());
        System.out.println(medico.getNomeMedico());
    }
    
}
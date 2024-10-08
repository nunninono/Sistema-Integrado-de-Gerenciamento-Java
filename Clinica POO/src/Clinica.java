import java.util.ArrayList;
import java.util.List;
// import java.util.Scanner;

public class Clinica {
    
    // Atributos da classe
    private List<Consulta> consultas;
    private List<Medico> medicos;
    private List<Paciente> pacientes;

    // Construtores da Clinica
    public Clinica() { 
        consultas = new ArrayList<>();
        medicos = new ArrayList<>();
        pacientes = new ArrayList<>();
    }

    // Procedimentos

    // Adicionar consulta na lista
    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    // Adicionar medico na lista
    public void adicionarMedico(Medico medico) {
        medicos.add(medico);
    }

    // Adicionar paciente na lista
    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    // Exibe os dados da consulta
    public void exibirDadosConsulta(Consulta consulta) {
        System.out.println("Dados da Consulta:");
        System.out.println("Prioridade: " + consulta.isPrioridade());
        System.out.println("Data: " + consulta.getData());
        System.out.println("Horario: " + consulta.getHorario());
        System.out.println("Medico responsavel: " + consulta.getMedico().getNomeMedico());
        System.out.println("Paciente: " + consulta.getPaciente().getNomePaciente());
    }

    // Exibe os dados do médico
    public void exibirDadosMedico(Medico medico) {
        System.out.println("Dados do Médico:");
        System.out.println("Nome: " + medico.getNomeMedico());
        System.out.println("CRM: " + medico.getCrm());
        System.out.println("Especialização: " + medico.getEspecializacao());
        System.out.println("Disponível: " + medico.getDisponibilidade());
    }

    // Exibe os dados do paciente
    public void exibirDadosPaciente(Paciente paciente) {
        System.out.println("Dados do Paciente:");
        System.out.println("Nome: " + paciente.getNomePaciente());
        System.out.println("Idade: " + paciente.getIdade());
        System.out.println("Sintoma: " + paciente.getSintoma());
        System.out.println("Plano de saude: " + paciente.isPlanoSaude());
        System.out.println("Numero de contato: " + paciente.getNumeroContato());
        System.out.println("Tipo Sanguíneo: " + paciente.getTipoSanguineo());
    }

    public static void main (String[] args) {

        // Cria uma isntância da Clinica
        Clinica clinica = new Clinica();

        // Cria um Paciente, Medico e Consulta
        Paciente paciente = new Paciente("Nunno", 19, "Tosse", true, "+55(81)99607-6104", "B-");
        Medico medico = new Medico("João", true, "Cardiologista", 123456);
        // Inicializar Consulta apenas apos inicializar os objetos Paciente e Medico, pq ambos compõe a Consulta
        Consulta consulta = new Consulta("27/08/2024", "16:00", false, medico, paciente);

        // Adiciona o Paciente, Medico e Consulta à Clinica
        clinica.adicionarPaciente(paciente);
        clinica.adicionarMedico(medico);
        clinica.adicionarConsulta(consulta);

        // Exibe os dados da consulta, do paciente e do médico
        System.out.println("\n");
        clinica.exibirDadosConsulta(consulta);
        System.out.println("\n");
        clinica.exibirDadosPaciente(paciente);
        System.out.println("\n");
        clinica.exibirDadosMedico(medico);
        System.out.println("\n");

        // Cria o Scanner pra inputar dados 
        /*Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            System.out.println("======== MENU DE OPÇÕES ========");
            System.out.println("1. .");
            System.out.println("2. .");
            System.out.println("3. .");
            System.out.println("4. Sair do prorama.");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    
                    break;

                case 2:
                    
                    break;

                case 3:
                    
                    break;

                case 4:
                    System.out.println("Saindo do sistema...\n");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
                    break;
            }
        }
        // Encerra o leitor
        scanner.close();*/
    }
}

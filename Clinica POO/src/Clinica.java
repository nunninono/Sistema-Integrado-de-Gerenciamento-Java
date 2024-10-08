import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    // Criar um novo paciente
    public void criarPaciente() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserir novo Paciente:");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Idade: ");
        int idade = scanner.nextInt();

        System.out.print("Sintoma: ");
        String sintoma = scanner.next();

        System.out.print("Possui plano de saúde? (true/false): ");
        boolean planoSaude = scanner.nextBoolean();

        System.out.print("Número de contato: ");
        String numeroContato = scanner.next();

        System.out.print("Tipo sanguíneo: ");
        String tipoSanguineo = scanner.next();

        Paciente novoPaciente = new Paciente(nome, idade, sintoma, planoSaude, numeroContato, tipoSanguineo);
        adicionarPaciente(novoPaciente);

        System.out.println("Paciente adicionado com sucesso!");
        scanner.close();
    }

    // Criar um novo médico
    public void criarMedico() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserir novo Médico:");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Disponível? (true/false): ");
        boolean disponibilidade = scanner.nextBoolean();

        System.out.print("Especialização: ");
        String especializacao = scanner.next();

        System.out.print("CRM: ");
        int crm = scanner.nextInt();

        Medico novoMedico = new Medico(nome, disponibilidade, especializacao, crm);
        adicionarMedico(novoMedico);

        System.out.println("Médico adicionado com sucesso!");
        scanner.close();
    }

    // Criar uma nova consulta
    public void criarConsulta() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserir nova Consulta:");

        System.out.print("Data (dd/mm/yyyy): ");
        String data = scanner.next();

        System.out.print("Horário (hh:mm): ");
        String horario = scanner.next();

        System.out.print("É prioritária? (true/false): ");
        boolean prioridade = scanner.nextBoolean();

        // Exibe lista de médicos disponíveis
        System.out.println("Médicos disponíveis:");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println(i + ": " + medicos.get(i).getNomeMedico());
        }
        System.out.print("Escolha o médico pelo número: ");
        int medicoIndex = scanner.nextInt();
        Medico medico = medicos.get(medicoIndex);

        // Exibe lista de pacientes
        System.out.println("Pacientes cadastrados:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println(i + ": " + pacientes.get(i).getNomePaciente());
        }
        System.out.print("Escolha o paciente pelo número: ");
        int pacienteIndex = scanner.nextInt();
        Paciente paciente = pacientes.get(pacienteIndex);

        Consulta novaConsulta = new Consulta(data, horario, prioridade, medico, paciente);
        adicionarConsulta(novaConsulta);

        System.out.println("Consulta adicionada com sucesso!");
        scanner.close();
    }

    // Exibe os dados da consulta
    public void exibirDadosConsulta(Consulta consulta) {
        System.out.println("Dados da Consulta:");
        System.out.println("Data: " + consulta.getData());
        System.out.println("Horario: " + consulta.getHorario());
        System.out.println("Medico responsavel: " + consulta.getMedico().getNomeMedico());
        System.out.println("Paciente: " + consulta.getPaciente().getNomePaciente());
        // Usar o método da própria classe para verificar prioridade
        consulta.possivelPrioridade(consulta.isPrioridade());
    }

    // Exibe os dados do médico
    public void exibirDadosMedico(Medico medico) {
        System.out.println("Dados do Médico:");
        System.out.println("Nome: " + medico.getNomeMedico());
        System.out.println("CRM: " + medico.getCrm());
        System.out.println("Especialização: " + medico.getEspecializacao());
        // Usar o método da própria classe para verificar disponibilidade
        medico.estaDisponivel(medico.getDisponibilidade());
    }

    // Exibe os dados do paciente
    public void exibirDadosPaciente(Paciente paciente) {
        System.out.println("Dados do Paciente:");
        System.out.println("Nome: " + paciente.getNomePaciente());
        System.out.println("Idade: " + paciente.getIdade());
        System.out.println("Sintoma: " + paciente.getSintoma());
        System.out.println("Numero de contato: " + paciente.getNumeroContato());
        System.out.println("Tipo Sanguíneo: " + paciente.getTipoSanguineo());
        // Usar o método da própria classe para verificar plano de saúde
        paciente.temPlanoSaude(paciente.isPlanoSaude());
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

        // Loop com a interface
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

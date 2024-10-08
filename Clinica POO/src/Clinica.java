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
    public void criarPaciente(Scanner scanner) {
        // Passa scanner por parametro pra evitar erro de "NoSuchElementException"

        System.out.println("\nInserir novo Paciente:");

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

        // Instancia o novo Paciente
        Paciente novoPaciente = new Paciente(nome, idade, sintoma, planoSaude, numeroContato, tipoSanguineo);
        adicionarPaciente(novoPaciente);

        System.out.println("\nPaciente adicionado com sucesso!");
    }

    // Criar um novo médico
    public void criarMedico(Scanner scanner) {
        // Passa scanner por parametro pra evitar erro de "NoSuchElementException"

        System.out.println("\nInserir novo Médico:");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Disponível? (true/false): ");
        boolean disponibilidade = scanner.nextBoolean();

        System.out.print("Especialização: ");
        String especializacao = scanner.next();

        System.out.print("CRM: ");
        int crm = scanner.nextInt();

        // Instancia o novo Medico
        Medico novoMedico = new Medico(nome, disponibilidade, especializacao, crm);
        adicionarMedico(novoMedico);

        System.out.println("\nMédico adicionado com sucesso!");
    }

    // Criar uma nova consulta
    public void criarConsulta(Scanner scanner) {
        // Passa scanner por parametro pra evitar erro de "NoSuchElementException"

        // Verificar se há médicos cadastrados
        if (medicos.isEmpty()) {
            System.out.println("\nErro: Nenhum médico cadastrado! Por favor, cadastre um médico antes de criar uma consulta.");
            return; // Sai do método sem criar a consulta
        }

        // Verificar se há pacientes cadastrados
        if (pacientes.isEmpty()) {
            System.out.println("\nErro: Nenhum paciente cadastrado! Por favor, cadastre um paciente antes de criar uma consulta.");
            return; // Sai do método sem criar a consulta
        }

        System.out.println("\nInserir nova Consulta:");

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

        // Instancia uma nova Consulta
        Consulta novaConsulta = new Consulta(data, horario, prioridade, medico, paciente);
        adicionarConsulta(novaConsulta);

        System.out.println("\nConsulta adicionada com sucesso!");
    }

    // Exibe os dados da consulta
    public void exibirDadosConsulta(Consulta consulta) {
        System.out.println("\nDados da Consulta:");
        System.out.println("Data: " + consulta.getData());
        System.out.println("Horario: " + consulta.getHorario());
        System.out.println("Medico responsavel: " + consulta.getMedico().getNomeMedico());
        System.out.println("Paciente: " + consulta.getPaciente().getNomePaciente());
        // Usar o método da própria classe para verificar prioridade
        consulta.possivelPrioridade(consulta.isPrioridade());
    }

    // Exibe os dados do médico
    public void exibirDadosMedico(Medico medico) {
        System.out.println("\nDados do Médico:");
        System.out.println("Nome: " + medico.getNomeMedico());
        System.out.println("CRM: " + medico.getCrm());
        System.out.println("Especialização: " + medico.getEspecializacao());
        // Usar o método da própria classe para verificar disponibilidade
        medico.estaDisponivel(medico.getDisponibilidade());
    }

    // Exibe os dados do paciente
    public void exibirDadosPaciente(Paciente paciente) {
        System.out.println("\nDados do Paciente:");
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
        System.out.println("\n--- Dados Iniciais ---");
        clinica.exibirDadosConsulta(consulta);
        clinica.exibirDadosPaciente(paciente);
        clinica.exibirDadosMedico(medico);
        System.out.println("\n---------------------\n");

        // Cria o Scanner pra inputar dados 
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        // Loop com a interface
        while (continuar) {
            System.out.println("======== MENU DE OPÇÕES ========");
            System.out.println("1. Inserir novo Paciente.");
            System.out.println("2. Inserir novo Medico.");
            System.out.println("3. Inserir uma nova Consulta.");
            System.out.println("4. Exibir Pacientes.");
            System.out.println("5. Exibir Medicos.");
            System.out.println("6. Exibir Consultas.");
            System.out.println("7. Sair do prorama.");
            System.out.println("================================");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            // Limpa o buffer para evitar erros ao ler strings depois de nextInt()
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    clinica.criarPaciente(scanner);
                    break;

                case 2:
                    clinica.criarMedico(scanner);
                    break;

                case 3:
                    clinica.criarConsulta(scanner);
                    break;
                
                case 4:
                    if (clinica.pacientes.isEmpty()) {
                        System.out.println("Nenhum paciente cadastrado.");
                    } 
                    else {
                        for (Paciente p : clinica.pacientes) {
                            clinica.exibirDadosPaciente(p);
                            System.out.println();
                        }
                    }
                    break;
                
                case 5:
                    if (clinica.medicos.isEmpty()) {
                        System.out.println("Nenhum médico cadastrado.");
                    } 
                    else {
                        for (Medico m : clinica.medicos) {
                            clinica.exibirDadosMedico(m);
                            System.out.println();
                        }
                    }
                    break;
                
                case 6:
                    if (clinica.consultas.isEmpty()) {
                        System.out.println("Nenhuma consulta cadastrada.");
                    } 
                    else {
                        for (Consulta c : clinica.consultas) {
                            clinica.exibirDadosConsulta(c);
                            System.out.println();
                        }
                    }
                    break;

                case 7:
                    System.out.println("Saindo do sistema...\n");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.\n");
                    break;
            }
        }
        // Encerra o leitor
        scanner.close();
    }
}

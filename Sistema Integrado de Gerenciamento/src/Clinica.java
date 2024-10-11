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

        System.out.println("\nPaciente adicionado com sucesso!\n");
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
        Medico novoMedico = new Medico(nome, disponibilidade, especializacao, crm, 0);
        adicionarMedico(novoMedico);

        System.out.println("\nMédico adicionado com sucesso!\n");
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
        System.out.println("\nMédicos disponíveis:");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println(i + ": " + medicos.get(i).getNomeMedico());
        }
        System.out.print("Escolha o médico pelo número: ");
        int novoMedico = scanner.nextInt();
        Medico medico = medicos.get(novoMedico);

        medico.incrementarContadorDeConsultas(); // Incrementa o contador de consultas do médico
    
        // Verificar se o médico já tem uma consulta marcada no mesmo horário e data
        boolean medicoDisponivel = true;
        for (Consulta consulta : consultas) {   // Percorre todas as consultas agendadas
            if (consulta.getMedico().equals(medico) && consulta.getData().equals(data) && consulta.getHorario().equals(horario)) {
                medicoDisponivel = false;
                break;
            }
        }
    
        if (medicoDisponivel == false) {
            System.out.println("\nErro: O médico " + medico.getNomeMedico() + " já possui uma consulta marcada para " + data + " às " + horario + ". Escolha outro horário ou outro médico.\n");
            return; // Sai do método sem criar a consulta
        }

        // Exibe lista de pacientes
        System.out.println("\nPacientes cadastrados:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println(i + ": " + pacientes.get(i).getNomePaciente());
        }
        System.out.print("Escolha o paciente pelo número: ");
        int pacienteIndex = scanner.nextInt();
        Paciente paciente = pacientes.get(pacienteIndex);

        // Instancia uma nova Consulta
        Consulta novaConsulta = new Consulta(data, horario, prioridade, medico, paciente);
        adicionarConsulta(novaConsulta);

        System.out.println("\nConsulta adicionada com sucesso!\n");
    }

    // Exibe os dados da consulta
    public void exibirDadosConsulta(Consulta consulta) {
        System.out.println("\nDados da Consulta (" + consulta.getHorario() + "):");
        System.out.println("    Data: " + consulta.getData());
        System.out.println("    Horario: " + consulta.getHorario());
        System.out.println("    Medico responsavel: " + consulta.getMedico().getNomeMedico());
        System.out.println("    Paciente: " + consulta.getPaciente().getNomePaciente());
        // Usar o método da própria classe para verificar prioridade
        consulta.possivelPrioridade(consulta.isPrioridade());
    }

    // Exibe os dados do médico
    public void exibirDadosMedico(Medico medico) {
        System.out.println("\nDados do Médico " + medico.getNomeMedico() + ":");
        System.out.println("    Nome: " + medico.getNomeMedico());
        System.out.println("    CRM: " + medico.getCrm());
        System.out.println("    Especialização: " + medico.getEspecializacao());
        // Usar o método da própria classe para verificar disponibilidade
        medico.estaDisponivel(medico.getDisponibilidade());
    }

    // Exibe os dados do paciente
    public void exibirDadosPaciente(Paciente paciente) {
        System.out.println("\nDados do Paciente " + paciente.getNomePaciente() + ":");
        System.out.println("    Nome: " + paciente.getNomePaciente());
        System.out.println("    Idade: " + paciente.getIdade());
        System.out.println("    Sintoma: " + paciente.getSintoma());
        System.out.println("    Numero de contato: " + paciente.getNumeroContato());
        System.out.println("    Tipo Sanguíneo: " + paciente.getTipoSanguineo());
        // Usar o método da própria classe para verificar plano de saúde
        paciente.temPlanoSaude(paciente.isPlanoSaude());
        
    }

    // Método para exibir o médico mais solicitado
    public void medicoMaisSolicitado() {
        if (medicos.isEmpty()) {
            System.out.println("Nenhum médico registrado.");
            return;
        }

        Medico medicoMaisSolicitado = null;
        int maxConsultas = 0;

        // Percorre a lista de médicos e verifica quem tem o maior contador de consultas
        for (Medico medico : medicos) {
            if (medico.getContadorDeConsultas() > maxConsultas) {
                maxConsultas = medico.getContadorDeConsultas();
                medicoMaisSolicitado = medico;
            }
        }

        if (medicoMaisSolicitado != null) {
            System.out.println("\nO médico mais solicitado é: " + medicoMaisSolicitado.getNomeMedico() + " com " + maxConsultas + " consultas.\n");
        }
    }

    // Função para exibir todos os horários e datas de consultas de um médico específico
    public void datasHorariosDeUmMedico(Scanner scanner) {
        if (consultas.isEmpty()) {
            System.out.println("Nenhuma consulta cadastrada.");
            return;
        }

        // Solicitar o CRM ou nome do médico
        System.out.print("\nDigite o nome ou o CRM do médico: ");
        String entrada = scanner.nextLine();

        Medico medicoEncontrado = null;

        // Tentar encontrar o médico pelo nome ou CRM
        try {
            int crm = Integer.parseInt(entrada); // Tentar tratar como CRM (número)
            for (Medico medico : medicos) {
                if (medico.getCrm() == crm) {
                    medicoEncontrado = medico;
                    break;
                }
            }
        } 
        catch (NumberFormatException e) {
            // Se a entrada não for um número, buscar pelo nome
            for (Medico medico : medicos) {
                if (medico.getNomeMedico().equalsIgnoreCase(entrada)) {
                    medicoEncontrado = medico;
                    break;
                }
            }
        }

        // Verificar se o médico foi encontrado
        if (medicoEncontrado == null) {
            System.out.println("Médico não encontrado.\n");
            return;
        }

        // Exibir todas as consultas do médico encontrado
        System.out.println("\nConsultas agendadas para o médico " + medicoEncontrado.getNomeMedico() + ":");

        boolean encontrouConsulta = false;

        for (Consulta consulta : consultas) {
            if (consulta.getMedico().equals(medicoEncontrado)) {
                System.out.println("Data: " + consulta.getData() + " | Horário: " + consulta.getHorario());
                encontrouConsulta = true;
            }
        }

        System.out.println("\n");

        if (encontrouConsulta == false) {
            System.out.println("Este médico não tem consultas agendadas.\n");
        }
    }

    public static void main (String[] args) {

        // Cria uma isntância da Clinica
        Clinica clinica = new Clinica();

        // Cria um Paciente, Medico e Consulta
        Paciente paciente = new Paciente("Nunno", 19, "Tosse", true, "+55(81)99607-6104", "B-");
        Medico medico = new Medico("joao", true, "Cardiologista", 123456, 1);
        // Inicializar Consulta apenas apos inicializar os objetos Paciente e Medico, pq ambos compõe a Consulta
        Consulta consulta = new Consulta("27/08/2024", "16:00", true, medico, paciente);

        // Adiciona o Paciente, Medico e Consulta à Clinica
        clinica.adicionarPaciente(paciente);
        clinica.adicionarMedico(medico);
        clinica.adicionarConsulta(consulta);

        // Exibe os dados da consulta, do paciente e do médico
        System.out.println("\n------------ Dados Iniciais ------------");
        clinica.exibirDadosConsulta(consulta);
        clinica.exibirDadosPaciente(paciente);
        clinica.exibirDadosMedico(medico);
        System.out.println("\n----------------------------------------\n");

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
            // Perguntas para auxiliar na tomada de decisão
            System.out.println("7. Qual o medico mais solicitado?");
            System.out.println("8. Quais os horários e datas que um medico específico está ocupado?");
            System.out.println("9. Sair do prorama.");
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
                    clinica.medicoMaisSolicitado();
                    break;
                
                case 8:
                    clinica.datasHorariosDeUmMedico(scanner);
                    break;

                case 9:
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

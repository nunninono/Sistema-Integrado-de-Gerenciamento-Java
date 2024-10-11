package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clinica {
    
    private List<Consulta> consultas;
    private List<Medico> medicos;
    private List<Paciente> pacientes;

    public Clinica() { 
        consultas = new ArrayList<>();
        medicos = new ArrayList<>();
        pacientes = new ArrayList<>();
    }

    public List<Medico> getMedicos() {
        return medicos;
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void adicionarConsulta(Consulta consulta) {
        consultas.add(consulta);
    }

    public void adicionarMedico(Medico medico) {
        medicos.add(medico);
    }

    public void adicionarPaciente(Paciente paciente) {
        pacientes.add(paciente);
    }

    public void criarPaciente(Scanner scanner) {

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

        Paciente novoPaciente = new Paciente(nome, idade, sintoma, planoSaude, numeroContato, tipoSanguineo);
        adicionarPaciente(novoPaciente);

        System.out.println("\nPaciente adicionado com sucesso!\n");
    }

    public void criarMedico(Scanner scanner) {

        System.out.println("\nInserir novo Médico:");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Disponível? (true/false): ");
        boolean disponibilidade = scanner.nextBoolean();

        System.out.print("Especialização: ");
        String especializacao = scanner.next();

        System.out.print("CRM: ");
        int crm = scanner.nextInt();

        Medico novoMedico = new Medico(nome, disponibilidade, especializacao, crm, 0);
        adicionarMedico(novoMedico);

        System.out.println("\nMédico adicionado com sucesso!\n");
    }

    public void criarConsulta(Scanner scanner) {

        if (medicos.isEmpty()) {
            System.out.println("\nErro: Nenhum médico cadastrado! Por favor, cadastre um médico antes de criar uma consulta.");
            return;
        }

        if (pacientes.isEmpty()) {
            System.out.println("\nErro: Nenhum paciente cadastrado! Por favor, cadastre um paciente antes de criar uma consulta.");
            return;
        }

        System.out.println("\nInserir nova Consulta:");

        System.out.print("Data (dd/mm/yyyy): ");
        String data = scanner.next();

        System.out.print("Horário (hh:mm): ");
        String horario = scanner.next();

        System.out.print("É prioritária? (true/false): ");
        boolean prioridade = scanner.nextBoolean();

        System.out.println("\nMédicos disponíveis:");
        for (int i = 0; i < medicos.size(); i++) {
            System.out.println(i + ": " + medicos.get(i).getNomeMedico());
        }
        System.out.print("Escolha o médico pelo número: ");
        int novoMedico = scanner.nextInt();
        Medico medico = medicos.get(novoMedico);

        medico.incrementarContadorDeConsultas();
    
        boolean medicoDisponivel = true;
        for (Consulta consulta : consultas) {
            if (consulta.getMedico().equals(medico) && consulta.getData().equals(data) && consulta.getHorario().equals(horario)) {
                medicoDisponivel = false;
                break;
            }
        }
    
        if (medicoDisponivel == false) {
            System.out.println("\nErro: O médico " + medico.getNomeMedico() + " já possui uma consulta marcada para " + data + " às " + horario + ". Escolha outro horário ou outro médico.\n");
            return;
        }

        System.out.println("\nPacientes cadastrados:");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println(i + ": " + pacientes.get(i).getNomePaciente());
        }
        System.out.print("Escolha o paciente pelo número: ");
        int pacienteIndex = scanner.nextInt();
        Paciente paciente = pacientes.get(pacienteIndex);

        Consulta novaConsulta = new Consulta(data, horario, prioridade, medico, paciente);
        adicionarConsulta(novaConsulta);

        System.out.println("\nConsulta adicionada com sucesso!\n");
    }

    public void exibirDadosConsulta(Consulta consulta) {
        System.out.println("\nDados da Consulta (" + consulta.getHorario() + "):");
        System.out.println("    Data: " + consulta.getData());
        System.out.println("    Horario: " + consulta.getHorario());
        System.out.println("    Medico responsavel: " + consulta.getMedico().getNomeMedico());
        System.out.println("    Paciente: " + consulta.getPaciente().getNomePaciente());
        consulta.possivelPrioridade(consulta.isPrioridade());
    }

    public void exibirDadosMedico(Medico medico) {
        System.out.println("\nDados do Médico " + medico.getNomeMedico() + ":");
        System.out.println("    Nome: " + medico.getNomeMedico());
        System.out.println("    CRM: " + medico.getCrm());
        System.out.println("    Especialização: " + medico.getEspecializacao());
        medico.estaDisponivel(medico.getDisponibilidade());
    }

    public void exibirDadosPaciente(Paciente paciente) {
        System.out.println("\nDados do Paciente " + paciente.getNomePaciente() + ":");
        System.out.println("    Nome: " + paciente.getNomePaciente());
        System.out.println("    Idade: " + paciente.getIdade());
        System.out.println("    Sintoma: " + paciente.getSintoma());
        System.out.println("    Numero de contato: " + paciente.getNumeroContato());
        System.out.println("    Tipo Sanguíneo: " + paciente.getTipoSanguineo());
        paciente.temPlanoSaude(paciente.isPlanoSaude());
        
    }

    public static void main (String[] args) {

        Clinica clinica = new Clinica();

        Paciente paciente = new Paciente("Nunno", 19, "Tosse", true, "+55(81)99607-6104", "B-");
        Medico medico = new Medico("joao", true, "Cardiologista", 123456, 1);
        Consulta consulta = new Consulta("27/08/2024", "16:00", true, medico, paciente);

        clinica.adicionarPaciente(paciente);
        clinica.adicionarMedico(medico);
        clinica.adicionarConsulta(consulta);

        System.out.println("\n------------ Dados Iniciais ------------");
        clinica.exibirDadosConsulta(consulta);
        clinica.exibirDadosPaciente(paciente);
        clinica.exibirDadosMedico(medico);
        System.out.println("\n----------------------------------------\n");

        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

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
        scanner.close();
    }
}
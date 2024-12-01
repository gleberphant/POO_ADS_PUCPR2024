/**
 * ┌────────────────────────────────────────────────────────────────────────┐
 * │            ╔════╗           ╔═════        ╔════╗  ╔═══╗                │
 * │            ╠════╝  ║    ║   ║             ╠════╝  ╠═══╩╗               │
 * │            ║       ╚════╝   ╚═════        ║       ║    ║               │
 * └────────────────────────────────────────────────────────────────────────┘
 * ┌────────────────────────────────────────────────────────────────────────┐
 * │ Análise e Desenvolvimento de Sistemas                                  │
 * │ Fundamentos da Programação Orientada a Objetos (11100010550_20242_20)  │
 * └────────────────────────────────────────────────────────────────────────┘
 *
 * @author HANDERSON GLEBER DE LIMA CAVALCANTI (1112024201103)
 * @version af_semana_008
 * <p>
 * REQUISITOS
O que devo desenvolver?

1) Todos os requisitos das semanas anteriores.
2) Salvar num arquivo de texto os dados de cada financiamento.
Cada linha do arquivo deve conter o valor do imóvel, o valor do financiamento, a taxa de juros, o prazo de financiamento
e os atributos específicos da classe especializada (exemplo: o andar do apartamento, caso seja um financiamento
de apartamento, ou a área construída para uma casa). Depois, leia novamente esses mesmos dados para comprovar que
foram salvos corretamente.

3) Salve um arquivo contendo os dados serializados dos financiamentos. Isto é, salve um arquivo contendo o ArrayList de
financiamentos que você criou no mé_todo main(). Depois, leia novamente esses mesmos dados para comprovar que fora.
 */

package semana08arquivos.main;


import semana08arquivos.builders.*;
import semana08arquivos.utils.exceptions.InterfaceException;
import semana08arquivos.utils.exceptions.LoanException;
import semana08arquivos.model.Loan;
import semana08arquivos.ui.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.InputMismatchException;
import java.util.LinkedList;




/**
 * Classe PRINCIPAL.
 * Contêm o loop central da aplicação.
 *
 * @author HANDERSON GLEBER
 */
public class Main {
    // Declaração e inicialização das variáveis.
    Path pathLogFile;
    Path pathDatafile;

    char loanType;
    boolean running = true;
    double totalPriceProperty, totalPriceLoan;
    LoanBuilder builderLoan;
    UserInterface appInterface;
    LinkedList<Loan> listLoans;

    /**
     * INICIALIZA AS VARIÁVEIS DA APLICAÇÃO
     * */
    void init(){

       System.out.println("Iniciando variáveis. ");
        // Declaração e inicialização de array de financiamentos
        listLoans = new LinkedList<>();

        // Declaração e inicialização da interface
        appInterface = UserInterface.getInstance().initialize();

        // Mensagem de abertura
        appInterface.viewOpening();

        // Path do banco de dados
        pathDatafile = Paths.get("loanDatabase.dat");

        // Path do log do sistema
        pathLogFile = Paths.get("logFile.txt");

        writeLog("Iniciando aplicação. ");
    }

    /**
     * Exibe os financiamentos
     * */
    void showLoans(){
        // Exibir a lista de todos financiamentos
        totalPriceProperty = 0f;
        totalPriceLoan = 0f;
        System.out.println("exibindo financiamentos ");
        for (Loan item : listLoans) {
            // Exibe o financiamento
            appInterface.viewLoan(item);

            //  Soma os valores totais do financiamento.
            totalPriceLoan += item.getPaymentValueTotal();
            totalPriceProperty += item.getPrice();
        }
        System.out.println(" ------- ");
    }

    /**
     * carrega a database
     * */
    void loadDatabase(){

        System.out.printf("\n Carregando Banco de Dados %s ...   ", pathDatafile);

        // Verifica se o arquivo de banco de dados existe.
        if(!Files.exists(pathDatafile)){
            System.out.print(" Arquivo inexistente \n ");
            writeLog(String.format("Arquivo não encontrado > %s",pathDatafile.getFileName()));

            try {
                // Cria o arquivo de banco de dados.
                Files.createFile(pathDatafile);
                System.out.printf("\n Arquivo criado %s ...   ", pathDatafile);
                writeLog(String.format("Arquivo de database criado com sucesso > %s",pathDatafile.getFileName()));

            } catch (IOException e) {
                // exibe mensagem de erro para o usuário.
                appInterface.viewException("Falha catastrófico ao criar arquivo de Bando de dados.");

                // registra o evento no log.
                writeLog(String.format("Error criação do arquivo DB > %s",e.getMessage()));

                // encerramento da aplicação
                appInterface.viewClosure();
            }
        }
        // abrir a base de dados serializada
        try (ObjectInputStream inputFile = new ObjectInputStream( Files.newInputStream(pathDatafile) ) )
        {
            listLoans = (LinkedList<Loan>) inputFile.readObject();
            System.out.print(" [ ok ] \n");

        }catch(EOFException e){
            // exibe mensagem de erro para o usuário.
            appInterface.viewException("Banco de dados vazio.");

            listLoans = new LinkedList<>();
            // registra o evento no log.
            writeLog("Banco dados vazio ");

        }catch(IOException | ClassNotFoundException e){
            // exibe mensagem de erro para o usuário.
            appInterface.viewException("Falha catastrófico ao abrir Bando de dados.");

            // registra o evento no log.
            writeLog(String.format("Error na abertura do arquivo DB > %s",e.getMessage()));

            // encerramento da aplicação
            appInterface.viewClosure();
        }
    }

    /**
     * salva a database
     * */
    void saveDatabase(){

        // Abrir arquivo de database.
        try (ObjectOutputStream outputFile = new ObjectOutputStream(Files.newOutputStream(pathDatafile) ) ) {

            // serializa e escreve o objeto o financiamento.
            System.out.print("\n SALVANDO DADOS EM ARQUIVO > ");
            outputFile.writeObject(listLoans);
            System.out.print("[ok] \n");

            this.writeLog("Arquivo de base de dados salvo com sucesso .");

        }catch(IOException e){

            // exibe mensagem de erro para o usuário.
            appInterface.viewException(e.getMessage());  // Exibe Exception.

            // registra o evento no log.
            this.writeLog(String.format("Falha > %s",e.getMessage()));

            // encerramento da aplicação
            this.appInterface.viewClosure();

        }
    }

    /**
     * Loop principal do programa
     * */
    void run() {

        // Loop principal da aplicação. termina somente quando usuário pedir para sair
        do {
            // exibir todos os financiamentos
            showLoans();

            // Bloco try para captar exceções de tipo entrada inválida ou de valor inválido.
            try {
                // Leitura dos dados do financiamento.
                loanType = appInterface.promptType();

                // define o item de financiamento
                switch (loanType) {
                    case '1':
                        builderLoan = new HouseBuilder()
                                .LandArea(appInterface.promptLandArea())
                                .BuildArea(appInterface.in().promptBuildArea());
                        break;

                    case '2':
                        builderLoan = new ApartBuilder()
                                .FloorNumber(appInterface.in().promptFloor())
                                .GaragesCount(appInterface.in().promptGarages());
                        break;

                    case '3':
                        builderLoan = new LandBuilder()
                                .Zone(appInterface.promptZone());
                        break;

                    case '4':
                        showLog();
                        continue;

                    case '5':
                        running = false;
                        return;

                    default:
                        throw new InterfaceException("OPÇÃO INVÁLIDA ");
                }

                // Conclui a criação do financiamento e adiciona na lista.
                listLoans.add(builderLoan
                        .Price(appInterface.in().promptPrice())
                        .Term(appInterface.in().promptTerm())
                        .Fee(appInterface.in().promptFee())
                        .build());

                // registra o evento no log.
                writeLog("Novo Financiamento criado com sucesso.");

            } catch (LoanException | InterfaceException | InputMismatchException | IllegalArgumentException e) {

                // exibe a exception para o usuário.
                appInterface.viewException(e.getMessage());

                // registra o evento no log.
                writeLog(String.format(" > %s",e.getMessage()));

                // aguarda usuário pressionar enter
                appInterface.pressEnterToContinue();

                // reinicia o loop
                continue;
            }

            // Exibe o total de todos financiamentos
            appInterface.viewTotals(totalPriceProperty, totalPriceLoan);

            // Pergunta se o usuário deseja sair ou inserir outro financiamento.
            running = appInterface.promptExit();

        } while (running);
    }

    /**
     * Exibir o arquivo de LOG do sistema.
     * */
    void showLog(){

        // abre o  arquivo de  log
        try (BufferedReader log = Files.newBufferedReader(pathLogFile)) {

            // exibe todos os registros do log.
            for (String logString = ""; logString != null; logString = log.readLine()) {
                System.out.printf("\n PG>>> %s", logString);
            }

        } catch (IOException e) {
            // exibe mensagem de erro para o usuário.
            appInterface.viewException(e.getMessage());  // Exibe Exception.

            // registra o evento no log.
            this.writeLog(String.format("Falha > %s",e.getMessage()));

            // encerramento da aplicação
            this.appInterface.viewClosure();
        }

        appInterface.pressEnterToContinue();

    }

    /**
     * Registrar LOG do sistema.
     * */
    void writeLog(String textParam){
        System.out.println("Registrando evento em LOG: "+ textParam);

        try {
            Files.writeString(
                    pathLogFile,
                    String.format("\n [ %s ] %s \n", LocalDateTime.now().format(DateTimeFormatter.ofPattern("d-M-yy H:m")), textParam ),
                    StandardOpenOption.APPEND
            );
        }
        catch (IOException e) {

            // exibe mensagem de erro para o usuário.
            appInterface.viewException(e.getMessage());  // Exibe Exception.

            // registra o evento no log.
            writeLog(String.format("Falha catastrófica > %s",e.getMessage()));

            // encerramento da aplicação
            appInterface.viewClosure();
            System.exit(1);
        }
    }

    /**
     * Main da aplicação
     * */
    public static void main(String[] args){

        Main app = new Main();

        // inicializa as variáveis do sistema.
        app.init();

        // carrega a base de dados salva em arquivo.
        app.loadDatabase();

        // loop principal da aplicação.
        app.run();

        // salvar os financiamentos em arquivo.
        app.saveDatabase();

        // encerramento da aplicação
        app.appInterface.viewClosure();

    }

}



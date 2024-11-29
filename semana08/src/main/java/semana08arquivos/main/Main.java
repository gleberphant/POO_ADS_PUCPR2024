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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.InputMismatchException;
import java.util.LinkedList;

import static java.nio.file.Files.newBufferedReader;

/**
 * Classe PRINCIPAL.
 * Contêm o loop central da aplicação.
 *
 * @author HANDERSON GLEBER
 */
public class Main {

    public static void main(String[] args) {
        // Declaração e inicialização das variáveis.
        char loanType;
        boolean running = true;
        double totalPriceProperty, totalPriceLoan;

        // Declaração e inicialização de array de financiamentos
        LinkedList<Loan> listLoans = new LinkedList<>();

        // Declaração e inicialização da interface
        UserInterface appInterface = UserInterface.getInstance().initialize();

        LoanBuilder builderLoan;

        // Mensagem de abertura
        appInterface.viewOpening();

        // carregando arquivo
        Path pathDatafile = Paths.get("loanDatabase.dat");
        Path pathLogFile = Paths.get("logFile.txt");


        // String logLine;
        StringBuilder logBuilder = new StringBuilder();
        String logString;

        logBuilder.append( String.format("\n [ %s ] Aplicação iniciada   \n" , LocalDateTime.now().format(DateTimeFormatter.ofPattern("d-M-yy H:m"))));

        try (ObjectInputStream inputFile = new ObjectInputStream(
                Files.newInputStream(pathDatafile) ) )
        {

            System.out.printf("\n abrindo ARQUIVO > %s \n ", pathDatafile.toUri());

            listLoans = (LinkedList<Loan>) inputFile.readObject();

            System.out.println("\n Arquivo aberto com sucesso \n");

            logBuilder.append( String.format("\n [ %s ]base de dados carregada com sucesso  \n" , LocalDateTime.now().format(DateTimeFormatter.ofPattern("d-M-yy H:m"))));

        }catch(IOException | ClassNotFoundException e){

            System.out.printf("Falha ao salvar o arquivo > %s", e.getMessage() );
            logBuilder.append( String.format("\n [ %s ]fala ao abrir arquivo de base de dados  \n" , LocalDateTime.now().format(DateTimeFormatter.ofPattern("d-M-yy H:m"))));

        }


        // Loop principal da aplicação. termina somente quando usuário pedir para sair
        do {

            // Percorre a lista com todos os financiamentos
            totalPriceProperty = 0f;
            totalPriceLoan = 0f;

            for (Loan item : listLoans) {
                // Exibe o financiamento
                appInterface.viewLoan(item);

                //  Soma os valores totais do financiamento.
                totalPriceLoan += item.getPaymentValueTotal();
                totalPriceProperty += item.getPrice();
            }

            // Bloco try para captar exceções de tipo entrada inválida ou de valor inválido.
            try {
                // Leitura dos dados do financiamento.
                loanType = appInterface.in().promptType();

                // define o item de financiamento
                builderLoan = switch (loanType) {

                    case '1' -> new HouseBuilder()
                            .LandArea(appInterface.promptLandArea())
                            .BuildArea(appInterface.in().promptBuildArea());

                    case '2' -> new ApartBuilder()
                            .FloorNumber(appInterface.in().promptFloor())
                            .GaragesCount(appInterface.in().promptGarages());

                    case '3' -> new LandBuilder()
                            .Zone(appInterface.promptZone());

                    case '4' -> {
                        // ler e exibir arquivo log
                        try ( Reader log = newBufferedReader(pathLogFile) ){

                            logString = log.read(logString);
                            System.out.printf("\n PG>>> %s", logString);

                        }catch (IOException e){
                            System.out.println("erro ao exibir log");
                        }
                    } // carregar arquivo de log

                    default -> throw new InterfaceException("Valor inválido. Digite uma das opções informadas.");

                };

                // Conclui a criação do financiamento e adiciona na lista.
                listLoans.add(builderLoan
                        .Price(appInterface.in().promptPrice())
                        .Term(appInterface.in().promptTerm())
                        .Fee(appInterface.in().promptFee())
                        .build());

                logBuilder.append( String.format("\n [ %s ] Novo LOAN criado com sucesso   \n" , LocalDateTime.now().format(DateTimeFormatter.ofPattern("d-M-yy H:m"))));

            } catch (LoanException | InterfaceException | InputMismatchException | IllegalArgumentException e) {
                appInterface.viewException(e);  // Exibe Exception.
                continue;  // Reinicia o loop.
            }

            // Salvar em arquivo
            try (ObjectOutputStream outputFile = new ObjectOutputStream(Files.newOutputStream(pathDatafile) ) ) {

                System.out.printf("\n SALVANDO DADOS EM ARQUIVO > %s \n ", pathDatafile);

                outputFile.writeObject(listLoans);

                System.out.println("\n Arquivo salvo com sucesso");

                logBuilder.append( String.format("\n [ %s ] Arquivo de base de dados salvo com sucesso " , LocalDateTime.now().format(DateTimeFormatter.ofPattern("d-M-yy H:m"))));

            }catch(IOException e){

                System.out.printf("\n Falha ao salvar o arquivo > %s \n", e.getMessage() );

            }

            // Salvar log
            try(PrintWriter logFile = new PrintWriter(Files.newOutputStream(pathLogFile))){
                logFile.print(logBuilder.toString());

            } catch (IOException e) {

                System.out.printf("\n erro no arquivo de log [%s] \n", e.getMessage()) ;
            }
            // Exibe o total de todos financiamentos
            appInterface.viewTotals(totalPriceProperty, totalPriceLoan);

            // Pergunta se o usuário deseja sair ou inserir outro financiamento.
            running = appInterface.promptExit();

        } while (running);

        // encerramento da aplicação
        appInterface.viewClosure();

    }
}



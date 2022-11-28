import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import domain.TabelaHashEncadeada;
import util.Aluno;
import util.ValidateException;
import view.InputKeyborad;

public class App {
    static TabelaHashEncadeada hashTable = new TabelaHashEncadeada();

    public static void main(String[] args) throws Exception {

        classInitApplication();

    }

    public static void classInitApplication() {
        logoBash();
        showMenu();

        boolean seguir = false;

        do {
            System.out.println("\n Deseja continuar? (y/n):\n");
            String optionSeguir = new InputKeyborad().getStringValueKeyboard();

            if (optionSeguir.equals("n") || optionSeguir.equals("N")) {
                seguir = true;

            } else {
                showMenu();
            }

        } while (seguir != true);
        
       
    }

    private static void showMenu() {
        showOptionsMessage();
        System.out.println("Digite uma opção para seguir");
        int option = new InputKeyborad().getValueIntegerKeyboard();

       
        if (option == 1) {
            addNewStudent();
        }
        if (option == 2) {
            searchStudent(hashTable);

        }
        if (option == 3) {
            
            removeStudent();
            
        }
        if (option == 4) {
            hashTable.getAllStudents();
        } 
    }

    private static void showOptionsMessage() {
        
        ArrayList<String> messageOptions = new ArrayList<String>();
        messageOptions.add("\n");
        messageOptions.add("1 - Para adicionar um novo aluno;");
        messageOptions.add("2 - Para buscar um aluno pelo numero de matricula;");
        messageOptions.add("3 - Para remover um aluno;");
        messageOptions.add("4 - Para listar todos os alunos; \n");

        for (String message : messageOptions) {
            System.out.println(message);
        }
       
    }

    private static void logoBash() {
        File arquivo = new File("./src/logoBash.txt");
        try {
            FileReader arq = new FileReader(arquivo);
            BufferedReader lerArq = new BufferedReader(arq);
      
            String linha = lerArq.readLine(); 
            while (linha != null) {
              System.out.printf("%s\n", linha);
      
              linha = lerArq.readLine(); // lê da segunda até a última linha
            }
      
            arq.close();
          } catch (IOException e) {
              System.err.printf("Erro na abertura do arquivo: %s.\n",
                e.getMessage());
          }

    }

    private static void removeStudent() {
        
            Aluno alunoRemovido;
            try {
                System.out.println("Digite o numero de matricula para remover uma aluno: ");
                alunoRemovido = hashTable.remove(new InputKeyborad().getValueIntegerKeyboard());
                System.out.println("O Aluno "+alunoRemovido.getNome()+" matricula "+ alunoRemovido.getMatricula());
            } catch (ValidateException e) {
                System.out.println(e.getMessage());
            }
    
           

        
    }

    private static void searchStudent(TabelaHashEncadeada hashTable2) {
        System.out.println("Digite o numero de matricula do estudante" + "\n"
                + "que deseja encontrar");
        Aluno alunoEncontrado = hashTable2.get(new InputKeyborad().getValueIntegerKeyboard());

        if (alunoEncontrado == null) {
            System.err.println("\n Aluno não existe, numero de matricula invalido \n");
            return;
        }
        System.out.println("\n Aluno: " + alunoEncontrado.getNome() + " matricula: " + alunoEncontrado.getMatricula());

    }

    private static void addNewStudent() {
            Aluno novoAluno = new Aluno();
            try {
                System.out.println("Digite o numero de matricula: ");
                novoAluno.setMatricula(new InputKeyborad().getValueIntegerKeyboard());

                System.out.println("Digite o nome do aluno: ");
                novoAluno.setNome(new InputKeyborad().getStringValueKeyboard());

                hashTable.put(novoAluno.getMatricula(), novoAluno);
            } catch (ValidateException e) {
                System.err.println("\n Oops! " + e.getMessage() + "\n");
            }

    }
}

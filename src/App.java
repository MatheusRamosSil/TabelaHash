import domain.TabelaHashEncadeada;
import util.Aluno;

public class App {

    static Aluno aluno;
    static TabelaHashEncadeada hashTable = new TabelaHashEncadeada();


    public static void main(String[] args) throws Exception {

        aluno = new Aluno(1,"teste");
        Aluno aluno2 = new Aluno(2,"teste novo");
        Aluno aluno3 = new Aluno(3,"Matheus");


        hashTable.put(aluno.getMatricula(), aluno);
        hashTable.put(aluno2.getMatricula(), aluno2);
        hashTable.put(aluno3.getMatricula(), aluno3);

        //Aluno encontrado = hashTable.get(1);
      
        hashTable.getAllStudents();

        
    }
}

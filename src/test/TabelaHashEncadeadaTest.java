package test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import domain.TabelaHashEncadeada;
import util.Aluno;
import util.ValidateException;

public class TabelaHashEncadeadaTest {
    Aluno aluno; 
    TabelaHashEncadeada hashTable; 

  
    
    @Test
    public void criandoUmNovoAluno() throws ValidateException{
        aluno = new Aluno(1,"test");
        hashTable = new TabelaHashEncadeada();

        hashTable.put(aluno.getMatricula(), aluno);

        assertTrue(hashTable.isEmpty());
    }

    @Test
    public void buscandoUmAlunoPelaMatricula() throws ValidateException{

        aluno = new Aluno(1,"test");
        hashTable = new TabelaHashEncadeada();

        hashTable.put(aluno.getMatricula(), aluno);

        Aluno alunoEncontrado = hashTable.get(1);
        assertNotNull(alunoEncontrado);

    }

    @Test
    public void removendoUmAluno() throws ValidateException{
        aluno = new Aluno(1,"test");
        hashTable = new TabelaHashEncadeada();

        hashTable.put(aluno.getMatricula(), aluno);

        Aluno alunoRemovido = hashTable.remove(1);
        assertEquals(1, alunoRemovido.getMatricula());
    }


    @Test
    public void verificandoSeExiteAlunosComMesmaMatricula(){
        
        aluno = new Aluno(1,"test");
        Aluno aluno2 = new Aluno(1, "novo teste");

        hashTable = new TabelaHashEncadeada();

        Throwable thrown = assertThrows(ValidateException.class, ()->  {
            hashTable.put(aluno.getMatricula(), aluno);
            hashTable.put(aluno2.getMatricula(), aluno2);
        });

        assertEquals("Já existe aluno com o numero de matricula inserido", thrown.getMessage());
    
       

    }

    @Test
    public void listandoTodosOsAlunos() throws ValidateException{
        aluno = new Aluno(1,"test");
        Aluno aluno2 = new Aluno(2, "novo teste");

        hashTable = new TabelaHashEncadeada();

        hashTable.put(aluno.getMatricula(), aluno);
        hashTable.put(aluno2.getMatricula(), aluno2);

        
    }
}

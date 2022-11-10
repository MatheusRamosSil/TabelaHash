package test;

import util.Aluno;

public class MoockAluno {
    
    private Aluno aluno;
    private int numeroMatricula;
    private String nomeDoAluno;
    
    public MoockAluno( int numeroMatricula, String nomeDoAluno) {
        this.aluno = new Aluno(numeroMatricula, nomeDoAluno);
        this.numeroMatricula = numeroMatricula;
        this.nomeDoAluno = nomeDoAluno;
    }

    

    
}

package domain;

import java.util.ArrayList;
import java.util.Iterator;

import util.Aluno;
import util.ValidateException;

public class TabelaHashEncadeada {

    private ArrayList<Aluno>[] tabela;
    private int size;
    private final int CAPACIDADE_DEFAULT = 20;

    /**
     * Cria uma nova tabela com a capacidade default 20.
     */
    public TabelaHashEncadeada() {
        this.size = CAPACIDADE_DEFAULT;
        this.tabela = new ArrayList[this.size];
    }

    /**
     * Cria uma nova tabela com a capacidade passada como parâmetro.
     * 
     * @param capacidade O número de posições da tabela.
     */
    public TabelaHashEncadeada(int size) {
        this.size = size;
        this.tabela = new ArrayList[this.size];
    }

    /**
     * Calcula o hash de uma determinada chave. A função de hash é simples
     * e usa o método da divisão.
     * 
     * @param chave A chave para a qual se deseja calcular o hash.
     * @return O hash calculado tendo como base a chave e o tamanho da tabela.
     */
    private int hash(Integer chave) {
        return chave % this.tabela.length;
    }

    /**
     * Calcula o hash utilizando o método da multiplicação.
     * 
     * @param chave A chave para a qual o hash deve ser calculado.
     * @return O hash calculado.
     */
    private int hashMultiplicacao(Integer chave) {
        double a = 0.617648934;
        double hash = chave * a;
        hash = (hash % 1) * this.tabela.length;
        return (int) hash;
    }

    public boolean isEmpty() {
        return (tabela.length > 0);
    }

    public int getSizeTable() {
        return size;
    }

    /**
     * Adiciona o par chave, valor na tabela.
     * 
     * @param chave a matrícula do aluno a ser adicionado.
     * @param valor o objeto Aluno a ser adicionado na tabela.
     */
    public void put(Integer chave, Aluno valor) throws ValidateException {
        int hash = hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];

        if (alunos == null) {
            alunos = new ArrayList<Aluno>();
            alunos.add(valor);
            this.tabela[hash] = alunos;

        } else {
            for (int i = 0; i < tabela.length; i++) {
                if (alunos.get(i).getMatricula() == chave) {
                    throw new ValidateException("Já existe aluno com o numero de matricula inserido");
                }
                alunos.add(valor);
                this.tabela[hash] = alunos;
                return;
            }

        }

    }

    /**
     * Recupera o aluno cuja chave é igual a passada como parâmetro.
     * 
     * @param chave a matrícula do aluno.
     * @return o aluno com a matrícula passada como parâmetro. null caso
     *         nenhum aluno presente na tabela tenha a matrícula igual a passada
     *         como
     *         parâmetro.
     */
    public Aluno get(Integer chave) {
        int hash = hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];

        if (alunos == null || alunos.isEmpty())
            return null;

        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equals(chave))
                return aluno;
        }

        return null;
    }

    /**
     * Remove o aluno cuja matrícula é igual a chave passada como parâmetro.
     * 
     * @param chave A matrícula do aluno a ser removido.
     * @return O aluno a ser removido. null caso não haja aluno com a matrícula
     *         passada como parâmetro.
     * @throws ValidateException
     */
    public Aluno remove(int chave) throws ValidateException {
        int hash = hash(chave);
        ArrayList<Aluno> alunos = this.tabela[hash];
        Aluno atual = null;

        if (alunos != null) {
            Iterator<Aluno> it = alunos.iterator();

            while (it.hasNext()) {
                atual = it.next();
                if (atual.getMatricula().equals(chave)) {
                    it.remove();
                    return atual;
                }
            }
        }else{
            throw new ValidateException("\n Parece que esse numero de matricula não existe \n");
        }

        return atual;
    }

    public void getAllStudents() {
        ArrayList<Aluno>[] alunos = this.tabela;
        System.out.println("\n================================");
        for (ArrayList<Aluno> aluno : alunos) {
            if (aluno != null) {
                for (Aluno atual : aluno) {
                    System.out.println(atual.getMatricula() + "\t" + atual.getNome());
                }
            }

        }
        System.out.println("================================");

    }

}
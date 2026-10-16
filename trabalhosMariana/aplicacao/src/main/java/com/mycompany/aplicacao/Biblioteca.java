
package com.mycompany.aplicacao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Pichau
 */
public class Biblioteca {
    private List<Leitor> leitores;
    private List<Livro> livros;
    private List<Emprestimo> emprestimos;
    
    public Biblioteca() {
        this.leitores = new ArrayList<>();
        this.livros = new ArrayList<>();
        this.emprestimos = new ArrayList();
    }
    
    public boolean cadastrarLeitor(Leitor leitor) {
        if (leitor != null && leitor.getCodigo() > 0 && consultarLeitor(leitor.getCodigo()) == null ) {
            leitores.add(leitor);
            return true;
        }
        return false;
    }
    
    public Leitor consultarLeitor(int codigo) {
        for (Leitor l: leitores) {
            if (l.getCodigo() == codigo) {
                return l;
            }
        }
        return null;
    }
    
    public void listarLeitores() {
        if (leitores.isEmpty()) {
            System.out.println("Não há leitores cadastrados.");
        }
        for (Leitor l : leitores ) {
            System.out.println(l);
        }
    }
    
    public boolean removerLeitor(Leitor leitor) {
        if (leitor == null) {
            return false;
        }
        for (Emprestimo e : emprestimos) {
            if (e.isAberto() && e.getLeitor().getCodigo() == leitor.getCodigo()) {
                return false;
            }
        }
        return leitores.remove(leitor);
    }
    
    public boolean cadastrarLivro(Livro livro) {
        if (livro != null && livro.getCodigo() > 0 && consultarLivro(livro.getCodigo())== null) {
            livros.add(livro);
            return true;
        }
        return false;
    }
    
    public Livro consultarLivro(int codigo) {
        for (Livro l: livros) {
            if (l.getCodigo()== codigo) {
                return l;
            }
        }
        return null;
    }
    
    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Não há livros cadastrados");
        }
        
        for (Livro l : livros) {
            System.out.println(l);
        }
    }
    
    public boolean removerLivro(Livro livro) {
        if (livro == null) {
            return false;
        }
        for (Emprestimo e: emprestimos) {
            if (e.isAberto()) {
                if (e.contemLivro(livro)) {
                    return false;
                }
            }
        }
        return livros.remove(livro);
        }
    
    public boolean registrarEmprestimo(int codigoEmprestimo, Leitor leitor, List<Livro> livrosSelecionados) {
        if (consultarEmprestimo(codigoEmprestimo)!= null || leitor == null || livrosSelecionados == null || livrosSelecionados.isEmpty()) {
            return false;
        }
        
        Emprestimo novoEmprestimo = new Emprestimo(codigoEmprestimo, leitor, LocalDate.now());
        for (Livro l : livrosSelecionados) {
            if (!novoEmprestimo.adicionarLivro(l)) {
                return false;
            }
        }
        
        emprestimos.add(novoEmprestimo);
        return true;
        
    }
    
    public Emprestimo consultarEmprestimo(int codigo) {
        for (Emprestimo e : emprestimos) {
            if (e.getCodigo()== codigo) {
                return e;
            }
        }
        return null;
    }
    
    public void listarEmprestimos() {
        if (emprestimos.isEmpty()) {
            System.out.println("Não há empréstimos registrados");
        }
        for (Emprestimo e : emprestimos) {
            System.out.println(e);
        }
    }
    
    public boolean registrarDevolucao(int codigoEmprestimo) {
        Emprestimo emp = consultarEmprestimo(codigoEmprestimo);
        if (emp != null && emp.isAberto()) {
            emp.finalizar();
            return true;
        }
        return false;
    }
    
    
}

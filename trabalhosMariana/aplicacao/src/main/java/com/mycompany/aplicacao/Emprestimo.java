package com.mycompany.aplicacao;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Pichau
 */
public class Emprestimo {
    private int codigo;
    private LocalDate dataEmprestimo;
    private boolean aberto;
    private Leitor leitor;
    private ArrayList<ItemEmprestimo> itens;
    
    public Emprestimo (int codigo, Leitor leitor, LocalDate dataEmprestimo) {
        this.codigo = codigo;
        this.leitor = leitor;
        this.dataEmprestimo = dataEmprestimo != null ? dataEmprestimo : LocalDate.now();
        this.itens = new ArrayList<>();
        this.aberto = true;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public int getCodigo() {
        return this.codigo;
    }
    
    public void setDataEmprestimo(LocalDate dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }
    
    public LocalDate getDataEmprestimo() {
        return this.dataEmprestimo;
    }
    
    public void setAberto(boolean aberto) {
        this.aberto = aberto;
    }
    
    public boolean isAberto() {
        return this.aberto;
    }
    
    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }
    
    public Leitor getLeitor() {
        return this.leitor;
    }
    
    public void setItens(ArrayList<ItemEmprestimo> itens) {
        this.itens = itens;
    }
    
    public ArrayList<ItemEmprestimo> getItens() {
        return this.itens;
    }
    
    public boolean contemLivro(Livro livro) {
        if (livro == null) {
            return false;
        }
        for (ItemEmprestimo item : itens) {
            if (item.getLivro().getCodigo()== livro.getCodigo()) {
                return true;
            }
        }
        return false;
    }
    
    public boolean adicionarLivro(Livro livro) {
        if (livro != null && livro.isDisponivel()) {
            if (contemLivro(livro)) {
                return false;
            }
            livro.emprestar();
            itens.add(new ItemEmprestimo(livro));
            return true;
        }
        return false;
    }
    
    public void finalizar() {
        for (ItemEmprestimo item: itens) {
            if (! item.isDevolvido()) {
                item.registrarDevolucao();
            }
        }
        this.aberto = false;
    }
    
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/aaaa");
        String dataFormatada = dataEmprestimo != null ? dataEmprestimo.format(formatter) : "";
        String situacaoTexto = aberto ? "aberto" : "finalizado";
        String nomeLeitor = leitor != null ? leitor.getNome() : "N/D";
        
        String livrosStr = "";
        for (int i = 0; i < itens.size(); i++) {
            livrosStr = livrosStr + itens.get(i).getLivro().getTitulo();
            if (i < itens.size() - 1) {
                livrosStr = livrosStr + ", ";
            }
        }

        return codigo + " - " + nomeLeitor + " - " + dataFormatada + " - " + situacaoTexto + " - livros: " + livrosStr;
    }
          
}

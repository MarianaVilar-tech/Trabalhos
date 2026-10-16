
package com.mycompany.aplicacao;

/**
 *
 * @author Pichau
 */
public class ItemEmprestimo {
    private Livro livro;
    private boolean devolvido;
    
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    
    public Livro getLivro() {
        return this.livro;
    }
    
    public ItemEmprestimo(Livro livro){
        this.livro = livro;
        this.devolvido = false;
    } 
    
    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }
    
    public boolean isDevolvido() {
        return this.devolvido;
    }
    
    public void registrarDevolucao() {
        this.devolvido = true;
        this.livro.devolver();
    }
    
    
    
    
    
    
    
    
    
    
    
}

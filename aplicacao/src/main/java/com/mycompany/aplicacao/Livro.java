
package com.mycompany.aplicacao;

/**
 *
 * @author Pichau
 */
public class Livro {
   private int codigo;
   private String titulo;
   private String autor;
   private boolean disponivel;
   
   public Livro(int codigo, String titulo, String autor){
       setCodigo(codigo);
       setTitulo(titulo);
       setAutor(autor);
       this.disponivel = true;
   }
   
   public boolean setCodigo(int codigo) {
       if (codigo > 0) {
           this.codigo = codigo;
           return true;
       }
       return false;
   }
   
   public int getCodigo() {
       return this.codigo;
   }
   
   public boolean setTitulo(String titulo) {
       if (titulo != null && !titulo.trim().isEmpty()) {
           this.titulo = titulo;
           return true;
       }
       return false;
   }
   
   public String getTitulo() {
       return this.titulo;
   }
   
   public boolean setAutor(String autor) {
       if (autor != null && autor.trim().isEmpty()) {
           this.autor = autor;
           return true;
       }
       return false;
   }
   
   public String getAutor() {
       return this.autor;
   }
   
   public void setDisponivel(boolean disponivel) {
       this.disponivel = disponivel;
   }
   
   public boolean isDisponivel() {
       return this.disponivel;
   }
   
   public boolean atualizarDados(String titulo, String autor) {
       if (setTitulo(titulo) && setAutor(autor)) {
           return true;
       }
       return false;
   }
   
   public void emprestar() {
       this.disponivel = false;
   }
   
   public void devolver() {
       this.disponivel = true;
   }
   
   public String toString() {
       String status = disponivel? "disponível" : "indisponível";
       return codigo + "-" + titulo + "(" + autor + ")-" + status;
   }
   
   
   
   
   
   
   
   
   
}

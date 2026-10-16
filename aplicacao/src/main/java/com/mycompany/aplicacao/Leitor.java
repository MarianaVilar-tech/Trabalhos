/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aplicacao;

/**
 *
 * @author Pichau
 */
public class Leitor {
    private int codigo;
    private String nome;
    private String email;

    public Leitor(int codigo, String nome, String email) {
        setCodigo(codigo);
        setNome(nome);
        setEmail(email);
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

    public boolean setNome(String nome) {
        if (nome != null && !nome.trim().isEmpty()) {
            this.nome = nome;
            return true;
        }
        return false;
    }
    
    public String getNome() {
        return this.nome;
    }

    public boolean setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.email = email;
            return true;
        }
        return false;
    }
    
    public String getEmail() {
        return this.email;
    }


    public boolean atualizarDados(String nome, String email) {
        if (setNome(nome) && setEmail(email)) {
            return true;
        }
        return false;
    }

    public String toString() {
        return codigo + " - " + nome + " (" + email + ")";
    }
}

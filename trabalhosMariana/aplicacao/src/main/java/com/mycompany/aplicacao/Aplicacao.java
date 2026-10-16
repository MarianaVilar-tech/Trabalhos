package com.mycompany.aplicacao;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Mariana
 */
public class Aplicacao {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcao = -1;
        
        while (opcao != 0) {
            System.out.println("\\n--- BIBLIOTECA COMUNITÁRIA ---");
            System.out.println("1 - Cadastrar leitor");
            System.out.println("2 - Consultar leitor");
            System.out.println("3 - Listar leitores");
            System.out.println("4 - Atualizar leitor");
            System.out.println("5 - Remover leitor");
            System.out.println("6 - Cadastrar livro");
            System.out.println("7 - Consultar livro");
            System.out.println("8 - Listar livros");
            System.out.println("9 - Atualizar livro");
            System.out.println("10 - Remover livro");
            System.out.println("11 - Registrar empréstimo");
            System.out.println("12 - Listar empréstimos");
            System.out.println("13 - Registrar devolução");
            System.out.println("0 - Sair");
            System.out.println("Escolha uma opção");
        
        if (!scanner.hasNextInt())  {
            System.out.println("Opção inválida");
            scanner.next();
            continue;
        }
        
        opcao = scanner.nextInt();
        scanner.nextLine();
        
        switch (opcao) {
                case 1:
                    System.out.print("Código do leitor: ");
                    int codL = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    String nomeL = scanner.nextLine();
                    System.out.print("E-mail: ");
                    String emailL = scanner.nextLine();

                    Leitor novoLeitor = new Leitor(codL, nomeL, emailL);
                    if (biblioteca.cadastrarLeitor(novoLeitor)) {
                        System.out.println("Leitor cadastrado.");
                    } else {
                        System.out.println("Não foi possível cadastrar o leitor.");
                    }
                    break;

                case 2:
                    System.out.print("Código do leitor a consultar: ");
                    int codConsL = scanner.nextInt();
                    Leitor lConsultado = biblioteca.consultarLeitor(codConsL);
                    if (lConsultado != null) {
                        System.out.println(lConsultado);
                    } else {
                        System.out.println("Registro não encontrado.");
                    }
                    break;

                case 3:
                    biblioteca.listarLeitores();
                    break;

                case 4:
                    System.out.print("Código do leitor a atualizar: ");
                    int codAtuL = scanner.nextInt();
                    scanner.nextLine();
                    Leitor leitorAtu = biblioteca.consultarLeitor(codAtuL);
                    if (leitorAtu != null) {
                        System.out.print("Novo nome: ");
                        String novoNome = scanner.nextLine();
                        System.out.print("Novo e-mail: ");
                        String novoEmail = scanner.nextLine();
                        if (leitorAtu.atualizarDados(novoNome, novoEmail)) {
                            System.out.println("Dados do leitor atualizados.");
                        } else {
                            System.out.println("Não foi possível atualizar os dados.");
                        }
                    } else {
                        System.out.println("Registro não encontrado.");
                    }
                    break;

                case 5:
                    System.out.print("Código do leitor a remover: ");
                    int codRemL = scanner.nextInt();
                    Leitor leitorRem = biblioteca.consultarLeitor(codRemL);
                    if (leitorRem != null) {
                        if (biblioteca.removerLeitor(leitorRem)) {
                            System.out.println("Leitor removido.");
                        } else {
                            System.out.println("Leitor não removido. Há empréstimo aberto.");
                        }
                    } else {
                        System.out.println("Registro não encontrado.");
                    }
                    break;

                case 6:
                    System.out.print("Código do livro: ");
                    int codLivro = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();

                    Livro novoLivro = new Livro(codLivro, titulo, autor);
                    if (biblioteca.cadastrarLivro(novoLivro)) {
                        System.out.println("Livro cadastrado.");
                    } else {
                        System.out.println("Não foi possível cadastrar o livro.");
                    }
                    break;

                case 7:
                    System.out.print("Código do livro a consultar: ");
                    int codConsLiv = scanner.nextInt();
                    Livro livConsultado = biblioteca.consultarLivro(codConsLiv);
                    if (livConsultado != null) {
                        System.out.println(livConsultado);
                    } else {
                        System.out.println("Registro não encontrado.");
                    }
                    break;

                case 8:
                    biblioteca.listarLivros();
                    break;

                case 9:
                    System.out.print("Código do livro a atualizar: ");
                    int codAtuLiv = scanner.nextInt();
                    scanner.nextLine();
                    Livro livroAtu = biblioteca.consultarLivro(codAtuLiv);
                    if (livroAtu != null) {
                        System.out.print("Novo título: ");
                        String novoTitulo = scanner.nextLine();
                        System.out.print("Novo autor: ");
                        String novoAutor = scanner.nextLine();
                        if (livroAtu.atualizarDados(novoTitulo, novoAutor)) {
                            System.out.println("Livro atualizado.");
                        } else {
                            System.out.println("Não foi possível atualizar o livro.");
                        }
                    } else {
                        System.out.println("Registro não encontrado.");
                    }
                    break;

                case 10:
                    System.out.print("Código do livro a remover: ");
                    int codRemLiv = scanner.nextInt();
                    Livro livroRem = biblioteca.consultarLivro(codRemLiv);
                    if (livroRem != null) {
                        if (biblioteca.removerLivro(livroRem)) {
                            System.out.println("Livro removido.");
                        } else {
                            System.out.println("Não foi possível remover o livro.");
                        }
                    } else {
                        System.out.println("Registro não encontrado.");
                    }
                    break;

                case 11:
                    System.out.print("Código do empréstimo: ");
                    int codEmp = scanner.nextInt();
                    System.out.print("Código do leitor: ");
                    int codLeitorEmp = scanner.nextInt();
                    Leitor leitorEmp = biblioteca.consultarLeitor(codLeitorEmp);

                    List<Livro> livrosEmp = new ArrayList<>();
                    int codLivEmp = -1;
                    while (true) {
                        System.out.print("Código do livro a adicionar (ou 0 para encerrar): ");
                        codLivEmp = scanner.nextInt();
                        if (codLivEmp == 0) break;
                        Livro livEmp = biblioteca.consultarLivro(codLivEmp);
                        if (livEmp != null) {
                            livrosEmp.add(livEmp);
                        } else {
                            System.out.println("Registro não encontrado.");
                        }
                    }

                    if (biblioteca.registrarEmprestimo(codEmp, leitorEmp, livrosEmp)) {
                        System.out.println("Empréstimo registrado.");
                    } else {
                        System.out.println("Não foi possível registrar o empréstimo.");
                    }
                    break;

                case 12:
                    biblioteca.listarEmprestimos();
                    break;

                case 13:
                    System.out.print("Código do empréstimo para devolução: ");
                    int codDev = scanner.nextInt();
                    if (biblioteca.registrarDevolucao(codDev)) {
                        System.out.println("Devolução registrada.");
                    } else {
                        System.out.println("Não foi possível registrar a devolução.");
                    }
                    break;

                case 0:
                    System.out.println("Aplicação encerrada.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        }
        scanner.close();
    }
    }
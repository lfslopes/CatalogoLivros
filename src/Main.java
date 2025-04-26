import livros_pacote.Catalogo;
import livros_pacote.Livro;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String RESPOSTA_SIM_PATTERN = "(sim)|(s)";
    private static final String RESPOSTA_NAO_PATTERN = "(nao)|(não)|(n)";

    public static void main(String[] args) {
        Livro l1 = new Livro("1984", "George Orwell", 1949);
        Livro l2 = new Livro("Mistborn - O Império Final", "Brandon Sanderson", 2006);
        Livro l3 = new Livro("Mistborn - O Poço da Ascenção", "Brandon Sanderson", 2007);
        Livro l4 = new Livro("Mistborn - O Herói das Eras", "Brandon Sanderson", 2008);
        Livro l5 = new Livro("Elantris", "Brandon Sanderson", 2005);
        Livro l6 = new Livro("A Sacramentadora", "Brandon Sanderson", 2024);
        Livro l7 = new Livro("Tress, a garota do Mar Esmeralda", "Brandon Sanderson", 2023);
        Livro l8 = new Livro("Neuromancer", "William Gibson", 1984);
        Livro l9 = new Livro("Count Zero", "William Gibson", 1986);
        Livro l10 = new Livro("Mona Lisa Overdrive", "William Gibson", 1988);
        Livro l11 = new Livro("Não Tenho Boca e Preciso Gritar", "Harlan Ellison", 1967);
        Livro l12 = new Livro("O Iluminado", "Stephen King", 1977);
        Livro l13 = new Livro("It - a Coisa", "Stephen King", 1986);
        Livro l14 = new Livro("A Dança da Morte", "Stephen King", 1978);
        Livro l15 = new Livro("À Espera de um Milagre", "Stephen King", 1996);

        Scanner sc = new Scanner(System.in);

        Catalogo catalogo = new Catalogo();
        List<Livro> livros = Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15);
        for (Livro livro : livros) {
            catalogo.adicionarLivro(livro);
        }

        System.out.println("Deseja pesquisar algum título do nosso catálogo? (S/N)");
        String SouN = sc.next().toLowerCase();
        sc.nextLine();
        if (SouN.matches(RESPOSTA_SIM_PATTERN)) {
            System.out.println("Como deseja pesquisar por nossos livros?");
            System.out.println("1 - Por autor");
            System.out.println("2 - Por intervalo de ano");
            System.out.println("3 - Por título");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Qual autor deseja pesquisar?");
                    String autor = sc.nextLine();
                    catalogo.pesquisarPorAutor(autor).forEach(System.out::println);
                    break;
                case 2:
                    System.out.println("Em qual o intervalo de tempo o seu livro foi publicado?");
                    int anoInicial = sc.nextInt();
                    int anoFinal = sc.nextInt();
                    if (anoInicial > anoFinal)
                        catalogo.pesquisarPorIntervaloAnos(anoFinal, anoInicial).forEach(System.out::println);
                    else
                        catalogo.pesquisarPorIntervaloAnos(anoInicial, anoFinal).forEach(System.out::println);
                    break;
                case 3:
                    System.out.println("Qual título deseja pesquisar?");
                    String titulo = sc.next();
                    System.out.println(catalogo.pesquisarPorTitulo(titulo));
            }
        } else if (SouN.matches(RESPOSTA_NAO_PATTERN))
            System.out.println("Encerrando o programa");
        else
            System.out.println("Resposta inválida. Encerrando o programa");
    }
}

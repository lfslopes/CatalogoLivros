package livros_pacote;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    List<Livro> livros;

    public Catalogo() {
        livros = new ArrayList<Livro>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }
    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        livros.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosAutor = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equals(autor))
                livrosAutor.add(livro);
        }

        livrosAutor.sort((l1, l2) -> Integer.compare(l1.getAnoPublicacao(), l2.getAnoPublicacao()));
        return livrosAutor;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> livrosAnos = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal)
                livrosAnos.add(livro);
        }
        livrosAnos.sort((l1, l2) -> Integer.compare(l1.getAnoPublicacao(), l2.getAnoPublicacao()));
        return livrosAnos;
    }

    public Livro pesquisarPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo))
                return livro;
        }
        return null;
    }
}

public class Livro {
    private String titulo;
    private String autoria;
    private String categoria;
    private String editora;
    private int numeroPaginas;
    private int anoLancamento;
    private boolean novo;

    public void setTitulo(String nome) {
        if (nome != null) {
            this.titulo = nome;
        }
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setAutoria(String autor) {
        if (autor != null) {
            this.autoria = autor;
        }
    }

    public String getAutoria() {
        return this.autoria;
    }

    public void setCategoria(String acao) {
        if (acao != null) {
            this.categoria = acao;
        }
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setEditora(String editora) {
        if (editora != null) {
            this.editora = editora;
        }
    }

    public String getEditora() {
        return this.editora;
    }

    public void setNumPaginas(int paginas) {
        if (paginas > 0) {
            this.numeroPaginas = paginas;
        }
    }

    public int getNumPaginas() {
        return this.numeroPaginas;
    }

    public void setAnoLancamento(int anoLancamento) {
        if (anoLancamento > -1501) {
            this.anoLancamento = anoLancamento;
        }
    }

    public int getAnoLancamento() {
        return this.anoLancamento;
    }

    public void setNovo(boolean novo) {
        this.novo = novo;
    }

    public boolean isNovo() {
        return this.novo;
    }
}

public class Agente {

    private String nome;
    private String missao;
    private int habilidade;
    private int experiencia;
    private int dificuldade;
    private int codigo;

    public Agente() { }

    public Agente(String nome) {
        this.nome = nome;
    }

    public Agente(String nome, int habilidade, int experiencia) {
        this.nome = nome;
        this.habilidade = habilidade;
        this.experiencia = experiencia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMissao() {
        return missao;
    }

    public void setMissao(String missao) {
        this.missao = missao;
    }

    public int getHabilidade() {
        return habilidade;
    }

    public void setHabilidade(int habilidade) {
        if (habilidade >= 0 && habilidade <= 10)
            this.habilidade = habilidade;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        if (experiencia >= 0 && experiencia <= 10)
            this.experiencia = experiencia;
    }

    public int getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(int dificuldade) {
        if (dificuldade >= 0 && dificuldade <= 10)
            this.dificuldade = dificuldade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo > 0)
            this.codigo = codigo;
    }
    
    public String relatorioDaMissao() {
        return "---Relatorio---\n" +
               "Nome: " + nome + "\n" +
               "Codigo: " + codigo + "\n" +
               "Missao: " + missao + "\n" +
               "Dificuldade: " + dificuldade + "\n" +
               "Habilidade: " + habilidade + "\n" +
               "Experiencia: " + experiencia + "\n";
    }

    public String executarMissao() {

        if (missao == null || missao.isEmpty() || codigo <= 0)
            return "Sem missao!";

        int poder = habilidade + experiencia;
        int exigencia = 2 * dificuldade;

        if (poder > exigencia)
            return "A missao foi um sucesso!";
        else if (poder < exigencia)
            return "A missao fracassou!";
        else if (poder == exigencia)
            return "Inconclusivo";
        else
            return "Sem missao!";
    }
}

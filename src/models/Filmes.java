package models;

public class Filmes {
    private int filmeId;
    private String filmeTitulo;
    private String filmeDesc;
    private int filmeDuracao;
    private int filmeAno;
    private int filmeClas;
    private int catId;

    // Construtores
    public Filmes() {
    }
    
    public Filmes(String filmeTitulo, String filmeDesc, int filmeDuracao, int filmeAno, int filmeClas, int catId) {
        this.filmeTitulo = filmeTitulo;
        this.filmeDesc = filmeDesc;
        this.filmeDuracao = filmeDuracao;
        this.filmeAno = filmeAno;
        this.filmeClas = filmeClas;
        this.catId = catId;
    }
    
    public Filmes(int filmeId, String filmeTitulo, String filmeDesc, int filmeDuracao, int filmeAno, int filmeClas, int catId) {
        this.filmeId = filmeId;
        this.filmeTitulo = filmeTitulo;
        this.filmeDesc = filmeDesc;
        this.filmeDuracao = filmeDuracao;
        this.filmeAno = filmeAno;
        this.filmeClas = filmeClas;
        this.catId = catId;
    }
    
    // Getters e Setters
    public int getFilmeId() {
        return filmeId;
    } // ID somente leitura, sem setter.
    
    // Titulo
    public String getFilmeTitulo() {
        return filmeTitulo;
    }
    public void setFilmeTitulo(String filmeTitulo) {
        this.filmeTitulo = filmeTitulo;
    }


    // Desc (Descrição)
    public String getFilmeDesc() {
        return filmeDesc;
    }
    public void setFilmeDesc(String filmeDesc) {
        this.filmeDesc = filmeDesc;
    }
    
    
    // Duração
    public int getFilmeDuracao() {
        return filmeDuracao;
    }
    public void setFilmeDuracao(int filmeDuracao) {
        this.filmeDuracao = filmeDuracao;
    }
    
    
    // Ano
    public int getFilmeAno() {
        return filmeAno;
    }
    public void setFilmeAno(int filmeAno) {
        this.filmeAno = filmeAno;
    }
    
    
    // Clas (classificação)
    public int getFilmeClas() {
        return filmeClas;
    }
    public void setFilmeClas(int filmeClas) {
        this.filmeClas = filmeClas;
    }
    
    
    // catId (id de categoria)
    public int getCatId() {
        return catId;
    }
    public void setCatId(int catId) {
        this.catId = catId;
    }
    
    
    // toString
    @Override
    public String toString() {
        return "Filmes [filmeId=" + filmeId + ", filmeTitulo=" + filmeTitulo + ", filmeDesc=" + filmeDesc + ", filmeDuracao=" + filmeDuracao + ", filmeAno=" + filmeAno + ", filmeClas=" + filmeClas + "]";
    }

    public void add(Filmes filmes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
    
    //ALTER TABLE "filmes" ADD CONSTRAINT "fk_filmes_categorias" FOREIGN KEY ( "catId" ) REFERENCES "categoria" ( " catId " );
}

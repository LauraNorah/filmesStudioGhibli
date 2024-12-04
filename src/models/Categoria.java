package models;

public class Categoria {
    private int catId;
    private String catTipo;
    
    // Construtores
    public Categoria() {
    }

    public Categoria(String catTipo) {
        this.catTipo = catTipo;
    }

    public Categoria(int catId, String catTipo) {
        this.catId = catId;
        this.catTipo = catTipo;
    }

    // Getters e Setters
    public int getCatId() {
        return catId; 
    } // ID somente leitura, sem setter.


    // catTipo (tipo da categoria)
    public String getCatTipo() {
        return catTipo;
    }
    public void setCatTipo(String catTipo) {
        this.catTipo = catTipo;
    }

    // toString
    @Override
    public String toString() {
        return "Filmes [catId=" + catId + ", catTipo=" + catTipo + "]";
    }
    
    //ALTER TABLE "filmes" ADD CONSTRAINT "fk_filmes_categorias" FOREIGN KEY ( "catId" ) REFERENCES "categoria" ( " catId " );
}

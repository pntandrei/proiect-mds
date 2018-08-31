/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarie;

/**
 *
 * @author DOMNUL STEFAN
 */
public class carte {
      
    private int ID;
    private String Nume;
    private String Autor;
    private String Gen ;
    private String Descriere;
    
    public carte(int id, String nume, String autor, String gen, String descriere){
        this.ID = id;
        this.Nume = nume;
        this.Autor = autor;
        this.Gen = gen;
        this.Descriere = descriere;
    }
    
    public int getID() {
            return ID;
        }

        public String getNUME() {
            return Nume;
        }

        public String getAUTOR() {
            return Autor;
        }

        public String getGEN() {
            return Gen;
        }

        public String getDESCRIERE() {
            return Descriere;
        }
        
}

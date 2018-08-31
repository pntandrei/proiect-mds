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
public class student {
      
    private String CNP;
    private String Nume;
    private String Prenume;
    private int Varsta;
    private String Telefon;
    
    public student(String cnp, String nume, String prenume, int varsta, String Tel){
        this.CNP = cnp;
        this.Nume = nume;
        this.Prenume = prenume;
        this.Varsta = varsta;
        this.Telefon = Tel;
    }
    
    public String getCNP() {
            return CNP;
        }

        public String getNUME() {
            return Nume;
        }

        public String getPRENUME() {
            return Prenume;
        }

        public int getVARSTA() {
            return Varsta;
        }

        public String getTELEFON() {
            return Telefon;
        }
        
}
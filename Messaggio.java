/**
 * La classe Messaggio ha il compito di gestire i messaggi.
 * 
 * @author IAMMEMI
 * @version 002_04/15
 */

public class Messaggio 
{
    /**
     * Indica il numero identificativo del messaggio.
     */
    private int id;
    /**
     * Indica il nome dell'utente che invia il messaggio.
     */
    private String mittente;
    /**
     * Indica il nome dell'utente che riceve il messaggio.
     */
    private String destinatario;
    /**
     * Indica il testo del messaggio.
     */
    private String testo;
    /**
     * Crea un oggetto di tipo messaggio.
     * @param id indica il numero del messaggio
     * @param mittente indica il nome dell'utente che invia il messaggio
     * @param destinatario indica il nome dell'utente che riceve il messaggio
     * @param testo indica il testo del messaggio
     */
    public Messaggio(int id, String mittente, String destinatario, String testo){
        this.id = id;
        this.mittente = mittente;
        this.destinatario = destinatario;
        this.testo = testo;
    }
    
    /**
     * Ritorna la stringa del messaggio.
     */
    public String toString(){
        return this.id + ", " + this.mittente + ", " + this.destinatario + ", " + this.testo; 
    }

    /**
     * Ritorna il mittente.
     */
    public String getMittente(){
        return mittente;
    }
    
    /**
     * Indica il numero identificativo del messaggio.
     */
    public String getDestinatario(){
        return destinatario;
    }
    
    /**
     * Ritorna il numero id.
     */
    public int getId(){
        return id;
    }
    
    
}


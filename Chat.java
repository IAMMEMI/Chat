/**
 * La classe Chat ha il compito di gestire tutte le funzioni disponibili nel menu.
 * 
 * @author IAMMEMI 
 * @version 002_04/15
 */
import java.util.*;
import java.io.*;
public class Chat
{
    /**
     * Creo un arraylist di oggetti di tipo Messaggio.
     */
    private ArrayList<Messaggio> arrayList = new ArrayList<Messaggio>();

    /**
     * Aggiungo un nuovo messaggio all'arraylist.
     * @param id indica il numero del messaggio
     * @param mittente indica il nome dell'utente che invia il messaggio
     * @param destinatario indica il nome dell'utente che riceve il messaggio
     * @param testo indica il testo del messaggio
     */
    public void setMess(int id, String mittente, String destinatario, String testo)
    {
        Messaggio mess = new Messaggio(id, mittente, destinatario, testo);
        arrayList.add(mess);
        System.out.println("Messaggio inserito:" + mess.toString());

    }

    /**
     * Prelevo il successivo id da assegnare al nuovo messaggio.
     */
    public int getNextId(){
        int num = arrayList.size(); //dichiaro una nuova variabile e vi inserisco la dimensione dell'arraylist
        Messaggio m = arrayList.get(num-1); //prelevo l'ultima riga e la metto in un oggetto di tipo messaggio
        int id = m.getId(); //prelevo l'id dall'oggetto
        return id+1; //ritorno il valore incrementato di uno
    }

    /**
     * Pulisce l'array.
     */
    public void pulisciArray(){
        for(int i =0; i<arrayList.size();i++){
            arrayList.remove(i);
            i-=1;
        }
    }

    /**
     * Importa tutti i messaggi dal file txt e li inserisce nell'array.
     */
    public void importaDaFile(){
        pulisciArray(); 
        try{
            FileReader fr = new FileReader("Messaggi.txt"); //apro la lettura del file
            BufferedReader br = new BufferedReader(fr); //apro il buffer sulla lettura del file
            String stringReader =""; //variabile tipo stringa che serve per leggere la stringa

            while(( stringReader = br.readLine()) != null) //finché leggo qualcosa diverso dal nulla
            {

                //uso lo StringTokenizer per scorrere il file suddiviso dalla virgola
                StringTokenizer st = new StringTokenizer(stringReader,",");
                //il primo "pezzo" prima della virgola è l'id del messaggio
                String cod = st.nextToken();
                //converto in int
                int id = Integer.parseInt(cod);
                //prendo il mittente 
                String mittente = st.nextToken();
                //prendo il destinatario
                String destinatario = st.nextToken();
                //prendo il testo
                String testo = st.nextToken();

                Messaggio mess = new Messaggio(id, mittente, destinatario,testo);
                //aggiungo il messaggio alla lista dei messaggi     
                arrayList.add(mess);

            }

            //chiudo il flusso con "Messaggi.txt"
            br.close();
        }
        catch(NumberFormatException nfe)
        {
            System.out.println("Impossibile convertire alcuni valori");
            System.exit(0);
        }
        catch(FileNotFoundException fnf)
        {
            System.out.println("Errore di lettura: file Messaggi.txt non trovato.");
            System.exit(0);
        }
        catch(IOException ioe)
        {
            System.out.println("Errore di lettura");
            System.exit(0);
        }       

    }

    /**
     * Cancella i messaggi con il nome del mittente indicato dall'utente.
     * @param mittente indica il nome del mittente da cancellare tra i messaggi
     */    
    public void cancella(String mittente){
        int cont = 0;
        for(int i = 0; i<arrayList.size();i++){
            Messaggio m = arrayList.get(i);
            String mitt = m.getMittente();

            if(mittente.equals(mitt)){
                System.out.println("Messaggio eliminato:");
                System.out.println(m.toString());
                arrayList.remove(i);
                i-=1;
                cont+=1;
            }

        }
        if(cont==0){
            System.out.println("Nominativo non trovato");
        }     
    }

    /**
     * Cancella il messaggio con il numero id indicato dall'utente.
     * @param id indica il numero id da cancellare tra i messaggi
     */
    public void cancella(int id){
        Iterator<Messaggio> it = arrayList.iterator();
        boolean trovato = false;
        while(it.hasNext() && trovato == false)
        {
            Messaggio m = it.next(); 
            int cod = m.getId();
            if(id==cod) {
                it.remove();
                trovato = true;
                System.out.println(m.toString());
            }
        }
        if(trovato==false){
            System.out.println("Id non trovato");
        }

    }

    /**
     * Preleva il messaggio con il numero id indicato dall'utente.
     * @param id indica il numero id da cercare tra i messaggi
     */
    public void getMessaggio(int id){
        boolean trovato = false;
        int i=0;

        for(i=0;i<arrayList.size() && trovato == false;i++){
            Messaggio m = arrayList.get(i);
            int cod = m.getId();
            if(id==cod){
                trovato = true;
                System.out.println(m.toString());
            }
        }
        if(trovato==false) System.out.println("Id non trovato");
    }

    /**
     * Preleva i messaggi con il nome del mittente indicato dall'utente.
     * @param mittente indica il mittente da cercare tra i messaggi
     */
    public void getMessaggi(String mittente){
        int conta = 0;
        for(int i = 0;i<arrayList.size();i++){
            Messaggio m = arrayList.get(i);
            String mitt = m.getMittente();
            if(mittente.equals(mitt)){
                conta+=1;
                System.out.println(m.toString());
            }
        }
        if( conta==0){
            System.out.println("Nominativo non trovato");
        }        
    }

    /**
     * Fornisce le statistiche sull'utilizzo della chat.
     */
    public void getStatistiche(){
        //devo mostrare tutti gli utenti e per ognuno di essi scrivere messaggi inviati e ricevuti
        ArrayList<String> arrayList2 = new ArrayList<String>();
        int inviati =0;
        int ricevuti = 0;
        for(int i =0;i<arrayList.size();i++){
            Messaggio m = arrayList.get(i);
            String mittente = m.getMittente();
            String destinatario = m.getDestinatario();
            inviati=0;
            ricevuti=0;
            for(int k=0;k<arrayList.size();k++){
                Messaggio mess = arrayList.get(k);
                String mitt = mess.getMittente();
                String dest = mess.getDestinatario();
                if(mitt.equals(mittente)){
                    inviati+=1;
                }
                if(dest.equals(destinatario)){
                    ricevuti+=1;
                }

            }

            if(!arrayList2.contains(mittente + " ha inviato " + inviati + " messaggi.") ) { 
                arrayList2.add(mittente + " ha inviato " + inviati + " messaggi.");
            }

            if(!arrayList2.contains(destinatario + " ha ricevuto " + ricevuti + " messaggi.")){
                arrayList2.add(destinatario + " ha ricevuto " + ricevuti + " messaggi.");
            }
        }

        //ordino alfabeticamente l'arraylist
        List<String> subList = arrayList2.subList(0,arrayList2.size());
        Collections.sort(subList);

        for(int i = 0; i< arrayList2.size(); i++){
            System.out.println(arrayList2.get(i));
        }

    }

    /**
     * Ritorna l'arraylist di tipo messaggio.
     */
    public ArrayList<Messaggio> ritornaArray(){
        return arrayList;
    }

}


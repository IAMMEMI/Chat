import java.util.*;

/**
 * Main: gestisce tutte le funzioni della classe Chat
 * 
 * @IAMMEMI  
 * @002_04/15 
 */
public class Main
{
    /**
     * Indica il nome del mittente
     */
    String mittente="";
    /**
     * Indica il nome del destinatario
     */
    String destinatario = "";
    /**
     * Indica il testo del messaggio
     */
    String testo ="";
    /**
     * Creo un'istanza della classe Chat statica, in modo da usare la stessa finché il programma non viene terminato.
     */
    //leva static
    Chat x = new Chat();

    /**
     * Main: inizializza il menu e importo i messaggi da file.
     */
    public static void main(String[] args)
    {
        //metti importaDaFile sul costruttore del main, così può inizializzare la chat
        //        x.importaDaFile();
        Main menu = new Main();
        menu.iniziaMenu();   

    }

    //crea costuttore senza parametri del main
    public Main() {
        //crea chat
        //x = new Chat();
        //importa file
        x.importaDaFile();
    }

    /**
     * Menu
     */
    public void iniziaMenu()
    {

        Scanner s = new Scanner(System.in);
        System.out.println("Scegli:");
        System.out.println("A - Nuovo messaggio");
        System.out.println("B - Mostra messaggi dal file");
        System.out.println("C - Cancella messaggi con mittente");
        System.out.println("D - Cancella messaggi con id");
        System.out.println("E - Statistiche");
        System.out.println("F - Cerca messaggi con mittente");
        System.out.println("G - Cerca messaggi con id");        
        System.out.println("H - Mostra i messaggi modificati");
        System.out.println("X - Esci dal programma");
        if(s.hasNext())
        {
            char c = Character.toLowerCase(s.next().charAt(0));
            do{
                //leggo riga da tastiera, prendo il primo carattere della stringa
                ritornaScelta(c);
                iniziaMenu();
                s.close();
            }while(c!='x');
        }

    }

    /**
     * Mi ritorna la scelta effettuata da menu.
     * @param c mi ritorna il carattere scelto dall'utente
     */
    public void ritornaScelta(char c){
        Scanner s = new Scanner(System.in);
        if(c=='a')
        {
            nuovoMessaggio();
            s.close();
        }

        else if(c=='b'){
            x.importaDaFile();
            stampaArrayList(x.ritornaArray());
        }

        else if(c=='c'){
            System.out.println("Digitare il nome del mittente");
            if(s.hasNext())
            {
                String mittente = s.next();
                x.cancella(mittente.toLowerCase());

            }
        }

        else if(c=='d'){
            System.out.println("Digitare il numero id");
            if(s.hasNext()){
                try{
                    int id = s.nextInt();
                    x.cancella(id);
                }
                catch(InputMismatchException ime)
                {
                    System.out.println("Non hai inserito un numero");
                }

            }   
        }

        else if(c=='e'){
            x.getStatistiche();
        }

        else if(c=='f'){
            System.out.println("Digitare il nome del mittente");

            if(s.hasNext())
            {
                String mittente = s.next();
                x.getMessaggi(mittente.toLowerCase());
            }
        }
        else if(c=='g'){
            System.out.println("Digitare il numero");
            if(s.hasNext())
            {
                try{
                    int id = s.nextInt();
                    x.getMessaggio(id);
                }
                catch(InputMismatchException ime){
                    System.out.println("Non hai inserito un numero");
                }

            }

        }

        else if(c=='h'){
            stampaArrayList(x.ritornaArray());
        }

        else if(c=='x'){
            System.exit(0);
        }

        s.close();

    }

    /**
     * Chiede all'utente i dati da aggiungere per il nuovo messaggio e lo aggiunge nell'arraylist.
     */
    public void nuovoMessaggio()
    {
        int id = x.getNextId();
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci il mittente: ");
        mittente = input.nextLine().toLowerCase();
        System.out.println("Inserisci il destinatario: ");
        destinatario = input.nextLine().toLowerCase();
        System.out.println("Testo del messaggio? ");
        testo = input.nextLine().toLowerCase();
        System.out.println("Vuoi aggiungere il messaggio? s/n");
        String risp = input.nextLine().toLowerCase();
        while(!risp.equals("s")){

            if(risp.equals("n")){
                break;
            }
            System.out.println("Vuoi aggiungere il messaggio? s/n");
            risp = input.nextLine().toLowerCase();
        }
        if(risp.equals("s")){
            x.setMess(id,mittente,destinatario,testo);
        }
        input.close();

    }

    /**
     * Stampa a video l'array di tipo Messaggio.
     * @param arrayList l'arraylist da stampare di tipo messaggio
     */
    public void stampaArrayList(ArrayList<Messaggio> arrayList){
        for(int i=0; i<arrayList.size();i++)
        {
            System.out.println(arrayList.get(i));
        }
    }
}
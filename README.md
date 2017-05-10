# Chat project
# ITALIANO

Sviluppare un’applicazione Java che consenta di gestire una chat.
L’applicazione dovrà prevedere lo sviluppo delle seguenti classi:
# Chat
La classe Chat avrà come attributi una lista di Messaggio. Tale classe si occuperà di gestire le operazioni di
importazione, inserimento, eliminazione e visione di messaggi. Nel dettaglio, dovranno essere definiti
metodi per:
- importare una lista di messaggi da un file di testo (almeno 50 messaggi) (importaDaFile());
- inserire un nuovo messaggio: l’utente deve inserire il nominativo del mittente, il nominativo del
destinatario e il testo del messaggio, mentre il programma genera in automatico il numero univoco
associato al messaggio da inserire (inserisci (String mittente, String destinatario, Stringtesto));
- eliminare uno o più messaggi esistenti in base al loro numero univoco o al nominativo del
mittente (cancella(int id) e cancella (String mittente));
- visionare uno o più messaggi esistenti in base al loro numero univoco o al nominativo del mittente
(getMessaggio(int id)) e getMessaggi(String mittente) );
- visionare la lista degli utenti partecipanti alla chat (come mittenti o destinatari) e per ognuno
mostrare il totale dei messaggi inviati e ricevuti( getStatistiche() );

# Messaggio
La classe messaggio avrà come attributi un numero univoco da 1 a n con passo 1, un mittente (nominativo),
un destinatario (nominativo) e un testo del messaggio.

# Main
La classe Main metterà a disposizione dell’utente tutte le procedure contenute nella classe Chat. Essa
mostrerà pertanto sulla console un menu in modo che l’utente possa scegliere quale operazione effettuare.
Dopo la scelta del comando da eseguire, ove necessarie, verranno richieste informazioni pertinenti
all’operazione.

# Organizzazione file
Il file dovrà contenere, nel seguente formato, una serie di righe, ognuna contenente un messaggio.

[numero univoco da 1 a n con passo 1],[mittente],[destinatario],[testo]

[numero univoco da 1 a n con passo 1],[mittente],[destinatario],[testo]

...

[numero univoco da 1 a n con passo 1],[mittente],[destinatario],[testo]


Usare il carattere virgola (,) come separatore dei valori all'interno di una riga.
Non inserire spazi tra un valore e l'altro.


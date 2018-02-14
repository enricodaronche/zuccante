# Progetto TRIS

### Autore: Enrico Da Ronche

### Classe 5^IA

### Istituto C.Zuccante

Il progetto Tris consiste in un'applicazione Android che consente di giocare a Tris secondo varie modalità.
L'applicazione si compone di due activity: la prima, MainActivity, permette all'utente di decidere se giocare contro la macchina o contro un amico tramite l'uso di due bottoni differenti, mentre la seconda, CampoTrisActivity, rappresenta la vista del campo da gioco. Per distinguere le due modalità di gioco, quando uno dei due bottoni di MainActivity viene premuto si attacca all'Intent utilizzato per cambiare activity un valore booleano tramite il metodo putExtra.
Il campo da gioco risulta costituito da 9 bottoni e da due TextView che riportano il numero di partite vinte da X e di quelle vinte da O. E' inoltre presente un bottone che consente di ricominciare la partita. I bottoni risultano identificati da dei tag che individuano la loro posizione in un sistema che calcola la stessa moltiplicando l'indice di riga per 3 e addizionando quello di colonna. Il progetto si compone inoltre di altre due classi: GiocoTris, che consente di effettuare una singola partita e che gestisce alcuni aspetti relativi alla partita stessa, e StatoTris, che riporta lo stato della griglia sotto forma di matrice. All'interno di queste due classi sono presenti due metodi di particolare interesse: in GiocoTris c'è il metodo mossaMacchina che permette di calcolare la mossa migliore per la macchina in modalità 1 giocatore mentre in StatoTris si ha isVittoria che indica se per uno dei due giocatori si è arrivati ad una situazione di vittoria.
La classe GiocoTris implementa View.OnClickListener dal momento che contiene il metodo onClick gestore della pressione di ciascuno dei 9 bottoni.
Le classi CampoTrisActivity e StatoTris implementano Observer mentre la classe GiocoTris estende Observable: ciò consente alla vista e allo stato della griglia di essere costantemente aggiornati in linea con l'andamento del gioco.
Durante l'utilizzo dell'applicazione è possibile ruotare lo schermo mantenendo inalterato lo stato delle activity e potendo dunque continuare a giocare riprendendo dal punto in cui si aveva interrotto.
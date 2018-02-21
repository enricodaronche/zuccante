# Progetto Dado

### Autore: Enrico Da Ronche

### Classe 5^IA

### Istituto C.Zuccante

Il progetto Dado consiste in un'applicazione Android che consente di simulare il lancio di un dado. L'app, in particolare, risulta costituita da un'unica activity nella quale vengono visualizzati Fragment differenti a seconda della situazione. Al lancio dell'applicazione viene visualizzato un FragmentStart rappresentante la schermata iniziale. A questo punto è possibile praticare lo swipe nelle varie direzioni orizzontali e verticali per spostarsi su dei FragmentFaccia rappresentanti le facce del dado. Per ottenere tali Fragment viene utilizzato un metodo factory collocato all'interno della classe FragmentFaccia stessa. Il layout di FragmentFaccia si basa su una griglia di nove ImageView rappresentanti dei cerchi(drawable). Tali cerchi vengono visualizzati o meno in base al valore della faccia. Per tornare alla schermata iniziale è sufficente ruotare lo schermo.
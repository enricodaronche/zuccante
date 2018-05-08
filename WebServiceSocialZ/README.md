# Progetto Web Service Social Z

### Autore: Enrico Da Ronche

### Classe 5^IA

### Istituto C.Zuccante

Il progetto Web Service Social Z si compone di due parti differenti: il Web Service WebServiceSocialZ e l'applicazione android ClientSocialZ che ne sfrutta le risorse.

Il Web Service è di tipo SOAP ed espone all'esterno un metodo getHobbiesConPraticanti che restituisce una stringa JSON con tutte le informazioni relative agli hobby e ai relativi praticanti. Tali informazioni vengono prese dal database SocialZ.db.

L'applicazione android fa uso della libreria kspoap2 e di un AsyncTask per richiamare il metodo presente nel Web Service. Ottenuta la stringa JSON, essa viene convertita in un oggetto Pojo tramite l'utilizzo della libreria GSON. L'app risulta costituita da due Activity: nella MainActivity viene visualizzata tramite una ScrollView la lista degi hobby mentre nella PraticantiActivity è presente l'elenco dei praticanti di uno specifico hobby precedentemente selezionato.
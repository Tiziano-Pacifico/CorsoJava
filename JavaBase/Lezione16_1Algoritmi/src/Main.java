import Classi.NumeroIterazioni;
import Classi.StatisticheOrdinamento;
import algoritmi.ricerca.RicercaBinaria;
import algoritmi.ricerca.RicercaLineare;
import algoritmi.superclassi.Ordinamento;
import algoritmi.superclassi.OrdinamentoConcreto;
import utils.Utils;
import algoritmi.decorator.BubbleDecorator;
import algoritmi.decorator.InsertionDecorator;
import algoritmi.decorator.SelectionDecorator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

//Per l'esecuzione del codice genero un array casuale
public class Main {
    //La lunghezza dell'array che vado a generare
        static int arrayLenght = 10;
        //Il numero di volte che eseguirò le operazioni di ordinamento
        static int numeroCicli = 10;
        //L'array che andrò a riempire con numeri casuali tra 0 e 100
        static int[] mioArray = new int[arrayLenght];
        //La variabile dove andrò a salvare il risultato degli ordinamenti
        static int[] arrayOrdinato = new int[arrayLenght];
        //Classe di utilita, array casuali e stampa gli array
        static Utils utils = new Utils(arrayLenght);
        static Random random = new Random();

    public static void main(String[] args) {
        //Inserisco le calssi che forniscono metodi di oridinamento in un array list.
        //Tutte le calssi di ordinamento estendono una supercalsse con il metodo astratto ordina
        //In questo modo posso inserirle tutte all'interno della stessa collection e iterare sull'array per valutare il funzionamento
        ArrayList<Ordinamento> metodiOrdinamento = new ArrayList<>();
        metodiOrdinamento.add(new BubbleDecorator(new OrdinamentoConcreto()));
        metodiOrdinamento.add(new SelectionDecorator(new OrdinamentoConcreto()));
        metodiOrdinamento.add(new InsertionDecorator(new OrdinamentoConcreto()));
        //Un array di stringhe che descrive il tipo di algoritmo di ordinamento.
        //L'ordine di inserimento nell'array ndica l'ordine di esecuzione degli algoritmi
        String[] algoritmiOrdinamento = {"BubbleSort","SelectionSort","InsertionSort"};
        //Voglio valutare il comportamento degli algoritmi in termini di numero di interazioni
        //Quindi creo una mappa tra la stringa che descrive il tipo di algoritmo e un array di interi che descrive
        //Il numero di iterazioni per ogni array casuale generato
        HashMap<String, StatisticheOrdinamento> numeroPassiAlgoritmi = new HashMap<>();
        StatisticheOrdinamento IterazioniBS = new StatisticheOrdinamento();
        StatisticheOrdinamento IterazioniSS = new StatisticheOrdinamento();
        StatisticheOrdinamento IterazioniIS = new StatisticheOrdinamento();
        numeroPassiAlgoritmi.put(algoritmiOrdinamento[0], IterazioniBS);
        numeroPassiAlgoritmi.put(algoritmiOrdinamento[1], IterazioniSS);
        numeroPassiAlgoritmi.put(algoritmiOrdinamento[2], IterazioniIS);

        int i = 0;
        //per valutare il numero di iterazioni per l'esecuzione di un algoritmo di ordinamento
        //senza utilizzare un valore di ritorno, uso un oggetto invece di un tipo primitivo
        //Passando l'oggetto al metodo di ordinameno posso riempirlo con il numero di iterazioni
        //Questo valore sarà automaticamente accessibile dalla classe chiamante
        NumeroIterazioni numeroIterazioni = new NumeroIterazioni();

        //Itero numeroCicli volte, ogni volta generando un array casuale e utilizzando su di esso i metodi di ordinamento
        //Ad ogni iterazione salvo in numeroPassiAlgoritmi il numero di passi che ogni iterazione produce per ogni tipo di algoritmo
        for(int z = 0; z < numeroCicli; z++) {
            mioArray = utils.creaArray();
            //utils.stampaArray(mioArray);
            i=0;
            for(Ordinamento metodo: metodiOrdinamento) {
                arrayOrdinato = metodo.ordina(mioArray, numeroIterazioni);
                //utils.stampaArray(arrayOrdinato);
                numeroPassiAlgoritmi.get(algoritmiOrdinamento[i]).numeroPassi.add(numeroIterazioni.getNumeroIterazioni());
                i++;
            }
        }

        System.out.printf("Statistiche su %d iterazioni\n", numeroCicli);
        utils.calcolaStatisticheOrdinamenti(numeroPassiAlgoritmi);
        System.out.println("--------------------------------------");


        //Ricerche

        utils.setLunghezzaArray(100);
        mioArray = utils.creaArray();
        //La ricerca binaria necessita un arrya ordinato
        arrayOrdinato = (new BubbleDecorator(new OrdinamentoConcreto())).ordina(mioArray,numeroIterazioni);

        RicercaLineare rl = new RicercaLineare();
        RicercaBinaria rb = new RicercaBinaria();
        //Genero casualmente un array di 100 elementi.
        //Genero casualmente un valore ra 0 e 100
        //Aumento il numero di elementi dell'array per aumentare le probabilità
        // che la chiave generata casualmente sia effettivamente presente nell'array generato casualmente
        int key = random.nextInt(101);
        int[] arrayRicercaLineareCompleta;
        boolean isElement = false;

        //Prima di eseguire tutta la parte di ricerca, controllo tramite ricercaLineare semplice se la chiave è presente nell'array
        if(rl.ricercaLineare(mioArray, key) != -1) isElement = true;

        if(isElement) {
            System.out.println("Ricerca Lineare");
            System.out.println("/////////////////////////////");
            System.out.println("La prima occorrenza dell'elemento da cercare è: " + rl.ricercaLineare(mioArray, key));
            arrayRicercaLineareCompleta = rl.recercaLineareCompleta(mioArray, key);
            System.out.println("Gli indici di tutti i match dell'elemento da cercare sono: \n");
            for(int j = 0; j < utils.getLunghezzaArray(); j++) {
                if(arrayRicercaLineareCompleta[j] == 1) System.out.print(j + " ");
            }
            System.out.println();
            System.out.println("Ricerca Binaria Ricorsiva");
            System.out.println("////////////////////////");
            System.out.println("La prima occorrenza dell'elemento da cercare è: " +
                    rb.RecursiveBinarySearch(
                            arrayOrdinato,
                            key,
                            0,
                            utils.getLunghezzaArray()
                            ));

            System.out.println("Ricerca Binaria Iterativa");
            System.out.println("////////////////////////");

            System.out.println("La prima occorrenza dell'elemento da cercare è: " +
                    rb.IterativeBinarySearch(
                            arrayOrdinato,
                            key
                            ));
        }
        else System.out.println("Elemeno non presente nell'array");
    }


}
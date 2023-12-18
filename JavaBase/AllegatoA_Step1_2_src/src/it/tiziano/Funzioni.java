package it.tiziano;

import java.util.ArrayList;
import java.util.Scanner;

public class Funzioni {
    Scanner scanner = new Scanner(System.in);
    public Dottore inserisciDottore(ArrayList<Dottore> dottori) {
        String nomeDoc = "";
        Double parcellaDoc = 0.0;
        String specDoc = "";

        boolean inserisci = true;

        while (inserisci) {

            boolean docNonPresente = true;

            System.out.println("Inserisci il nome");
            nomeDoc = scanner.next();
            System.out.println("Inerisci la specializzazione");
            specDoc = scanner.next();
            System.out.println("Inserisci la parcella");
            parcellaDoc = scanner.nextDouble();
            Dottore doc = new Dottore(specDoc, parcellaDoc, nomeDoc);

            int i = 0;
            while (docNonPresente && (i < dottori.size())){
                if (doc.haLoStessoNomeParcellaSpec(dottori.get(i))) {
                    System.out.println("Il dottore è già presente");
                    docNonPresente = false;
                }
                i++;
            }
            if (docNonPresente) {
                inserisci = false;
            }
        }
        Dottore doc = new Dottore(specDoc, parcellaDoc, nomeDoc);
        return doc;
    }

    public Paziente inserisciPaziente(ArrayList<Paziente> pazienti) {
        String nomePaz = "";
        String idPaz = "";

        boolean inserisci = true;

        while (inserisci) {

            boolean pazNonPresente = true;

            System.out.println("Inserisci il nome");
            nomePaz = scanner.next();
            System.out.println("Inserisci l'id");
            idPaz = scanner.next();

            Paziente paz = new Paziente(nomePaz, idPaz);
            int i = 0;
            while (pazNonPresente && (i < pazienti.size())){
                if (paz.haLoStessoIdNome(pazienti.get(i))) {
                    System.out.println("Il paziente è già presente");
                    pazNonPresente = false;
                }
                i++;
            }
            if(pazNonPresente) {
                inserisci = false;
            }
        }
        Paziente paz = new Paziente(nomePaz, idPaz);
        return paz;
    }

    public DatiPAgamento inserisciPagamento(ArrayList<Fattura> fatture, ArrayList<Dottore> dottori, ArrayList<Paziente> pazienti) {
        Fattura fattura = inserisciFattura(fatture,dottori, pazienti);
        Pagamento pagamento = inserisciMetodoPagamento(fattura.getDoc().getParcella());
        DatiPAgamento datiPAgamento = new DatiPAgamento(fattura, pagamento);

        return datiPAgamento;
    }

    public Fattura inserisciFattura(ArrayList<Fattura> fatture, ArrayList<Dottore> dottori, ArrayList<Paziente> pazienti) {
        String doc;
        String paz;
        boolean isNotDoc = true;
        boolean isNotPaz = true;
        Dottore docScelto = new Dottore();
        Paziente pazScelto = new Paziente();

        if ((pazienti.size()>0)&&(dottori.size()>0)){

            while (isNotDoc) {
                System.out.println("Inserisci il nome del dottore");
                doc = scanner.next();
                for (int i = 0; i < dottori.size(); i++) {
                    if (!doc.equalsIgnoreCase(dottori.get(i).getNome())) {
                        isNotDoc = true;
                    } else {
                        isNotDoc = false;
                        docScelto = dottori.get(i);
                        break;
                    }
                }
                if (isNotDoc) {
                    System.out.println("Il dottore non è presente nell'archivio");
                    System.out.println("Ecco i dottori presenti nell'elenco");
                    for (int i = 0; i < dottori.size(); i++) {
                        System.out.println(dottori.get(i).getNome());
                    }
                }

            }

            while (isNotPaz) {
                System.out.println("Inserisci il Paziente");
                paz = scanner.next();
                for (int i = 0; i < pazienti.size(); i++) {
                    if (!paz.equalsIgnoreCase(pazienti.get(i).getNome())) {
                        isNotPaz = true;

                    } else {
                        isNotPaz = false;
                        pazScelto = pazienti.get(i);
                        break;
                    }
                }
                if (isNotPaz) {
                    System.out.println("Il paziente non è presente nell'archivio");
                    System.out.println("Ecco i pazienti presenti nell'elenco");
                    for (int i = 0; i < pazienti.size(); i++) {
                        System.out.println(pazienti.get(i).getNome());
                    }
                }
            }
        }
        Fattura fattura = new Fattura(docScelto,pazScelto);
        return fattura;
    }

    public Double calcolaTotaleFatture(ArrayList<Fattura> fatture) {
        double totale = 0.0;
        for (int i = 0; i < fatture.size(); i++) {
            totale += fatture.get(i).getDoc().getParcella();
        }
        return totale;
    }

    public Pagamento inserisciMetodoPagamento(Double importo) {
        int sceltaPAgamento;
        boolean sceltaPagamentoNonCorretta = true;
        Pagamento pagamento = new Pagamento();

        while (sceltaPagamentoNonCorretta) {
            System.out.println("Il pagamento è 1) in contanti 2) con carta di credito");
            sceltaPAgamento = scanner.nextInt();

            switch (sceltaPAgamento) {
                case Costanti.PAGAMENTO_CONTANTI:
                    pagamento = new PagamentoContanti(importo);
                    pagamento.dettagliPagamento();
                    sceltaPagamentoNonCorretta = false;
                    break;
                case Costanti.PAGAMENTO_CARTA:
                    String nomeCarta;
                    String numeroCarta;
                    String dataCarta;

                    System.out.println("Inserire il nome sulla carta");
                    nomeCarta = scanner.next();
                    System.out.println("Inserire il numero sulla carta");
                    numeroCarta = scanner.next();
                    System.out.println("Inserire la data di scadenza");
                    dataCarta = scanner.next();
                    pagamento = new PagamentoCartaDiCredito(importo, nomeCarta, dataCarta, numeroCarta);
                    pagamento.dettagliPagamento();
                    sceltaPagamentoNonCorretta = false;
                    break;
                default:
                    System.out.println("Scelta non valida");
                    break;
            }
        }
        return pagamento;
    }

}

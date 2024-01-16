package algoritmi.superclassi;

import Classi.NumeroIterazioni;
import algoritmi.superclassi.Ordinamento;
import algoritmi.superclassi.OrdinamentoConcreto;

public class BaseDecorator extends OrdinamentoConcreto {

    private Ordinamento wrappee;

    public BaseDecorator(Ordinamento source) {
        wrappee = source;
    }

}

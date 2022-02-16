package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.Main;
import it.unimi.di.prog2.esame.model.Articolo;
import it.unimi.di.prog2.esame.model.Model;
import it.unimi.di.prog2.esame.model.Observer;
import it.unimi.di.prog2.esame.model.Subject;
import it.unimi.di.prog2.esame.view.BuyerView;

import java.util.List;

public class BuyerPresenter implements Presenter, Observer<List<Articolo>> {

    private BuyerView view;
    private Model model;

    public BuyerPresenter(BuyerView view, Model model) {
        this.view = view;
        this.model = model;
        model.addObserver(this);
        view.addHandlers(this);
    }

    @Override
    public void update(Subject<List<Articolo>> subject, List<Articolo> state) {
        int i = 0;
        for (Articolo articolo : state) {
            if (articolo.getDaComprare() > 0){
                view.set(i,articolo.getNome());
                i++;
            }

        }
        while (i < Main.MAX_ALIMENTI)
            view.set(i++, "");



    }

    @Override
    public void action(int id, String text) {//updateModel
        //aggiornare il model dicendogli che voglio comprare un oggetto
        model.buy(id,text);
    }
}

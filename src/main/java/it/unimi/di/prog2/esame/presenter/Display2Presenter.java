package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.Main;
import it.unimi.di.prog2.esame.model.Articolo;
import it.unimi.di.prog2.esame.model.Model;
import it.unimi.di.prog2.esame.model.Observer;
import it.unimi.di.prog2.esame.model.Subject;
import it.unimi.di.prog2.esame.view.DisplayView;

import java.util.List;

public class Display2Presenter implements Observer<List<Articolo>> {
    private final DisplayView view;
    private final Model model;

    public Display2Presenter(DisplayView view, Model model) {
        this.view = view;
        this.model = model;
        model.addObserver(this);
    }

    @Override
    public void update(Subject<List<Articolo>> subject, List<Articolo> state) {
        int i = 0;
        for (Articolo articolo : state) {
           if (articolo.getComprati() > 0){
               view.set(i,articolo.getNome()+" "+articolo.getComprati());
               i++;
           }

        }
        while (i < Main.MAX_ALIMENTI)
            view.set(i++, "");
    }
}

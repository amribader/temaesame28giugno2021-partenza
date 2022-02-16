package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.model.Model;
import it.unimi.di.prog2.esame.view.AdderView;
import org.jetbrains.annotations.NotNull;

public class AdderPresenter implements Presenter {
  //TODO da completare
  private final AdderView view;
  private final Model model;

  public AdderPresenter(@NotNull final AdderView view, Model model) {
    this.view = view;
    this.model = model;
    view.addHandlers(this);
  }

  public final void action(int i, String text) {
    System.err.printf("aggiungo articolo %s in quantità %d\n", text, i);
    model.add(i,text);
  }
}

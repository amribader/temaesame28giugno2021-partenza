package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.view.AdderView;
import org.jetbrains.annotations.NotNull;

public class AdderPresenter implements Presenter {
  //TODO da completare
  private final AdderView view;

  public AdderPresenter(@NotNull final AdderView view) {
    this.view = view;
    view.addHandlers(this);
  }

  public final void action(int i, String text) {
    System.err.printf("aggiungo articolo %s in quantità %d\n", text, i);
  }
}

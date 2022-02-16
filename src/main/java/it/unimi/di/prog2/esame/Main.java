package it.unimi.di.prog2.esame;

import it.unimi.di.prog2.esame.presenter.AdderPresenter;
import it.unimi.di.prog2.esame.view.BuyerView;
import it.unimi.di.prog2.esame.view.DisplayView;
import it.unimi.di.prog2.esame.view.AdderView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
  //TODO da completare

  public static final int MAX_ALIMENTI = 8;

  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {

    primaryStage.setTitle("Grocery List");

    BuyerView[] command = new BuyerView[2];

    AdderView input = new AdderView();
    DisplayView display = new DisplayView(MAX_ALIMENTI, "To buy");
    DisplayView display2 = new DisplayView(MAX_ALIMENTI, "Bought");

    GridPane gridPane = new GridPane();
    gridPane.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    gridPane.setPadding(new Insets(10, 10, 10, 10));

    gridPane.add(input, 0, 0);
    GridPane.setColumnSpan(input, GridPane.REMAINING);
    for (int i = 0; i < 2; i++) {
      command[i] = new BuyerView("Buy", MAX_ALIMENTI, "Buyer#"+i);
      gridPane.add(command[i], i, 1);
    }

    gridPane.add(display, 0, 2);
    gridPane.add(display2, 1, 2);

    new AdderPresenter(input);

    Scene scene = new Scene(gridPane);
    primaryStage.setScene(scene);
    primaryStage.show();

    //HINT: utile dopo aver definito model per inizializzare viste
    //model.notifyObservers();
  }
}

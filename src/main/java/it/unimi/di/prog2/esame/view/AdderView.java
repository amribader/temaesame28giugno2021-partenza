package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.presenter.Presenter;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import org.jetbrains.annotations.NotNull;

public class AdderView extends Region {
  private final TextField text = new TextField();
  private final TextField num = new TextField();
  private final Button addButton = new Button("Add");


  public AdderView() {
    setBackground(new Background(
        new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5.0), Insets.EMPTY)));
    setBorder(new Border(
        new BorderStroke(null, BorderStrokeStyle.SOLID, new CornerRadii(5.0), new BorderWidths(2))));


    num.setPrefColumnCount(2);
    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10, 10, 10, 10));
    grid.add(text, 0, 0);
    grid.setPadding(new Insets(10, 10, 10, 10));
    grid.add(num, 1, 0);
    grid.add(addButton, 0, 1);

    this.getChildren().add(grid);
  }

  public void addHandlers(@NotNull Presenter presenter) {
    addButton.setOnAction(eh -> presenter.action(Integer.parseInt(num.getText()), text.getText()));
  }

}

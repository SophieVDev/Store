package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.Main;
import main.MyListener;
import model.Store;

public class ItemController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
    private ImageView img;

    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(store);
    }

    private Store store;
    private MyListener myListener;

    public void setData(Store store, MyListener myListener) {
        this.store = store;
        this.myListener = myListener;
        nameLabel.setText(store.getName());
        priceLable.setText(Main.CURRENCY + store.getPrice());
        Image image = new Image(getClass().getResourceAsStream(store.getImgSrc()));
        img.setImage(image);
    }
}

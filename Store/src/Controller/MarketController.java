package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import main.Main;
import main.MyListener;
import model.Store;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarketController implements Initializable {
    @FXML
    private VBox chosenStoreCard;

    @FXML
    private Label storeNameLable;

    @FXML
    private Label storePriceLabel;

    @FXML
    private ImageView storeImg;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    private List<Store> stores = new ArrayList<>();
    private Image image;
    private MyListener myListener;

    private List<Store> getData() {
        List<Store> stores = new ArrayList<>();
        Store store;

        store = new Store();
        store.setName("Blender");
        store.setPrice(22.99);
        store.setImgSrc("/img/blender.png");
        store.setColor("6A7324");
        stores.add(store);

        store = new Store();
        store.setName("camera");
        store.setPrice(53.99);
        store.setImgSrc("/img/camera.png");
        store.setColor("A7745B");
        stores.add(store);

        store = new Store();
        store.setName("earbuds");
        store.setPrice(10.50);
        store.setImgSrc("/img/earbuds.png");
        store.setColor("F16C31");
        stores.add(store);

        store = new Store();
        store.setName("headphone");
        store.setPrice(5.99);
        store.setImgSrc("/img/headphone.png");
        store.setColor("291D36");
        stores.add(store);

        store = new Store();
        store.setName("laptop");
        store.setPrice(134.99);
        store.setImgSrc("/img/laptop.png");
        store.setColor("22371D");
        stores.add(store);

        store = new Store();
        store.setName("laptop pro");
        store.setPrice(2.99);
        store.setImgSrc("/img/laptop2.png");
        store.setColor("FB5D03");
        stores.add(store);

        store = new Store();
        store.setName("laptop home");
        store.setPrice(590.99);
        store.setImgSrc("/img/laptop3.png");
        store.setColor("80080C");
        stores.add(store);

        store = new Store();
        store.setName("mobilephone");
        store.setPrice(290.99);
        store.setImgSrc("/img/mobilephone.png");
        store.setColor("FFB605");
        stores.add(store);

        store = new Store();
        store.setName("smartwatch");
        store.setPrice(30.99);
        store.setImgSrc("/img/smartwatch.png");
        store.setColor("5F060E");
        stores.add(store);

        store = new Store();
        store.setName("smartphone");
        store.setPrice(109.99);
        store.setImgSrc("/img/smartphone.png");
        store.setColor("E7C00F");
        stores.add(store);

        return stores;
    }

    private void setChosenStore(Store store) {
        storeNameLable.setText(store.getName());
        storePriceLabel.setText(Main.CURRENCY + store.getPrice());
        image = new Image(getClass().getResourceAsStream(store.getImgSrc()));
        storeImg.setImage(image);
        chosenStoreCard.setStyle("-fx-background-color: #" + store.getColor() + ";\n" +
                "    -fx-background-radius: 30;");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stores.addAll(getData());
        if (stores.size() > 0) {
            setChosenStore(stores.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Store store) {
                    setChosenStore(store);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < stores.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(stores.get(i),myListener);

                if (column == 3) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

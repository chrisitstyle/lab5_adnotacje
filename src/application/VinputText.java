package application;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VinputText {

    @FXML
    public VBox vboxItem;
    public Button btnSend;
    public static Image img;
    public static ImageView imgView;
    public TextInputControl textInput;
    public MyPatternValidator patternValidator = new MyPatternValidator();
    public JavaBeanClass bean = new JavaBeanClass();

    @FXML
    void initialize() {
        try {
            img = new Image(new FileInputStream("C:\\Users\\krzysztof\\Desktop\\studia_960\\ZPO\\zpo_laby\\lab5_adnotacje\\src\\views\\empty.png"));
            imgView = new ImageView(img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie znaleziono pliku");
        }
        textInput = new TextField();
        Label label = new Label("<-Podaj adres email");

        HBox hboxItem = new HBox();
        hboxItem.getChildren().add(imgView);
        hboxItem.getChildren().add(textInput);
        hboxItem.getChildren().add(label);

        vboxItem.getChildren().add(hboxItem);

        textInput.textProperty().addListener((observable, oldValue, newValue) -> {

            bean.setValue(newValue);
            patternValidator.validate(bean.getValue());
            if (patternValidator.isValid()) {
                changeImage("valid");
                btnSend.setDisable(false);
                Tooltip.uninstall(imgView, null);
            } else {
                changeImage("invalid");
                btnSend.setDisable(true);
                Tooltip.install(imgView, new Tooltip(patternValidator.getMessage()));
            }
        });
    }

    @FXML
    void changeImage(String state) {
        try {
            switch (state) {
                case "empty":
                    img = new Image(new FileInputStream("C:\\Users\\krzysztof\\Desktop\\studia_960\\ZPO\\zpo_laby\\lab5_adnotacje\\src\\views\\empty.png"));
                    imgView.setImage(img);
                    break;
                case "invalid":
                    img = new Image(new FileInputStream("C:\\Users\\krzysztof\\Desktop\\studia_960\\ZPO\\zpo_laby\\lab5_adnotacje\\src\\views\\false.png"));
                    imgView.setImage(img);
                    break;
                case "valid":
                    img = new Image(new FileInputStream("C:\\Users\\krzysztof\\Desktop\\studia_960\\ZPO\\zpo_laby\\lab5_adnotacje\\src\\views\\true.png"));
                    imgView.setImage(img);
                    break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Nie znaleziono pliku");
        }
    }

    @FXML
    void sendMessage() {
        System.out.println(textInput.getText());
        textInput.setText("");
        changeImage("empty");
    }

}

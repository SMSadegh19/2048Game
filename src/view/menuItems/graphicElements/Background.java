package view.menuItems.graphicElements;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Background {
    public static ImageView getInstance() {
        Image image;
        try {
            image = new Image(new FileInputStream("2048.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

        //Setting the image view
        ImageView imageView = new ImageView(image);

        //Setting the position of the image
        imageView.setX(-200);
        imageView.setY(0);

        //setting the fit height and width of the image view
        imageView.setFitHeight(1800);
        imageView.setFitWidth(1012);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        Rotate rotate = new Rotate();
        rotate.setAngle(-10);

        Scale scale = new Scale();
        scale.setY(2);
        scale.setX(2);

        imageView.getTransforms().addAll(rotate, scale);

        return imageView;
    }
}

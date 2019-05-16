package view.menuItems.graphicElements;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

public class Background {
    public static ImageView getInstance(int backgroundNumber) {
        Image image;
        try {
            String fileName = "background" + backgroundNumber + ".jpg";
            image = new Image(new FileInputStream(fileName));
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
        if (backgroundNumber == 1) {
            imageView.setFitHeight(1800);
            imageView.setFitWidth(1012);
        } else {
            imageView.setX(0);
            imageView.setFitHeight(1500);
            imageView.setFitWidth(1000);
        }

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        Rotate rotate = new Rotate();
        rotate.setAngle(-10);
        if (backgroundNumber == 2) {
            rotate.setAngle(0);
        }

        Scale scale = new Scale();
        scale.setY(2);
        scale.setX(2);

        imageView.getTransforms().addAll(rotate, scale);

        return imageView;
    }

    public static ArrayList<ImageView> getRandomTiles() {
        ArrayList<ImageView> tiles = new ArrayList<>();
        Random random = new Random();
        int numberOfTiles = random.nextInt(15) + 40;
        for (int i = 0; i < numberOfTiles; i++) {
            int tileNumber = random.nextInt(6) + 1;
            String fileName = tileNumber + ".png";
            Image image;
            try {
                image = new Image(new FileInputStream(fileName));
            } catch (FileNotFoundException e) {
                System.out.println("A problem in reading image.");
                continue;
            }
            ImageView imageView = new ImageView(image);
            imageView.setPreserveRatio(true);
            tiles.add(imageView);


            Rotate rotate = new Rotate();
            rotate.setAngle(random.nextInt() % 20);

            Translate translate = new Translate();

            int yFirstValue = -random.nextInt(4000);
            int yEndValue = 2000;
            double time = (yEndValue - yFirstValue) / 0.1;
            translate.setX(random.nextInt(1000));
            translate.setY(yFirstValue);
            translate.setZ(0);

            imageView.getTransforms().addAll(rotate, translate);

            KeyValue keyValue1 = new KeyValue(translate.xProperty(), random.nextInt(1000));
            KeyValue keyValue2 = new KeyValue(translate.yProperty(), yEndValue);
            KeyFrame keyFrame = new KeyFrame(Duration.millis(time), keyValue1, keyValue2);
            Timeline timeline = new Timeline(keyFrame);
            timeline.setAutoReverse(false);
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }
        return tiles;
    }
}

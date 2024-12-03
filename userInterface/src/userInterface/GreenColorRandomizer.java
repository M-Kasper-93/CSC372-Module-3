/*Purpose of GreenColorRandomizer class: Method to generate random hue of green for option 3 */

package userInterface;

import java.util.Random;
import javafx.scene.paint.Color;

public class GreenColorRandomizer {
    public Color getRandomGreenColor() {
        Random greenColor = new Random();

        double hue = 100 + greenColor.nextDouble() * 40;
        double saturation = 0.6 + greenColor.nextDouble() * 0.4;  
        double lightness = 0.4 + greenColor.nextDouble() * 0.2;  
        return Color.hsb(hue, saturation, lightness); 
    }
} 
    

/*Purpose of GreenColorRandomizer class: Method to generate random hue of green for option 3 */

package userInterface;

import java.util.Random;

public class GreenColorRandomizer {
    private GreenColorRandomizer getRandomGreenColor() {
        Random greenColor = new Random();

        double hue = 100 + rand.nextDouble() * 40;
        double saturation = 0.6 + rand.nextDouble() * 0.4;  
        double lightness = 0.4 + rand.nextDouble() * 0.2;  
        return Color.hsb(hue, saturation, lightness); 
}

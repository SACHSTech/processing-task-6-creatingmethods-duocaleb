import processing.core.PApplet;

public class Sketch extends PApplet {
	
	int screenSize = 800;
  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(screenSize, screenSize);
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {
    background(210, 255, 173);
  }

  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {
	  for(int x = 0; x < 9; x++){
      for(int y = 0; y < 9; y++){
        drawFlower(8, 100, -400+100*x, -400+100*y);
      }
    }
  }
  // define other methods down here.
  public void drawFlower(int intPetals, int intSize, int intLocationX, int intLocationY) {
    if (intPetals >= 30){
      strokeWeight(0);
    }
    else{
      strokeWeight(1);
    }

    //Main drawing loop
    for (int x = 0; x < 360; x += 360/intPetals){
      pushMatrix();

      //making a smooth gradient of colours
      if (x*intPetals/360 < intPetals/2){
        fill(0,255-(17/12*x),x*17/12);
      }
      else{
        fill(0 , 255-(17/12*(360-x)) , (360-x)*17/12);
      }

      //Setting the position
      translate(intChangeToPlane(intLocationX, 'x'), intChangeToPlane(intLocationY, 'y'));

      //Rotating
      rotate(radians(x+360/intPetals));

      //Drawing petals
      ellipse(0, 4*intSize/80*3, 8*intSize/5/intPetals, 4*intSize/10);
      popMatrix();
    }
    //Drawing the center
    stroke(0,0,0);
    fill(0,0,0);
    pushMatrix();
    translate(intChangeToPlane(intLocationX, 'x'), intChangeToPlane(intLocationY, 'y'));
    ellipse(0, 0, 24*intSize/80, 24*intSize/80);
    popMatrix();
  }

  //I don't like the java co-ordinates
  public int intChangeToPlane(int intCordsIn, char charCordType){
    if(charCordType == 'x'){
      return((screenSize/2 + intCordsIn));
    }
    else{
      return((screenSize/2 - intCordsIn));
    }
  }
}
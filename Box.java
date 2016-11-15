public class Box {
  public double length;
  public double width;
  public double height;
  
  //constructors
  public Box(double newLength, double newWidth, double newHeight) {
    length = newLength;
    width = newWidth;
    height = newHeight;
  }
  
  public Box() {
  }
  
  //get volume
  public double getVolume() {
    return (length * width * height);
  }

}
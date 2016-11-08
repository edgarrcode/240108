public class Box {
  public double width;
  public double height;
  public double length;
  
  //constructors
  public Box(double newWidth, double newHeight, double newLength) {
    width = newWidth;
    height = newHeight;
    length = newLength;
  }
  
  public Box() {
  }
  
  //get volume
  public double getVolume() {
    return (width * height * length);
  }

}
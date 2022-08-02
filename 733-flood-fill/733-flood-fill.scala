object Solution {
  def floodFill(image: Array[Array[Int]], sr: Int, sc: Int, color: Int): Array[Array[Int]] = {
    def fillRecurs(sr: Int, sc: Int, color: Int, newColor: Int): Unit = {
      if (image(sr)(sc) == color) {
        image(sr)(sc) = newColor
        if (sr > 0) fillRecurs(sr -1, sc, color, newColor)
        if (sc > 0) fillRecurs(sr, sc - 1, color, newColor)
        if (sc +1 < image(0).size) fillRecurs(sr, sc + 1, color, newColor)
        if (sr +1 < image.size) fillRecurs(sr + 1, sc, color, newColor)
      }
    } 
    val oldColor = image(sr)(sc)
    if (oldColor != color) {
      fillRecurs(sr, sc, oldColor, color)  
    }
    
    image
  }
  
  
}
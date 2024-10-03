package lab9;

class Square{
    
    int width;
    int length;
    String color;
    
     public Square(int width,int length,String color) {
        this.color = color;
        this.length = length;
        this.width = width;
    }
    public String toString(){
        
       return color +" " +length+" "+"x"+" "+width +" Rectangle.";
        
    }


}
public class Planet {
    //Planet class with each attribute from files
    String name;
    Double mass;
    int xCoord;
    int yCoord;
    Double xVel;
    Double yVel;
    int scale;

    public Planet(String name, Double mass, int xCoord, int yCoord, Double xVel, Double yVel, int scale) {
        this.name = name;
        this.mass = mass;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.xVel = xVel;
        this.yVel = yVel;
        this.scale = scale;

    }

    public String getName(){
        return this.name;
    }

    public Double getMass(){
        return this.mass;
    }

    public int getxCoord(){
        return this.xCoord;
    }

    public void setxCoord(int newX){
        this.xCoord = newX;
    }

    public int getyCoord(){
        return this.yCoord;
    }

    public void setyCoord(int newY){
        this.yCoord = newY;
    }

    public Double getxVel(){
        return this.xVel;
    }

    public void setxVel(double newxVel){
        this.xVel = newxVel;
    }

    public Double getyVel(){
        return this.yVel;
    }

    public void setyVel(double newyVel){
        this.yVel = newyVel;
    }

    public int getScale(){
        return this.scale;
    }


    @Override
    public String toString() {
        return "Celestial Body: {" +
                "name= '" + name + '\'' +
                ", mass= " + mass +
                ", xCoord= " + xCoord +
                ", yCoord= " + yCoord +
                ", xVel= " + xVel +
                ", yVel= " + yVel +
                ", scale= " + scale +
                '}';
    }
}

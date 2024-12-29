import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PVector;

import java.util.Random;

public class Partic {
    PVector pos,speed,acc;
    Random rand =new Random();
    Partic(float x,float y)
    {
        this.pos=new PVector(x,y) ;
        this.speed=new PVector(0,-5);
        this.acc=new PVector(0,0);
    }
    void applyForce(PVector forec)
    {
        acc.add(forec);
    }
    void update(){
        pos=pos.add(speed);
        speed.add(acc);
        this.acc.mult(0);
    }

    void display(PApplet p, PImage rocket)
    {
        rocket.resize(25, 25);
        p.image(rocket,this.pos.x,this.pos.y);


    }
}
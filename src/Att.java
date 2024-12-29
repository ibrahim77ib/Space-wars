import processing.core.PApplet;
import processing.core.PImage;

import java.util.Random;

public class Att {
    float x, y, speedy;

    Att() {
        Random rand=new Random();
        this.speedy = 1 + rand.nextInt(2);
        this.x = 30 + rand.nextInt(550);
        this.y = 0;
    }

    void update() {

        this.y = this.y + this.speedy;


    }
    boolean Explosion_site(Partic p) {
        double s = Math.sqrt(Math.pow(this.x+25-p.pos.x,2) + Math.pow(this.y-p.pos.y,2));
        return s<35;
    }

    boolean game_over()
    {
        if(600 == y) return true;
return false;
    }
    void show_game_win(PApplet p)
    {
        p.noLoop();
        p.background(0);
        p.textAlign(p.CENTER);
        p.fill(0,0,255);
        p.textSize(100);
        p.text("Your Winner",(float) p.width/2, (float) p.height /2);
    }
    void show_game_over(PApplet p,int w)
    {
        p.noLoop();
        p.background(0);
        p.textAlign(p.CENTER);
        p.fill(255,0,0);
        p.textSize(100);
        p.text("GAME OVER",(float) p.width/2, (float) p.height /2);
        p.fill(0,255,0);
        p.textSize(50);
        p.text("Your Score :",(float) p.width/2-20, (float) p.height /2+100);
        p.fill(0,255,0);
        p.text(w,(float) p.width/2+130, (float) p.height /2+100);
    }
    void pom(PApplet p,PImage im)
    {
        im.resize(100, 100);
        p.image(im,this.x-5,this.y );
    }
    void display(PApplet p,PImage war_plane ) {
        war_plane.resize(50, 50);
        p.image(war_plane, x, y);
       // p.rect(x,y,12,12);
    }

}
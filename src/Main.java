import processing.core.*;
import java.util.ArrayList;

public class Main extends PApplet {
    public static void main(String[] args) {
        PApplet.main("Main");
    }
    ArrayList<Partic> p;
    PImage war_plane,Explosion;
    PImage rocket ,bgImage  ;
    PImage mo;
    ArrayList<Att> a;
    int time = 120,w;
    public void settings() {
        size(600, 600);
    }
    public void setup() {
        p = new ArrayList<>();
        a = new ArrayList<>();
        w=0;
        Explosion=loadImage("3.png");
        war_plane = loadImage("8.png");
        rocket=loadImage("5.png");
        mo=loadImage("7.png");
        bgImage=loadImage("6.jpg");
    }
    public void draw() {
        bgImage.resize(600,600);
        image(bgImage,0,0);
        mo.resize(60, 60);
        image(mo,mouseX,mouseY);
        if (frameCount % time == 0) {
            a.add(new Att());
        }
        for (int i = a.size() - 1; i >= 0; i--) {
            a.get(i).update();
            a.get(i).display(this,war_plane);
            if(a.get(i).game_over())
            {
                a.get(i).show_game_over(this,w);
                a.removeAll(a);
                p.removeAll(p);
            }
            if(w==40)
            {
                a.get(i).show_game_win(this);
            }
            for (int j = p.size() - 1; j >= 0; j--) {

                if (a.get(i).Explosion_site(p.get(j)) ) {
                    a.get(i).pom(this,Explosion);
                    p.remove(j);
                    a.remove(i);
                    w++;
                    break;
                }
            }
        }
        for (Partic s : p) {
            s.update();
            s.display(this,rocket);
        }
    }
    public void mouseClicked(){
        p.add(new Partic(mouseX+15, mouseY));
    }
}
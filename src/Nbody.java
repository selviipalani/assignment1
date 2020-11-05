import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Nbody extends JPanel implements ActionListener {
    Timer tm = new Timer(50, this);
    //data members for the bodies
    Double mass;
    int xCoord;
    int yCoord;
    Double xVel;
    Double yVel;
    int scale;
    List<Planet> nBodies = new <Planet>ArrayList();
    List<Planet> nBodiesLinked = new <Planet> LinkedList();
    boolean isArrayList = false;
    boolean isLinked = false;


    public List readFile() throws Exception {
        //read the file
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/selviipalani/Downloads/nbody_input.txt"))) {
            //empty string which will store each line
            String line = "";
            line = br.readLine();
            //check if the line specifies array list
            if (line.contentEquals("ArrayList")) {
                isArrayList = true;
                line = br.readLine();
            } else if (line.contentEquals("LinkedList")) {
                isLinked = true;
                line = br.readLine();
            }


            //while we are not at the end of the file
            while (line != null) {
                line = br.readLine();
                //error checking ;/
                if (line == null) {
                    break;
                }
                //split each line by commas and store result in array
                String[] str = (line.split(",", 7));
                mass = Double.parseDouble(str[1]);
                xCoord = Integer.parseInt(str[2]);
                yCoord = Integer.parseInt(str[3]);
                xVel = Double.parseDouble(str[4]);
                yVel = Double.parseDouble(str[5]);
                scale = Integer.parseInt(str[6]);

                //check if its arraylist or linked list and add accordingly
                if (isArrayList) {
                    Planet planet = new Planet(str[0],mass,xCoord,yCoord,xVel,yVel,scale);
                    nBodies.add(planet);
                } else if (isLinked) {
                    Planet planet = new Planet(str[0],mass,xCoord,yCoord,xVel,yVel,scale);
                    nBodiesLinked.add(planet);
                }
            }
            //check again and return list accordingly
            if (isArrayList) {
                return nBodies;
            }
            return nBodiesLinked;
        }
    }

    public void update() {
        //check if arrayList
        if(isArrayList) {
            for (int i = 0; i < nBodies.size(); i++) {
                //create new planet
                Planet body = nBodies.get(i);
                final double gravity = 6.674 + Math.pow(10, -11);
                //set coords because im not a physicist and the velocity is confusing :)
                body.setxCoord((int) (body.getxCoord() + body.getxVel()));
                body.setyCoord((int) (body.getyCoord() + body.getyVel()));
            }
        }
        //same thing for linked list
        if(isLinked){
            for (int i = 0; i < nBodiesLinked.size(); i++) {
                Planet body = nBodiesLinked.get(i);
                final double gravity = 6.674 + Math.pow(10, -11);
                body.setxVel(Math.sqrt((gravity * body.mass) / ((body.getyCoord() - body.getxCoord()) / 2)));
                body.setxCoord((int) (body.getxCoord() + body.getxVel()));
                body.setyCoord((int) (body.getyCoord() + body.getyVel()));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        update();
        repaint();
    }


    public void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        //check if arrayList
        if(isArrayList){
            //loop through arrayList
            for(int i = 0 ; i < nBodies.size(); i++){
                //set all colors
                if(i == 0){
                    graphics.setColor(Color.BLUE);
                }else if(i == 1){
                    graphics.setColor(Color.RED);
                }else if(i == 2){
                    graphics.setColor(Color.GREEN);
                }else{
                    graphics.setColor(Color.PINK);
                }

                //draw and fill each body
                graphics.drawOval(nBodies.get(i).getxCoord(),nBodies.get(i).getyCoord(), nBodies.get(i).getScale(),nBodies.get(i).getScale());
                graphics.fillOval(nBodies.get(i).getxCoord(),nBodies.get(i).getyCoord(), nBodies.get(i).getScale(),nBodies.get(i).getScale());
            }
        }
        //same thing as above but now in our linked list
        if(isLinked){
            for(int i = 0 ; i < nBodiesLinked.size(); i++){
                if(i == 0){
                    graphics.setColor(Color.BLUE);
                }else if(i == 1){
                    graphics.setColor(Color.RED);
                }else if(i == 2){
                    graphics.setColor(Color.GREEN);
                }else{
                    graphics.setColor(Color.PINK);
                }

                graphics.drawOval(nBodiesLinked.get(i).getxCoord(),nBodiesLinked.get(i).getyCoord(), nBodiesLinked.get(i).getScale(),nBodiesLinked.get(i).getScale());
                graphics.fillOval(nBodiesLinked.get(i).getxCoord(),nBodiesLinked.get(i).getyCoord(), nBodiesLinked.get(i).getScale(),nBodiesLinked.get(i).getScale());
            }
        }
        tm.start();
    }

    public static void main(String[] args) throws Exception {
        Nbody nbody = new Nbody();
        List celestialBodies = nbody.readFile();
        System.out.println(celestialBodies);
        JFrame jf = new JFrame();
        jf.setTitle("Tutorial");
        jf.setSize(768,768);
        jf.add(nbody);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

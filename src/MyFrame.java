import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class MyFrame extends JFrame {
    // JButton button;

    static JTextField t;

    // JFrame
    static JFrame f;

    // JButton
    static JButton sButt;

    // label to display text
    static JLabel l;

    public static boolean display = false;


    MyFrame() {
        this.setTitle("GuiGui");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1200, 1000);
        this.setLayout(null);
        this.setVisible(false);
        // this.add(label);
        //this.add(button);

        f = new JFrame();

        f.setLocation(getWidth() / 2 , getHeight() / 2);

        l = new JLabel("Enter number of nodes please");

        // create a new button
        sButt = new JButton("submit");

        // create an object of JTextField with 16 columns
        t = new JTextField(15);

        sButt.addActionListener(e -> {Main.n = Integer.parseInt(t.getText());Main.createNodes(); Main.displayPath(); display = true; repaint(); f.setVisible(false); this.setVisible(true);});

        // create a panel to add buttons and text-field
        JPanel p = new JPanel();

        // add buttons and text-field to panel
        p.add(t);
        p.add(sButt);
        p.add(l);


        // add panel to frame
        f.add(p);

        // set the size of frame
        f.setSize(300, 100);

        f.setVisible(true);

    }

    public void paint(Graphics g){

        Graphics2D g2D = (Graphics2D) g;

        // anti-aliasing for smoother lines
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        if (display){
            for (int i = 0; i < Main.n; i++) {
                //draw the oval nodes
                //set the nodes colour to be blue
                g2D.setPaint(Color.RED);
                g2D.setStroke(new BasicStroke(1));
                g2D.drawOval(Main.nodes.get(i).getX(), Main.nodes.get(i).getY(), 20, 10);
                g2D.fillOval(Main.nodes.get(i).getX(), Main.nodes.get(i).getY(), 20, 10);



                // display node name
                g2D.setPaint(Color.BLACK);
                g2D.drawString(Main.nodes.get(i).getName(), Main.nodes.get(i).getX() - 10, Main.nodes.get(i).getY() - 10);


                //draw edges
                for (int j = 0; j < Main.n; j++){
                    g2D.setPaint(Color.GRAY);
                    if (Main.nodes.get(i).getAdjacentNodes().get(Main.nodes.get(j)) != null)
                        g2D.drawLine(Main.nodes.get(i).getX() + 10, Main.nodes.get(i).getY() + 5, Main.nodes.get(j).getX() + 10, Main.nodes.get(j).getY() + 5);
                }


            }

            // shortest path

            g2D.setPaint(Color.GREEN);
            g2D.setStroke(new BasicStroke(3));

            //temporary variable to store shortest path of each node
            ArrayList<Integer> path = Main.nodes.get(Main.start).getShortestPath();

            for (int k = 0; k < path.size() - 1; k++) {
                g2D.drawLine(Main.nodes.get(path.get(k)).getX() + 10, Main.nodes.get(path.get(k)).getY() + 5, Main.nodes.get(path.get(k + 1)).getX() + 10, Main.nodes.get(path.get(k + 1)).getY() + 5);
            }




        }


    }




}
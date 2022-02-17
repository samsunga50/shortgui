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



       // button = new JButton();
       /// button.setBounds(200 ,100, 250, 50);
       // button.addActionListener(e -> {Main.createNodes();});
       // button.setText("Generate");
        // button.setFocusable(false);
       // button.setVerticalAlignment(JButton.CENTER);
       // button.setHorizontalAlignment(JButton.CENTER);
       // button.setFont(new Font("Comic Sans", Font.BOLD, 25));
        //button.setForeground(Color.BLUE);
       // button.setBorder(BorderFactory.createEtchedBorder());

        /*
        //JFrame; gui window to add components to
        ImageIcon image = new ImageIcon("welcome.png");
        Border border = BorderFactory.createLineBorder(Color.BLUE, 4);


        JLabel label = new JLabel();
        label.setText("GuiGui");
        // label.setIcon(image);
        // label.setHorizontalTextPosition(JLabel.CENTER);
        // label.setVerticalTextPosition(JLabel.TOP);
        label.setForeground(new Color(223, 145, 167));
        label.setFont(new Font("Arial", Font.PLAIN, 40));
        label.setBackground(Color.BLACK);
        label.setOpaque(true);
        label.setBorder(border);
        label.setVerticalAlignment(JLabel.TOP);
        label.setHorizontalAlignment(JLabel.CENTER);
        


         */
        this.setTitle("GuiGui");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1200, 1000);
        this.setLayout(null);
        this.setVisible(false);
        // this.add(label);
        //this.add(button);

        f = new JFrame();

        //fshort = new JFrame();

        f.setLocation(getWidth() / 2 , getHeight() / 2);
        //fshort.setLocation(getWidth() / 2 , getHeight() / 2);

        l = new JLabel("Enter number of nodes please");
        //lshort = new JLabel("Enter valid name of starting node: ");

        // create a new button
        sButt = new JButton("submit");
        //sButtshort = new JButton("submit");

        // create an object of the text class


        // addActionListener to button

        // create an object of JTextField with 16 columns
        t = new JTextField(15);
        //tshort = new JTextField(15);


        sButt.addActionListener(e -> {Main.n = Integer.parseInt(t.getText());Main.createNodes(); Main.displayPath(); display = true; repaint(); f.setVisible(false); this.setVisible(true);});
        //sButtshort.addActionListener(e -> {Main.start = Integer.parseInt(tshort.getText()); Main.displayPath(); ; displayshort = true; repaint(); fshort.setVisible(false);});

        // create a panel to add buttons and text-field
        JPanel p = new JPanel();
        JPanel pshort = new JPanel();

        // add buttons and text-field to panel
        p.add(t);
        p.add(sButt);
        p.add(l);

        /*
        pshort.add(tshort);
        pshort.add(sButtshort);
        pshort.add(lshort);


         */

        // add panel to frame
        f.add(p);
        //fshort.add(pshort);

        // set the size of frame
        f.setSize(300, 100);
        //fshort.setSize(300, 100);

        f.setVisible(true);
        //fshort.setVisible(false);



       // label.setBounds(this.getWidth() / 2 - 250 / 2, 0, 250, 55);
       // button.setBounds(this.getWidth() / 2 - 250 / 2, 900, 250, 55);
       // this.setIconImage(image.getImage());
        // this.getContentPane().setBackground(new Color(123, 145, 156));


    }

    public void paint(Graphics g){

        Graphics2D g2D = (Graphics2D) g;

        /*
        g2D.setPaint(Color.red);
        g2D.setStroke(new BasicStroke(5));
        g2D.drawLine(0, 0, 500, 500);


         */
        /*
        int[] xPoints = {20, 50 ,67, 167, 589, 345};
        int[] yPoints = {459, 235, 456, 234, 34, 567};
        */

        if (display){
            for (int i = 0; i < Main.n; i++) {
                //draw the oval nodes
                //set the nodes colour to be blue
                g2D.setPaint(Color.BLUE);
                g2D.setStroke(new BasicStroke(1));
                g2D.drawOval(Main.nodes.get(i).getX(), Main.nodes.get(i).getY(), 20, 10);
                g2D.fillOval(Main.nodes.get(i).getX(), Main.nodes.get(i).getY(), 20, 10);

                g2D.setPaint(Color.BLACK);

                // display node name
                g2D.drawString(Main.nodes.get(i).getName(), Main.nodes.get(i).getX() - 10, Main.nodes.get(i).getY() - 10);


                for (int j = 0; j < Main.n; j++){
                    g2D.setPaint(Color.RED);
                    if (Main.nodes.get(i).getAdjacentNodes().get(Main.nodes.get(j)) != null)
                        g2D.drawLine(Main.nodes.get(i).getX() + 10, Main.nodes.get(i).getY() + 5, Main.nodes.get(j).getX() + 10, Main.nodes.get(j).getY() + 5);
                }


            }



        }

        if (display){
            // shortest path

            g2D.setPaint(Color.BLUE);
            g2D.setStroke(new BasicStroke(2));

            //temporary variable to store shortest path of each node
            ArrayList<Integer> path = Main.nodes.get(Main.start).getShortestPath();

            for (int i = 0; i < path.size() - 1; i++) {
                g2D.drawLine(Main.nodes.get(path.get(i)).getX() + 10, Main.nodes.get(path.get(i)).getY() + 5, Main.nodes.get(path.get(i + 1)).getX() + 10, Main.nodes.get(path.get(i + 1)).getY() + 5);
            }

        }

    }




}
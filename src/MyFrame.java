import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.Objects;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

public class MyFrame extends JFrame implements ActionListener {
    JFrame frame;
    JLabel nameLabel;
    JTextField textField;
    JButton submit;
    JPanel top;

    JPanel generator;
    JPanel second;

    JPanel third;

    JLabel quote;

    MyFrame() {
        ImageIcon originalIcon = new ImageIcon(MyFrame.class.getResource("images/logo.png"));
        //ImageIcon scaledIcon = scaleImageIcon(originalIcon,originalIcon.getIconWidth()/2,originalIcon.getIconHeight()/2);
        JLabel imageLabel = new JLabel(originalIcon);
        //imageLabel.setHorizontalAlignment(SwingConstants.LEFT);


        // add the JLabel to a container
        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER));
        container.setLayout(new BorderLayout());
        container.add(imageLabel);
        container.setBackground(Color.LIGHT_GRAY);


        // add a ComponentListener to the container to resize the JLabel when the container is resized
        container.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // get the size of the container
                Dimension size = container.getSize();
                // get the aspect ratio of the image
                double aspectRatio = (double) originalIcon.getIconWidth() / originalIcon.getIconHeight();
                // calculate the new size based on the aspect ratio
                int width = (int) (size.height * aspectRatio);
                int height = size.height;
                if (width > size.width) {
                    width = size.width;
                    height = (int) (width / aspectRatio);
                }
                // scale the image to the new size
                Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
                ImageIcon scaledIcon = new ImageIcon(scaledImage);
                // update the JLabel with the new scaled image
                imageLabel.setIcon(scaledIcon);
            }
        });

        top = new JPanel();
        generator = new JPanel();
        second = new JPanel();
        quote = new JLabel();

        top.setBounds(0, 0, 500, 50);
        //top.setPreferredSize(new Dimension(500,50));
        top.setVisible(true);
        top.setBackground(Color.lightGray);
        top.setLayout(new FlowLayout());
        JLabel bigO = new JLabel();
        bigO.setBounds(0, 10, 500, 30);
        bigO.setText("Randomize Class E2");
        bigO.setFont(new Font("MC Boli", Font.BOLD, 18));
        bigO.setForeground(new Color(0x48BEBE));
        bigO.setVisible(true);


        //generator.setLayout(new FlowLayout(FlowLayout.CENTER));
        generator.setBounds(0, 50, 500, 50);
        generator.setBackground(Color.lightGray);
        generator.setVisible(true);

        second.setBounds(0, 100, 500, 400);
        second.setLayout(new GridLayout(1, 2));
        second.setBackground(Color.lightGray);
        second.setVisible(true);


        quote.setText("皆さん、" + "\n 頑張りましょう！");
        quote.setFont(new Font("Meiryo", Font.PLAIN, 20));
        quote.setLayout(new FlowLayout());


        nameLabel = new JLabel();
        nameLabel.setText("Name: ");
        nameLabel.setFont(new Font("MC Boli", Font.BOLD, 25));
        nameLabel.setForeground(Color.BLACK);
        //nameLabel.setBounds(5,5,100,50);

        submit = new JButton();
        submit.setText("Generate");
        submit.setFont(new Font("Comic Sans", Font.PLAIN, 18));
        submit.setForeground(Color.green);
        submit.setBackground(Color.lightGray);
        submit.setFocusable(false);
        //submit.setBounds(205,5,100,50);
        submit.addActionListener(this);

        textField = new JTextField();
        //textField.setBounds(105,5,150,50);
        textField.setPreferredSize(new Dimension(150, 50));
        textField.setEditable(false);
        textField.setForeground(Color.green);
        textField.setBackground(Color.BLACK);
        textField.setFont(new Font("MC Boli", Font.PLAIN, 25));
        textField.setText("name");


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("Name-Randomizer");


        generator.add(nameLabel);
        generator.add(textField);
        generator.add(submit);

        second.add((container));
        second.add((quote));

        top.add(bigO);

        this.add(top);
        this.add(generator);
        this.add(second);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            Randomize n = new Randomize();
            textField.setText(n.nm);
        }
    }

}

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class FrameClass extends JFrame
{
    //sets up variables for text fields
    private JTextField nameTF, bDayTF, cityTF, stateTF;

    //sets up variables for labels
    private JLabel nameLabel, bDayLabel, cityLabel, stateLabel;

    //sets up variables for buttons
    private JButton closeButton;

    //sets up variables for information to be stored
    private String name = "", bday = "", city = "", state = "", string = "";

    public FrameClass()
    {
        //sends the window's title to the JFrame class
        super("Personal Info");
        //sets the layout so that once the window width is hit, it wraps the assets
        setLayout(new FlowLayout(FlowLayout.LEFT));

        //creates the label for the name text field
        nameLabel = new JLabel("Enter your name: ");
        nameLabel.setLabelFor(nameTF);
        add(nameLabel);

        //creates the text entry field for the name label with a width of 15 columns
        nameTF = new JTextField(15);
        add(nameTF);

        //creates the label for the birthday text field
        bDayLabel = new JLabel("Enter your birthday:");
        bDayLabel.setLabelFor(bDayTF);
        add(bDayLabel);

        //creates the text entry field for the Birthday label with a width of 15 columns
        bDayTF = new JTextField(15);
        add(bDayTF);

        //creates the label for the city text field
        cityLabel = new JLabel("Enter your city:");
        cityLabel.setLabelFor(cityTF);
        add(cityLabel);

        //creates the text entry field for the city label with a width of 15 columns
        cityTF = new JTextField(15);
        add(cityTF);

        //creates the label for the state text field
        stateLabel = new JLabel("Enter your state: ");
        stateLabel.setLabelFor(stateTF);
        add(stateLabel);

        //creates the text entry field for the state label with a width of 15 columns
        stateTF = new JTextField(15);
        add(stateTF);

        //Creates a button with the text Close
        closeButton = new JButton("Close");
        add(closeButton);

        //adds the action handlers for each element
        theHandler handler = new theHandler();
        nameTF.addActionListener(handler);
        bDayTF.addActionListener(handler);
        cityTF.addActionListener(handler);
        stateTF.addActionListener(handler);
        closeButton.addActionListener(handler);


    }

    //Called in theHandler class. Outputs all information in a JOptionPane
    private void displayString()
    {
        string = String.format("Name: %s\n" +
                        "Birthday: %s\n" +
                        "City, State: %s, %s",
                        name, bday, city, state);

        JOptionPane.showMessageDialog(null,string);
    }

    //creates a second class within the FrameClass so that all assets are still usable
    public class theHandler implements ActionListener
    {
        /*
         * Once the close button gets pressed this receives the strings from
         * each element of the window, closes the window, and calls the
         * displayString method
         */
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == closeButton)
            {
                name = nameTF.getText();
                bday = bDayTF.getText();
                city = cityTF.getText();
                state = stateTF.getText();
                dispose();
                displayString();
            }
        }
    }
}
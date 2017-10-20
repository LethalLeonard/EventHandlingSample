import javax.swing.*;
import java.awt.*;
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

    //sets up the variables for used JPanels
    private JPanel button, info;

    //sets up variables for information to be stored
    private String name = "", bday = "", city = "", state = "", string = "";

    public FrameClass()
    {
        //sends the window's title to the JFrame class
        super("Personal Info");
        //sets the layout so that once the window width is hit, it wraps the assets
        setLayout(new BorderLayout());

        //sets up the panel for the information input area
        info = new JPanel(new FlowLayout(FlowLayout.LEFT));
        add(info);

        //creates the label for the name text field
        nameLabel = new JLabel("Enter your name: \t");
        nameLabel.setLabelFor(nameTF);
        info.add(nameLabel);

        //creates the text entry field for the name label with a width of 15 columns
        nameTF = new JTextField(15);
        info.add(nameTF);

        //creates the label for the birthday text field
        bDayLabel = new JLabel("Enter your birthday:\t");
        bDayLabel.setLabelFor(bDayTF);
        info.add(bDayLabel);

        //creates the text entry field for the Birthday label with a width of 15 columns
        bDayTF = new JTextField(15);
        info.add(bDayTF);

        //creates the label for the city text field
        cityLabel = new JLabel("Enter your city:\t");
        cityLabel.setLabelFor(cityTF);
        info.add(cityLabel);

        //creates the text entry field for the city label with a width of 15 columns
        cityTF = new JTextField(15);
        info.add(cityTF);

        //creates the label for the state text field
        stateLabel = new JLabel("Enter your state: \t");
        stateLabel.setLabelFor(stateTF);
        info.add(stateLabel);

        //creates the text entry field for the state label with a width of 15 columns
        stateTF = new JTextField(15);
        info.add(stateTF);

        //sets up the panel for the button area
        button = new JPanel(new FlowLayout(FlowLayout.CENTER));
        add(button,BorderLayout.SOUTH);

        //Creates a button with the text Close
        closeButton = new JButton("Continue");
        button.add(closeButton);

        //adds the action handlers for each element
        theHandler handler = new theHandler();
        nameTF.addActionListener(handler);
        bDayTF.addActionListener(handler);
        cityTF.addActionListener(handler);
        stateTF.addActionListener(handler);
        closeButton.addActionListener(handler);

        setResizable(false);
    }

    //Called in theHandler class. Outputs all information in a JOptionPane
    private void displayString()
    {   //formats the String string for the output
        string = String.format("Name: %s\n" +
                        "Birthday: %s\n" +
                        "City, State: %s, %s",
                        name, bday, city, state);

        //outputs the String string in a popup
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
            else if(event.getSource() == nameTF)
                nameTF.transferFocus();
            else if(event.getSource() == bDayTF)
                bDayTF.transferFocus();
            else if(event.getSource() == cityTF)
                cityTF.transferFocus();
        }
    }
}
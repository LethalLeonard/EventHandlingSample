import javax.swing.JFrame;

public class MainClass
{
    public static void main(String[] args)
    {
        //creates the object for the JFrame in FrameClass
        FrameClass f1 = new FrameClass();

        //Sets the Default Close Op
        f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //sets the window size
        f1.setSize(350,200);

        //sets whether the window is visible or not
        f1.setVisible(true);
    }
}

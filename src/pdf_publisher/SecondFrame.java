package pdf_publisher;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

public class SecondFrame {
private JFrame f = new JFrame("Second");
	
	public SecondFrame()throws IOException  {
		
		Desktop.getDesktop().open(new File("C://Metapercept/DITA-OT Publishing Tool/Resources/output"));
		
	}
	
}



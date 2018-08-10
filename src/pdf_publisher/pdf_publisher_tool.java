package pdf_publisher;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.TrayIcon;

import javax.swing.JTextField;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.w3c.dom.Attr;
import org.xml.sax.InputSource;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.awt.SystemTray;
import java.awt.ScrollPane;
import java.awt.TextArea;



public class pdf_publisher_tool {

	private JFrame frmPdfPublisher;
	private JTextField textField_1;
	private JTextField textFieldChoose;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pdf_publisher_tool window = new pdf_publisher_tool();
					window.frmPdfPublisher.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
				
			}
		});
	}

	/**
	 * Create the application.
	 */
	public pdf_publisher_tool() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPdfPublisher = new JFrame();
		
		frmPdfPublisher.setIconImage(new ImageIcon("C:\\Users\\Admin\\Desktop\\imageedit_1_6449501097.png").getImage());
		frmPdfPublisher.setTitle("PDF Publisher");
		frmPdfPublisher.setBounds(100, 100, 559, 565);
		frmPdfPublisher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPdfPublisher.getContentPane().setLayout(null);
		
		
		
		TextArea textArea = new TextArea();
		textArea.setBounds(10, 261, 524, 187);
		frmPdfPublisher.getContentPane().add(textArea);
		textArea.setEditable(false);
		textArea.getText().length();
		
		
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(10, 261, 526, 187);
		frmPdfPublisher.getContentPane().add(scrollPane);
		
		
		JProgressBar progressBar = new JProgressBar(0,100);
		
		progressBar.setStringPainted(true);
		progressBar.setBounds(10, 241, 526, 14);
	    frmPdfPublisher.getContentPane().add(progressBar);
		progressBar.setVisible(true);
		
		
		
		
		
		//Transform button function
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Dita Files","ditamap");
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setAcceptAllFileFilterUsed(false);
                fileChooser.setDialogTitle("Choose");
				fileChooser.setFileFilter(filter);
				 
		        // For Directory
		        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
  
		        int rVal  = fileChooser.showOpenDialog(null);
		        if (rVal == JFileChooser.APPROVE_OPTION) {
		          textFieldChoose.setText(fileChooser.getSelectedFile().toString());
		     
                    String str="";
                    
		          final JFrame msgframe= new JFrame();
		          msgframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		          str= textFieldChoose.getText();
		          JOptionPane.showMessageDialog(textFieldChoose, str);
		          getClass().getClassLoader();
		          str= textFieldChoose.getText();    //step1: get the content of the text field
		          try {
		        	  XPathFactory factory = XPathFactory.newInstance();
		        	    XPath xPath = factory.newXPath();

		        	    Attr result = (Attr) xPath.evaluate("//project/property/target/ant/property[1]/location[0]", new InputSource(
		        	        new FileReader("C://dita-ot-3.1.1/plugins/org.dita.pdf2/build.xml")), XPathConstants.NODE);
		        	    System.out.println(result.getValue());

		        	    result.setValue(str);

		        }catch (IOException | XPathExpressionException IoException) {
		            IoException.printStackTrace();
			        
		        }
			}}
		});
		JButton btnTransform = new JButton("Transform");
		btnTransform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String str = null;
					str= textFieldChoose.getText();
					String inputFile = str;
					String outputFile = "C:\\Users/india/Desktop";
					String logFile = "C:\\Users/india/Desktop/dofhdif.txt";

					ProcessBuilder pb = new ProcessBuilder(
							"cmd.exe", 
							"/c",
					        "dita",
					        "--input=" + inputFile,
					        "--format=pdf",
					        "--output=" + outputFile,
					        "--logfile=" + logFile)
					    .directory(new File("C:\\dita-ot-3.1.1\\bin"))
					    //.inheritIO();
					    .redirectErrorStream(true);

					Process process = pb.start();
				    BufferedReader inStreamReader = new BufferedReader(
				        new InputStreamReader(process.getInputStream())); 

				    while(inStreamReader.readLine() != null){
				        //do something with commandline output.
				    }
	            process.getOutputStream().close();
	            java.io.InputStream inputStream = process.getInputStream() ;
	            InputStreamReader inputstreamreader = new InputStreamReader(inputStream);
	            BufferedReader bufferedrReader = new BufferedReader(inputstreamreader);
	            String strLine = "";
	            int length = strLine.length();
	            progressBar.setMaximum(100);
	            length=progressBar.getValue();
	        	   
                while ((strLine = bufferedrReader.readLine()) != null) {
	                System.out.println(strLine);
	                System.setErr(System.out);
	                String newline = "\n";
	                textArea.append(strLine+newline);
	                textArea.setCaretPosition(TextArea.SCROLLBARS_VERTICAL_ONLY);
	                length++;
	                
		        	   progressBar.setValue(length);
		        	   
					try {
						Thread.sleep(length);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	                progressBar.setStringPainted(true);
	                progressBar.dispatchEvent(e);   
	                progressBar.getValue();
	                progressBar.updateUI();
                 
	               
			}
			} catch (IOException IoException) {
	            IoException.printStackTrace();
	        
	        }
			}
			
			
	            
		});
		btnTransform.setBounds(10, 207, 206, 23);
		frmPdfPublisher.getContentPane().add(btnTransform);
		
		JButton btnPreview = new JButton("Preview");
		btnPreview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					new SecondFrame();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		frmPdfPublisher.setVisible(true);
		btnPreview.setBounds(351, 207, 183, 23);
		frmPdfPublisher.getContentPane().add(btnPreview);
		
		
		
		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(235, 472, 89, 23);
		frmPdfPublisher.getContentPane().add(btnQuit);
		
		JLabel lblLabel1 = new JLabel("Default DITA-OT Path :");
		lblLabel1.setBounds(10, 89, 138, 14);
		frmPdfPublisher.getContentPane().add(lblLabel1);
		

		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 194, 526, 2);
		frmPdfPublisher.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 454, 526, 2);
		frmPdfPublisher.getContentPane().add(separator_1);
		
		textField_1 = new JTextField();
		textField_1.setBackground(SystemColor.menu);
		textField_1.setBounds(158, 86, 375, 20);
		frmPdfPublisher.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setBorder(null);
		textField_1.setText("C:/Metapercept/DITA-OT Publishing Tool/DITA");
		String str1="";
		str1= textField_1.getText(); 
		//step1: get the content of the text field
         try {

                     File file = new File("C:/Users/india/Desktop/ditaot.txt");
                     
                     // if file doesn't exists, then create it
                     if (!file.exists()) {
                         file.createNewFile();
                     }

                     FileWriter fw = new FileWriter(file.getAbsoluteFile());
                     BufferedWriter bw = new BufferedWriter(fw);
                     bw.write(str1);    //step2: write it
                      bw.close();
                      

       }catch (IOException IoException) {
           IoException.printStackTrace();
	        
       }
		textField_1.setEditable(false);
		
		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/toolbanner.png")).getImage();
		
		Image newImg= img.getScaledInstance(img.getWidth(lblNewLabel),img.getHeight(lblNewLabel),Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(newImg));
		new ImageIcon(newImg);
		lblNewLabel.setBounds(10, 0, 533, 78);
		frmPdfPublisher.getContentPane().add(lblNewLabel);
		
		
		btnOpen.setBounds(461, 131, 73, 21);
		frmPdfPublisher.getContentPane().add(btnOpen);
		
		
		textFieldChoose = 
				new JTextField();
		textFieldChoose.setBounds(132, 131, 325, 20);
		frmPdfPublisher.getContentPane().add(textFieldChoose);
		textFieldChoose.setColumns(10);
		
		JLabel lblOpenLabel = new JLabel("Choose Dita file :");
		lblOpenLabel.setBounds(10, 134, 112, 14);
		frmPdfPublisher.getContentPane().add(lblOpenLabel);
		
		
		//app in the system tray
	
		String icoPath = "C:\\Users\\Admin\\Desktop\\imageedit_1_6449501097.png";
       if (SystemTray.isSupported()) {
            final SystemTray systemTray = SystemTray.getSystemTray();
            final TrayIcon trayIcon = new TrayIcon(new ImageIcon(icoPath, "omt").getImage(), "PDF Publisher");
            trayIcon.setImageAutoSize(true);// Auto size icon base on space

            MouseAdapter mouseAdapter = new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    systemTray.remove(trayIcon);
                }
            };
            trayIcon.addMouseListener(mouseAdapter);
            try {
                systemTray.add(trayIcon);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
		
		JMenuBar menuBar = new JMenuBar();
		frmPdfPublisher.setJMenuBar(menuBar);
		
		JMenu mnHelp = new JMenu("Option");
		menuBar.add(mnHelp);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnHelp.add(mntmHelp);
	}

	@SuppressWarnings("unused")
	private void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}

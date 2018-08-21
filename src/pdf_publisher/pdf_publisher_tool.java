package pdf_publisher;

import javax.swing.UIManager.*;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.TrayIcon;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import javax.swing.JSeparator;
import java.awt.SystemTray;

public class pdf_publisher_tool {

	private JFrame frmPdfPublisher;
	private JTextField textFieldChoose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
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
		// frmPdfPublisher.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frmPdfPublisher.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPdfPublisher.getContentPane().setLayout(null);

		// Transform button function
		JButton btnOpen = new JButton("Open");
		btnOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				FileNameExtensionFilter filter = new FileNameExtensionFilter("Dita Files", "ditamap", "bookmap");
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.setDialogTitle("Choose");
				fileChooser.setFileFilter(filter);

				// For Directory
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

				int rVal = fileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					textFieldChoose.setText(fileChooser.getSelectedFile().toString());

					String str = "";

					final JFrame msgframe = new JFrame();
					msgframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					str = textFieldChoose.getText();
					JOptionPane.showMessageDialog(textFieldChoose, str);
					getClass().getClassLoader();
					str = textFieldChoose.getText(); // step1: get the content of the text field
				}
			}
		});
		JButton btnTransform = new JButton("Transform");
		btnTransform.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String str = null;
					str = textFieldChoose.getText();
					String inputFile = str;
					String outputFile = "C:\\Users/india/Desktop";
					String logFile = "C:\\Users/india/Desktop/dofhdif.txt";

					ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "dita", "--input=" + inputFile,
							"--format=pdf", "--output=" + outputFile, "--logfile=" + logFile)
									.directory(new File("C:\\dita-ot-3.1.1\\bin"))
									// .inheritIO();
									.redirectErrorStream(true);

					Process process = pb.start();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
				}
			}

		});
		btnTransform.setBounds(10, 176, 523, 71);
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
		btnPreview.setBounds(10, 273, 523, 71);
		frmPdfPublisher.getContentPane().add(btnPreview);

		JButton btnQuit = new JButton("Quit");
		btnQuit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnQuit.setBounds(444, 471, 89, 23);
		frmPdfPublisher.getContentPane().add(btnQuit);

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 151, 526, 2);
		frmPdfPublisher.getContentPane().add(separator);
		String str1 = "";
		// step1: get the content of the text field
		try {

			File file = new File("C:/Users/india/Desktop/ditaot.txt");

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(str1); // step2: write it
			bw.close();

		} catch (IOException IoException) {
			IoException.printStackTrace();

		}

		JLabel lblNewLabel = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/toolbanner.png")).getImage();

		Image newImg = img.getScaledInstance(img.getWidth(lblNewLabel), img.getHeight(lblNewLabel), Image.SCALE_SMOOTH);
		lblNewLabel.setIcon(new ImageIcon(newImg));
		new ImageIcon(newImg);
		lblNewLabel.setBounds(10, 0, 533, 78);
		frmPdfPublisher.getContentPane().add(lblNewLabel);

		btnOpen.setBounds(470, 99, 73, 23);
		frmPdfPublisher.getContentPane().add(btnOpen);

		textFieldChoose = new JTextField();
		textFieldChoose.setBounds(120, 99, 340, 23);
		frmPdfPublisher.getContentPane().add(textFieldChoose);
		textFieldChoose.setColumns(10);

		JLabel lblOpenLabel = new JLabel("Choose Dita file :");
		lblOpenLabel.setBounds(10, 103, 100, 14);
		frmPdfPublisher.getContentPane().add(lblOpenLabel);

		JButton btnNewButton = new JButton("Edit XSLT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				SwingJComboBoxDemo viewModifyXsl = new SwingJComboBoxDemo();
				viewModifyXsl.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 370, 523, 71);
		frmPdfPublisher.getContentPane().add(btnNewButton);

		// app in the system tray

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

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntOpenXsl = new JMenuItem("Open XSLT");
		mnFile.add(mntOpenXsl);
		mntOpenXsl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				FileNameExtensionFilter filter = new FileNameExtensionFilter("XSLT Files", "xsl");
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.setDialogTitle("Browse DITA-OT folder to choose XSLT file");
				fileChooser.setFileFilter(filter);

				// For Directory
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

				int rVal = fileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION) {
					textFieldChoose.setText(fileChooser.getSelectedFile().toString());

					String strxslfile = "";

					final JFrame msgframe = new JFrame();
					msgframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					strxslfile = textFieldChoose.getText();
					JOptionPane.showMessageDialog(textFieldChoose, strxslfile);
					getClass().getClassLoader();

					BufferedReader r = null;
					try {
						r = new BufferedReader(new FileReader(strxslfile));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String s = "", line = null;
					try {
						while ((line = r.readLine()) != null) {
							s += line;
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.print(s);
					ModifyXsl viewModifyXsl = new ModifyXsl();
					viewModifyXsl.setVisible(true);

				}
			}

		});
		JMenuItem mntSaveAs = new JMenuItem("Save As");
		mnFile.add(mntSaveAs);
		JMenuItem mntSave = new JMenuItem("Save");
		mnFile.add(mntSave);
		JMenuItem mntExport = new JMenuItem("Export");
		mnFile.add(mntExport);

		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		JMenu mnExplore = new JMenu("Explore");
		menuBar.add(mnExplore);

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
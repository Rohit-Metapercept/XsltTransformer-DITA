package pdf_publisher;

import javax.swing.UIManager.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.JSplitPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.CardLayout;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ModifyXsl extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;

	/**
	 * Launch the application.
	 */

	void setColor(JPanel panel) {
		panel.setBackground(new Color(135, 112, 225));
	}

	void resetColor(JPanel panel) {
		panel.setBackground(new Color(76, 41, 211));
	}

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
					ModifyXsl frame = new ModifyXsl();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ModifyXsl() {
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 200, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.LIGHT_GRAY);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		String[] items = new String[] { "center", "right", "left" };

		// System.out.println(cmboitem);

		JMenuBar menuBarxsl = new JMenuBar();
		menuBarxsl.setBounds(0, 0, 784, 23);
		contentPane.add(menuBarxsl);
		JMenu mnFile = new JMenu("File");
		menuBarxsl.add(mnFile);

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
					AbstractButton textFieldChoose = null;
					textFieldChoose.setText(fileChooser.getSelectedFile().toString());

					String strxslfile = "";

					final JFrame msgframe = new JFrame();
					msgframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					strxslfile = textFieldChoose.getText();
					JOptionPane.showMessageDialog(textFieldChoose, strxslfile);
					getClass().getClassLoader();
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
		menuBarxsl.add(mnEdit);
		JMenu mnExplore = new JMenu("Explore");
		menuBarxsl.add(mnExplore);

		JMenu mnHelp = new JMenu("Option");
		menuBarxsl.add(mnHelp);

		JMenuItem mntmHelp = new JMenuItem("Help");
		mnHelp.add(mntmHelp);

		JPanel sidepane = new JPanel();
		sidepane.setBackground(new Color(76, 41, 205));
		sidepane.setBounds(0, 21, 194, 720);
		contentPane.add(sidepane);
		sidepane.setLayout(null);

		JButton btn_tables = new JButton();
		btn_tables.setBounds(0, 99, 194, 38);
		btn_tables.setBackground(new Color(76, 41, 205));
		sidepane.add(btn_tables);
		btn_tables.setLayout(null);

		JLabel label_1 = new JLabel("Tables");
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		label_1.setBounds(32, 0, 135, 38);
		btn_tables.add(label_1);

		JPanel panel_table = new JPanel();
		panel_table.setOpaque(false);
		panel_table.setBounds(0, 0, 4, 46);
		btn_tables.add(panel_table);

		JLabel lblEditXslt = new JLabel("Edit PDF");
		lblEditXslt.setFont(new Font("Century Gothic", Font.BOLD, 24));
		lblEditXslt.setForeground(new Color(192, 192, 192));
		lblEditXslt.setBounds(33, 39, 104, 22);
		sidepane.add(lblEditXslt);

		JButton btn_frontmatter = new JButton();
		btn_frontmatter.setLayout(null);
		btn_frontmatter.setBackground(new Color(76, 41, 205));
		btn_frontmatter.setBounds(0, 140, 194, 38);
		sidepane.add(btn_frontmatter);

		JPanel panel_frontmatter = new JPanel();
		panel_frontmatter.setOpaque(false);
		panel_frontmatter.setBounds(0, 0, 4, 46);
		btn_frontmatter.add(panel_frontmatter);

		JLabel lblFrontmatter = new JLabel("Frontmatter");
		lblFrontmatter.setForeground(Color.LIGHT_GRAY);
		lblFrontmatter.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblFrontmatter.setBounds(31, 0, 135, 38);
		btn_frontmatter.add(lblFrontmatter);

		JButton btn_headerFooter = new JButton();
		btn_headerFooter.setLayout(null);
		btn_headerFooter.setBackground(new Color(76, 41, 205));
		btn_headerFooter.setBounds(0, 181, 194, 38);
		sidepane.add(btn_headerFooter);

		JPanel panel_headerFooter = new JPanel();
		panel_headerFooter.setOpaque(false);
		panel_headerFooter.setBounds(0, 0, 4, 46);
		btn_headerFooter.add(panel_headerFooter);

		JLabel lblHeaderAndFooter = new JLabel("Header and Footer");
		lblHeaderAndFooter.setForeground(Color.LIGHT_GRAY);
		lblHeaderAndFooter.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		lblHeaderAndFooter.setBounds(31, 0, 135, 38);
		btn_headerFooter.add(lblHeaderAndFooter);

		JLabel lblV = new JLabel("V 2.0.1");
		lblV.setForeground(Color.LIGHT_GRAY);
		lblV.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		lblV.setBounds(132, 25, 52, 14);
		sidepane.add(lblV);

		String rohitxsl = "<xsl:stylesheet xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\"\r\n"
				+ "    xmlns:fo=\"http://www.w3.org/1999/XSL/Format\"\r\n" + "    version=\"2.0\">\r\n" + "\r\n"
				+ "    <xsl:attribute-set name=\"__frontmatter\">\r\n"
				+ "        <xsl:attribute name=\"text-align\">center</xsl:attribute>\r\n"
				+ "    </xsl:attribute-set>\r\n" + "</xsl:stylesheet>";

		JButton btnNewButton_1 = new JButton("transform ");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

			}
		});
		btnNewButton_1.setBounds(48, 300, 89, 23);
		sidepane.add(btnNewButton_1);

		JPanel bodypanel = new JPanel();
		bodypanel.setBounds(194, 21, 590, 720);
		contentPane.add(bodypanel);
		bodypanel.setLayout(new CardLayout(0, 0));

		JPanel panel = new JPanel();
		bodypanel.add(panel, "name_603471119094596");
		panel.setLayout(null);
		JScrollPane pane = new JScrollPane();
		panel.add(pane);
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(573, 0, 17, 720);
		panel.add(scrollBar);

		textField = new JTextField();
		textField.setBounds(84, 49, 92, 20);
		panel.add(textField);
		textField.setColumns(10);

		JComboBox comboBox_1 = new JComboBox(new Object[] {});
		comboBox_1.setBounds(278, 49, 94, 20);
		panel.add(comboBox_1);
		JComboBox comboBox = new JComboBox(items);
		comboBox.setBounds(129, 700, 259, 20);
		panel.add(comboBox);
		Object cmboitem = comboBox.getSelectedItem();

		comboBox.setSelectedItem("right");
		cmboitem = comboBox.getSelectedItem();

		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(427, 697, 108, 23);
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		JLabel lblCommonBody = new JLabel("Common Body");
		lblCommonBody.setBounds(10, 11, 104, 14);
		panel.add(lblCommonBody);

		JSeparator separator = new JSeparator();
		separator.setBounds(99, 23, 456, 2);
		panel.add(separator);

		JLabel lblNewLabel = new JLabel("Space Before");
		lblNewLabel.setBounds(186, 52, 82, 14);
		panel.add(lblNewLabel);

		JLabel lblSpaceBeforeConditionality = new JLabel("Space Before Conditionality");
		lblSpaceBeforeConditionality.setBounds(382, 52, 176, 14);
		panel.add(lblSpaceBeforeConditionality);

		JLabel lblSpaceAfter = new JLabel("Space After");
		lblSpaceAfter.setBounds(186, 83, 82, 14);
		panel.add(lblSpaceAfter);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(84, 80, 92, 20);
		panel.add(textField_1);

		JComboBox comboBox_2 = new JComboBox(new Object[] {});
		comboBox_2.setBounds(278, 80, 94, 20);
		panel.add(comboBox_2);

		JLabel lblSpaceAfterConditionality = new JLabel("Space After Conditionality");
		lblSpaceAfterConditionality.setBounds(379, 83, 176, 14);
		panel.add(lblSpaceAfterConditionality);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(84, 111, 92, 20);
		panel.add(textField_2);

		JLabel lblStartIndent = new JLabel("Start Indent");
		lblStartIndent.setBounds(186, 114, 82, 14);
		panel.add(lblStartIndent);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(278, 111, 94, 20);
		panel.add(textField_3);

		JLabel lblEndIndent = new JLabel("End Indent");
		lblEndIndent.setBounds(379, 114, 176, 14);
		panel.add(lblEndIndent);

		JLabel lblCommonHead = new JLabel("Common Head");
		lblCommonHead.setBounds(10, 142, 104, 14);
		panel.add(lblCommonHead);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(99, 154, 456, 2);
		panel.add(separator_1);

		JComboBox comboBox_3 = new JComboBox(new Object[] {});
		comboBox_3.setBounds(84, 167, 92, 20);
		panel.add(comboBox_3);

		JLabel lblFontWeight = new JLabel("Font Weight");
		lblFontWeight.setBounds(186, 170, 82, 14);
		panel.add(lblFontWeight);

		JLabel lblTableTitle = new JLabel("Table Title");
		lblTableTitle.setBounds(10, 210, 64, 14);
		panel.add(lblTableTitle);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(70, 222, 485, 2);
		panel.add(separator_2);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(84, 235, 92, 20);
		panel.add(textField_4);

		JLabel label = new JLabel("Space Before");
		label.setBounds(186, 238, 82, 14);
		panel.add(label);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(84, 266, 92, 20);
		panel.add(textField_5);

		JLabel lblSpaceAfter_1 = new JLabel("Space After");
		lblSpaceAfter_1.setBounds(186, 269, 82, 14);
		panel.add(lblSpaceAfter_1);

		JComboBox comboBox_4 = new JComboBox(new Object[] {});
		comboBox_4.setBounds(278, 235, 94, 20);
		panel.add(comboBox_4);

		JLabel label_2 = new JLabel("Font Weight");
		label_2.setBounds(382, 235, 173, 14);
		panel.add(label_2);

		JLabel lblKeepWithNext = new JLabel("Keep with next within column");
		lblKeepWithNext.setBounds(379, 269, 176, 14);
		panel.add(lblKeepWithNext);

		JComboBox comboBox_5 = new JComboBox(new Object[] {});
		comboBox_5.setBounds(278, 266, 94, 20);
		panel.add(comboBox_5);

		JLabel lblTableFrameBottom = new JLabel("Table Frame Bottom");
		lblTableFrameBottom.setBounds(10, 300, 115, 14);
		panel.add(lblTableFrameBottom);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(129, 312, 426, 2);
		panel.add(separator_3);

		JComboBox comboBox_6 = new JComboBox(new Object[] {});
		comboBox_6.setBounds(84, 325, 92, 20);
		panel.add(comboBox_6);

		JLabel lblBorderAfterWidth = new JLabel("Border after width conditionality");
		lblBorderAfterWidth.setBounds(186, 328, 176, 14);
		panel.add(lblBorderAfterWidth);

		JLabel lblTableContainer = new JLabel("Table Container");
		lblTableContainer.setBounds(10, 357, 92, 14);
		panel.add(lblTableContainer);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(112, 369, 443, 2);
		panel.add(separator_4);

		JLabel lblStartIndent_1 = new JLabel("Start Indent");
		lblStartIndent_1.setBounds(186, 385, 82, 14);
		panel.add(lblStartIndent_1);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(84, 382, 92, 20);
		panel.add(textField_6);

		JLabel lblTableBase = new JLabel("Table - Base Font");
		lblTableBase.setBounds(10, 412, 104, 14);
		panel.add(lblTableBase);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(112, 424, 443, 2);
		panel.add(separator_5);

		JLabel label_3 = new JLabel("Space After");
		label_3.setBounds(186, 437, 82, 14);
		panel.add(label_3);

		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(84, 437, 92, 20);
		panel.add(textField_7);

		JLabel label_4 = new JLabel("Start Indent");
		label_4.setBounds(382, 437, 82, 14);
		panel.add(label_4);

		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(280, 434, 92, 20);
		panel.add(textField_8);

		JLabel lblTableTgroup = new JLabel("Table - t.Group");
		lblTableTgroup.setBounds(10, 468, 104, 14);
		panel.add(lblTableTgroup);

		JSeparator separator_6 = new JSeparator();
		separator_6.setBounds(99, 479, 456, 2);
		panel.add(separator_6);

		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(84, 493, 92, 20);
		panel.add(textField_9);

		JLabel lblTableLayout = new JLabel("Table Layout");
		lblTableLayout.setBounds(186, 496, 82, 14);
		panel.add(lblTableLayout);

		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(280, 493, 92, 20);
		panel.add(textField_10);

		JLabel lblWidth = new JLabel("Width");
		lblWidth.setBounds(382, 496, 82, 14);
		panel.add(lblWidth);

		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(84, 528, 92, 20);
		panel.add(textField_11);

		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(280, 528, 92, 20);
		panel.add(textField_12);

		JLabel label_5 = new JLabel("Space Before");
		label_5.setBounds(186, 531, 82, 14);
		panel.add(label_5);

		JLabel label_6 = new JLabel("Space After");
		label_6.setBounds(379, 531, 82, 14);
		panel.add(label_6);

		JLabel lblTbodyrow = new JLabel("Tbody.row");
		lblTbodyrow.setBounds(10, 567, 104, 14);
		panel.add(lblTbodyrow);

		JSeparator separator_7 = new JSeparator();
		separator_7.setBounds(70, 578, 485, 2);
		panel.add(separator_7);

		JComboBox comboBox_7 = new JComboBox(new Object[] {});
		comboBox_7.setBounds(84, 592, 92, 20);
		panel.add(comboBox_7);

		JLabel lblKeeptogetherwithinpage = new JLabel("keep-together.within-page");
		lblKeeptogetherwithinpage.setBounds(186, 595, 176, 14);
		panel.add(lblKeeptogetherwithinpage);

		JLabel lblTbodyrowentryfirstcol = new JLabel("Tbody.row.entry__firstcol");
		lblTbodyrowentryfirstcol.setBounds(10, 623, 141, 14);
		panel.add(lblTbodyrowentryfirstcol);

		JSeparator separator_8 = new JSeparator();
		separator_8.setBounds(150, 633, 405, 2);
		panel.add(separator_8);

		JLabel label_7 = new JLabel("Font Weight");
		label_7.setBounds(186, 651, 173, 14);
		panel.add(label_7);

		JComboBox comboBox_8 = new JComboBox(new Object[] {});
		comboBox_8.setBounds(84, 648, 92, 20);
		panel.add(comboBox_8);

	}
}

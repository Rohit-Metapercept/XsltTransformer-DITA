package pdf_publisher;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 * A Swing program that demonstrates how to create and use JComboBox component.
 * 
 * @author www.codejava.net
 * 
 */
public class SwingJComboBoxDemo extends JFrame {

	private JButton buttonSelect = new JButton("Select");
	private JButton buttonRemove = new JButton("Remove");

	public SwingJComboBoxDemo() {
		super("Swing JComboBox Demo");

		setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));

		String[] bookTitles = new String[] { "center",
				"right", "left" };

		// create a combo box with items specified in the String array:
		final JComboBox<String> frontmatterList = new JComboBox<String>(bookTitles);

		// add more books
		//bookList.addItem("Java Generics and Collections");
		//bookList.addItem("Beginnning Java 7");
		//bookList.addItem("Java I/O");

		// customize some appearance:
		frontmatterList.setForeground(Color.BLUE);
		frontmatterList.setFont(new Font("Arial", Font.BOLD, 14));
		frontmatterList.setMaximumRowCount(10);
		
		// make the combo box editable so we can add new item when needed
		frontmatterList.setEditable(true);

		// add an event listener for the combo box
		frontmatterList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				JComboBox<String> combo = (JComboBox<String>) event.getSource();
				String selectedFronttitle = (String) combo.getSelectedItem();

				DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) combo
						.getModel();

				int selectedIndex = model.getIndexOf(selectedFronttitle);
				if (selectedIndex < 0) {
					// if the selected book does not exist before, 
					// add it into this combo box
					model.addElement(selectedFronttitle);
				}

			}
		});

		// add event listener for the button Select 
		buttonSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String selectedFronttitle = (String) frontmatterList.getSelectedItem();
				JOptionPane.showMessageDialog(SwingJComboBoxDemo.this,
						"You selected the book: " + selectedFronttitle);
			}
		});

		// add event listener for the button Remove
		buttonRemove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				String selectedFronttitle = (String) frontmatterList.getSelectedItem();
				frontmatterList.removeItem(selectedFronttitle);
			}
		});

		// add components to this frame
		add(frontmatterList);
		add(buttonSelect);
		add(buttonRemove);

		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new SwingJComboBoxDemo().setVisible(true);
			}
		});
	}
}
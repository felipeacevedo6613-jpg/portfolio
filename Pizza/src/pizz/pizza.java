package pizz;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class pizza extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private int total = 0;
	private int pizzaValue = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pizza frame = new pizza();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public pizza() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewJgoodiesTitle_2 = DefaultComponentFactory.getInstance().createTitle("0");
		lblNewJgoodiesTitle_2.setBounds(218, 294, 33, 16);
		contentPane.add(lblNewJgoodiesTitle_2);

		JCheckBox chckbxNewCheckBox = new JCheckBox("Champignons(3$)");
		chckbxNewCheckBox.addActionListener(e -> {
			if (chckbxNewCheckBox.isSelected()) {
				total += 3;
			} else {
				total -= 3;
			}
			lblNewJgoodiesTitle_2.setText(String.valueOf(total));
		});
		chckbxNewCheckBox.setBounds(53, 127, 153, 23);
		contentPane.add(chckbxNewCheckBox);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Peperoni($4)");
		chckbxNewCheckBox_1.addActionListener(e -> {
			if (chckbxNewCheckBox_1.isSelected()) {
				total += 4;
			} else {
				total -= 4;
			}
			lblNewJgoodiesTitle_2.setText(String.valueOf(total));
		});
		chckbxNewCheckBox_1.setBounds(53, 169, 128, 23);
		contentPane.add(chckbxNewCheckBox_1);

		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Poivrons(2$)");
		chckbxNewCheckBox_2.addActionListener(e -> {
			if (chckbxNewCheckBox_2.isSelected()) {
				total += 2;
			} else {
				total -= 2;
			}
			lblNewJgoodiesTitle_2.setText(String.valueOf(total));
		});
		chckbxNewCheckBox_2.setBounds(53, 206, 128, 23);
		contentPane.add(chckbxNewCheckBox_2);

		JRadioButton rdbtnNewRadioButton = new JRadioButton("Petite pizza");
		rdbtnNewRadioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					total += 10;
					pizzaValue = 10;
				} else {
					total -= 10;
					pizzaValue = 0;
				}
				lblNewJgoodiesTitle_2.setText(String.valueOf(total));
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(282, 127, 141, 23);
		contentPane.add(rdbtnNewRadioButton);

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Moyenne pizza");
		rdbtnNewRadioButton_2.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					total += 15;
					pizzaValue = 15;
				} else {
					total -= 15;
					pizzaValue = 0;
				}
				lblNewJgoodiesTitle_2.setText(String.valueOf(total));
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(282, 169, 141, 23);
		contentPane.add(rdbtnNewRadioButton_2);

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Grande pizza");
		rdbtnNewRadioButton_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					total += 20;
					pizzaValue = 20;
				} else {
					total -= 20;
					pizzaValue = 0;
				}
				lblNewJgoodiesTitle_2.setText(String.valueOf(total));
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(282, 206, 141, 23);
		contentPane.add(rdbtnNewRadioButton_1);

		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("Commande d'une pizza");
		lblNewJgoodiesTitle.setBounds(157, 42, 175, 16);
		contentPane.add(lblNewJgoodiesTitle);

		JLabel lblNewJgoodiesTitle_1 = DefaultComponentFactory.getInstance().createTitle("Prix de votre pizza:");
		lblNewJgoodiesTitle_1.setBounds(59, 294, 135, 16);
		contentPane.add(lblNewJgoodiesTitle_1);

		JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("$");
		lblNewJgoodiesLabel.setBounds(243, 294, 18, 16);
		contentPane.add(lblNewJgoodiesLabel);
	}
}

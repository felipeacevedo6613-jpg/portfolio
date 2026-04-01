package jue_memoire;

// import java.awt.Color;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
// import java.nio.file.Path;
// import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;

public class jeu_memoire extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	// private int compteur;
	private int temp1;
	private int temp2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jeu_memoire frame = new jeu_memoire();
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
	public jeu_memoire() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 583);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = DefaultComponentFactory.getInstance().createTitle("JUE DE MEMOIRE");
		title.setBounds(214, 3, 122, 16);
		contentPane.add(title);
		
		JLabel vouliez = DefaultComponentFactory.getInstance().createTitle("Vouliez vous choisir vos images ");
		vouliez.setBounds(6, 53, 219, 16);
		contentPane.add(vouliez);
		
        JButton selectFile = new JButton("Charger Images");
        selectFile.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    String selectedFilePath = selectedFile.getAbsolutePath();
                    System.out.println("Selected file: " + selectedFilePath);
                    
                    try {
                        File tempFile = File.createTempFile("tempImage", ".png");
                        Files.copy(selectedFile.toPath(), tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Image charge: " + tempFile.getAbsolutePath());
                        
                        // Object bufferedImage = ImageIO.read(tempFile);

                    } catch (IOException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Error al guardar la imagen temporal", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
		selectFile.setBounds(237, 48, 117, 29);
		contentPane.add(selectFile);
		
		JButton un = new JButton("?");
		un.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp1 = 1;
				if (temp1 == temp2) {
					un.setEnabled(false);
				}

			}
		});
		un.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		un.setBounds(6, 81, 117, 131);
		contentPane.add(un);
		
		JButton deux = new JButton("?");
		deux.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		deux.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		deux.setBounds(131, 81, 117, 131);
		contentPane.add(deux);
		
		JButton trois = new JButton("?");
		trois.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		trois.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		trois.setBounds(261, 81, 117, 131);
		contentPane.add(trois);
		
		JButton quatre = new JButton("?");
		quatre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		quatre.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		quatre.setBounds(385, 81, 117, 131);
		contentPane.add(quatre);
		
		JButton cinque = new JButton("?");
		cinque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				temp2 = 1;
				if (temp1 == temp2) {
					un.setEnabled(false);
					cinque.setEnabled(false);
				}
			}
		});
		cinque.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		cinque.setBounds(6, 224, 117, 131);
		contentPane.add(cinque);
		
		JButton six = new JButton("?");
		six.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		six.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		six.setBounds(131, 224, 117, 131);
		contentPane.add(six);
		
		JButton sept = new JButton("?");
		sept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sept.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		sept.setBounds(261, 224, 117, 131);
		contentPane.add(sept);
		
		JButton huite = new JButton("?");
		huite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		huite.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		huite.setBounds(385, 224, 117, 131);
		contentPane.add(huite);
		
		JButton neuf = new JButton("?");
		neuf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		neuf.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		neuf.setBounds(6, 377, 117, 131);
		contentPane.add(neuf);
		
		JButton dix = new JButton("?");
		dix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dix.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		dix.setBounds(131, 377, 117, 131);
		contentPane.add(dix);
		
		JButton once = new JButton("?");
		once.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		once.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		once.setBounds(261, 377, 117, 131);
		contentPane.add(once);
		
		JButton douce = new JButton("?");
		douce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		douce.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		douce.setBounds(385, 377, 117, 131);
		contentPane.add(douce);
		
		
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mnInformation = new JMenu("Information");
        menuBar.add(mnInformation);

        JMenuItem menuItemInformation = new JMenuItem("A propos");
        mnInformation.add(menuItemInformation);
        menuItemInformation.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "jue cree par: Felipe Acevedo \nle: 04/06/2024 \nau: collegue maisonneuve");
            }
        });
        JMenuItem menuItemInformationJue = new JMenuItem("Comme jouer");
        mnInformation.add(menuItemInformationJue);
        menuItemInformationJue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Choisizes images de votre ordenador, apres les comparer pour exercier la memoire. \n AMOUZES VOUS!!!");
            }
        });
        
        JMenuItem menuItemQuitter = new JMenuItem("Quitter");
        mnInformation.add(menuItemQuitter);
        menuItemQuitter.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });

	}
	
	
}
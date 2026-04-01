package pile;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Calculatrice extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JButton resultat;
    private boolean lastWasOperator = false;
    private boolean lastWasEqual = false;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Calculatrice frame = new Calculatrice();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Calculatrice() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 255, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        String[] labels = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        for (int i = 0; i < labels.length; i++) {
            JButton button = new JButton(labels[i]);
            button.setBounds((i % 4) * 60 + 6, (i / 4) * 40 + 113, 59, 41);
            button.addActionListener(new ButtonClickListener());
            contentPane.add(button);
        }

        JButton btnOff = new JButton("OFF");
        btnOff.setBounds(185, 70, 59, 41);
        btnOff.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        contentPane.add(btnOff);

        JButton btnOuvrirPar = new JButton("(");
        btnOuvrirPar.setBounds(6, 70, 59, 41);
        btnOuvrirPar.addActionListener(new ButtonClickListener());
        contentPane.add(btnOuvrirPar);

        JButton btnFermerPar = new JButton(")");
        btnFermerPar.setBounds(65, 70, 59, 41);
        btnFermerPar.addActionListener(new ButtonClickListener());
        contentPane.add(btnFermerPar);

        resultat = new JButton("");
        resultat.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        resultat.setBounds(6, 6, 245, 52);
        resultat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resultat.setText("");
            }
        });
        contentPane.add(resultat);
    }

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String text = source.getText();

            if (text.equals("=")) {
                try {
                    String infixExpression = resultat.getText();
                    ConvertisseurInfixeEnSuffixe convertisseur = new ConvertisseurInfixeEnSuffixe();
                    String subfixExpression = convertisseur.convertirEnSuffixe(infixExpression);
                    double result = convertisseur.evaluerSuffixe(subfixExpression);

                    DecimalFormat df = new DecimalFormat("#.##########");
                    String formattedResult = df.format(result);

                    JOptionPane.showMessageDialog(contentPane, "Expression en notation subfixe: " + subfixExpression);
                    resultat.setText(formattedResult);

                    lastWasEqual = true;
                } catch (Exception ex) {
                    resultat.setText("Erreur");
                }
            } else if (text.equals("<-")) {
                String currentText = resultat.getText();
                if (currentText.length() > 0) {
                    resultat.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else if (estOperateur(text)) {
                if (!lastWasOperator) {
                    if (lastWasEqual) {
                        lastWasEqual = false;
                    } else {
                        resultat.setText(resultat.getText() + text);
                    }
                    lastWasOperator = true;
                } else {
                    String currentText = resultat.getText();
                    if (currentText.length() > 0) {
                        resultat.setText(currentText.substring(0, currentText.length() - 1) + text);
                    }
                }
                lastWasEqual = false;
            } else {
                if (lastWasEqual) {
                    resultat.setText(text);
                    lastWasEqual = false;
                } else {
                    resultat.setText(resultat.getText() + text);
                }
                lastWasOperator = false;
            }
        }
    }

    private boolean estOperateur(String text) {
        return text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/");
    }
}

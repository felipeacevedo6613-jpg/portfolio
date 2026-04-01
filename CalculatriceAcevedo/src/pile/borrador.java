// package pile;
// import java.awt.EventQueue;
// import javax.swing.JFrame;
// import javax.swing.JPanel;
// import javax.swing.border.EmptyBorder;
// import javax.swing.JButton;
// import java.awt.event.ActionListener;
// import java.text.DecimalFormat;
// import java.util.Stack;
// import java.awt.event.ActionEvent;
// import java.awt.Font;

// public class Calculatrice extends JFrame {

//     private static final long serialVersionUID = 1L;
//     private JPanel contentPane;
//     private JButton resultat;
//     private boolean lastWasOperator = false;
//     private boolean lastWasEqual = false; // Drapeau pour suivre si la dernière action était '='

//     public static void main(String[] args) {
//         EventQueue.invokeLater(new Runnable() {
//             public void run() {
//                 try {
//                     Calculatrice frame = new Calculatrice();
//                     frame.setVisible(true);
//                 } catch (Exception e) {
//                     e.printStackTrace();
//                 }
//             }
//         });
//     }

//     public Calculatrice() {
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setBounds(100, 100, 255, 300);
//         contentPane = new JPanel();
//         contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//         setContentPane(contentPane);
//         contentPane.setLayout(null);

//         String[] labels = {
//             "7", "8", "9", "/",
//             "4", "5", "6", "*",
//             "1", "2", "3", "-",
//             "0", ".", "=", "+"
//         };

//         for (int i = 0; i < labels.length; i++) {
//             JButton button = new JButton(labels[i]);
//             button.setBounds((i % 4) * 60 + 6, (i / 4) * 40 + 113, 59, 41);
//             button.addActionListener(new ButtonClickListener());
//             contentPane.add(button);
//         }

//         JButton btnOff = new JButton("OFF");
//         btnOff.setBounds(185, 70, 59, 41);
//         btnOff.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 System.exit(0);
//             }
//         });
//         contentPane.add(btnOff);

//         JButton btnOuvrirPar = new JButton("(");
//         btnOuvrirPar.setBounds(6, 70, 59, 41);
//         btnOuvrirPar.addActionListener(new ButtonClickListener());
//         contentPane.add(btnOuvrirPar);

//         JButton btnFermerPar = new JButton(")");
//         btnFermerPar.setBounds(65, 70, 59, 41);
//         btnFermerPar.addActionListener(new ButtonClickListener());
//         contentPane.add(btnFermerPar);

//         JButton btnRetour = new JButton("<-");
//         btnRetour.setBounds(125, 70, 59, 41);
//         btnRetour.addActionListener(new ButtonClickListener());
//         contentPane.add(btnRetour);

//         resultat = new JButton("");
//         resultat.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
//         resultat.setBounds(6, 6, 245, 52);
//         resultat.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 resultat.setText("");
//             }
//         });
//         contentPane.add(resultat);
//     }

//     private class ButtonClickListener implements ActionListener {
//         public void actionPerformed(ActionEvent e) {
//             JButton source = (JButton) e.getSource();
//             String text = source.getText();

//             if (text.equals("=")) {
//                 try {
//                     String result = evaluer(resultat.getText());
//                     resultat.setText(result);
//                     lastWasEqual = true;
//                 } catch (Exception ex) {
//                     resultat.setText("Erreur");
//                 }
//             } else if (text.equals("<-")) {
//                 String currentText = resultat.getText();
//                 if (currentText.length() > 0) {
//                     resultat.setText(currentText.substring(0, currentText.length() - 1));
//                 }
//             } else if (estOperateur(text)) {
//                 if (!lastWasOperator) {
//                     if (lastWasEqual) {
//                         lastWasEqual = false;
//                     } else {
//                         resultat.setText(evaluer(resultat.getText()));
//                     }
//                     resultat.setText(resultat.getText() + text);
//                     lastWasOperator = true;
//                 } else {
//                     String currentText = resultat.getText();
//                     if (currentText.length() > 0) {
//                         // Remplacer le dernier opérateur par le nouveau
//                         resultat.setText(currentText.substring(0, currentText.length() - 1) + text);
//                     }
//                 }
//                 lastWasEqual = false;
//             } else {
//                 if (lastWasEqual) {
//                     resultat.setText(text);
//                     lastWasEqual = false;
//                 } else {
//                     resultat.setText(resultat.getText() + text);
//                 }
//                 lastWasOperator = false;
//             }
//         }
//     }

//     private boolean estOperateur(String text) {
//         return text.equals("+") || text.equals("-") || text.equals("*") || text.equals("/");
//     }

//     private String evaluer(String expression) {
//         try {
//             Stack<Double> operands = new Stack<>();
//             Stack<Character> operators = new Stack<>();
//             int n = expression.length();
//             for (int i = 0; i < n; i++) {
//                 char ch = expression.charAt(i);
//                 if (Character.isDigit(ch) || ch == '.') {
//                     StringBuilder sb = new StringBuilder();
//                     while (i < n && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
//                         sb.append(expression.charAt(i++));
//                     }
//                     i--;
//                     operands.push(Double.parseDouble(sb.toString()));
//                 } else if (ch == '(') {
//                     operators.push(ch);
//                 } else if (ch == ')') {
//                     while (operators.peek() != '(') {
//                         operands.push(operate(operands.pop(), operands.pop(), operators.pop()));
//                     }
//                     operators.pop();
//                 } else if (estOperateur(String.valueOf(ch))) {
//                     while (!operators.isEmpty() && precedence(ch) <= precedence(operators.peek())) {
//                         operands.push(operate(operands.pop(), operands.pop(), operators.pop()));
//                     }
//                     operators.push(ch);
//                 }
//             }
//             while (!operators.isEmpty()) {
//                 operands.push(operate(operands.pop(), operands.pop(), operators.pop()));
//             }
//             DecimalFormat df = new DecimalFormat("#.##########");
//             return df.format(operands.pop());
//         } catch (Exception e) {
//             return "Erreur";
//         }
//     }

//     private double operate(double b, double a, char operator) {
//         switch (operator) {
//             case '+': return a + b;
//             case '-': return a - b;
//             case '*': return a * b;
//             case '/': 
//                 if (b == 0) throw new ArithmeticException("Division par zéro");
//                 return a / b;
//             default: throw new IllegalArgumentException("Opérateur invalide");
//         }
//     }

//     private int precedence(char operator) {
//         switch (operator) {
//             case '+':
//             case '-':
//                 return 1;
//             case '*':
//             case '/':
//                 return 2;
//             default:
//                 return -1;
//         }
//     }
// }
/////////////////
// package pile;

// import java.util.Stack;

// public class ConvertisseurInfixeEnSuffixe {

//     public String convertirEnSuffixe(String expression) {
//         Stack<Character> pile = new Stack<>();
//         StringBuilder suffixe = new StringBuilder();
//         expression = expression + ")";
//         pile.push('(');

//         for (char ch : expression.toCharArray()) {
//             if (Character.isDigit(ch)) {
//                 suffixe.append(ch);
//             } else if (ch == '(') {
//                 pile.push(ch);
//             } else if (estUnOperateur(ch)) {
//                 while (!pile.isEmpty() && estUnOperateur(pile.peek()) && prioriteEgaleOuGrande(pile.peek(), ch)) {
//                     suffixe.append(pile.pop());
//                 }
//                 pile.push(ch);
//             } else if (ch == ')') {
//                 while (pile.peek() != '(') {
//                     suffixe.append(pile.pop());
//                 }
//                 pile.pop();
//             }
//         }

//         return suffixe.toString();
//     }

//     private boolean estUnOperateur(char ch) {
//         return ch == '+' || ch == '-' || ch == '*' || ch == '/';
//     }

//     private boolean prioriteEgaleOuGrande(char op1, char op2) {
//         if (op1 == '*' || op1 == '/') {
//             return (op2 == '+' || op2 == '-') ? true : true;
//         } else if (op1 == '+' || op1 == '-') {
//             return (op2 == '+' || op2 == '-') ? true : false;
//         }
//         return false;
//     }

//     public double evaluerSuffixe(String expression) {
//         Stack<Double> pile = new Stack<>();

//         for (char ch : expression.toCharArray()) {
//             if (Character.isDigit(ch)) {
//                 pile.push((double) (ch - '0'));
//             } else if (estUnOperateur(ch)) {
//                 double operande2 = pile.pop();
//                 double operande1 = pile.pop();
//                 double resultat = resultat(operande1, operande2, ch);
//                 pile.push(resultat);
//             }
//         }

//         return pile.pop();
//     }

//     private double resultat(double operande1, double operande2, char operateur) {
//         switch (operateur) {
//             case '+':
//                 return operande1 + operande2;
//             case '-':
//                 return operande1 - operande2;
//             case '*':
//                 return operande1 * operande2;
//             case '/':
//                 if (operande2 == 0) throw new ArithmeticException("Division par zéro");
//                 return operande1 / operande2;
//             default:
//                 throw new IllegalArgumentException("Opérateur invalide");
//         }
//     }
// }

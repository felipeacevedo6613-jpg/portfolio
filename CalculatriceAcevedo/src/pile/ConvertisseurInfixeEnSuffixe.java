package pile;

import java.util.Stack;

public class ConvertisseurInfixeEnSuffixe {

    public String convertirEnSuffixe(String expression) {
        Stack<Character> pile = new Stack<>();
        StringBuilder suffixe = new StringBuilder();
        expression = expression + ")";
        pile.push('(');

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (Character.isDigit(ch)) {
                suffixe.append(ch);
                while (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                    suffixe.append(expression.charAt(++i));
                }
                suffixe.append(' ');
            } else if (ch == '(') {
                pile.push(ch);
            } else if (estUnOperateur(ch)) {
                while (!pile.isEmpty() && estUnOperateur(pile.peek()) && prioriteEgaleOuGrande(pile.peek(), ch)) {
                    suffixe.append(pile.pop()).append(' ');
                }
                pile.push(ch);
            } else if (ch == ')') {
                while (pile.peek() != '(') {
                    suffixe.append(pile.pop()).append(' ');
                }
                pile.pop();
            }
        }

        return suffixe.toString().trim();
    }

    private boolean estUnOperateur(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private boolean prioriteEgaleOuGrande(char op1, char op2) {
        if (op1 == '*' || op1 == '/') {
            return true;
        } else if (op1 == '+' || op1 == '-') {
            return (op2 == '+' || op2 == '-') ? true : false;
        }
        return false;
    }

    public double evaluerSuffixe(String expression) {
        Stack<Double> pile = new Stack<>();
        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (token.matches("-?\\d+(\\.\\d+)?")) { // Cheque si es un numero
                pile.push(Double.parseDouble(token));
            } else if (estUnOperateur(token.charAt(0))) {
                double operande2 = pile.pop();
                double operande1 = pile.pop();
                double resultat = resultat(operande1, operande2, token.charAt(0));
                pile.push(resultat);
            }
        }

        return pile.pop();
    }

    private double resultat(double operande1, double operande2, char operateur) {
        switch (operateur) {
            case '+':
                return operande1 + operande2;
            case '-':
                return operande1 - operande2;
            case '*':
                return operande1 * operande2;
            case '/':
                if (operande2 == 0) throw new ArithmeticException("Division par zéro");
                return operande1 / operande2;
            default:
                throw new IllegalArgumentException("Opérateur invalide");
        }
    }
}

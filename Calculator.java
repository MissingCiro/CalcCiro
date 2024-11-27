import javax.swing.*; // Importing Swing components for GUI
import java.awt.*; // Importing AWT components for layout and graphics
import java.awt.event.*; // Importing AWT event classes for handling actions

// Main class implementing ActionListener for button actions
public class Calculator implements ActionListener {
    
    // GUI components
    JFrame frame; // Main window frame
    JTextField textfield; // Text field to display input and results
    JButton[] numberButtons = new JButton[10]; // Array for number buttons
    JButton[] functionButtons = new JButton[9]; // Array for function buttons
    
    // Individual function buttons
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    
    JPanel panel; // Panel to hold buttons
    
    // Font settings for buttons and text field
    Font myFont = new Font("Sans Regular", Font.BOLD, 30);
    
    // Variables to hold numbers and the operator
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    
    // Constructor to set up the calculator GUI
    Calculator() {
        // Setting up the main frame
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit on close
        frame.setSize(420, 550); // Set size of the frame
        frame.setLayout(null); // Use no layout manager
        frame.getContentPane().setBackground(Color.BLACK); // Set background color to black
        
        // Setting up the text field
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 50); // Position and size
        textfield.setFont(myFont); // Set font
        textfield.setEditable(false); // Make it non-editable
        textfield.setBackground(Color.BLACK); // Set background color to black
        textfield.setForeground(Color.WHITE); // Set text color to white
        
        // Initializing function buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");
        
        // Adding function buttons to the array
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        
        // Setting up action listeners and properties for function buttons
        for (int i = 0; i < 9; i++) {
            functionButtons[i].addActionListener(this); // Register action listener
            functionButtons[i].setFont(myFont); // Set font
            functionButtons[i].setFocusable(false); // Disable focus
            functionButtons[i].setBackground(Color.GRAY); // Set button background color
            functionButtons[i].setForeground(Color.WHITE); // Set button text color
        }
        
        // Setting up number buttons (0-9)
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i)); // Create button for each number
            numberButtons[i].addActionListener(this); // Register action listener
            numberButtons[i].setFont(myFont); // Set font
            numberButtons[i].setFocusable(false); // Disable focus
            numberButtons[i].setBackground(Color.GRAY); // Set button background color
            numberButtons[i].setForeground(Color.WHITE); // Set button text color
        }
        
        // Setting bounds for the additional function buttons
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);
        
        // Creating a panel for the number buttons
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300); // Position and size
        panel.setLayout(new GridLayout(4, 4, 10, 10)); // 4x4 grid layout with gaps
        panel.setBackground(Color.BLACK); // Set panel background color to black
        
        // Adding buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        
        // Adding components to the frame
        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true); // Make the frame visible
    }
    
    // Main method to run the calculator
    public static void main(String[] args) {
        Calculator calc = new Calculator(); // Create an instance of the calculator
    }
    
    // Handling button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        // Check which number button was clicked
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i))); // Append number to text field
            }
        }
        // Check for decimal point button
        if (e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat(".")); // Append decimal point
        }
        // Check for addition button
        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(textfield.getText()); // Store first number
            operator = '+'; // Set operator
            textfield.setText(""); // Clear text field
        }
        // Check for subtraction button
        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(textfield.getText()); // Store first number
            operator = '-'; // Set operator
            textfield.setText(""); // Clear text field
        }
        // Check for multiplication button
        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(textfield.getText()); // Store first number
            operator = '*'; // Set operator
            textfield.setText(""); // Clear text field
        }
        // Check for division button
        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(textfield.getText()); // Store first number
            operator = '/'; // Set operator
            textfield.setText(""); // Clear text field
        }
        // Check for equals button
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(textfield.getText()); // Store second number
            
            // Handle division by zero
            if (operator == '/' && num2 == 0) {
                textfield.setText("Error"); // Show error message
            } else {
                // Perform calculation based on operator
                switch (operator) {
                    case '+':
                        result = num1 + num2; // Addition
                        break;
                    case '-':
                        result = num1 - num2; // Subtraction
                        break;
                    case '*':
                        result = num1 * num2; // Multiplication
                        break;
                    case '/':
                        result = num1 / num2; // Division
                        break;
                }
                textfield.setText(String.valueOf(result)); // Display result
                num1 = result; // Store result for further calculations
            }
        }
        // Check for clear button
        if (e.getSource() == clrButton) {
            textfield.setText(""); // Clear text field
        }
        // Check for delete button
        if (e.getSource() == delButton) {
            String string = textfield.getText(); // Get current text
            textfield.setText(""); // Clear text field
            // Remove last character from text field
            for (int i = 0; i < string.length() - 1; i++) {
                textfield.setText(textfield.getText() + string.charAt(i));
            }
        }
        // Check for negative button
        if (e.getSource() == negButton) {
            double temp = Double.parseDouble(textfield.getText()); // Get current number
            temp *= -1; // Negate the number
            textfield.setText(String.valueOf(temp)); // Display negative number
        }
    }
}
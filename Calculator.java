import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener {


    JFrame frame = new JFrame("Calculator");

    JTextField textField;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButton = new JButton[6];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton, equButton, delButton, clrButton, negButton;
    JPanel panel1;
    JPanel panel2;

    Font myFont = new Font("MV Boli",Font.BOLD,30);

    double num1 = 0, num2 = 0, result= 0;
    char operator;

    Calculator(){
        frame = new JFrame("Calcuator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,600);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);


        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(myFont);
        textField.setEditable(false);


        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");
        negButton = new JButton("(-)");

        functionButton[0] = addButton;
        functionButton[1] = subButton;
        functionButton[2] = mulButton;
        functionButton[3] = divButton;
        functionButton[4] = decButton;
        functionButton[5] = equButton;


        for(int i = 0 ; i < functionButton.length ;i++){
            functionButton[i].addActionListener(this);
            functionButton[i].setFont(myFont);
            functionButton[i].setFocusable(false);
        }

        for(int i = 0 ; i < numberButton.length ; i++){
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFont(myFont);
            numberButton[i].setFocusable(false);
        }


        delButton.setFont(myFont);
        delButton.setFocusable(false);
        delButton.addActionListener(this);


        clrButton.setFont(myFont);
        clrButton.setFocusable(false);
        clrButton.addActionListener(this);



        panel1 = new JPanel();
        panel1.setBounds(50,100,300,300);
        panel1.setLayout(new GridLayout(4,4,10,10));

        panel2 = new JPanel();
        panel2.setBounds(50,400,300,50);
        panel2.setLayout(new GridLayout(1,2,10,10));

        panel1.add(numberButton[1]);
        panel1.add(numberButton[2]);
        panel1.add(numberButton[3]);
        panel1.add(addButton);
        panel1.add(numberButton[4]);
        panel1.add(numberButton[5]);
        panel1.add(numberButton[6]);
        panel1.add(subButton);
        panel1.add(numberButton[7]);
        panel1.add(numberButton[8]);
        panel1.add(numberButton[9]);
        panel1.add(mulButton);
        panel1.add(decButton);
        panel1.add(numberButton[0]);
        panel1.add(equButton);
        panel1.add(divButton);

        panel2.add(delButton);
        panel2.add(clrButton);


        frame.add(textField);
        frame.add(panel1);

        frame.add(panel2);





        frame.setVisible(true);

    }

    public static void main(String[] args) {


        Calculator calculator = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0 ; i < 10 ; i++){
            if(e.getSource() == numberButton[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()== decButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());
            switch(operator) {
                case'+':
                    result=num1+num2;
                    break;
                case'-':
                    result=num1-num2;
                    break;
                case'*':
                    result=num1*num2;
                    break;
                case'/':
                    result=num1/num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1=result;
        }
        if(e.getSource() == clrButton){
            textField.setText("");
        }
        if(e.getSource()== delButton) {
            String string = textField.getText();
            textField.setText("");
            for(int i=0;i<string.length()-1;i++) {
                textField.setText(textField.getText()+string.charAt(i));
            }
        }

    }
}
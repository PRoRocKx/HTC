import javax.swing.*;
import java.awt.event.ActionEvent;

public class CalcUI extends JFrame{
    private JPanel root;
    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton buttonSqr;
    private JButton buttonDiv;
    private JButton buttonMul;
    private JButton buttonSub;
    private JButton buttonAdd;
    private JButton buttonRun;
    private JButton button0;

    public CalcUI() {
        setContentPane(root);
        setVisible(true);

        ActionListener actionListener = new ActionListener();
        button1.addActionListener(actionListener);
        button2.addActionListener(actionListener);
        button3.addActionListener(actionListener);
        button4.addActionListener(actionListener);
        button5.addActionListener(actionListener);
        button6.addActionListener(actionListener);
        button7.addActionListener(actionListener);
        button8.addActionListener(actionListener);
        button9.addActionListener(actionListener);
        button0.addActionListener(actionListener);
        buttonSqr.addActionListener(actionListener);
        buttonDiv.addActionListener(actionListener);
        buttonMul.addActionListener(actionListener);
        buttonSub.addActionListener(actionListener);
        buttonAdd.addActionListener(actionListener);
        buttonRun.addActionListener(actionListener);

        setSize(400,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public class ActionListener implements java.awt.event.ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("=")) {
                Calc calc = new Calc();
                textField1.setText((calc.calculate(textField1.getText())));
            } else {
                textField1.setText(textField1.getText() + e.getActionCommand());
            }
        }


    }
}

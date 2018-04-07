package sample;

import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import static java.lang.Thread.sleep;


public class Controller {
    @FXML
    private Text output;
    @FXML
    private Text helpOutput;
    private int numberOne = 0, numberTwo = 0;
    Calculation calculate = new Calculation();
    String operator = "";
    @FXML
    public void numberListener(ActionEvent e){
        String value = ((Button)e.getSource()).getText();
        output.setText(output.getText() + value);
    }
    @FXML
    public void operatorListener(ActionEvent e){
        String value = ((Button)e.getSource()).getText();
        if(value.equals("=") && !output.getText().isEmpty()) {
            numberTwo = Integer.parseInt(output.getText());
            String text = calculate.getResult(numberOne,numberTwo,operator);
            output.setText("");
            if(numberOne == 0)
                helpOutput.setText(numberTwo + "=" + text);
            else
                helpOutput.setText(helpOutput.getText()+ numberTwo + "="+text);
            operator = "";
            numberOne = 0;
            numberTwo = 0;

        }
        else{
            if(output.getText().isEmpty() || !operator.isEmpty())
                e.consume();
            else{
                helpOutput.setText(output.getText() + value);
                operator = value;
                numberOne = Integer.parseInt(output.getText());
                output.setText("");
            }
        }
    }
}

package sample;

public class Calculation {
    public String getResult(int numberOne, int numberTwo, String operator){
        switch (operator){
            case "+":
                return Integer.toString(numberOne+numberTwo);
            case "-":
                return Integer.toString(numberOne-numberTwo);
            case "*":
                return Integer.toString(numberOne*numberTwo);
            case "/":
                if(numberTwo != 0){
                    if(numberOne%numberTwo != 0)
                        return Double.toString((double)numberOne/numberTwo);
                    else
                        return Integer.toString(numberOne/numberTwo);
                }
                return "Don't do this again";
        }
        return Integer.toString(numberTwo);

    }
}

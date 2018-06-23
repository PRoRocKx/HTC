import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;

public class InputParser {

    public final static char[] OPERATIONS = new char[] {'-','+','*','/','^'};

    public Expression parse(String input) throws ParseException {
        input = input.replaceAll(" ", "");
        for (int i = 0; i < input.length(); i++) {
            int op = new String(OPERATIONS).indexOf(input.charAt(i));
            if (op == -1){
                continue;
            }
            int opNum = input.indexOf(OPERATIONS[op]);
            if (opNum == 0) {
                continue;
            }
            if (opNum == input.length()-1) {
                return new Expression(false);
            }
            else {
                double n1;
                double n2;
                try {
                    n1 = Double.parseDouble(input.substring(0, opNum));
                    n2 = Double.parseDouble(input.substring(opNum + 1));
                }catch (NumberFormatException e){
                    return new Expression(false);
                }
                return new Expression(n1,n2,Expression.getAct(OPERATIONS[op]));
            }


        }
        return new Expression(false);
    }

    private int getMin(int op1, int op2){
        int op = Math.min(op1,op2);
        if (op == -1) {
            if (op1 != -1) {
                op = op1;
            } else {
                if (op2 != -1) {
                    op = op2;
                }
            }
        }
        return op;
    }


    public ExpressionEx findExp(String input, char exp, char exp2) throws ParseException{
        int op1 = input.indexOf(exp);
        int op2 = input.indexOf(exp2);
        int op = getMin(op1,op2);
        if (op == -1) {
            return new ExpressionEx(true, false);
        }
        if (op == 0) {
            op1 = input.substring(1).indexOf(exp);
            op2 = input.substring(1).indexOf(exp2);
            op = getMin(op1,op2);
            if (op == -1) {
                return new ExpressionEx(true, false);
            }
            op++;
        }
        int x = op-1;
        boolean findMinus = false;
        while(x > 0){
            int tempX = new String(OPERATIONS).indexOf(input.charAt(x));
            if (tempX == -1) {
                if (findMinus) {
                    findMinus = false;
                    x++;
                    break;
                }
                x--;
            }
            else{
                if (input.charAt(x) == '-' && !findMinus) {
                    findMinus = true;
                    x--;
                }
                else {
                    if (findMinus) {
                        findMinus = false;
                        x++;
                        break;
                    } else {
                        x++;
                        break;
                    }
                }
            }
        }
        if (findMinus) {
            x += 2;
        }

        int y = op+1;
        while(y < input.length()){
            int tempY = new String(OPERATIONS).indexOf(input.charAt(y));
            if (tempY == -1) {
                y++;
            }
            else {
                if (y == op + 1 && input.charAt(y) == '-') {
                    y++;
                    continue;
                }
                break;
            }
        }

        double n1;
        double n2;
        try {
            n1 = Double.parseDouble(input.substring(x, op));
            n2 = Double.parseDouble(input.substring(op + 1, y));
        }catch (NumberFormatException e){
            return new ExpressionEx(false);
        }
        return new ExpressionEx(n1,n2,Expression.getAct(input.charAt(op)),x,y);

    }

    public String replace(String input, ExpressionEx expressionEx){
        String res = "";
        if (expressionEx.startChar > 0) {
            res += input.substring(0, expressionEx.startChar);
        }
        int intResult = (int)expressionEx.getResult();
        DecimalFormat df = new DecimalFormat("#.########");
        df.setRoundingMode(RoundingMode.CEILING);
        res += df.format(expressionEx.getResult()).replace(',','.');
        //res += expressionEx.result == intResult ? String.valueOf(intResult) : df.format(expressionEx.result);

        //res += expressionEx.result;
        res += input.substring(expressionEx.endChar, input.length());
        res = res.replace("+-", "-").replace("--","+");
        return res;
    }

    public String findBrackets(String exp){
        int b1 = (exp.indexOf('('));
        int b2 = (exp.indexOf(')'));
        if (b1 != -1 && b2 != -1) {
            return exp.substring(b1, b2 + 1);
        }
        return null;
    }

    public String replace(String input, String exp, Double res){
        DecimalFormat df = new DecimalFormat("#.########");
        df.setRoundingMode(RoundingMode.CEILING);
        return input.replace(exp,df.format(res).replace(',','.'));
    }

}

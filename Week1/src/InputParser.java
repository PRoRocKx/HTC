public class InputParser {

    private final static char[] OPERATIONS = new char[] {'+','-','*','/','^'};

    public Expression parse(String input){
        input = input.replaceAll(" ", "");
        for (int i = 0; i < input.length(); i++) {
            int op = new String(OPERATIONS).indexOf(input.charAt(i));
            if (op == -1){
                continue;
            }
            int opNum = input.indexOf(OPERATIONS[op]);
            if (opNum == 0)
                continue;
            if (opNum == input.length()-1)
                return new Expression(false);
            else {
                double n1;
                double n2;
                try {
                    n1 = Double.parseDouble(input.substring(0, opNum));
                    n2 = Double.parseDouble(input.substring(opNum + 1));
                }catch (NumberFormatException e){
                    return new Expression(false);
                }
                return new Expression(n1,n2,op);
            }


        }
        return new Expression(false);
    }
}

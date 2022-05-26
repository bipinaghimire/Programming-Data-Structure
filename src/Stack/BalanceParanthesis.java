package src.Stack;

public class BalanceParanthesis {

    public boolean isBalanced(String exp){
        StackExampleChar stk = new StackExampleChar(exp.length());
        String closingbracket="]})";
        String openingbracket="[{(";

        for(int i=0; i<exp.length();i++){
            char bracket=exp.charAt(i);
            if (bracket=='[' ||  bracket=='{' || bracket=='('){
                stk.push(bracket);
            }
            else{
                int index=closingbracket.indexOf(bracket);
                char openingbraces=openingbracket.charAt(index);
                if(stk.isEmpty()){
                    return false;
                }
                if(stk.pop()!=openingbraces){
                    return false;
                }
            }
            }
            if(!stk.isEmpty()){
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        BalanceParanthesis b= new BalanceParanthesis();
        System.out.println(b.isBalanced("{()}"));
        System.out.println(b.isBalanced("{({}})"));
    }
    
}

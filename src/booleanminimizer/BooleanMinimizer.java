/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package booleanminimizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author LOLU
 */
public class BooleanMinimizer {
    
    public static int numberOfVariables;
    private ArrayList<Integer> canonicalTerms;
    private ArrayList<Integer> dontCares;   
    private boolean isMaxTerm;
    private boolean isPOS;
    
    private ArrayList<String> variables;
    public static int numOfLiterals;
    
    /**
     * @param args the command line arguments
     */
            
    public BooleanMinimizer(int numOfVars, ArrayList<Integer> t, 
            ArrayList<Integer> dc, boolean MT, boolean POS, ArrayList<String> variables){
        numberOfVariables = numOfVars;
        canonicalTerms = t;
        dontCares = dc;
        
        isMaxTerm = MT;
        isPOS = POS;
        
        this.variables = variables;
    }
    
    
    public String minimize(){
        String result = "";
        String newResult = "";
        
        ArrayList<Integer> termsAndDontCares = new ArrayList<>();
        termsAndDontCares.addAll(canonicalTerms);
        termsAndDontCares.addAll(dontCares);
        
        if (!isMaxTerm && !isPOS){
            numOfLiterals = 0;
            Table table = new Table(numberOfVariables, termsAndDontCares);
            List<Term> primeImplicants = table.getPrimeImplicants();


            EssentialTable essTable = new EssentialTable(canonicalTerms, primeImplicants);
            Set<Term> ePrimeImplicants = essTable.essentialPrimes();

            for (Term t: ePrimeImplicants){
                result += binaryToVariableSOP(t.getTerm()) + " + ";
            }
            
            
            String temp = result.substring(0, result.length() - 2);
            if (!temp.equals("() ")){
                newResult = temp;
            }
            else{
                newResult += "1";
            }
            primeImplicants.clear();
            ePrimeImplicants.clear();
        }
        else if (!isMaxTerm && isPOS){
            numOfLiterals = 0;
            Table table = new Table(numberOfVariables, termsAndDontCares);
            List<Term> primeImplicants = table.getPrimeImplicants();


            EssentialTable essTable = new EssentialTable(canonicalTerms, primeImplicants);
            Set<Term> ePrimeImplicants = essTable.essentialPrimes();
            
            for (Term t: ePrimeImplicants){
                result += "(";
                result += binaryToVariablePOS(binaryDual(t));
                result += ")";
            }
            primeImplicants.clear();
            ePrimeImplicants.clear();
            
            newResult = result;
        }
        else if (isMaxTerm && isPOS){
            numOfLiterals = 0;
            ArrayList<Integer> reverseTermsAndDontCares = new ArrayList<>();
            ArrayList<Integer> reverseCanonicalTerms = new ArrayList<>();
            for (int i = 0; i < (int)Math.pow(2, numberOfVariables); i++){
                if (!termsAndDontCares.contains(i)){
                    reverseTermsAndDontCares.add(i);
                }
            }
            for (int i = 0; i < (int)Math.pow(2, numberOfVariables); i++){
                if (!canonicalTerms.contains(i)){
                    reverseCanonicalTerms.add(i);
                }
            }
            Table table = new Table(numberOfVariables, reverseTermsAndDontCares);
            List<Term> primeImplicants = table.getPrimeImplicants();
            

            EssentialTable essTable = new EssentialTable(reverseCanonicalTerms, primeImplicants);
            Set<Term> ePrimeImplicants = essTable.essentialPrimes();
            
            for (Term t: ePrimeImplicants){
                result += "(";
                result += binaryToVariablePOS(binaryDual(t));
                result += ")";
            }
            String temp = result;
            if(temp.equals("")){
                newResult = "1";
            }
            else{
                newResult = result;
            }
            
            primeImplicants.clear();
            ePrimeImplicants.clear();
            
            
            
        }
        else if (isMaxTerm && !isPOS){
            numOfLiterals = 0;
            ArrayList<Integer> reverseTermsAndDontCares = new ArrayList<>();
            ArrayList<Integer> reverseCanonicalTerms = new ArrayList<>();
            for (int i = 0; i < (int)Math.pow(2, numberOfVariables); i++){
                if (!termsAndDontCares.contains(i)){
                    reverseTermsAndDontCares.add(i);
                }
            }
            for (int i = 0; i < (int)Math.pow(2, numberOfVariables); i++){
                if (!canonicalTerms.contains(i)){
                    reverseCanonicalTerms.add(i);
                }
            }
            Table table = new Table(numberOfVariables, reverseTermsAndDontCares);
            List<Term> primeImplicants = table.getPrimeImplicants();
            

            EssentialTable essTable = new EssentialTable(reverseCanonicalTerms, primeImplicants);
            Set<Term> ePrimeImplicants = essTable.essentialPrimes();
            
            for (Term t: ePrimeImplicants){
                result += binaryToVariableSOP(t.getTerm()) + " + ";
            }
            try{
                newResult = result.substring(0, result.length() - 2);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Invalid Operation");
            }
            primeImplicants.clear();
            ePrimeImplicants.clear();
            
        }
        
        return newResult;
    }
    
    public String binaryToVariablePOS(List<Character> term){
        String newResult = "";
        try{
            String result = "";
            for (int i = 0; i < term.size(); i++){
                if (term.get(i) == '1'){
                    result += variables.get(i) + "+";
                    numOfLiterals++;
                }
                else if (term.get(i) == '0'){
                    result += variables.get(i) + "'" + "+";
                    numOfLiterals++;
                }
                else if (term.get(i) == '_'){
                    continue;
                }
            }
            newResult += result.substring(0, result.length()-1);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Invalid Operation");
        }
        finally{
            return newResult;
        }
    }
    
    public String binaryToVariableSOP(List<Character> term){
        String result = "(";
        for (int i = 0; i < term.size(); i++){
            if (term.get(i) == '1'){
                result += variables.get(i);
                numOfLiterals++;
            }
            else if (term.get(i) == '0'){
                result += variables.get(i) + "'";
                numOfLiterals++;
            }
            else if (term.get(i) == '_'){
                continue;
            }
        }
        return result + ")";
    }
    
    private ArrayList<Character> binaryDual(Term t){
        ArrayList<Character> result = new ArrayList<>();
        for (Character c: t.getTerm()){
            if (c == '1'){
                result.add('0');
            }
            else if (c == '0'){
                result.add('1');
            }
            else if (c == '_'){
                result.add('_');
            }
        }
        return result;
    }
    
    
}

package booleanminimizer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

/**
 *
 * @author LOLU
 */
public class Term {
    /*
     * 
     */
    private List<Character> term;  
    private ArrayList<Integer> decimalRep;
    private boolean isChecked;
    
    public Term(int canonicalTerm, int numberOfVars){
        term = toBinary(canonicalTerm, numberOfVars);
        decimalRep = new ArrayList<>();
        decimalRep.add(canonicalTerm);
        
    }
    
    //Create a new Term from two combined terms
    public Term(Term term1, Term term2){
        term = new ArrayList<>();
        
        int shift = shiftPosition(term1, term2);
        
        for(int i = 0; i < shift; i++){
            term.add(term2.term.get(i));
        }
        term.add('_');
        for(int i = shift+1; i < term2.term.size(); i++){
            term.add(term2.term.get(i));
        }
        decimalRep = new ArrayList<>();
        decimalRep.addAll(term1.getDecimalRep());
        decimalRep.addAll(term2.getDecimalRep());
        
    }
    
    private ArrayList<Character> toBinary (int canonicalTerm, int numberOfVars){
        Stack<Integer> stack = new Stack<>();
        ArrayList<Character> result = new ArrayList<>();
        
        while (canonicalTerm > 0){
            stack.push(canonicalTerm % 2);
            canonicalTerm /= 2;
        }
        while(stack.size() < numberOfVars){
            stack.push(0);
        }
        while (!stack.empty()){
            result.add(String.valueOf(stack.pop()).toCharArray()[0]);
        }
           
        return result;
    }
    
    /*
     * Find the shift position of two terms that have a shift bit of 1.
     */
    private int shiftPosition(Term term1, Term term2){
        int shiftPos = -1;
        for (int c = 0; c < term1.getTerm().size(); c++){
            if (term1.getTerm().get(c) != term2.getTerm().get(c)){
                shiftPos = c;
            }
        }
        return shiftPos;
    }
    
    public int numberOfOnes(){
        int count = 0;
        for (Character c: getTerm()){
            if (c == '1'){
                count ++;
            }
        }
        return count;
    }
    
    /*
     * Compares two terms bit by bit to check if
     *  there is only a shift in 1 bit between them.
     */
    public boolean isShiftByOne(Term otherTerm){
        int shift = 0;
        for (int c = 0; c < getTerm().size(); c++){
            if (getTerm().get(c) != otherTerm.getTerm().get(c)){
                shift++;
            }
        }
        return shift == 1;
    }

    /**
     * @return the decimalRep
     */
    public ArrayList<Integer> getDecimalRep() {
        return decimalRep;
    }

    /**
     * @param decimalRep the decimalRep to set
     */
    public void setDecimalRep(ArrayList<Integer> decimalRep) {
        this.decimalRep = decimalRep;
    }

    /**
     * @return the isChecked
     */
    public boolean isIsChecked() {
        return isChecked;
    }

    /**
     * @param isChecked the isChecked to set
     */
    public void setIsChecked(boolean isChecked) {
        this.isChecked = isChecked;
    }

    @Override
    public String toString() {
       String s = "";
       for (Character c : getTerm()){
           s += String.valueOf(c.charValue());
       }
       return s;
    }

    @Override
    public boolean equals(Object otherTerm) {
        if (otherTerm == null){
            return false;
        }
        if (this.getClass() != otherTerm.getClass()){
            return false;
        }
        Term t = (Term)otherTerm;
        if (!this.term.equals(t.term)){
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.term);
        return hash;
    }
    
    
    public List<Character> getTerm() {
        return term;
    }
    
    //
    public boolean isCoversMinterm(int canonicalTerm){
        ArrayList<Integer> decimalValue = this.getDecimalRep();
        if (decimalValue.contains(canonicalTerm)){
            return true;
        }
        return false;
    }
    
       
}

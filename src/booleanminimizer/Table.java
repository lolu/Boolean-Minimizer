/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package booleanminimizer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LOLU
 */
public class Table {
    /*
     * A table consists of the first column built from the minterms
     * and subsequent columns built from the first column.
     */
    public int numberOfVariables;
    private List<Column> table;
    
    public Table(int numberOfVariables, ArrayList<Integer> canonicalTerms){
        this.numberOfVariables = numberOfVariables;
        table = new ArrayList<>();
        //Add the column with the initial number of terms to the table.
        table.add(new Column(canonicalTerms, this));
        
        /*No of groups decreases from left column to right.
         * This means the maximum number of columns in a table is numberOfVariables+1
         */
        //Add subsequent columns that will be built from the initial column.
        for (int i = 0; i < numberOfVariables; i++) {
          table.add(new Column(table.get(i))); 
        }
    }
    public List<Column> getColumns(){
        return table;
    }
    
    
    public List<Term> getPrimeImplicants(){
        List<Term> primeImplicants = new ArrayList<>();
        //Iterate through the whole table column by column.
        for(Column c: table){
            //Iterate through each column group by group.
            for (Group g: c.getGroups()){
                //Iterate through each group term by term.
                for (Term t: g.getTerms()){
                    //if this term has not been used
                    if (!t.isIsChecked()){
                        //Remove Duplicates
                        if(!primeImplicants.contains(t)){
                            primeImplicants.add(t);
                        }
                    }
                }
            }
        }
      
        return primeImplicants;
    }
}

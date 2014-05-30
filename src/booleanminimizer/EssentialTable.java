/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package booleanminimizer;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author LOLU
 */
public class EssentialTable {
    /*
     * An Essential Table consists of prime implicants and 
     * the original list of canonical terms used to get the
     * prime implicants.
     */
    private List<Integer> terms;
    private List<Term> primeImplicants;
    
    public EssentialTable(List<Integer> ts, List<Term> pIs){
        terms = new ArrayList<>(ts);
        primeImplicants = new ArrayList<>(pIs);
        
    }
    
    private boolean allTermsDone( boolean[] mintermsDoneArray ) {
    for ( int ix = 0; ix < terms.size(); ix++) {
        if ( mintermsDoneArray[ix] == false ) {
        return false;
        }
    }
    return true;
    }
    
    
    public Set<Term> essentialPrimes(){
        boolean[][] checkTable = new boolean[terms.size()][primeImplicants.size()];
        for (int i = 0; i < primeImplicants.size(); i++){
            for (int j = 0; j < terms.size(); j++){
                if (primeImplicants.get(i).isCoversMinterm(terms.get(j))){
                    checkTable[j][i] = true;
                    System.out.println(primeImplicants.get(i) + ", " + terms.get(j));
                    
                }else{
                    checkTable[j][i] = false;
                }
            }  
        }
        
        
        for (int i = 0; i < primeImplicants.size(); i++){
            for (int j = 0; j < terms.size(); j++){
                System.out.print(checkTable[j][i]);
                System.out.print("\t");
            }
            System.out.println();
            
        }
        
        Set<Term> ePIs = new LinkedHashSet<>();
        boolean[] mintermsDone = new boolean[terms.size()];
        for  (int i = 0; i < mintermsDone.length; i++){
            mintermsDone[i] = false;
        }
        while (!allTermsDone( mintermsDone ) ) {
            // do columns in order of how many checks they have (least first)
            // find  the col. with the least number of checks:
            int minChecksCol = 0;
            int minChecksVal = primeImplicants.size() + 1;
            for (int col = 0; col < terms.size(); col++) {
                int numChecksInCol = 0;
                if ( !mintermsDone[col] ) { // don’t check any minterms that are circled
                    for (int row = 0; row < primeImplicants.size(); row++) {
                        if (checkTable[col][row]) {
                            // there is a check. Add 1 to the number of checks in col.
                            numChecksInCol++;
                        }
                    }
                    if ( numChecksInCol < minChecksVal ) {
                        // There are fewer checks in this column than the current choice.
                        minChecksVal = numChecksInCol;
                        minChecksCol = col;
                    }
                }
            }
            //find row with most additional checks from col minChecksCol
            int maxChecksRow = 0;
            int maxChecksVal = 0;
            for (int row = 0; row < primeImplicants.size(); row++) {
                if ( checkTable[minChecksCol][row] ) {
                    // There is a check in this row that is in minChecksCol.
                    // Count the number of additional checks in this row.
                    int checksInRow = 0;
                    for (int col = 0; col < terms.size(); col++) {
                        if ( checkTable[col][row] && !mintermsDone[col] ) {
                            // There is a check, and its minterm is not circled.
                            checksInRow++;
                        }
                    }
                    if ( checksInRow > maxChecksVal ) {
                    // There are more additional checks in this row than the current choice.
                    maxChecksVal = checksInRow;
                    maxChecksRow = row;
                    }
                }
            }
            // Circle all minterms with checks in maxChecksRow:
            for ( int col = 0; col < terms.size(); col++ ) {
                if ( checkTable[col][maxChecksRow] ) {
                    mintermsDone[col] = true;
                }
            }
            // The implicant at maxChecksRow is essential. Take it:
            for (int i = 0; i < BooleanMinimizer.numberOfVariables; i++){
                ePIs.add(primeImplicants.get(maxChecksRow));
                System.out.println(maxChecksRow);
            }
      }
        return ePIs; // done. Return essentialPrimes.
    }
 }
package booleanminimizer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LOLU
 */
public class Group {
    /*
     * A Group is a collection of terms that have the same number of 1's.
     */
    
    private List<Term> group;//Using a set so all the terms in a group are unique.
    
    public Group(){
        group = new ArrayList<>();
    }
    //Create a new Group by combining terms
    public Group(Group groupA, Group groupB){
        group = new ArrayList<>();
        
        //For each term in group A
        for (Term i: groupA.group){
            //for each term in group B
            for (Term j: groupB.group){
                if (i.isShiftByOne(j)){
                    //add combined term to group.
                    group.add(new Term(i, j));
                    //Terms i and j have been used, so check them.
                    i.setIsChecked(true);
                    j.setIsChecked(true);
                }
            }
        }   
    }
    
    public List<Term> getTerms() {
        return group;
    }
   

    public void add(Term term){
        group.add(term);
    }
}

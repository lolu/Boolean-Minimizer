package booleanminimizer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author LOLU
 */
public class Column {
    /*y
     * A column represents a list of grouped terms.
     * 
     */
    private List<Group> column;
    private Table table;// The table this column belongs to.
    
    //Create Initial Column
    public Column(ArrayList<Integer> canonicalTerms, Table table){
        this.table = table;
        
        /* The Initial Column should have (numberOFVariables + 1) groups.*/ 
        column = new ArrayList<>();
        for (int i = 0; i <= this.table.numberOfVariables; i++){
            //Create empty groups
            column.add(new Group());
        }
        
        /*Add each term in a column to group based on their numberOfOnes*/
        for (Integer i : canonicalTerms){
            //Create the binary term
            Term t = new Term(i, this.table.numberOfVariables);
            //Get groups in initial column based on numberOfOnes
            Group group = column.get(t.numberOfOnes());
            group.add(t);//Adds term to appropriate group.
        }
         
    }
    //Constructor builds column from the previous column.
    public Column(Column oldColumn){
        table = oldColumn.table;
        //Create a new column from the old column.
        column = new ArrayList<>();
        
        /* Iterate through the old column and combine terms to form new groups*/
        //for each group in the old column
        /*for (int i = 0; i < oldColumn.column.size(); i++){
            //create new Group by combining groups
            Group newGroup = new Group();
            
        }*/
        
        
        Iterator<Group> groups = oldColumn.column.iterator();
        Group group0, group1 = groups.next();
        while (groups.hasNext()) {
          group0 = group1;
          group1 = groups.next();
          Group newGroup = new Group(group0, group1);
          column.add(newGroup);
        }
    }
    
    public List<Group> getGroups(){
        return column;
    }
}

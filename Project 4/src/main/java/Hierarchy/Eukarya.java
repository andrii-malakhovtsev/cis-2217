// Andrii Malakhovtsev
// Plants Hierarchy

package Hierarchy;

public abstract class Eukarya extends Organism {
    public Eukarya(String className, String orderName, String familyName,
                   String genusName, String speciesName, String name, boolean isExtinct) {
        super(className, orderName, familyName, genusName, speciesName, name, isExtinct);
    }
}
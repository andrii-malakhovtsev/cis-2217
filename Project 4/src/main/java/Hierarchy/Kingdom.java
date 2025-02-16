// Andrii Malakhovtsev
// Plants Hierarchy

package Hierarchy;

public abstract class Kingdom extends Eukarya {
    public Kingdom(String className, String orderName, String familyName,
                   String genusName, String speciesName, String name, boolean isExtinct) {
        super(className, orderName, familyName, genusName, speciesName, name, isExtinct);
    }
}
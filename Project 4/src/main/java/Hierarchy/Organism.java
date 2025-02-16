// Andrii Malakhovtsev
// Plants Hierarchy

package Hierarchy;

public abstract class Organism {
    protected String className, orderName, familyName, genusName, speciesName, name;
    protected boolean isExtinct;

    public Organism(String className, String orderName, String familyName,
                    String genusName, String speciesName, String name, boolean isExtinct) {
        this.className = className;
        this.orderName = orderName;
        this.familyName = familyName;
        this.genusName = genusName;
        this.speciesName = speciesName;
        this.name = name;
        this.isExtinct = isExtinct;
    }

    public String toString() {
        return "Hierarchy.Organism: " + name + " (" + speciesName + ")";
    }

    public String getName() { return name; }
    public String getSpecies() { return speciesName; }
}
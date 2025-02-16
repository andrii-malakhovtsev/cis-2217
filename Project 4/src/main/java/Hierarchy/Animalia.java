// Andrii Malakhovtsev
// Plants Hierarchy

package Hierarchy;

public class Animalia extends Kingdom {
    protected String phylum;

    public Animalia(String phylum, String className, String orderName,
                    String familyName, String genusName, String speciesName, String name, boolean isExtinct) {
        super(className, orderName, familyName, genusName, speciesName, name, isExtinct);
        this.phylum = phylum;
    }
}
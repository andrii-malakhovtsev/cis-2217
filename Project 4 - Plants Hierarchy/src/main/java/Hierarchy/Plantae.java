package Hierarchy;

public class Plantae extends Kingdom {
    protected String division;

    public Plantae(String division, String className, String orderName,
                   String familyName, String genusName, String speciesName,
                   String name, boolean isExtinct) {
        super(className, orderName, familyName, genusName, speciesName, name, isExtinct);
        this.division = division;
    }
}
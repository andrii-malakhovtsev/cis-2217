// Andrii Malakhovtsev
// Plants Hierarchy

package Organisms;

import Hierarchy.Animalia;

class Ant extends Animalia {
    private String caste;

    public Ant(String className, String orderName, String familyName,
               String genusName, String speciesName, String name,
               boolean isExtinct, String caste) {
        super("Arthropoda", className, orderName, familyName,
                genusName, speciesName, name, isExtinct);
        this.caste = caste;
    }

    public String getCaste() { return caste; }
}

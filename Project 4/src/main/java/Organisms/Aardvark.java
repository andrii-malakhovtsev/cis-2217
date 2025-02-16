// Andrii Malakhovtsev
// Plants Hierarchy

package Organisms;

import Hierarchy.Animalia;

class Aardvark extends Animalia implements AntConsumer {
    private String habitat;
    private double foodQuantity;

    public Aardvark(String className, String orderName, String familyName,
                    String genusName, String speciesName, String name,
                    boolean isExtinct, String habitat, double foodQuantity) {
        super("Chordata", className, orderName, familyName, genusName,
                speciesName, name, isExtinct);
        this.habitat = habitat;
        this.foodQuantity = foodQuantity;
    }

    public String getHabitat() { return habitat; }

    public void consumeAnt() {
        System.out.println(name + " eats some ants.");
    }
}

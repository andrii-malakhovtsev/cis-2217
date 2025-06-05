package Organisms;

import Hierarchy.Plantae;

class VenusFlyTrap extends Plantae implements AntConsumer {
    private double trapSize;

    public VenusFlyTrap(String className, String orderName, String familyName, String genusName,
                        String speciesName, String name, boolean isExtinct, double trapSize) {
        super("Magnoliophyta", className, orderName, familyName, genusName, speciesName, name, isExtinct);
        this.trapSize = trapSize;
    }

    public void consumeAnt() {
        System.out.println(name + " consumes an ant with its traps if gets lucky.");
    }
}
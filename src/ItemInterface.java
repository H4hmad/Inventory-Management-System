public interface ItemInterface {
    /**
     * @return the Items name
     */
    String getName();

    /**
     * @return the Items description
     */
    String getDescription();

    /**
     * Find the weight of an Item. This may include all items that make up this Item.
     * @return the Items weight
     */
    double getWeight();

    /**
     * @return the Items definition
     */
    ItemDefinition getDefinition();

    /**
     * Returns a String that appears on the Product Page to describe the
     * composition of the Item. Each sub-item/component is separated by a
     * '\n' character.
     * @return
     */
    String getCompositionDescription();
}

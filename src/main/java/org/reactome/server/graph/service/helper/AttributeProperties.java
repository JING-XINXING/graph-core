package org.reactome.server.graph.service.helper;

import org.reactome.server.graph.domain.model.DatabaseObject;

import javax.annotation.Nonnull;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Florian Korninger (florian.korninger@ebi.ac.uk)
 * @author Antonio Fabregat (fabregat@ebi.ac.uk)
 */
@SuppressWarnings("unused")
public class AttributeProperties implements Comparable<AttributeProperties> {

    private String name;
    private String cardinality;
    private List<AttributeClass> attributeClasses = new LinkedList<>();
    private Class<? extends DatabaseObject> origin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardinality() {
        return cardinality;
    }

    public void setCardinality(String cardinality) {
        this.cardinality = cardinality;
    }

    public List<AttributeClass> getAttributeClasses() {
        return attributeClasses;
    }

    public void addAttributeClass(Class valueType) {
        this.attributeClasses.add(new AttributeClass(valueType));
    }

    public Class<? extends DatabaseObject> getOrigin() {
        return origin;
    }

    public void setOrigin(Class<? extends DatabaseObject> origin) {
        this.origin = origin;
    }

    @Override
    public int compareTo(@Nonnull AttributeProperties o) {
        return this.name.compareTo(o.name);
    }
}

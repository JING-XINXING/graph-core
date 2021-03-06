package org.reactome.server.graph.domain.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.reactome.server.graph.domain.annotations.ReactomeAllowedClasses;
import org.reactome.server.graph.domain.annotations.ReactomeProperty;

@SuppressWarnings("unused")
@NodeEntity
public class CrosslinkedResidue extends TranslationalModification {

    @ReactomeProperty
    private Integer secondCoordinate;

    @Relationship(type = "modification")
    @ReactomeAllowedClasses(allowed = {EntitySet.class, Polymer.class, ReferenceGroup.class})
    private DatabaseObject modification;

    public CrosslinkedResidue() {}

    public Integer getSecondCoordinate() {
        return secondCoordinate;
    }

    public void setSecondCoordinate(Integer secondCoordinate) {
        this.secondCoordinate = secondCoordinate;
    }

    @ReactomeAllowedClasses(allowed = {EntitySet.class, Polymer.class, ReferenceGroup.class})
    public DatabaseObject getModification() {
        return modification;
    }

    @Relationship(type = "modification")
    public void setModification(DatabaseObject modification) {
        if(modification == null) return;


        if (modification instanceof Polymer || modification instanceof ReferenceGroup || modification instanceof EntitySet) {
            this.modification = modification;
        } else {
            throw new RuntimeException(modification + " is not a Polymer, ReferenceGroup or EntitySet");
        }
    }
}

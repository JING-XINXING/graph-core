package org.reactome.server.graph.domain.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.reactome.server.graph.domain.annotations.ReactomeProperty;

import java.util.List;

@SuppressWarnings("unused")
@NodeEntity
public class Taxon extends DatabaseObject {

    @ReactomeProperty
    private List<String> name;
    @ReactomeProperty(addedField = true)
    private String taxId;

    @Deprecated
    @Relationship(type = "crossReference")
    private List<DatabaseIdentifier> crossReference;

    @Relationship(type = "superTaxon")
    private Taxon superTaxon;
    
    public Taxon() {}

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    @Deprecated
    public List<DatabaseIdentifier> getCrossReference() {
        return crossReference;
    }

    @Deprecated
    @Relationship(type = "crossReference")
    public void setCrossReference(List<DatabaseIdentifier> crossReference) {
        this.crossReference = crossReference;
    }

    public Taxon getSuperTaxon() {
        return superTaxon;
    }

    @Relationship(type = "superTaxon")
    public void setSuperTaxon(Taxon superTaxon) {
        this.superTaxon = superTaxon;
    }
}

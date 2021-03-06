package org.reactome.server.graph.domain.model;

import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author Florian Korninger (florian.korninger@ebi.ac.uk)
 * @author Antonio Fabregat (fabregat@ebi.ac.uk)
 */
@SuppressWarnings("unused")
@NodeEntity
public class TopLevelPathway extends Pathway{

    public TopLevelPathway() {}

//    The idea behind having this method was to avoid having this kind of object in the final schema
//    but at the end we figure out that is useful to have it, that is why this is commented out
//    @ReactomeSchemaIgnore
//    @Override
//    public String getSchemaClass() {
//        return Pathway.class.getSimpleName();
//    }
}
package org.reactome.server.graph.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.NodeEntity;
import org.reactome.server.graph.domain.annotations.ReactomeSchemaIgnore;

/**
 * This describes an Event/CatalystActivity that is positively regulated by the Regulator (e.g., allosteric activation).
 */
@SuppressWarnings("unused")
@NodeEntity
public class PositiveRegulation extends Regulation {

    public PositiveRegulation() {}

    @ReactomeSchemaIgnore
    @Override
    @JsonIgnore
    public String getExplanation() {
        return  "This describes an Event/CatalystActivity that is positively regulated by the Regulator (e.g., allosteric activation)";
    }
}

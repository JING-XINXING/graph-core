package org.reactome.server.graph.repository;

import org.reactome.server.graph.domain.model.DatabaseObject;
import org.reactome.server.graph.domain.model.ReferenceEntity;
import org.reactome.server.graph.domain.result.ComponentOf;
import org.reactome.server.graph.domain.result.SchemaClassCount;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * Created by:
 *
 * @author Florian Korninger (florian.korninger@ebi.ac.uk)
 * @since 19.04.16.
 */
@Repository
public interface GeneralRepository extends GraphRepository<DatabaseObject> {

    @Query("MATCH (n) RETURN DISTINCT LABELS(n) AS labels, Count(n) AS count")
    Collection<SchemaClassCount> getSchemaClassCounts();

    @Query("Match (n:SimpleEntity)-[:referenceEntity]-(m:ReferenceEntity) RETURN Distinct(m)")
    Collection<ReferenceEntity> getAllChemicals();

    @Query("Match (n:DatabaseObject{stId:{0}})<-[r:hasEvent|input|output|hasComponent|hasMember|hasCandidate|repeatedUnit]-(m) Return DISTINCT(type(r)) AS type, Collect(m.displayName) AS names, Collect(m.stId) AS stIds")
    Collection<ComponentOf> getComponentsOf(String stId);

    @Query("Match (n:DatabaseObject{dbId:{0}})<-[r:hasEvent|input|output|hasComponent|hasMember|hasCandidate|repeatedUnit]-(m) Return DISTINCT(type(r)) AS type, Collect(m.displayName) AS names, Collect(m.stId) AS stIds")
    Collection<ComponentOf> getComponentsOf(Long dbId);

    @Query("Match (n:DBInfo) RETURN n.version LIMIT 1")
    Integer getDBVersion();

    @Query("Match (n:DBInfo) RETURN n.name LIMIT 1")
    String getDBName();
}

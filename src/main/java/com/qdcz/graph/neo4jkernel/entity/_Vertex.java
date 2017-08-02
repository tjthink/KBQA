package com.qdcz.graph.neo4jkernel.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.json.JSONObject;

/**
 * Created by hadoop on 17-6-22.
 */
@Data
@NodeEntity(label="law")
public class _Vertex {

    public void setId(Long id) {
        this.id = id;
    }

    @GraphId
    private Long id;

    public String type;

    public String getName() {
        return name;
    }

    @Property(name="name")
    public String name;
    public String identity;


    public String getRoot() {
        return root;
    }

    @Property
    public String content;
    @Property
    public String root;

    public _Vertex(){

    }
    @JsonCreator
    public _Vertex(@JsonProperty("type") String type,
                   @JsonProperty("name") String name,
                   @JsonProperty("identity") String identity) {
        this.type = type;
        this.name = name;
        this.identity = identity;
        this.root = null;
    }
    @JsonCreator
    public _Vertex(@JsonProperty("type") String type,
                   @JsonProperty("name") String name,
                   @JsonProperty("identity") String identity,
                   @JsonProperty("root") String root) {
        this.type = type;
        this.name = name;
        this.identity = identity;
        this.root =root;
        this.content = "";
    }
    @JsonCreator
    public _Vertex(@JsonProperty("type") String type,
                   @JsonProperty("name") String name,
                   @JsonProperty("identity") String identity,
                   @JsonProperty("root") String root,
                   @JsonProperty("content") JSONObject content) {
        this.type = type;
        this.name = name;
        this.identity = identity;
        this.root =root;
        this.content = content.toString();
    }

    @Override
    public String toString() {
        return String.format("%s/%s/%s", type, name, identity);
    }

    public Long getId() {
        return id;
    }


}

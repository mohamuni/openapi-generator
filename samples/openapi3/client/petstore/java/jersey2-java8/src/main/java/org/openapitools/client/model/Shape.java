/*
 * OpenAPI Petstore
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package org.openapitools.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.openapitools.client.model.Quadrilateral;
import org.openapitools.client.model.Triangle;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
<<<<<<< HEAD
import org.openapitools.client.JSON;
=======
>>>>>>> 7c45925d064b0e9992944cb292a53c0a88824a91

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;


@JsonDeserialize(using=Shape.ShapeDeserializer.class)
public class Shape extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(Shape.class.getName());

<<<<<<< HEAD
    private static Map<String, Class> classByDiscriminatorValue = new HashMap<String, Class>();

=======
>>>>>>> 7c45925d064b0e9992944cb292a53c0a88824a91
    public static class ShapeDeserializer extends StdDeserializer<Shape> {
        public ShapeDeserializer() {
            this(Shape.class);
        }

        public ShapeDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Shape deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            int match = 0;
            Object deserialized = null;
<<<<<<< HEAD
            Class cls = JSON.getClassForElement(tree, Shape.class);
            if (cls != null) {
                // When the OAS schema includes a discriminator, use the discriminator value to
                // discriminate the oneOf schemas.
                // Get the discriminator mapping value to get the class.
                log.info("Deserializing payload using discriminator " + cls.getName());
                deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
                Shape ret = new Shape();
                ret.setActualInstance(deserialized);
                log.info("Deserialized payload using discriminator " + cls.getName());
                return ret;
            }
            log.info("No discriminator value was found");
            // deserialize Quadrilateral
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(Quadrilateral.class);
                // TODO: there is no validation against JSON schema constraints
                // (min, max, enum, pattern...), this does not perform a strict JSON
                // validation, which means the 'match' count may be higher than it should be.
=======
            // deserialize Quadrilateral
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(Quadrilateral.class);
>>>>>>> 7c45925d064b0e9992944cb292a53c0a88824a91
                match++;
                log.log(Level.FINER, "Input data matches schema 'Quadrilateral'");
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'Quadrilateral'", e);
            }

            // deserialize Triangle
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(Triangle.class);
<<<<<<< HEAD
                // TODO: there is no validation against JSON schema constraints
                // (min, max, enum, pattern...), this does not perform a strict JSON
                // validation, which means the 'match' count may be higher than it should be.
=======
>>>>>>> 7c45925d064b0e9992944cb292a53c0a88824a91
                match++;
                log.log(Level.FINER, "Input data matches schema 'Triangle'");
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'Triangle'", e);
            }

            if (match == 1) {
                Shape ret = new Shape();
                ret.setActualInstance(deserialized);
                return ret;
            }
            throw new IOException(String.format("Failed deserialization for Shape: %d classes match result, expected 1", match));
        }
    }

    // store a list of schema names defined in oneOf
    public final static Map<String, GenericType> schemas = new HashMap<String, GenericType>();

    public Shape() {
        super("oneOf", Boolean.FALSE);
    }

    public Shape(Quadrilateral o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Shape(Triangle o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("Quadrilateral", new GenericType<Quadrilateral>() {
        });
        schemas.put("Triangle", new GenericType<Triangle>() {
        });
<<<<<<< HEAD
        // Initialize discriminator mappings.
        classByDiscriminatorValue.put("Quadrilateral", Quadrilateral.class);
        classByDiscriminatorValue.put("Triangle", Triangle.class);
        classByDiscriminatorValue.put("Shape", Shape.class);
=======
>>>>>>> 7c45925d064b0e9992944cb292a53c0a88824a91
    }

    @Override
    public Map<String, GenericType> getSchemas() {
        return Shape.schemas;
    }

    @Override
    public void setActualInstance(Object instance) {
        if (instance instanceof Quadrilateral) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof Triangle) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be Quadrilateral, Triangle");
    }



}


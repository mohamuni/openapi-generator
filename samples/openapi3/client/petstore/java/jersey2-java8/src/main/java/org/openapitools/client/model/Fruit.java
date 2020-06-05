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
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.openapitools.client.model.Apple;
import org.openapitools.client.model.Banana;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.openapitools.client.JSON;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;


@JsonDeserialize(using=Fruit.FruitDeserializer.class)
public class Fruit extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(Fruit.class.getName());

    public static class FruitDeserializer extends StdDeserializer<Fruit> {
        public FruitDeserializer() {
            this(Fruit.class);
        }

        public FruitDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Fruit deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            int match = 0;
            Object deserialized = null;
            // deserialize Apple
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(Apple.class);
                // TODO: there is no validation against JSON schema constraints
                // (min, max, enum, pattern...), this does not perform a strict JSON
                // validation, which means the 'match' count may be higher than it should be.
                match++;
                log.log(Level.FINER, "Input data matches schema 'Apple'");
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'Apple'", e);
            }

            // deserialize Banana
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(Banana.class);
                // TODO: there is no validation against JSON schema constraints
                // (min, max, enum, pattern...), this does not perform a strict JSON
                // validation, which means the 'match' count may be higher than it should be.
                match++;
                log.log(Level.FINER, "Input data matches schema 'Banana'");
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'Banana'", e);
            }

            if (match == 1) {
                Fruit ret = new Fruit();
                ret.setActualInstance(deserialized);
                return ret;
            }
            throw new IOException(String.format("Failed deserialization for Fruit: %d classes match result, expected 1", match));
        }

        /**
         * Handle deserialization of the 'null' value.
         */
        @Override
        public Fruit getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException(ctxt.getParser(), "Fruit cannot be null");
        }
    }

    // store a list of schema names defined in oneOf
    public final static Map<String, GenericType> schemas = new HashMap<String, GenericType>();

    public Fruit() {
        super("oneOf", Boolean.FALSE);
    }

    public Fruit(Apple o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Fruit(Banana o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("Apple", new GenericType<Apple>() {
        });
        schemas.put("Banana", new GenericType<Banana>() {
        });
        JSON.registerDescendants(Fruit.class, Collections.unmodifiableMap(schemas));
    }

    @Override
    public Map<String, GenericType> getSchemas() {
        return Fruit.schemas;
    }

    /**
     * Set the instance that matches the oneOf child schema, check
     * the instance parameter is valid against the oneOf child schemas.
     *
     * It could be an instance of the 'oneOf' schemas.
     * The oneOf child schemas may themselves be a composed schema (allOf, anyOf, oneOf).
     */
    @Override
    public void setActualInstance(Object instance) {
        if (JSON.isInstanceOf(Apple.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        if (JSON.isInstanceOf(Banana.class, instance, new HashSet<Class<?>>())) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be Apple, Banana");
    }



}


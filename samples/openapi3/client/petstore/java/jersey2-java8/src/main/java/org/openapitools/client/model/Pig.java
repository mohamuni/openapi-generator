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
import org.openapitools.client.model.BasquePig;
import org.openapitools.client.model.DanishPig;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.openapitools.client.JSON;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;


@JsonDeserialize(using=Pig.PigDeserializer.class)
public class Pig extends AbstractOpenApiSchema {
    private static final Logger log = Logger.getLogger(Pig.class.getName());

    public static class PigDeserializer extends StdDeserializer<Pig> {
        public PigDeserializer() {
            this(Pig.class);
        }

        public PigDeserializer(Class<?> vc) {
            super(vc);
        }

        @Override
        public Pig deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
            JsonNode tree = jp.readValueAsTree();

            int match = 0;
            Object deserialized = null;
            Class cls = JSON.getClassForElement(tree, Pig.class);
            if (cls != null) {
                // When the OAS schema includes a discriminator, use the discriminator value to
                // discriminate the oneOf schemas.
                // Get the discriminator mapping value to get the class.
                log.info("Deserializing payload using discriminator " + cls.getName());
                deserialized = tree.traverse(jp.getCodec()).readValueAs(cls);
                Pig ret = new Pig();
                ret.setActualInstance(deserialized);
                log.info("Deserialized payload using discriminator " + cls.getName());
                return ret;
            }
            log.info("No discriminator value was found");
            // deserialize BasquePig
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(BasquePig.class);
                // TODO: there is no validation against JSON schema constraints
                // (min, max, enum, pattern...), this does not perform a strict JSON
                // validation, which means the 'match' count may be higher than it should be.
                match++;
                log.log(Level.FINER, "Input data matches schema 'BasquePig'");
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'BasquePig'", e);
            }

            // deserialize DanishPig
            try {
                deserialized = tree.traverse(jp.getCodec()).readValueAs(DanishPig.class);
                // TODO: there is no validation against JSON schema constraints
                // (min, max, enum, pattern...), this does not perform a strict JSON
                // validation, which means the 'match' count may be higher than it should be.
                match++;
                log.log(Level.FINER, "Input data matches schema 'DanishPig'");
            } catch (Exception e) {
                // deserialization failed, continue
                log.log(Level.FINER, "Input data does not match schema 'DanishPig'", e);
            }

            if (match == 1) {
                Pig ret = new Pig();
                ret.setActualInstance(deserialized);
                return ret;
            }
            throw new IOException(String.format("Failed deserialization for Pig: %d classes match result, expected 1", match));
        }

        @Override
        public Pig getNullValue(DeserializationContext ctxt) throws JsonMappingException {
            throw new JsonMappingException("Pig cannot be null");
        }
    }

    // store a list of schema names defined in oneOf
    public final static Map<String, GenericType> schemas = new HashMap<String, GenericType>();

    public Pig() {
        super("oneOf", Boolean.FALSE);
    }

    public Pig(BasquePig o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    public Pig(DanishPig o) {
        super("oneOf", Boolean.FALSE);
        setActualInstance(o);
    }

    static {
        schemas.put("BasquePig", new GenericType<BasquePig>() {
        });
        schemas.put("DanishPig", new GenericType<DanishPig>() {
        });
    }

    @Override
    public Map<String, GenericType> getSchemas() {
        return Pig.schemas;
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
        if (instance instanceof BasquePig) {
            super.setActualInstance(instance);
            return;
        }

        if (instance instanceof DanishPig) {
            super.setActualInstance(instance);
            return;
        }

        throw new RuntimeException("Invalid instance type. Must be BasquePig, DanishPig");
    }



}


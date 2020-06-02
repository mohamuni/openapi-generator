package org.openapitools.client;

import org.openapitools.client.model.*;
import java.lang.Exception;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.junit.*;
import static org.junit.Assert.*;


public class JSONComposedSchemaTest {
    JSON json = null;

    @Before
    public void setup() {
        json = new JSON();
    }

    /**
     * Validate a oneOf schema can be deserialized into the expected class.
     * The oneOf schema does not have a discriminator. 
     */
    @Test
    public void testOneOfSchemaWithoutDiscriminator() throws Exception {
        // BananaReq and AppleReq have explicitly defined properties that are different by name.
        // There is no discriminator property.
        {
            String str = "{ \"cultivar\": \"golden delicious\", \"mealy\": false }";
            FruitReq o = json.getContext(null).readValue(str, FruitReq.class);
            assertTrue(o.getActualInstance() instanceof AppleReq);
            AppleReq inst = (AppleReq) o.getActualInstance();
            assertEquals(inst.getCultivar(), "golden delicious");
            assertEquals(inst.getMealy(), false);
        }
        {
            // Same test, but this time with additional (undeclared) properties.
            // Since FruitReq has additionalProperties: false, deserialization should fail.
            String str = "{ \"cultivar\": \"golden delicious\", \"mealy\": false, \"garbage_prop\": \"abc\" }";
            Exception exception = assertThrows(JsonMappingException.class, () -> {
                FruitReq o = json.getContext(null).readValue(str, FruitReq.class);
            });
            assertTrue(exception.getMessage().contains("Failed deserialization for FruitReq: 0 classes match result"));
        }
        {
            String str = "{ \"lengthCm\": 17 }";
            FruitReq o = json.getContext(null).readValue(str, FruitReq.class);
            assertTrue(o.getActualInstance() instanceof BananaReq);
            BananaReq inst = (BananaReq) o.getActualInstance();
            assertEquals(inst.getLengthCm(), new java.math.BigDecimal(17));
        }
        {
            // Try to deserialize empty object. This should fail 'oneOf' because that will match
            // both AppleReq and BananaReq.
            String str = "{ }";
            Exception exception = assertThrows(JsonMappingException.class, () -> {
                json.getContext(null).readValue(str, FruitReq.class);
            });
            assertTrue(exception.getMessage().contains("Failed deserialization for FruitReq: 2 classes match result"));
            // TODO: add a similar unit test where the oneOf child schemas have required properties.
            // If the implementation is correct, the unmarshaling should take the "required" keyword
            // into consideration, which it is not doing currently.
        }
        {
            // Deserialize the null value. This should be allowed because the 'FruitReq' schema
            // has nullable: true.
            String str = "null";
            FruitReq o = json.getContext(null).readValue(str, FruitReq.class);
            assertNull(o);
        }        
    }

    /**
     * Validate a oneOf schema can be deserialized into the expected class.
     * The oneOf schema has a discriminator. 
     */
    @Test
    public void testOneOfSchemaWithDiscriminator() throws Exception {
        // Mammal can be one of whale, pig and zebra.
        // pig has sub-classes.
        {
            String str = "{ \"className\": \"whale\", \"hasBaleen\": true, \"hasTeeth\": false }";
            
            // Note that the 'zebra' schema does not have any explicit property defined AND
            // it has additionalProperties: true. Hence without a discriminator the above
            // JSON payload would match both 'whale' and 'zebra'. This is because the 'hasBaleen'
            // and 'hasTeeth' would be considered additional (undeclared) properties for 'zebra'.
            AbstractOpenApiSchema o = json.getContext(null).readValue(str, Mammal.class);
            assertNotNull(o);
            assertTrue(o.getActualInstance() instanceof Whale);
        }
        {
            String str = "{ \"className\": \"zebra\", \"type\": \"plains\" }";
            AbstractOpenApiSchema o = json.getContext(null).readValue(str, Mammal.class);
            assertNotNull(o);
            assertTrue(o.getActualInstance() instanceof Zebra);
            Zebra z = (Zebra)o.getActualInstance();
            // TODO: this is incorrect: assert the value is Zebra.TypeEnum.PLAINS
            assertNull(z.getType());
            //assertEquals(Zebra.TypeEnum.PLAINS, z.getType());
        }
        {
            // The discriminator value is valid but the 'type' value is invalid.
            // TODO: the current deserialization code is incorrectly accepting the input data.
            // The unit test code below should be rewritten to assert an exception.
            String str = "{ \"className\": \"zebra\", \"type\": \"garbage_value\" }";
            AbstractOpenApiSchema o = json.getContext(null).readValue(str, Mammal.class);
            assertNotNull(o);
            assertTrue(o.getActualInstance() instanceof Zebra);
            Zebra z = (Zebra)o.getActualInstance();
            assertNull(z.getType());
            //Exception exception = assertThrows(JsonMappingException.class, () -> {
            //json.getContext(null).readValue(str, Mammal.class);
            //});
        }
        {
            // The discriminator value is zebra but the properties belong to Whale.
            // The 'whale' properties are considered to be additional (undeclared) properties
            // because in the 'zebra' schema, the 'additionalProperties' keyword has been set
            // to true.
            // TODO: The outcome should depend on the value of the 'useOneOfDiscriminatorLookup' CLI.
            String str = "{ \"className\": \"zebra\", \"hasBaleen\": true, \"hasTeeth\": false }";
            AbstractOpenApiSchema o = json.getContext(null).readValue(str, Mammal.class);
            assertNotNull(o);
            assertTrue(o.getActualInstance() instanceof Zebra);
        }
        {
            String str = "{ \"className\": \"zebra\" }";
            AbstractOpenApiSchema o = json.getContext(null).readValue(str, Mammal.class);
            assertNotNull(o);
            assertTrue(o.getActualInstance() instanceof Zebra);
        }
        {
            // Deserialization test with indirections of 'oneOf' child schemas.
            // Mammal is oneOf whale, zebra and pig, and pig is itself one of BasquePig, DanishPig.
            String str = "{ \"className\": \"BasquePig\" }";
            AbstractOpenApiSchema o = json.getContext(null).readValue(str, Mammal.class);
            assertTrue(o.getActualInstance() instanceof BasquePig);
        }
    }

    @Test
    public void testOneOfNullable() throws Exception {
        String str = "null";
        // 'null' is a valid value for NullableShape because it is nullable.
        AbstractOpenApiSchema o = json.getContext(null).readValue(str, NullableShape.class);
        assertNull(o);

        // 'null' is a valid value for ShapeOrNull because it is a oneOf with one of the
        // children being the null type.
        o = json.getContext(null).readValue(str, ShapeOrNull.class);
        assertNull(o);

        // 'null' is not a valid value for the Shape model because it is not nullable.
        // An exception should be raised.
        Exception exception = assertThrows(JsonMappingException.class, () -> {
            json.getContext(null).readValue(str, Shape.class);
        });
        assertEquals("Shape cannot be null", exception.getMessage());
    }

    /**
     * Test payload with more than one discriminator.
     */
    @Test
    public void testOneOfMultipleDiscriminators() throws Exception {
        // 'shapeType' is a discriminator for the 'Shape' model and
        // 'triangleType' is a discriminator forr the 'Triangle' model.
        String str = "{ \"shapeType\": \"Triangle\", \"triangleType\": \"EquilateralTriangle\" }";

        // We should be able to deserialize a equilateral triangle into a EquilateralTriangle class.
        EquilateralTriangle t = json.getContext(null).readValue(str, EquilateralTriangle.class);
        assertNotNull(t);

        // We should be able to deserialize a equilateral triangle into a triangle.
        AbstractOpenApiSchema o = json.getContext(null).readValue(str, Triangle.class);
        assertNotNull(o);
        assertTrue(o.getActualInstance() instanceof EquilateralTriangle);

        // We should be able to deserialize a equilateral triangle into a shape.
        o = json.getContext(null).readValue(str, Shape.class);
        // The container is a shape, and the actual instance should be a EquilateralTriangle.        
        assertTrue(o instanceof Shape);
        assertTrue(o.getActualInstance() instanceof EquilateralTriangle);

        // It is not valid to deserialize a equilateral triangle into a quadrilateral.
        Exception exception = assertThrows(JsonMappingException.class, () -> {
            json.getContext(null).readValue(str, Quadrilateral.class);
        });
        assertTrue(exception.getMessage().contains("Failed deserialization for Quadrilateral: 0 classes match result"));
    }

    @Test
    public void testOneOfNestedComposedSchema() throws Exception {
        /*
        {
            String str = "{ " +
                " \"mainShape\":      { \"shapeType\": \"Triangle\", \"triangleType\": \"EquilateralTriangle\" }, " +
                " \"shapeOrNull\":    { \"shapeType\": \"Triangle\", \"triangleType\": \"IsoscelesTriangle\" }, " +
                " \"nullableShape\":  { \"shapeType\": \"Triangle\", \"triangleType\": \"ScaleneTriangle\" } " +
            "}";
            Drawing d = json.getContext(null).readValue(str, Drawing.class);
            assertNotNull(d);
            assertNotNull(d.getMainShape());
            assertNotNull(d.getShapeOrNull());
            assertNotNull(d.getNullableShape());
            assertTrue(d.getMainShape().getActualInstance() instanceof EquilateralTriangle);
            assertTrue(d.getShapeOrNull().getActualInstance() instanceof IsoscelesTriangle);
            assertTrue(d.getNullableShape().getActualInstance() instanceof ScaleneTriangle);
        }

        {
            String str = "{ " +
                " \"mainShape\":      { \"shapeType\": \"Triangle\", \"triangleType\": \"EquilateralTriangle\" }, " +
                " \"shapeOrNull\":    null, " +
                " \"nullableShape\":  null " +
            "}";
            Drawing d = json.getContext(null).readValue(str, Drawing.class);
            assertNotNull(d);
            assertNotNull(d.getMainShape());
            assertNull(d.getShapeOrNull());
            assertNull(d.getNullableShape());
            assertTrue(d.getMainShape().getActualInstance() instanceof EquilateralTriangle);
        }
        */
    }

    /**
     * Validate a allOf schema can be deserialized into the expected class.
     */
    @Test
    public void testAllOfSchema() throws Exception {
        String str = null;
        {
            str = "{ \"className\": \"Dog\", \"color\": \"white\",  \"breed\": \"Siberian Husky\" }";

            // We should be able to deserialize a dog into a Dog.
            Dog d = json.getContext(null).readValue(str, Dog.class);            
            assertNotNull(d);
            assertEquals("white", d.getColor());
        }
    }
}

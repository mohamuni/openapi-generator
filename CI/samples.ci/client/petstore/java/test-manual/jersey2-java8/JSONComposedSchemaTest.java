package org.openapitools.client;

import org.openapitools.client.model.*;
import java.lang.Exception;

import org.junit.*;
import static org.junit.Assert.*;


public class JSONComposedSchemaTest {
    JSON json = null;
    Mammal mammal = null;

    @Before
    public void setup() {
        json = new JSON();
        mammal = new Mammal();
    }

    /**
     * Validate a oneOf schema can be deserialized into the expected class.
     * The oneOf schema does not have a discriminator. 
     */
    @Test
    public void testOneOfSchemaWithoutDiscriminator() throws Exception {
        // BananaReq and AppleReq have explicitly defined properties that are different by name.
        // There is no discriminator property.
        String str = "{ \"cultivar\": \"golden delicious\", \"mealy\": false }";
        FruitReq o = json.getContext(null).readValue(str, FruitReq.class);
        assertTrue(o.getActualInstance() instanceof AppleReq);
    }

    /**
     * Validate a oneOf schema can be deserialized into the expected class.
     * The oneOf schema has a discriminator. 
     */
    @Test
    public void testOneOfSchemaWithDiscriminator() throws Exception {
        String str = null;
        AbstractOpenApiSchema o = null;
        {
            // Mammal can be one of whale, pig and zebra.
            // pig has sub-classes.
            str = "{ \"className\": \"whale\", \"hasBaleen\": true, \"hasTeeth\": false }";
            
            // Note that the 'zebra' schema does not have any explicit property defined AND
            // it has additionalProperties: true. Hence without a discriminator the above
            // JSON payload would match both 'whale' and 'zebra'. This is because the 'hasBaleen'
            // and 'hasTeeth' would be considered additional (undeclared) properties for 'zebra'.
            o = json.getContext(null).readValue(str, Mammal.class);
            assertTrue(o.getActualInstance() instanceof Whale);

            str = "{ \"className\": \"zebra\" }";
            o = json.getContext(null).readValue(str, Mammal.class);
            assertTrue(o.getActualInstance() instanceof Zebra);

            // Deserialization test with indirections of 'oneOf' child schemas.
            // Mammal is oneOf whale, zebra and pig, and pig is itself one of BasquePig, DanishPig.
            // TODO: the current jersey2 implementation does not work when there is more than one level
            // of 'oneOf' children. Disabling for now.
            /*
            str = "{ \"className\": \"BasquePig\" }";
            o = json.getContext(null).readValue(str, Mammal.class);
            assertTrue(o.getActualInstance() instanceof BasquePig);
            */
        }
        
        {
            str = "null";
            // 'null' is a valid value for NullableShape because it is nullable.
            o = json.getContext(null).readValue(str, NullableShape.class);
            assertEquals(o.getActualInstance(), null);

            // 'null' is a valid value for ShapeOrNull because it is a oneOf with one of the
            // children being the null type.
            o = json.getContext(null).readValue(str, ShapeOrNull.class);
            assertEquals(o.getActualInstance(), null);

            // 'null' is not a valid value for the Shape model because it is not nullable.
            // An exception should be raised.
            Exception exception = assertThrows(NumberFormatException.class, () -> {
                o = json.getContext(null).readValue(str, Shape.class);
                assertEquals(o.getActualInstance(), null);
            });
        }
        {
            str = "{ \"shapeType\": \"Triangle\", \"triangleType\": \"EquilateralTriangle\" }";

            // We should be able to deserialize a equilateral triangle into a EquilateralTriangle class.
            EquilateralTriangle t = json.getContext(null).readValue(str, EquilateralTriangle.class);
            assertNotNull(t);

            // We should be able to deserialize a equilateral triangle into a triangle.
            o = json.getContext(null).readValue(str, Triangle.class);
            assertTrue(o.getActualInstance() instanceof EquilateralTriangle);

            // We should be able to deserialize a equilateral triangle into a shape.
            o = json.getContext(null).readValue(str, Shape.class);
            assertTrue(o.getActualInstance() instanceof EquilateralTriangle);

            // It is not valid to deserialize a equilateral triangle into a quadrilateral.
            Exception exception = assertThrows(NumberFormatException.class, () -> {
                o = json.getContext(null).readValue(str, Quadrilateral.class);
                assertEquals(o.getActualInstance(), null);
            });

        }

        {
            str = "{ " +
                " \"mainShape\":      { \"shapeType\": \"Triangle\", \"triangleType\": \"EquilateralTriangle\" }, " +
                " \"shapeOrNull\":    { \"shapeType\": \"Triangle\", \"triangleType\": \"IsoscelesTriangle\" }, " +
                " \"nullableShape\":  { \"shapeType\": \"Triangle\", \"triangleType\": \"ScaleneTriangle\" }, " +
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

    }

    /**
     * Validate a allOf schema can be deserialized into the expected class.
     */
    @Test
    public void testAllSchema() throws Exception {
        String str = null;
        AbstractOpenApiSchema o = null;

        {
            str = "{ \"className\": \"Dog\", \"color\": \"white\",  \"breed\": \"Siberian Husky\" }";

            // We should be able to deserialize a dog into a Dog.
            Dog d = json.getContext(null).readValue(str, Dog.class);            
            assertNotNull(d);
        }
    }
}

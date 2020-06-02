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
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.openapitools.client.model.Fruit;
import org.openapitools.client.model.NullableShape;
import org.openapitools.client.model.Shape;
import org.openapitools.client.model.ShapeOrNull;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.openapitools.jackson.nullable.JsonNullable;
import java.util.NoSuchElementException;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Drawing
 */
@JsonPropertyOrder({
  Drawing.JSON_PROPERTY_MAIN_SHAPE,
  Drawing.JSON_PROPERTY_SHAPE_OR_NULL,
  Drawing.JSON_PROPERTY_NULLABLE_SHAPE,
  Drawing.JSON_PROPERTY_SHAPES
})

public class Drawing {
  public static final String JSON_PROPERTY_MAIN_SHAPE = "mainShape";
  private Shape mainShape = null;

  public static final String JSON_PROPERTY_SHAPE_OR_NULL = "shapeOrNull";
  private ShapeOrNull shapeOrNull = null;

  public static final String JSON_PROPERTY_NULLABLE_SHAPE = "nullableShape";
  private JsonNullable<NullableShape> nullableShape = JsonNullable.<NullableShape>of(null);

  public static final String JSON_PROPERTY_SHAPES = "shapes";
  private List<Shape> shapes = null;


  public Drawing mainShape(Shape mainShape) {
    
    this.mainShape = mainShape;
    return this;
  }

   /**
   * Get mainShape
   * @return mainShape
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_MAIN_SHAPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public Shape getMainShape() {
    return mainShape;
  }


  public void setMainShape(Shape mainShape) {
    this.mainShape = mainShape;
  }


  public Drawing shapeOrNull(ShapeOrNull shapeOrNull) {
    
    this.shapeOrNull = shapeOrNull;
    return this;
  }

   /**
   * Get shapeOrNull
   * @return shapeOrNull
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SHAPE_OR_NULL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public ShapeOrNull getShapeOrNull() {
    return shapeOrNull;
  }


  public void setShapeOrNull(ShapeOrNull shapeOrNull) {
    this.shapeOrNull = shapeOrNull;
  }


  public Drawing nullableShape(NullableShape nullableShape) {
    this.nullableShape = JsonNullable.<NullableShape>of(nullableShape);
    
    return this;
  }

   /**
   * Get nullableShape
   * @return nullableShape
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonIgnore

  public NullableShape getNullableShape() {
        return nullableShape.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NULLABLE_SHAPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public JsonNullable<NullableShape> getNullableShape_JsonNullable() {
    return nullableShape;
  }
  
  @JsonProperty(JSON_PROPERTY_NULLABLE_SHAPE)
  public void setNullableShape_JsonNullable(JsonNullable<NullableShape> nullableShape) {
    this.nullableShape = nullableShape;
  }

  public void setNullableShape(NullableShape nullableShape) {
    this.nullableShape = JsonNullable.<NullableShape>of(nullableShape);
  }


  public Drawing shapes(List<Shape> shapes) {
    
    this.shapes = shapes;
    return this;
  }

  public Drawing addShapesItem(Shape shapesItem) {
    if (this.shapes == null) {
      this.shapes = new ArrayList<>();
    }
    this.shapes.add(shapesItem);
    return this;
  }

   /**
   * Get shapes
   * @return shapes
  **/
  @javax.annotation.Nullable
  @ApiModelProperty(value = "")
  @JsonProperty(JSON_PROPERTY_SHAPES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public List<Shape> getShapes() {
    return shapes;
  }


  public void setShapes(List<Shape> shapes) {
    this.shapes = shapes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Drawing drawing = (Drawing) o;
    return Objects.equals(this.mainShape, drawing.mainShape) &&
        Objects.equals(this.shapeOrNull, drawing.shapeOrNull) &&
        Objects.equals(this.nullableShape, drawing.nullableShape) &&
        Objects.equals(this.shapes, drawing.shapes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mainShape, shapeOrNull, nullableShape, shapes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Drawing {\n");
    sb.append("    mainShape: ").append(toIndentedString(mainShape)).append("\n");
    sb.append("    shapeOrNull: ").append(toIndentedString(shapeOrNull)).append("\n");
    sb.append("    nullableShape: ").append(toIndentedString(nullableShape)).append("\n");
    sb.append("    shapes: ").append(toIndentedString(shapes)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}


package org.openapitools.client;

import org.openapitools.client.model.*;
import java.lang.Exception;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.*;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.annotation.*;
import org.junit.*;
import static org.junit.Assert.*;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.core.type.TypeReference;

public class JacksonTest {
    @Test
    public void testSerialization() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Employee.class, new ModelDeserializer<Employee>());
        mapper.registerModule(module);

        Employee emp1 = new Employee();
        emp1.setFirstName("Adithya");
        emp1.setLastName("Sai");
        emp1.setEmpId(125);

        Wrapper wrapper = new Wrapper<Employee, String>();
        wrapper.additionalProperties.put("technology1", "Machine Learning");
        wrapper.additionalProperties.put("technology2", "Robotics");
        wrapper.modelObject = emp1;
        String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(wrapper);
        System.out.println(jsonStr);
        System.out.println("Deserializing JSON to WRAPPER:");
        Wrapper wrap2 = mapper.readValue(jsonStr, new TypeReference<Wrapper<Employee, String>>() {});
        System.out.println(wrap2 + "\n");
    }
}


//@JsonDeserialize(using=WrapperDeserializer.class)
@JsonPropertyOrder({"modelObject", "additionalProperties" })
class Wrapper<T, S> {
    @JsonUnwrapped
    //@JsonProperty("modelObject")
    protected T modelObject;

    @JsonUnwrapped
    @JsonIgnore
    protected Map<String, S> additionalProperties = new HashMap<String, S>();

    @JsonAnyGetter
    @JsonFilter("nameFilter")
    public Map<String, S> getAdditionalProperties() {
       return additionalProperties;
    }
    @JsonAnySetter
    @JsonFilter("nameFilter")
    public void setAdditionalProperties(final String name, final S value) {
       this.additionalProperties.put(name, value);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Wrappped object: \n   ").append(modelObject).append('\n');
        for (Map.Entry<String, S> entry : additionalProperties.entrySet()) {
            sb.append("ADDITIONAL PROP UNDECLARED: ").append(entry.getKey()).append(": ").append(entry.getValue()).append('\n');
        }
        return sb.toString();       
    }
}


class ModelDeserializer<T> extends StdDeserializer<T> {
    private Class<T> type;

    public ModelDeserializer() {
        this(Object.class);
    }

    public ModelDeserializer(Class<?> vc) {
        super(vc);
    }
    @Override
    public T deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        //JsonNode tree = jp.readValueAsTree();
        System.out.println("IN deserialize: " + type);
        T e = jp.readValueAs(new TypeReference<Employee>() {});
        System.out.println("IN deserialize DONE");
        return e;
    }

    @Override
    protected void handleUnknownProperty(JsonParser p,
                                 DeserializationContext ctxt,
                                 Object instanceOrClass,
                                 String propName) throws IOException {
        System.out.println("Deserializing unknown property " + propName);
        System.out.println("Deserializing unknown property " + instanceOrClass);
        Object deserialized = p.readValueAs(String.class);
        //additionalProperties.put(propName, deserialized);
    }
}


class WrapperDeserializer extends StdDeserializer<Wrapper> {
    public WrapperDeserializer() {
        this(Wrapper.class);
    }

    public WrapperDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Wrapper deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        //JsonNode tree = jp.readValueAsTree();
        // Is IGNORE_UNDEFINED specific to this operation?
        //jp.disable(JsonParser.Feature.IGNORE_UNDEFINED);
        System.out.println("Deserializing node");
        Wrapper w = new Wrapper();

        //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        //Employee e = mapper.readValue(tree.traverse(jp.getCodec()), Employee.class);
        Employee e = jp.readValueAs(Employee.class);
        w.modelObject = e;

        /*
        tree = jp.readValueAsTree();
        //Map<String, String> props = mapper.readValue(tree.traverse(jp.getCodec()), Map.class);
        Map<String, String> props = tree.traverse(jp.getCodec()).readValueAs(Map.class);
        w.additionalProperties = props;
        */
        return w;
        //return tree.traverse(jp.getCodec()).readValueAs(Employee.class);
    }  
}

// Employee class
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"firstName", "lastName", "technologies", "empId" })
class Employee {
   @JsonProperty("EMPLOYEE_ID")
   private int empId;
   @JsonProperty("EMPLOYEE_FIRST_NAME")
   private String firstName;
   @JsonProperty("EMPLOYEE_LAST_NAME")
   private String lastName;

   public int getEmpId() {
      return empId;
   }
   public void setEmpId(int empId) {
      this.empId = empId;
   }
   public String getFirstName() {
      return firstName;
   }
   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }
   public String getLastName() {
      return lastName;
   }
   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String toString() {
       return "ID: " + empId + " last name: " + lastName;
   }
}
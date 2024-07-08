// <auto-generated>
/*
 * OpenAPI Petstore
 *
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */

using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.IO;
using System.Text;
using System.Text.RegularExpressions;
using System.Text.Json;
using System.Text.Json.Serialization;
using System.ComponentModel.DataAnnotations;
using OpenAPIClientUtils = Org.OpenAPITools.Client.ClientUtils;
using Org.OpenAPITools.Client;

namespace Org.OpenAPITools.Model
{
    /// <summary>
    /// LiteralStringClass
    /// </summary>
    public partial class LiteralStringClass : IValidatableObject
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="LiteralStringClass" /> class.
        /// </summary>
        /// <param name="escapedLiteralString">escapedLiteralString (default to &quot;C:\\Users\\username&quot;)</param>
        /// <param name="unescapedLiteralString">unescapedLiteralString (default to &quot;C:\Users\username&quot;)</param>
        [JsonConstructor]
        public LiteralStringClass(Option<string> escapedLiteralString = default, Option<string> unescapedLiteralString = default)
        {
            EscapedLiteralStringOption = escapedLiteralString;
            UnescapedLiteralStringOption = unescapedLiteralString;
            OnCreated();
        }

        partial void OnCreated();

        /// <summary>
        /// Used to track the state of EscapedLiteralString
        /// </summary>
        [JsonIgnore]
        [System.ComponentModel.EditorBrowsable(System.ComponentModel.EditorBrowsableState.Never)]
        public Option<string> EscapedLiteralStringOption { get; private set; }

        /// <summary>
        /// Gets or Sets EscapedLiteralString
        /// </summary>
        [JsonPropertyName("escapedLiteralString")]
        public string EscapedLiteralString { get { return this.EscapedLiteralStringOption; } set { this.EscapedLiteralStringOption = new(value); } }

        /// <summary>
        /// Used to track the state of UnescapedLiteralString
        /// </summary>
        [JsonIgnore]
        [System.ComponentModel.EditorBrowsable(System.ComponentModel.EditorBrowsableState.Never)]
        public Option<string> UnescapedLiteralStringOption { get; private set; }

        /// <summary>
        /// Gets or Sets UnescapedLiteralString
        /// </summary>
        [JsonPropertyName("unescapedLiteralString")]
        public string UnescapedLiteralString { get { return this.UnescapedLiteralStringOption; } set { this.UnescapedLiteralStringOption = new(value); } }

        /// <summary>
        /// Gets or Sets additional properties
        /// </summary>
        [JsonExtensionData]
        public Dictionary<string, JsonElement> AdditionalProperties { get; } = new Dictionary<string, JsonElement>();

        /// <summary>
        /// Returns the string presentation of the object
        /// </summary>
        /// <returns>String presentation of the object</returns>
        public override string ToString()
        {
            StringBuilder sb = new StringBuilder();
            sb.Append("class LiteralStringClass {\n");
            sb.Append("  EscapedLiteralString: ").Append(EscapedLiteralString).Append("\n");
            sb.Append("  UnescapedLiteralString: ").Append(UnescapedLiteralString).Append("\n");
            sb.Append("  AdditionalProperties: ").Append(AdditionalProperties).Append("\n");
            sb.Append("}\n");
            return sb.ToString();
        }

        /// <summary>
        /// To validate all properties of the instance
        /// </summary>
        /// <param name="validationContext">Validation context</param>
        /// <returns>Validation Result</returns>
        IEnumerable<ValidationResult> IValidatableObject.Validate(ValidationContext validationContext)
        {
            yield break;
        }
    }

    /// <summary>
    /// A Json converter for type <see cref="LiteralStringClass" />
    /// </summary>
    public class LiteralStringClassJsonConverter : JsonConverter<LiteralStringClass>
    {
        /// <summary>
        /// Deserializes json to <see cref="LiteralStringClass" />
        /// </summary>
        /// <param name="utf8JsonReader"></param>
        /// <param name="typeToConvert"></param>
        /// <param name="jsonSerializerOptions"></param>
        /// <returns></returns>
        /// <exception cref="JsonException"></exception>
        public override LiteralStringClass Read(ref Utf8JsonReader utf8JsonReader, Type typeToConvert, JsonSerializerOptions jsonSerializerOptions)
        {
            int currentDepth = utf8JsonReader.CurrentDepth;

            if (utf8JsonReader.TokenType != JsonTokenType.StartObject && utf8JsonReader.TokenType != JsonTokenType.StartArray)
                throw new JsonException();

            JsonTokenType startingTokenType = utf8JsonReader.TokenType;

            Option<string> escapedLiteralString = default;
            Option<string> unescapedLiteralString = default;

            while (utf8JsonReader.Read())
            {
                if (startingTokenType == JsonTokenType.StartObject && utf8JsonReader.TokenType == JsonTokenType.EndObject && currentDepth == utf8JsonReader.CurrentDepth)
                    break;

                if (startingTokenType == JsonTokenType.StartArray && utf8JsonReader.TokenType == JsonTokenType.EndArray && currentDepth == utf8JsonReader.CurrentDepth)
                    break;

                if (utf8JsonReader.TokenType == JsonTokenType.PropertyName && currentDepth == utf8JsonReader.CurrentDepth - 1)
                {
                    string localVarJsonPropertyName = utf8JsonReader.GetString();
                    utf8JsonReader.Read();

                    switch (localVarJsonPropertyName)
                    {
                        case "escapedLiteralString":
                            escapedLiteralString = new Option<string>(utf8JsonReader.GetString());
                            break;
                        case "unescapedLiteralString":
                            unescapedLiteralString = new Option<string>(utf8JsonReader.GetString());
                            break;
                        default:
                            break;
                    }
                }
            }

            if (escapedLiteralString.IsSet && escapedLiteralString.Value == null)
                throw new ArgumentNullException(nameof(escapedLiteralString), "Property is not nullable for class LiteralStringClass.");

            if (unescapedLiteralString.IsSet && unescapedLiteralString.Value == null)
                throw new ArgumentNullException(nameof(unescapedLiteralString), "Property is not nullable for class LiteralStringClass.");

            return new LiteralStringClass(escapedLiteralString, unescapedLiteralString);
        }

        /// <summary>
        /// Serializes a <see cref="LiteralStringClass" />
        /// </summary>
        /// <param name="writer"></param>
        /// <param name="literalStringClass"></param>
        /// <param name="jsonSerializerOptions"></param>
        /// <exception cref="NotImplementedException"></exception>
        public override void Write(Utf8JsonWriter writer, LiteralStringClass literalStringClass, JsonSerializerOptions jsonSerializerOptions)
        {
            writer.WriteStartObject();

            WriteProperties(writer, literalStringClass, jsonSerializerOptions);
            writer.WriteEndObject();
        }

        /// <summary>
        /// Serializes the properties of <see cref="LiteralStringClass" />
        /// </summary>
        /// <param name="writer"></param>
        /// <param name="literalStringClass"></param>
        /// <param name="jsonSerializerOptions"></param>
        /// <exception cref="NotImplementedException"></exception>
        public void WriteProperties(Utf8JsonWriter writer, LiteralStringClass literalStringClass, JsonSerializerOptions jsonSerializerOptions)
        {
            if (literalStringClass.EscapedLiteralStringOption.IsSet && literalStringClass.EscapedLiteralString == null)
                throw new ArgumentNullException(nameof(literalStringClass.EscapedLiteralString), "Property is required for class LiteralStringClass.");

            if (literalStringClass.UnescapedLiteralStringOption.IsSet && literalStringClass.UnescapedLiteralString == null)
                throw new ArgumentNullException(nameof(literalStringClass.UnescapedLiteralString), "Property is required for class LiteralStringClass.");

            if (literalStringClass.EscapedLiteralStringOption.IsSet)
                writer.WriteString("escapedLiteralString", literalStringClass.EscapedLiteralString);

            if (literalStringClass.UnescapedLiteralStringOption.IsSet)
                writer.WriteString("unescapedLiteralString", literalStringClass.UnescapedLiteralString);
        }
    }
}

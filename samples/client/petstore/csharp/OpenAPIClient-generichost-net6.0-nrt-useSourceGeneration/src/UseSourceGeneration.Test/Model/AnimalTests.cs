/*
 * OpenAPI Petstore
 *
 * This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\
 *
 * The version of the OpenAPI document: 1.0.0
 * Generated by: https://github.com/openapitools/openapi-generator.git
 */


using Xunit;

using System;
using System.Linq;
using System.IO;
using System.Collections.Generic;
using UseSourceGeneration.Model;
using UseSourceGeneration.Client;
using System.Reflection;

namespace UseSourceGeneration.Test.Model
{
    /// <summary>
    ///  Class for testing Animal
    /// </summary>
    /// <remarks>
    /// This file is automatically generated by OpenAPI Generator (https://openapi-generator.tech).
    /// Please update the test case below to test the model.
    /// </remarks>
    public class AnimalTests : IDisposable
    {
        // TODO uncomment below to declare an instance variable for Animal
        //private Animal instance;

        public AnimalTests()
        {
            // TODO uncomment below to create an instance of Animal
            //instance = new Animal();
        }

        public void Dispose()
        {
            // Cleanup when everything is done.
        }

        /// <summary>
        /// Test an instance of Animal
        /// </summary>
        [Fact]
        public void AnimalInstanceTest()
        {
            // TODO uncomment below to test "IsType" Animal
            //Assert.IsType<Animal>(instance);
        }

        /// <summary>
        /// Test deserialize a Cat from type Animal
        /// </summary>
        [Fact]
        public void CatDeserializeFromAnimalTest()
        {
            // TODO uncomment below to test deserialize a Cat from type Animal
            //Assert.IsType<Animal>(JsonConvert.DeserializeObject<Animal>(new Cat().ToJson()));
        }

        /// <summary>
        /// Test deserialize a Dog from type Animal
        /// </summary>
        [Fact]
        public void DogDeserializeFromAnimalTest()
        {
            // TODO uncomment below to test deserialize a Dog from type Animal
            //Assert.IsType<Animal>(JsonConvert.DeserializeObject<Animal>(new Dog().ToJson()));
        }

        /// <summary>
        /// Test the property 'ClassName'
        /// </summary>
        [Fact]
        public void ClassNameTest()
        {
            // TODO unit test for the property 'ClassName'
        }

        /// <summary>
        /// Test the property 'Color'
        /// </summary>
        [Fact]
        public void ColorTest()
        {
            // TODO unit test for the property 'Color'
        }
    }
}

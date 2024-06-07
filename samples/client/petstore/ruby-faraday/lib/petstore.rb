=begin
#OpenAPI Petstore

#This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\

The version of the OpenAPI document: 1.0.0

Generated by: https://openapi-generator.tech
Generator version: 7.7.0-SNAPSHOT

=end

# Common files
require 'petstore/api_client'
require 'petstore/api_error'
require 'petstore/version'
require 'petstore/configuration'

# Models
require 'petstore/models/additional_properties_class'
require 'petstore/models/all_of_with_single_ref'
require 'petstore/models/animal'
require 'petstore/models/api_response'
require 'petstore/models/array_of_array_of_number_only'
require 'petstore/models/array_of_number_only'
require 'petstore/models/array_test'
require 'petstore/models/capitalization'
require 'petstore/models/category'
require 'petstore/models/class_model'
require 'petstore/models/client'
require 'petstore/models/deprecated_object'
require 'petstore/models/enum_arrays'
require 'petstore/models/enum_class'
require 'petstore/models/enum_test'
require 'petstore/models/fake_big_decimal_map200_response'
require 'petstore/models/file'
require 'petstore/models/file_schema_test_class'
require 'petstore/models/foo'
require 'petstore/models/foo_get_default_response'
require 'petstore/models/format_test'
require 'petstore/models/has_only_read_only'
require 'petstore/models/health_check_result'
require 'petstore/models/list'
require 'petstore/models/map_test'
require 'petstore/models/mixed_properties_and_additional_properties_class'
require 'petstore/models/model200_response'
require 'petstore/models/model_return'
require 'petstore/models/name'
require 'petstore/models/nullable_class'
require 'petstore/models/number_only'
require 'petstore/models/object_with_deprecated_fields'
require 'petstore/models/order'
require 'petstore/models/outer_composite'
require 'petstore/models/outer_enum'
require 'petstore/models/outer_enum_default_value'
require 'petstore/models/outer_enum_integer'
require 'petstore/models/outer_enum_integer_default_value'
require 'petstore/models/outer_object_with_enum_property'
require 'petstore/models/parent_with_nullable'
require 'petstore/models/pet'
require 'petstore/models/read_only_first'
require 'petstore/models/single_ref_type'
require 'petstore/models/special_model_name'
require 'petstore/models/tag'
require 'petstore/models/test_inline_freeform_additional_properties_request'
require 'petstore/models/user'
require 'petstore/models/cat'
require 'petstore/models/child_with_nullable'
require 'petstore/models/dog'

# APIs
require 'petstore/api/another_fake_api'
require 'petstore/api/default_api'
require 'petstore/api/fake_api'
require 'petstore/api/fake_classname_tags123_api'
require 'petstore/api/pet_api'
require 'petstore/api/store_api'
require 'petstore/api/user_api'

module Petstore
  class << self
    # Customize default settings for the SDK using block.
    #   Petstore.configure do |config|
    #     config.username = "xxx"
    #     config.password = "xxx"
    #   end
    # If no block given, return the default Configuration object.
    def configure
      if block_given?
        yield(Configuration.default)
      else
        Configuration.default
      end
    end
  end
end

=begin
#OpenAPI Petstore

#This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\

The version of the OpenAPI document: 1.0.0

Generated by: https://openapi-generator.tech
OpenAPI Generator version: 5.0.0-SNAPSHOT

=end

require 'date'
require 'time'

module Petstore
  class OuterEnumInteger
    N0 = 0.freeze
    N1 = 1.freeze
    N2 = 2.freeze

    # Builds the enum from string
    # @param [String] The enum value in the form of the string
    # @return [String] The enum value
    def self.build_from_hash(value)
      new.build_from_hash(value)
    end

    # Builds the enum from string
    # @param [String] The enum value in the form of the string
    # @return [String] The enum value
    def build_from_hash(value)
      constantValues = OuterEnumInteger.constants.select { |c| OuterEnumInteger::const_get(c) == value }
      raise "Invalid ENUM value #{value} for class #OuterEnumInteger" if constantValues.empty?
      value
    end
  end
end

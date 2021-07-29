=begin comment

OpenAPI Petstore

This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\

The version of the OpenAPI document: 1.0.0

Generated by: https://openapi-generator.tech

=end comment

=cut

#
# NOTE: This class is auto generated by OpenAPI Generator
# Please update the test cases below to test the API endpoints.
# Ref: https://openapi-generator.tech
#
use Test::More tests => 1; #TODO update number of test cases
use Test::Exception;

use lib 'lib';
use strict;
use warnings;

use_ok('WWW::OpenAPIClient::PetApi');

my $api = WWW::OpenAPIClient::PetApi->new();
isa_ok($api, 'WWW::OpenAPIClient::PetApi');

#
# add_pet test
#
# uncomment below and update the test
#my $add_pet_pet = undef; # replace NULL with a proper value
#my $add_pet_result = $api->add_pet(pet => $add_pet_pet);

#
# delete_pet test
#
# uncomment below and update the test
#my $delete_pet_pet_id = undef; # replace NULL with a proper value
#my $delete_pet_api_key = undef; # replace NULL with a proper value
#my $delete_pet_result = $api->delete_pet(pet_id => $delete_pet_pet_id, api_key => $delete_pet_api_key);

#
# find_pets_by_status test
#
# uncomment below and update the test
#my $find_pets_by_status_status = undef; # replace NULL with a proper value
#my $find_pets_by_status_result = $api->find_pets_by_status(status => $find_pets_by_status_status);

#
# find_pets_by_tags test
#
# uncomment below and update the test
#my $find_pets_by_tags_tags = undef; # replace NULL with a proper value
#my $find_pets_by_tags_result = $api->find_pets_by_tags(tags => $find_pets_by_tags_tags);

#
# get_pet_by_id test
#
# uncomment below and update the test
#my $get_pet_by_id_pet_id = undef; # replace NULL with a proper value
#my $get_pet_by_id_result = $api->get_pet_by_id(pet_id => $get_pet_by_id_pet_id);

#
# update_pet test
#
# uncomment below and update the test
#my $update_pet_pet = undef; # replace NULL with a proper value
#my $update_pet_result = $api->update_pet(pet => $update_pet_pet);

#
# update_pet_with_form test
#
# uncomment below and update the test
#my $update_pet_with_form_pet_id = undef; # replace NULL with a proper value
#my $update_pet_with_form_name = undef; # replace NULL with a proper value
#my $update_pet_with_form_status = undef; # replace NULL with a proper value
#my $update_pet_with_form_result = $api->update_pet_with_form(pet_id => $update_pet_with_form_pet_id, name => $update_pet_with_form_name, status => $update_pet_with_form_status);

#
# upload_file test
#
# uncomment below and update the test
#my $upload_file_pet_id = undef; # replace NULL with a proper value
#my $upload_file_additional_metadata = undef; # replace NULL with a proper value
#my $upload_file_file = undef; # replace NULL with a proper value
#my $upload_file_result = $api->upload_file(pet_id => $upload_file_pet_id, additional_metadata => $upload_file_additional_metadata, file => $upload_file_file);

#
# upload_file_with_required_file test
#
# uncomment below and update the test
#my $upload_file_with_required_file_pet_id = undef; # replace NULL with a proper value
#my $upload_file_with_required_file_required_file = undef; # replace NULL with a proper value
#my $upload_file_with_required_file_additional_metadata = undef; # replace NULL with a proper value
#my $upload_file_with_required_file_result = $api->upload_file_with_required_file(pet_id => $upload_file_with_required_file_pet_id, required_file => $upload_file_with_required_file_required_file, additional_metadata => $upload_file_with_required_file_additional_metadata);


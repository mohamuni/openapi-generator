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

use_ok('WWW::OpenAPIClient::UserApi');

my $api = WWW::OpenAPIClient::UserApi->new();
isa_ok($api, 'WWW::OpenAPIClient::UserApi');

#
# create_user test
#
# uncomment below and update the test
#my $create_user_user = undef; # replace NULL with a proper value
#my $create_user_result = $api->create_user(user => $create_user_user);

#
# create_users_with_array_input test
#
# uncomment below and update the test
#my $create_users_with_array_input_user = undef; # replace NULL with a proper value
#my $create_users_with_array_input_result = $api->create_users_with_array_input(user => $create_users_with_array_input_user);

#
# create_users_with_list_input test
#
# uncomment below and update the test
#my $create_users_with_list_input_user = undef; # replace NULL with a proper value
#my $create_users_with_list_input_result = $api->create_users_with_list_input(user => $create_users_with_list_input_user);

#
# delete_user test
#
# uncomment below and update the test
#my $delete_user_username = undef; # replace NULL with a proper value
#my $delete_user_result = $api->delete_user(username => $delete_user_username);

#
# get_user_by_name test
#
# uncomment below and update the test
#my $get_user_by_name_username = undef; # replace NULL with a proper value
#my $get_user_by_name_result = $api->get_user_by_name(username => $get_user_by_name_username);

#
# login_user test
#
# uncomment below and update the test
#my $login_user_username = undef; # replace NULL with a proper value
#my $login_user_password = undef; # replace NULL with a proper value
#my $login_user_result = $api->login_user(username => $login_user_username, password => $login_user_password);

#
# logout_user test
#
# uncomment below and update the test
#my $logout_user_result = $api->logout_user();

#
# update_user test
#
# uncomment below and update the test
#my $update_user_username = undef; # replace NULL with a proper value
#my $update_user_user = undef; # replace NULL with a proper value
#my $update_user_result = $api->update_user(username => $update_user_username, user => $update_user_user);


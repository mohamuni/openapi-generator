# coding: utf-8

"""
    OpenAPI Petstore

    This spec is mainly for testing Petstore server and contains fake endpoints, models. Please do not use this for any other purpose. Special characters: \" \\  # noqa: E501

    The version of the OpenAPI document: 1.0.0
    Generated by: https://openapi-generator.tech
"""


from __future__ import absolute_import

import unittest

import petstore_api
try:
    from petstore_api.models import file
except ImportError:
    file = sys.modules[
        'petstore_api.models.file']
from petstore_api.models.file_schema_test_class import FileSchemaTestClass


class TestFileSchemaTestClass(unittest.TestCase):
    """FileSchemaTestClass unit test stubs"""

    def setUp(self):
        pass

    def tearDown(self):
        pass

    def testFileSchemaTestClass(self):
        """Test FileSchemaTestClass"""
        # FIXME: construct object with mandatory attributes with example values
        # model = FileSchemaTestClass()  # noqa: E501
        pass


if __name__ == '__main__':
    unittest.main()

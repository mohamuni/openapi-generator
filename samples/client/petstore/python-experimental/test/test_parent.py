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
    from petstore_api.models import grandparent
except ImportError:
    grandparent = sys.modules[
        'petstore_api.models.grandparent']
try:
    from petstore_api.models import parent_all_of
except ImportError:
    parent_all_of = sys.modules[
        'petstore_api.models.parent_all_of']
from petstore_api.models.parent import Parent


class TestParent(unittest.TestCase):
    """Parent unit test stubs"""

    def setUp(self):
        pass

    def tearDown(self):
        pass

    def testParent(self):
        """Test Parent"""
        # FIXME: construct object with mandatory attributes with example values
        # model = Parent()  # noqa: E501
        pass


if __name__ == '__main__':
    unittest.main()

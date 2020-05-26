# coding: utf-8

"""
Run the tests.
$ pip install nose (optional)
$ cd OpenAPIPetstore-python
$ nosetests -v
"""


from __future__ import absolute_import

import unittest

import petstore_api
from petstore_api.models import biology_mammal
from petstore_api.models import biology_hominid

class TestChordates(unittest.TestCase):

    def setUp(self):
        pass

    def tearDown(self):
        pass

    def testChordateDeserializationAndDiscriminator(self):
        """Test Chordates deserialization
        It should be possible to create instances from anywhere
        in the animal class hierarchy, as long as the discriminator
        value is valid. Internally, the get_discriminator_class()
        function may need to call itself recursively to traverse
        the composed hierarchy.
        These unit tests would not work if get_discriminator_class
        did not call itself recursively.
        """
        from petstore_api.models import biology_chordate

        inst = biology_chordate.BiologyChordate(
            class_name="biology.Mammal",
        )
        assert isinstance(inst, biology_mammal.BiologyMammal)

        from petstore_api.models import biology_primate
        inst = biology_chordate.BiologyChordate(
            class_name="biology.Primate",
        )
        assert isinstance(inst, biology_primate.BiologyPrimate)

        from petstore_api.models import biology_reptile
        inst = biology_chordate.BiologyChordate(
            class_name="biology.Reptile",
        )
        assert isinstance(inst, biology_reptile.BiologyReptile)

        inst = biology_chordate.BiologyChordate(
            class_name="biology.Hominid",
        )
        assert isinstance(inst, biology_hominid.BiologyHominid)

    def testMammalDeserializationAndDiscriminator(self):
        """Test Chordates deserialization"""
        inst = biology_mammal.BiologyMammal(
            class_name="biology.Hominid",
        )
        assert isinstance(inst, biology_hominid.BiologyHominid)

    def testHominidDeserializationAndDiscriminator(self):
        inst = biology_hominid.BiologyHominid(
            class_name="biology.Hominid",
        )
        assert isinstance(inst, biology_hominid.BiologyHominid)

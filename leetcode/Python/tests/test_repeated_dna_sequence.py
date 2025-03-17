"""
Test cases for repeated_dna_sequence.py
The order of the output values does not matter, so converting the expected and actual output to sets here.

Author: gitmikegonz684
"""
import pytest
from leetcode.Python.repeated_dna_sequence import find_repeated_dna_sequences

@pytest.mark.parametrize("s, expected", [
    ("AAAAAAAAAAA",['AAAAAAAAAA']),
    ("AAAAAAAAAAABBBBBBBBBBB",['AAAAAAAAAA', 'BBBBBBBBBB']),
    ("ACGTACGTACGTACGTACGT", ['GTACGTACGT', 'CGTACGTACG', 'ACGTACGTAC', 'TACGTACGTA']),
    ("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", ['CCCCCAAAAA', 'AAAAACCCCC'])
])
def test_find_repeated_dna_sequences(s, expected):
    assert set(find_repeated_dna_sequences(s)) == set(expected)
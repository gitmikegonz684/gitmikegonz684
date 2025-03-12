"""
Test cases for length_of_longest_substring.py

Author: gitmikegonz684
"""
import pytest
from leetcode.Python.length_of_longest_substring import length_of_longest_substring

@pytest.mark.parametrize("s, expected", [
    ("abcabcbb", 3),
    ("bbbbb", 1),
    ("pwwkew", 3),
    ("", 0),
    ("a", 1),
    ("au", 2),
    ("dvdf", 3),
    ("abba", 2),
    ("abcadefg", 7),
    ("123@abc@def", 7),
    ("aaaa12345aaaa", 6),
])
def test_length_of_longest_substring(s, expected):
    assert length_of_longest_substring(s) == expected
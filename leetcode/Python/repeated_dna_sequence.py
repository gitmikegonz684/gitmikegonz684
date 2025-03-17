"""
187. Repeated DNA Sequence

A DNA sequence is represtented by a string of characters `A`,`C`,`G`,`T`. 
"ACGAATTCCG" is a DNA sequence.
Given a DNA string, return all the 10-letter-long sequences (substrings) that occur more than once within the string.

Author gitmikegonz684
"""

def find_repeated_dna_sequences(s: str) -> list[str]:
    """
    Finds all 10-letter-long substrings that appear more than once in a given DNA sequence.

    A DNA sequence consists of the characters 'A', 'C', 'G', and 'T'. The function extracts
    all possible 10-character substrings and returns a list of substrings that occur more than once.

    Args:
        s (str): A string representing the DNA sequence.

    Returns:
        list[str]: A list of 10-character-long substrings that appear more than once in the input string.
                  The order of substrings in the output is not guaranteed.

    Example:
        >>> find_repeated_dna_sequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT")
        ['AAAAACCCCC', 'CCCCCAAAAA']

        >>> find_repeated_dna_sequences("AAAAAAAAAAAAA")
        ['AAAAAAAAAA']

        >>> find_repeated_dna_sequences("ACGTACGTACGTACGTACGT")
        ['GTACGTACGT', 'CGTACGTACG', 'ACGTACGTAC', 'TACGTACGTA']

    Constraints:
        - The input string contains only characters 'A', 'C', 'G', and 'T'.
        - The input string has a minimum length of 1.
    """
    seen_sequences = set()
    repeated_sequences = set()
    if len(s) > 10:
        for i in range(len(s)-9):
            if i+10 <= len(s):
                sequence = s[i:i+10]
                if sequence not in seen_sequences:
                    seen_sequences.add(sequence)
                else:
                    repeated_sequences.add(sequence)
    return list(repeated_sequences)


# input: str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT" # ['CCCCCAAAAA', 'AAAAACCCCC']
# output: list[str] = find_repeated_dna_sequences(input)
# print(f"Input: {input}\nOutput: {output}")
"""
3. Longest Substring Without Repeating Characters

Given a string `s` Find the length of the longest substring without duplicate characters.

Example 1
    Input: "abcabcabb"
    Output: 3

Example 2
    Input: "bbbbb"
    Output: 1

Example 3
    Input: "pwwekw"
    Output: 3

Input `s` will have a length >= 0 and will consist of English letters, digits, symbols, and spaces.

Author: gitmikegonz684
"""
def length_of_longest_substring(s: str) -> int:
    if s:
        char_indexes = {}
        chars_found = set()
        window_start_index = 0
        max_length = 0
        for index, char in enumerate(list(s)):
            # check if the char is already in the set
            if char in chars_found and (char_indexes[char] + 1) > window_start_index:
                # update the window_start_index only if it is increasing
                window_start_index = char_indexes[char] + 1
                char_indexes[char] = index
            else:
                # keep track of char and index
                chars_found.add(char)
                char_indexes[char] = index
                # update the max_length only if it is increasing
                if (index - window_start_index + 1) > max_length:
                    max_length = index - window_start_index + 1
        return max_length
    return 0

# input: str = "abcabcabb"
# output: int = length_of_longest_substring(input)
# print(f"Input: {input}\nOutput: {output}")
# Given a digit string, return all possible letter combinations that the number could represent.

# A mapping of digit to letters (just like on the telephone buttons) is given below.
# Example
# Input:Digit string "23"
# Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

class Solution(object):
    def letterCombinations(self, digits):
        """
        :type digits: str
        :rtype: List[str]
        """
        
        digit_mapping = {'1':'*',
                        '2': ['a','b','c'],
                        '3': ['d','e','f'],
                        '4': ['g','h','i'],
                        '5': ['j','k','l'],
                        '6': ['m','n','o'],
                        '7': ['p','q','r','s'],
                        '8': ['t','u','v'],
                        '9': ['w','x','y','z'],
                        '0': [' ']}
        letter_combo = self.generate_letter_combinations(digits, digit_mapping)
        return letter_combo
    
    def generate_letter_combinations(self, digits, digit_mapping):
        if len(digits) == 0:
            return []
        if len(digits) == 1:
            return digit_mapping[digits[0]]
        #base case of 2, generate possibilities for 2 digits
        if len(digits) == 2:
            list_to_compile = []
            first_digit_possibilities = digit_mapping[digits[0]]
            second_digit_possibilities = digit_mapping[digits[1]]
            
            for i in range(len(first_digit_possibilities)):
                for j in range(len(second_digit_possibilities)):
                    generated_digit = first_digit_possibilities[i] + second_digit_possibilities[j]
                    list_to_compile.append(generated_digit)
                    
            return list_to_compile
        #recursive case, take current first digit and enumerate all of its possible values onto the running digit possibilities list
        else:
            removed_first_digit = digits[0]
            generated_list = self.generate_letter_combinations(digits[1:], digit_mapping)
            
            removed_first_digit_possibilities = digit_mapping[removed_first_digit]
            
            list_to_compile = []
            #each digit will basically have a turn to slap on its possibilities to the running digit possibilities list
            for i in range(len(removed_first_digit_possibilities)):
                for j in range(len(generated_list)):
                    generated_digit = removed_first_digit_possibilities[i] + generated_list[j]
                    list_to_compile.append(generated_digit)
                    
            return list_to_compile
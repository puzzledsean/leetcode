## facebook

Numbers have mappings to letters:
1 -> A, 2 -> B, ... 26 -> Z 

Given a string of numbers, count the number of ways you can change your string to its letter mappings 
Ex:
"123" - 4 ways
"1,2,3"
"12,3"
"1,23" 


OPT(i) = count(curr) + OPT(i-1) + OPT(i-2) ?

"1234"
"1", "12", "2"
"123"
 
########    x-1 x
########"12#4   5"



   
"123456" 
   ^ 
1, 12, 2, 23, 3, 4, 5, 6 -> 8

[1, 3, 5]
    ^
def countWays(str): 
    tracker = [] 
    for x in range(len(str)): 
        if x == 0: 
            tracker[0] = 1 #1
        if x == 1: 
            if int(str[:x]) <= 26: #
                tracker[1] = tracker[0]+2 #12, 2
            else:
                tracker[1] = tracker[0]+1 
        else: 
            tracker[x] = tracker[x-1] + calculate_count(x-1, x) ### current digit, current digit and previous digit


def calculate_count(tens_place, ones_place):
    counter = 0
    if ones_place != 0:  
        counter += 1 
    
    if int(tens_place+ones_place) <= 26:  
        counter += 1 
        
    return counter 
              
             
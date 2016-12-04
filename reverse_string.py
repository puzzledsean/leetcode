def reverseString(s):
    """
    :type s: str
    :rtype: str
    """
    
    start = 0
    end = len(s) - 1
    
    s_list = list(s)

    while start < end:
        temp = s_list[start] 
        s_list[start] = s_list[end]
        s_list[end] = temp
        
        start += 1
        end -= 1
    return ''.join(s_list)

print(reverseString("hello"))
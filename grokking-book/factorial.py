""" 
Get the number
If the number is zero return zero
Initilize result with 1
While number > 1
Result receives result multiplied with number
number receive number - 1
return result
"""
def fatorial_no_recursive(number):
    if number == 0:
        return 0

    result = 1
    while number > 1:
        result *= number
        number = number - 1
    return result


"""
Get a number higher than zero
if number equals to 1 return 1
otherwise resurn the number * the factorial of number -1
"""
def fatorial(number):
    if (number == 0):
        return 0

    if (number == 1):
        return 1
    else:
        return number * fatorial(number - 1)


print("faborial_no_recursive")
print(fatorial_no_recursive(4))
print(fatorial_no_recursive(0))

print("faborial")
print(fatorial(4))
print(fatorial(0))

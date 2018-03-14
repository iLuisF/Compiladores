
val_max = 50
count = 1
while count <= val_max:
    p = ""
    p += str(count) + " \ :"
    if count % 3 == 0:
        p += " fizz"
    if count % 5 == 0:
        p += " buzz"
    count += 1
    print p


val_max = 50
count = 1
abc = True
soy_un_real1 = .7765784
soy_un_real2 = 123546.08976
soy_un_real3 = 24357.
while count <= val_max:
    p = ""
    p += str(count) + " :"
    if count % 3 == 0:
        p += " fizz"
    if count % 5 == 0:
        p += " buzz"
    count += 1
    print p


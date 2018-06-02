.text
li $t0, 1
li $t1, 2
add $t0, $t0, $t1
li $t1, 3
add $t0, $t0, $t1
li $t1, 4
add $t0, $t0, $t1
li $t1, 5
add $t0, $t0, $t1
li $t1, 6
add $t0, $t0, $t1
li $t1, 7
add $t0, $t0, $t1
li $t1, 8
add $t0, $t0, $t1
li $t1, 9
add $t0, $t0, $t1
li $t1, 10
add $t0, $t0, $t1
li $t1, 5
sub $t0, $t0, $t1
li $t1, 50
sub $t0, $t0, $t1
li $t1, 9
li $t2, 100
mul $t1, $t1, $t2
add $t0, $t0, $t1
li $t1, 11
add $t0, $t0, $t1
move $a0, $t0
li $v0, 1
syscall

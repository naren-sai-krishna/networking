
proc fact {x} {
set a 1
for {set i 1} {$i<= $x} {incr i} {
set a [expr $a*$i]
}
return $a
}
puts "[fact 6]"

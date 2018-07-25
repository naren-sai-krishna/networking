proc fact {x} {
 set i 5

 for {set i 0} {$i>0} {incr i -1} {
 
 set n [expr n*i]
 
 puts $n
 }
 return n
 }
 puts {fact {5} }

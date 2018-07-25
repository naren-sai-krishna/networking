set ns [new Simulator]
set nf [open out.nam w]
$ns namtrace-all $nf
proc finish { } {
                 global ns nf
                 $ns flush-trace
                 close $nf
                 exec nam out.nam &
                 exit 0
                }
$ns at 5.0 "finish"
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
$ns duplex-link $n0 $n1 1mb 10ms DropTail 
$ns duplex-link $n0 $n2 1mb 10ms DropTail 
$ns duplex-link $n0 $n3 1mb 10ms DropTail 
$ns duplex-link $n1 $n2 1mb 10ms DropTail 
$ns duplex-link $n1 $n3 1mb 10ms DropTail 
$ns duplex-link $n0 $n2 1mb 10ms DropTail 
$ns duplex-link $n3 $n2 1mb 10ms DropTail 
$ns run        
$ns run        

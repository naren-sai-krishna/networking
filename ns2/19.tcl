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

set udp0 [newAgent/UDP]
$ns attach-agent $n0 $udp0
set cbr0 [newAppn/Traffic/CBR]
$cbr0 set packetSize_ 500
$cbr0 set interval_ 0.005
$cbr0 attach-get udp0
set null0 [newAgent/Null]
$ns attach-agent $n1 $null0
$ns connect $udp0 $null0
$ns at 0.5 "$cbr0 start"
$ns at 4.5 "$cbr0 start"

$ns run

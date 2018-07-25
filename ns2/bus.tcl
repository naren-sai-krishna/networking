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
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]



set lan [$ns newLan "$n0 $n1 $n2" 0.5Mb 40ms LL Queue/DropTail Mac/Csma/Cd Channel]



$ns at 10 "finish"
$ns run

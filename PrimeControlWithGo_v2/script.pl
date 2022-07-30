use strict;
use warnings;

my $readFile = 'results.txt';
my $writeFile = 'primeResults.txt';
my $serachWord = 'not';
open(FileRead, $readFile) or die("Could not open  file.");
open(WriteFile, '>',$writeFile) or die "File Not Created";


foreach my $line (<FileRead>)  {
    if ($line!~$serachWord) {
        print $line;
        print WriteFile $line;
    }
    
}

close $writeFile;
close $readFile;

package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
)

func main() {
	readFile, err := os.Open("numbers.txt")

	if err != nil {
		fmt.Println(err)
	}

	fileScanner := bufio.NewScanner(readFile)

	fileScanner.Split(bufio.ScanLines)

	for fileScanner.Scan() {

		number, _ := strconv.Atoi(fileScanner.Text())
		fmt.Println(isPrime(number))

	}
}

func isPrime(number int) (int, string) {
	control := 0
	for i := 1; i <= number; i++ {
		if number%i == 0 {
			control++
		}
	}

	if control == 2 {
		return number, "is prime"
	} else {
		return number, "is not prime"
	}
}

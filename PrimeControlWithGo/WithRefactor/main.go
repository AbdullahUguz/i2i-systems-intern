package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
)

func main() {

	fileScanner := bufio.NewScanner(openFile("numbers.txt"))

	fileScanner.Split(bufio.ScanLines)

	for fileScanner.Scan() {

		number, _ := strconv.Atoi(fileScanner.Text())
		fmt.Println(primeControl(number))

	}
}

func openFile(fileName string) io.Reader {
	readFile, err := os.Open(fileName)

	if err != nil {
		fmt.Println(err)
	}

	return readFile
}

func primeControl(number int) (int, string) {
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

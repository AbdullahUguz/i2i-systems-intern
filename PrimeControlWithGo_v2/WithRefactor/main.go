package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"strconv"
)

var asd []string

func main() {

	readFile := openFile("numbers.txt")

	fileScanner := bufio.NewScanner(readFile)

	fileScanner.Split(bufio.ScanLines)

	for fileScanner.Scan() {

		number, _ := strconv.Atoi(fileScanner.Text())
		fmt.Println(primeControl(number))
	}

	writeFile()

}

func primeControl(number int) (int, string) {
	control := 0
	for i := 1; i <= number; i++ {
		if number%i == 0 {
			control++
		}
	}

	if control == 2 {
		resultPrime := strconv.Itoa(number) + " is prime"
		asd = append(asd, resultPrime)
		return number, "is prime"
	} else {
		resultNotPrime := strconv.Itoa(number) + " is not prime"
		asd = append(asd, resultNotPrime)
		return number, "is not prime"
	}
}

func writeFile() {
	writeFile, err := os.Create("results.txt")
	checkError(err)

	defer writeFile.Close()

	for i := 0; i < len(asd); i++ {
		writeFile.WriteString(asd[i] + "\n")
	}
}

func openFile(fileName string) io.Reader {
	readFile, err := os.Open(fileName)

	checkError(err)

	return readFile
}

func checkError(err error) {
	if err != nil {
		fmt.Println(err)
	}
}

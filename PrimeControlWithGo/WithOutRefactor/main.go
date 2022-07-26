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
		control := 0

		number, _ := strconv.Atoi(fileScanner.Text())
		//	fmt.Println(number)

		for i := 2; i < number; i++ {
			if number%i == 0 {
				control++
			}
		}

		if control == 0 {
			fmt.Println(number, "is prime ")
		} else {
			fmt.Println(number, "is not prime ")
		}
		control = 0
	}
}

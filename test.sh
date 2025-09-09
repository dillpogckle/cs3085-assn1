#!/bin/zsh

# === Valid basic usage ===
echo ">>> Single Fibonacci"
java Assign1 -fib 6

echo ">>> Single Factorial"
java Assign1 -fac 6

echo ">>> Single e calculation"
java Assign1 -e 24

echo ">>> Multiple computations (mix)"
java Assign1 -fib 6 -fac 6 -e 24

echo ">>> Multiple Fibonacci"
java Assign1 -fib 6 -fib 10

# === Edge cases ===
echo ">>> Fibonacci lower bound"
java Assign1 -fib 0

echo ">>> Fibonacci upper bound"
java Assign1 -fib 40

echo ">>> Fibonacci out of bound"
java Assign1 -fib 41

echo ">>> Factorial lower bound"
java Assign1 -fac 0

echo ">>> Factorial small number"
java Assign1 -fac 1

echo ">>> Factorial out of bound"
java Assign1 -fac 2147483648

echo ">>> e lower bound"
java Assign1 -e 1

# === Invalid input tests ===
echo ">>> Fibonacci above upper bound"
java Assign1 -fib 41

echo ">>> e with 0 iterations"
java Assign1 -e 0

echo ">>> multiple correct and incorrect inputs"
java Assign1 -fib 6 -fib 50 -fac 2147483648 -e 10 -e 0

echo ">>> Unknown argument"
java Assign1 -abc 123

echo ">>> Non-integer parameter"
java Assign1 -fib a

echo ">>> Missing parameter after flag"
java Assign1 -fib

echo ">>> No parameters"
java Assign1
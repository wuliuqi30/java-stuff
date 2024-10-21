#!/bin/bash

javac Solution.java

if [ $? -eq 0 ]; then
    echo "Compilation Succesful. Running the program..."

    java Solution
else
    echo "Compilation Failed."
fi 
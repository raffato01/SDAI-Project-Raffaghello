#!/usr/bin/env bash
set -e

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
cd "$DIR"

echo "========================================================"
echo "  Cleaning Robots - Jason MAS Simulation Launcher"
echo "========================================================"

if ! command -v java &> /dev/null; then
    echo "[ERROR] Java was not found in the PATH. Install Java JDK 17 or later."
    exit 1
fi

mkdir -p bin

echo "[*] Compiling MarsEnv.java..."
javac -cp "lib/*" -d bin MarsEnv.java

echo "[*] Starting the Jason simulation with graphical interface..."
java -cp "bin:lib/*" -Djava.util.logging.config.file=logging.properties jason.infra.local.RunLocalMAS mars.mas2j
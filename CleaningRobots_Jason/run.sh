#!/usr/bin/env bash
set -e

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
cd "$DIR"

echo "========================================================"
echo "  Cleaning Robots - Jason MAS Simulation Launcher"
echo "========================================================"

if ! command -v java &> /dev/null; then
    echo "[ERRORE] Java non è stato trovato nel PATH. Installa Java JDK 17 o superiore."
    exit 1
fi

mkdir -p bin

echo "[*] Compilazione di MarsEnv.java..."
javac -cp "lib/*" -d bin MarsEnv.java

echo "[*] Avvio della simulazione Jason con interfaccia grafica..."
java -cp "bin:lib/*" -Djava.util.logging.config.file=logging.properties jason.infra.local.RunLocalMAS mars.mas2j

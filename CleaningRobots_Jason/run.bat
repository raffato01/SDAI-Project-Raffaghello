@echo off
setlocal
cd /d "%~dp0"

echo ========================================================
echo   Cleaning Robots - Jason MAS Simulation Launcher
echo ========================================================

REM Verifica installazione di Java
java -version >nul 2>&1
if errorlevel 1 (
    echo [ERRORE] Java non e' stato trovato nel PATH.
    echo Assicurati di aver installato Java JDK 17 o superiore.
    pause
    exit /b 1
)

REM Crea directory bin se non esiste
if not exist "bin" mkdir bin

REM Compilazione dell'ambiente MarsEnv.java
echo [*] Compilazione di MarsEnv.java...
javac -cp "lib/*" -d bin MarsEnv.java
if errorlevel 1 (
    echo [ERRORE] Errore durante la compilazione di MarsEnv.java.
    pause
    exit /b 1
)

REM Avvio della simulazione Jason
echo [*] Avvio della simulazione Jason con interfaccia grafica...
echo [*] Premi CTRL+C nella console per terminare.
java -cp "bin;lib/*" "-Djava.util.logging.config.file=logging.properties" jason.infra.local.RunLocalMAS mars.mas2j

pause

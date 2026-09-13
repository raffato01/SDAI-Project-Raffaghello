@echo off
setlocal
cd /d "%~dp0"

echo ========================================================
echo   Cleaning Robots - Jason MAS Simulation Launcher
echo ========================================================

REM Check Java installation
java -version >nul 2>&1
if errorlevel 1 (
    echo [ERROR] Java was not found in the PATH.
    echo Make sure Java JDK 17 or later is installed.
    pause
    exit /b 1
)

REM Create bin directory if it does not exist
if not exist "bin" mkdir bin

REM Compile the MarsEnv.java environment
echo [*] Compiling MarsEnv.java...
javac -cp "lib/*" -d bin MarsEnv.java
if errorlevel 1 (
    echo [ERROR] An error occurred while compiling MarsEnv.java.
    pause
    exit /b 1
)

REM Start the Jason simulation
echo [*] Starting the Jason simulation with graphical interface...
echo [*] Press CTRL+C in the console to terminate.
java -cp "bin;lib/*" "-Djava.util.logging.config.file=logging.properties" jason.infra.local.RunLocalMAS mars.mas2j

pause
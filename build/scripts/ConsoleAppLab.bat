@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem

@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  ConsoleAppLab startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and CONSOLE_APP_LAB_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto execute

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\ConsoleAppLab-1.0-SNAPSHOT.jar;%APP_HOME%\lib\junit-4.13.1.jar;%APP_HOME%\lib\kaml-jvm-0.51.0.jar;%APP_HOME%\lib\kotlin-stdlib-jdk8-1.8.0.jar;%APP_HOME%\lib\kotlinx-serialization-json-jvm-1.5.0-RC.jar;%APP_HOME%\lib\kotlinx-serialization-core-jvm-1.5.0-RC.jar;%APP_HOME%\lib\dotenv-kotlin-6.4.1.jar;%APP_HOME%\lib\mockk-1.10.2.jar;%APP_HOME%\lib\hamcrest-core-1.3.jar;%APP_HOME%\lib\kotlin-stdlib-jdk7-1.8.0.jar;%APP_HOME%\lib\mockk-dsl-jvm-1.10.2.jar;%APP_HOME%\lib\kotlin-reflect-1.8.0.jar;%APP_HOME%\lib\kotlin-stdlib-1.8.0.jar;%APP_HOME%\lib\dotenv-java-2.3.2.jar;%APP_HOME%\lib\mockk-agent-jvm-1.10.2.jar;%APP_HOME%\lib\mockk-common-1.10.2.jar;%APP_HOME%\lib\kotlin-stdlib-common-1.8.0.jar;%APP_HOME%\lib\annotations-13.0.jar;%APP_HOME%\lib\snakeyaml-engine-2.6.jar;%APP_HOME%\lib\mockk-agent-common-1.10.2.jar;%APP_HOME%\lib\mockk-agent-api-1.10.2.jar;%APP_HOME%\lib\objenesis-3.1.jar;%APP_HOME%\lib\byte-buddy-1.10.14.jar;%APP_HOME%\lib\byte-buddy-agent-1.10.14.jar;%APP_HOME%\lib\mockk-dsl-1.10.2.jar


@rem Execute ConsoleAppLab
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %CONSOLE_APP_LAB_OPTS%  -classpath "%CLASSPATH%" MainKt %*

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable CONSOLE_APP_LAB_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%CONSOLE_APP_LAB_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega

# Kotlin compiler fuzzer and reduktor
Requirements:
* Kotlin compiler v.1.3.50
* NodeJS


Usage:
* Compile
  * ./compile.sh
* Start
  * -f [path to files for mutating] - fuzzing mode
  * -r [file with kotlin bug] - reducing mode
  
All options (backends, dir for results, etc.) specifies in bbf.conf file


